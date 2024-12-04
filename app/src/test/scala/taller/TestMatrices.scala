package taller
import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestMatrices extends AnyFunSuite {
    // Test para la función multMatriz
    test("multMatriz test 1") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        println("Matriz 1:")
        App.printMatriz(m1)
        println("Matriz 2:")
        App.printMatriz(m2)
        val m3 = App.multMatriz(m1, m2)
        println("Resultado Matriz multMatriz:")
        App.printMatriz(m3)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    test("multMatriz test 2") {
        val m1 = App.matrizAlAzar(16, 16)
        val m2 = App.matrizAlAzar(16, 16)
        val m3 = App.multMatriz(m1, m2)
        assert(m3.length == 16)
        assert(m3.forall(_.length == 16))
    }
    test("multMatriz test 3") {
        val m1 = App.matrizAlAzar(32, 32)
        val m2 = App.matrizAlAzar(32, 32)
        val m3 = App.multMatriz(m1, m2)
        assert(m3.length == 32)
        assert(m3.forall(_.length == 32))
    }
    test("multMatriz test 4") {
        val m1 = App.matrizAlAzar(64, 64)
        val m2 = App.matrizAlAzar(64, 64)
        val m3 = App.multMatriz(m1, m2)
        assert(m3.length == 64)
        assert(m3.forall(_.length == 64))
    }
    test("multMatriz test 5"){
        val m1 = App.matrizAlAzar(128, 128)
        val m2 = App.matrizAlAzar(128, 128)
        val m3 = App.multMatriz(m1, m2)
        assert(m3.length == 128)
        assert(m3.forall(_.length == 128))
    }

    // Tests para la función multMatrizPar
    test("multMatrizPar test 1") {
        val m1 = App.matrizAlAzar(8,8)
        val m2 = App.matrizAlAzar(8,8)
        println("Matriz 1:")
        App.printMatriz(m1)
        println("Matriz 2:")
        App.printMatriz(m2)
        val m3 = App.multMatrizPar(m1, m2)
        println("Resultado Matriz multMatrizPar:")
        App.printMatriz(m3)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    test("multMatrizPar test 2") {
        val m1 = App.matrizAlAzar(16, 16)
        val m2 = App.matrizAlAzar(16, 16)
        val m3 = App.multMatrizPar(m1, m2)
        assert(m3.length == 16)
        assert(m3.forall(_.length == 16))
    }
    test("multMatrizPar test 3") {
        val m1 = App.matrizAlAzar(32, 32)
        val m2 = App.matrizAlAzar(32, 32)
        val m3 = App.multMatrizPar(m1, m2)
        assert(m3.length == 32)
        assert(m3.forall(_.length == 32))
    }
    test("multMatrizPar test 4") {
        val m1 = App.matrizAlAzar(64, 64)
        val m2 = App.matrizAlAzar(64, 64)
        val m3 = App.multMatrizPar(m1, m2)
        assert(m3.length == 64)
        assert(m3.forall(_.length == 64))
    }
    test("multMatrizPar test 5"){
        val m1 = App.matrizAlAzar(128, 128)
        val m2 = App.matrizAlAzar(128, 128)
        val m3 = App.multMatrizPar(m1, m2)
        assert(m3.length == 128)
        assert(m3.forall(_.length == 128))
    }


    // Tests para la función multMatrizRec
    test("multMatrizRec test 1") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        println("Matriz 1:")
        App.printMatriz(m1)
        println("Matriz 2:")
        App.printMatriz(m2)
        val m3 = App.multMatrizRec(m1, m2)
        println("Resultado Matriz multMatrizRec:")
        App.printMatriz(m3)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    test("multMatrizRec test 2") {
        val m1 = App.matrizAlAzar(16, 16)
        val m2 = App.matrizAlAzar(16, 16)
        val m3 = App.multMatrizRec(m1, m2)
        assert(m3.length == 16)
        assert(m3.forall(_.length == 16))
    }
    test("multMatrizRec test 3") {
        val m1 = App.matrizAlAzar(32, 32)
        val m2 = App.matrizAlAzar(32, 32)
        val m3 = App.multMatrizRec(m1, m2)
        assert(m3.length == 32)
        assert(m3.forall(_.length == 32))
    }
    test("multMatrizRec test 4") {
        val m1 = App.matrizAlAzar(64, 64)
        val m2 = App.matrizAlAzar(64, 64)
        val m3 = App.multMatrizRec(m1, m2)
        assert(m3.length == 64)
        assert(m3.forall(_.length == 64))
    }
    test("multMatrizRec test 5"){
        val m1 = App.matrizAlAzar(128, 128)
        val m2 = App.matrizAlAzar(128, 128)
        val m3 = App.multMatrizRec(m1, m2)
        assert(m3.length == 128)
        assert(m3.forall(_.length == 128))
    }

    // Tests para la función multMatrizRecPar
    test("multMatrizRecPar test 1") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        println("Matriz 1:")
        App.printMatriz(m1)
        println("Matriz 2:")
        App.printMatriz(m2)
        val m3 = App.multMatrizRecPar(m1, m2)
        println("Resultado Matriz multMatrizRecPar:")
        App.printMatriz(m3)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    test("multMatrizRecPar test 2") {
        val m1 = App.matrizAlAzar(16, 16)
        val m2 = App.matrizAlAzar(16, 16)
        val m3 = App.multMatrizRecPar(m1, m2)
        assert(m3.length == 16)
        assert(m3.forall(_.length == 16))
    }
    test("multMatrizRecPar test 3") {
        val m1 = App.matrizAlAzar(32, 32)
        val m2 = App.matrizAlAzar(32, 32)
        val m3 = App.multMatrizRecPar(m1, m2)
        assert(m3.length == 32)
        assert(m3.forall(_.length == 32))
    }
    test("multMatrizRecPar test 4") {
        val m1 = App.matrizAlAzar(64, 64)
        val m2 = App.matrizAlAzar(64, 64)
        val m3 = App.multMatrizRecPar(m1, m2)
        assert(m3.length == 64)
        assert(m3.forall(_.length == 64))
    }
    test("multMatrizRecPar test 5"){
        val m1 = App.matrizAlAzar(128, 128)
        val m2 = App.matrizAlAzar(128, 128)
        val m3 = App.multMatrizRecPar(m1, m2)
        assert(m3.length == 128)
        assert(m3.forall(_.length == 128))
    }


    // Tests para la función multStrassen
    test("multStrassen test 1") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        println("Matriz 1:")
        App.printMatriz(m1)
        println("Matriz 2:")
        App.printMatriz(m2)
        val m3 = App.multStrassen(m1, m2)
        println("Resultado Matriz multStrassen:")
        App.printMatriz(m3)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    test("multStrassen test 2") {
        val m1 = App.matrizAlAzar(16, 16)
        val m2 = App.matrizAlAzar(16, 16)
        val m3 = App.multStrassen(m1, m2)
        assert(m3.length == 16)
        assert(m3.forall(_.length == 16))
    }
    test("multStrassen test 3") {
        val m1 = App.matrizAlAzar(32, 32)
        val m2 = App.matrizAlAzar(32, 32)
        val m3 = App.multStrassen(m1, m2)
        assert(m3.length == 32)
        assert(m3.forall(_.length == 32))
    }
    test("multStrassen test 4") {
        val m1 = App.matrizAlAzar(64, 64)
        val m2 = App.matrizAlAzar(64, 64)
        val m3 = App.multStrassen(m1, m2)
        assert(m3.length == 64)
        assert(m3.forall(_.length == 64))
    }
    test("multStrassen test 5"){
        val m1 = App.matrizAlAzar(128, 128)
        val m2 = App.matrizAlAzar(128, 128)
        val m3 = App.multStrassen(m1, m2)
        assert(m3.length == 128)
        assert(m3.forall(_.length == 128))
    }

    // Tests para la función multStrassenPar
    test("multStrassenPar test 1") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        println("Matriz 1:")
        App.printMatriz(m1)
        println("Matriz 2:")
        App.printMatriz(m2)
        val m3 = App.multStrassenPar(m1, m2)
        println("Resultado Matriz multStrassen:")
        App.printMatriz(m3)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    test("multStrassenPar test 2") {
        val m1 = App.matrizAlAzar(16, 16)
        val m2 = App.matrizAlAzar(16, 16)
        val m3 = App.multStrassenPar(m1, m2)
        assert(m3.length == 16)
        assert(m3.forall(_.length == 16))
    }
    test("multStrassenPar test 3") {
        val m1 = App.matrizAlAzar(32, 32)
        val m2 = App.matrizAlAzar(32, 32)
        val m3 = App.multStrassenPar(m1, m2)
        assert(m3.length == 32)
        assert(m3.forall(_.length == 32))
    }
    test("multStrassenPar test 4") {
        val m1 = App.matrizAlAzar(64, 64)
        val m2 = App.matrizAlAzar(64, 64)
        val m3 = App.multStrassenPar(m1, m2)
        assert(m3.length == 64)
        assert(m3.forall(_.length == 64))
    }
    test("multStrassenPar test 5"){
        val m1 = App.matrizAlAzar(128, 128)
        val m2 = App.matrizAlAzar(128, 128)
        val m3 = App.multStrassenPar(m1, m2)
        assert(m3.length == 128)
        assert(m3.forall(_.length == 128))
    }

    // Test para la función matrizAlAzar
    test("matrizAlAzar(3, 3)") {
        val matriz = App.matrizAlAzar(3, 3)
        assert(matriz.length == 3)
        assert(matriz.forall(_.length == 3)) // Forall que recorre cada fila de la matriz
    }
    // Test para la función vectorAlAzar
    test("vectorAlAzar(3, 3)") {
        val vector = App.vectorAlAzar(3, 3)
        assert(vector.length == 3)
    }

    // Test para la función subMatriz
    test("subMatriz test") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.subMatriz(m1, 0, 0, 4)
        assert(m2.length == 4)
        assert(m2.forall(_.length == 4))
    }
    // Test para la función sumMatriz
    test("sumMatriz test") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        val m3 = App.sumMatriz(m1, m2)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }
    // Test para la función restaMatriz
    test("restarMatriz test") {
        val m1 = App.matrizAlAzar(8, 8)
        val m2 = App.matrizAlAzar(8, 8)
        val m3 = App.restaMatriz(m1, m2)
        assert(m3.length == 8)
        assert(m3.forall(_.length == 8))
    }

}
