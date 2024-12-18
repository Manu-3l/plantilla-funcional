/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package taller

import scala.util.Random
import common.parallel

import scala.collection.parallel.CollectionConverters.ImmutableSeqIsParallelizable
import scala.collection.parallel.immutable._

object App {
  def main(args: Array[String]): Unit = {
    println(greeting())
    Benchmarks.benchmarkingVectores()
    Benchmarks.benchmarkingMultMatriz()
    Benchmarks.benchmarkingMultMatrizRec()
    Benchmarks.benchmarkingMultMatrizStrassen()
  }

  def greeting(): String = "Hello, world!"

  type Matriz = Vector[Vector[Int]]

    // Funciones para tests de software

    def matrizAlAzar ( long:Int, vals : Int ) : Matriz = {
        //Crea una matriz de enteros cuadrada de long x long ,
        // con valores aleatorios entre 0 y vals
        val v = Vector.fill(long,long){Random.nextInt(vals)}
        v
    }

    def vectorAlAzar(long: Int, vals: Int): Vector[Int] = {
      // Crea un vector de enteros de longitud long
      // con valores aleatorios entre 0 y vals.
      val v = Vector.fill(long){Random.nextInt(vals)}
      v
    }

    //Funciones base otorgadas por el taller
    def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
        (v1 zip v2).map { case (i, j) => i * j }.sum
    }
    def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int ={
     (v1 zip v2).map({case(i,j)=>(i*j)}).sum
    }

    def transpuesta(m: Matriz): Matriz = {
        val n = m.length
        Vector.tabulate(n, n)((i, j) => m(j)(i))
    }

    // Multiplicación estandar de matrices del 1.1
    def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
        val transpuestaM2 = transpuesta(m2)
        Vector.tabulate(m1.length, m2.length) { (i, j) =>
            prodPunto(m1(i), transpuestaM2(j))
        }
    }

    // Funciónn multMatrizPar que paraleliza la función multMatriz
    def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
      val transpuestaM2 = transpuesta(m2)
      Vector.tabulate(m1.length, m2.length) { (i, j) =>
        prodPunto(m1(i).par.toVector, transpuestaM2(j).par.toVector)
      }
    }

    // Funciones para extraer una submatriz y sumar posteriormente las matrices
    def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
        m.slice(i, i + l).map(_.slice(j, j + l))
    }

    def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
        Vector.tabulate(m1.length, m1.head.length) { (i, j) =>
            m1(i)(j) + m2(i)(j)
        }
    }

    // Función para llevar a cabo la multiplicación 
    // Utilizando la formula de 
    // C11 = A11 * B11 + A12 * B21
    // C12 = A11 * B12 + A12 * B22
    // C21 = A21 * B11 + A22 * B21
    // C22 = A21 * B12 + A22 * B22
    // En otras palabras el punto 1.2

    def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
        val n = m1.length

        if (n == 1) {
            Vector(Vector(m1(0)(0) * m2(0)(0)))
        } else {
            val mitad = n / 2

            val a11 = subMatriz(m1, 0, 0, mitad)
            val a12 = subMatriz(m1, 0, mitad, mitad)
            val a21 = subMatriz(m1, mitad, 0, mitad)
            val a22 = subMatriz(m1, mitad, mitad, mitad)

            val b11 = subMatriz(m2, 0, 0, mitad)
            val b12 = subMatriz(m2, 0, mitad, mitad)
            val b21 = subMatriz(m2, mitad, 0, mitad)
            val b22 = subMatriz(m2, mitad, mitad, mitad)

            val c11 = sumMatriz(multMatrizRec(a11, b11), multMatrizRec(a12, b21))
            val c12 = sumMatriz(multMatrizRec(a11, b12), multMatrizRec(a12, b22))
            val c21 = sumMatriz(multMatrizRec(a21, b11), multMatrizRec(a22, b21))
            val c22 = sumMatriz(multMatrizRec(a21, b12), multMatrizRec(a22, b22))

            (c11 ++ c21).zip(c12 ++ c22).map { case (filaIzq, filaDer) => filaIzq ++ filaDer }
        }
    }

    def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
        val n = m1.length

        if (n == 1) {
            Vector(Vector(m1(0)(0) * m2(0)(0)))
        } else {
            val mitad = n / 2

            val ((a11,a12),(a21,a22)) = parallel(
                parallel(subMatriz(m1, 0, 0, mitad),subMatriz(m1, 0, mitad, mitad)),
                parallel(subMatriz(m1, mitad, 0, mitad),subMatriz(m1, mitad, mitad, mitad))
            )

            val ((b11,b12),(b21,b22)) = parallel(
                parallel(subMatriz(m2, 0, 0, mitad),subMatriz(m2, 0, mitad, mitad)),
                parallel(subMatriz(m2, mitad, 0, mitad),subMatriz(m2, mitad, mitad, mitad))
            )

            val ((c11,c12),(c21,c22)) = parallel(
                parallel(
                    sumMatriz(multMatrizRec(a11, b11), multMatrizRec(a12, b21)),
                    sumMatriz(multMatrizRec(a11, b12), multMatrizRec(a12, b22))
                    ),
                parallel(
                    sumMatriz(multMatrizRec(a21, b11), multMatrizRec(a22, b21)),
                    sumMatriz(multMatrizRec(a21, b12), multMatrizRec(a22, b22))
                    )
            )

            (c11 ++ c21).zip(c12 ++ c22).map { case (filaIzq, filaDer) => filaIzq ++ filaDer }
        }
    }

    //Función para la resta de matrices
    def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
        Vector.tabulate(m1.length, m1.head.length) { (i, j) =>
            m1(i)(j) - m2(i)(j)
        }
    }

    //Función para la multiplicación por el algoritmo de Strassen
    //Se extraen las submatrices antes de realizar las 7 multiplicaciones 
    //y sus respectivas operaciones. i.e punto 1.3

    def multStrassen(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    if (n == 1) {
        Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
        val mitad = n / 2

        val a11 = subMatriz(m1, 0, 0, mitad)
        val a12 = subMatriz(m1, 0, mitad, mitad)
        val a21 = subMatriz(m1, mitad, 0, mitad)
        val a22 = subMatriz(m1, mitad, mitad, mitad)

        val b11 = subMatriz(m2, 0, 0, mitad)
        val b12 = subMatriz(m2, 0, mitad, mitad)
        val b21 = subMatriz(m2, mitad, 0, mitad)
        val b22 = subMatriz(m2, mitad, mitad, mitad)

        val p1 = multStrassen(a11, restaMatriz(b12, b22))
        val p2 = multStrassen(sumMatriz(a11, a12), b22)
        val p3 = multStrassen(sumMatriz(a21, a22), b11)
        val p4 = multStrassen(a22, restaMatriz(b21, b11))
        val p5 = multStrassen(sumMatriz(a11, a22), sumMatriz(b11, b22))
        val p6 = multStrassen(restaMatriz(a12, a22), sumMatriz(b21, b22))
        val p7 = multStrassen(restaMatriz(a11, a21), sumMatriz(b11, b12))

        val c11 = sumMatriz(restaMatriz(sumMatriz(p5, p4), p2), p6)
        val c12 = sumMatriz(p1, p2)
        val c21 = sumMatriz(p3, p4)
        val c22 = restaMatriz(restaMatriz(sumMatriz(p5, p1), p3), p7)

        (c11 ++ c21).zip(c12 ++ c22).map { case (filaIzq, filaDer) => filaIzq ++ filaDer }
        }
    }
    // Función paralelizada de la función multStrassen
    def multStrassenPar(m1: Matriz, m2: Matriz) : Matriz = {
        val n = m1.length
        if (n == 1) {
            Vector(Vector(m1(0)(0) * m2(0)(0)))
        } else {
            val mitad = n / 2

            val ((a11,a12),(a21,a22)) = parallel(
                parallel(subMatriz(m1, 0, 0, mitad),subMatriz(m1, 0, mitad, mitad)),
                parallel(subMatriz(m1, mitad, 0, mitad),subMatriz(m1, mitad, mitad, mitad))
            )

            val ((b11,b12),(b21,b22)) = parallel(
                parallel(subMatriz(m2, 0, 0, mitad),subMatriz(m2, 0, mitad, mitad)),
                parallel(subMatriz(m2, mitad, 0, mitad),subMatriz(m2, mitad, mitad, mitad))
            )

            val p1 = multStrassenPar(a11, restaMatriz(b12, b22))
            val p2 = multStrassenPar(sumMatriz(a11, a12), b22)
            val p3 = multStrassenPar(sumMatriz(a21, a22), b11)
            val p4 = multStrassenPar(a22, restaMatriz(b21, b11))
            val p5 = multStrassenPar(sumMatriz(a11, a22), sumMatriz(b11, b22))
            val p6 = multStrassenPar(restaMatriz(a12, a22), sumMatriz(b21, b22))
            val p7 = multStrassenPar(restaMatriz(a11, a21), sumMatriz(b11, b12))

            val ((c11,c12),(c21,c22)) = parallel(
                parallel(
                    sumMatriz(restaMatriz(sumMatriz(p5, p4), p2), p6),
                    sumMatriz(p1, p2)
                    ),
                parallel(
                    sumMatriz(p3, p4),
                    restaMatriz(restaMatriz(sumMatriz(p5, p1), p3), p7)
                    )
            )

            (c11 ++ c21).zip(c12 ++ c22).map { case (filaIzq, filaDer) => filaIzq ++ filaDer }
            }
    }

  // Función para visualizar la matriz en consola, ignorar
  def printMatriz(matriz: Matriz): Unit = {
    matriz.foreach(row => println(row.mkString(" ")))
  }
}
