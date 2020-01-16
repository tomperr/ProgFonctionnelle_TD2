package example

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object `Lists` that need to be implemented as  part
 * of this assignment. A test suite is simply a collection of individual tests for some specific component of a program.
 *
 * A test suite is created by defining a class which extends the type`org.scalatest.FunSuite`. When running ScalaTest,
 * it will automatically find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class lists extends FunSuite {
    /**
     * Tests are written using the `test` operator which takes two arguments:
     * - A description of the test. This description has to be unique, no two tests can have the same description.
     * - The test body, a piece of Scala code that implements the test
     *
     * The most common way to implement a test body is using the method `assert` which tests that its argument evaluates to `true`.
     *  So one of the simplest successful tests is the following:
     */
    test("one plus one is two")(assert(1 + 1 == 2))

    /**
     * In Scala, it is allowed to pass an argument to a method using the block syntax, i.e. `{ argument }` instead of parentheses
     * `(argument)`.
     *
     * This allows tests to be written in a more readable manner:
     */
    test("one plus two is four ?") {
        assert(1 + 2 == 4) //TODO  This assertion fails! Go ahead and fix it.
    }

    /**
     * One problem with the previous (failing) test is that ScalaTest will only tell you that a test failed, but it will not tell you
     * what was the reason for the failure. The output looks like this:
     *
     * {{{
     *    [info] - one plus one is three? *** FAILED ***
     * }}}
     *
     * This situation can be improved by using a special equality operator `===` instead of `==` (this is only possible in ScalaTest).
     * So if you run the next test, ScalaTest will show the following output:
     *
     * {{{
     *    [info] - details why one plus one is not three *** FAILED ***
     *    [info]   2 did not equal 3 (ListsSuite.scala:67)
     * }}}
     *
     * We recommend to always use the `===` equality operator when writing tests.
     */
    test("details why one plus two is not four") {
        assert(1 + 2 === 4) //TODO FIX ME
    }

    /**
     * In order to test the exceptional behavior of a methods, ScalaTest offers the `intercept` operation.
     * In the following example, we test the fact that the method `intNotZero` throws an `IllegalArgumentException` if its argument is `0`.
     */
    test("intNotZero throws an exception if its argument is 0") {
        intercept[IllegalArgumentException] {
            intNotZero(0)
        }
    }

    def intNotZero(x: Int): Int =
        {
            if (x == 0) throw new IllegalArgumentException("zero is not allowed")
            else x
        }

    /**
     * Now we finally write some tests for the list functions that have to be implemented for this assignment. We fist import all members
     * of the `List` object.
     */
    import listsFun._

    /**
     * We only provide two very basic tests for you. Write more tests to make sure your `sum` and `max` methods work as expected.
     *
     * In particular, write tests for corner cases: negative numbers, zeros, empty lists, lists with repeated elements, etc.
     *
     * It is allowed to have multiple `assert` statements inside one test, however it is recommended to write an individual `test` statement
     * for every tested aspect of a method.
     */

    // TESTS multi function
    test("test fct multi -- a few positif numbers") {
        assert(multi(List(1, 2, 3)) === 6)
    }

    test("test fct multi -- a few numbers") {
        assert(multi(List(2, 2, -3)) === -12)
    }

    test("test fct multi -- empty list") {
        assert(multi(List()) === 1)
    }

    // TESTS multiBinaire
    test("test fct multiBinaire -- a few positif numbers") {
        assert(multiBinaire(List(1, 2, 3, 6, 8), 3, 3) === 144)
    }

    test("test fct multiBinaire -- a few numbers") {
        assert(multiBinaire(List(1, 2, -3), 2, 2) === -6)
    }

    test("test fct multiBinaire -- empty list") {
        assert(multiBinaire(List(), 1, 2) === 1) // 1 is the default value
    }

    test("test fct multiBinaire -- indice sup size") {
        assert(multiBinaire(List(1, 2, -3), 4, 2) === 1) // 1 is the default value
    }
    
    test("test fct multiBinaire -- nb elem sup size") {
        assert(multiBinaire(List(1, 2, -4), 2, 4) === -8) // just add the existing elem
    }

    // TESTS isGrowing
    test("test fct isGrowing -- growing") {
        assert(isGrowing(List(1, 2, 4, 6, 8)) === true)
    }

    test("test fct isGrowing -- not growing") {
        assert(isGrowing(List(1, 2, -3, 3, 4)) === false)
    }

    test("test fct isGrowing -- not growing last elem") {
        assert(isGrowing(List(1, 2, 3, 4, -3)) === false)
    }

    test("test fct isGrowing -- empty list") {
        assert(isGrowing(List()) === true)
    }

    // TESTS reminvert
    test("test fct min -- list") {
        assert(min(List(1, 2, -3, 123, 255555, 5, 36)) === -3)
    }

    test("test fct min -- list 2") {
        assert(min(List(1, 2, -3, 123, 25, 5, -36)) === -36)
    }

    test("test fct min -- throws an exception if the list is empty") {
        assert(false) //TODO FIX ME
    }

    // TESTS revert
    test("test fct revert -- list") {
        assert(renverse(List(1, 2, -3, 123, -255555, 5, 36)) === List(36, 5, -255555, 123, -3, 2, 1))
    }

    test("test fct revert -- throws an exception if the list is empty") {
        assert(false) //TODO FIX ME
    }

    // TESTS Function
    test("test fct fusion -- 1 lists") {
        assert(fusion(List(1, 2, 3), List(4, 5, 6)).sorted === List(1, 2, 3, 4, 5, 6))
    }

    test("test fct fusion -- 2 lists") {
        assert(fusion(List(1, -3, 3), List(7, 5, 3)).sorted === List(-3, 1, 3, 5, 7))
    }

    test("test fct fusion -- 3 lists") {
        assert(fusion(List(1, 2, 0), List(4, 4, 1, 5)).sorted === List(0, 1, 2, 4, 5))
    }

    test("test fct fusion --  empty R lists") {
        assert(fusion(List(1, 2, 0), List()).sorted === List(0, 1, 2))
    }

    test("test fct fusion --  empty L lists") {
        assert(fusion(List(), List(1, 2, 0)).sorted === List(0, 1, 2))
    }

    test("test fct fusion -- same lists") {
        assert(fusion(List(1, 2, 0), List(1, 2, 0)).sorted === List(0, 1, 2))
    }

    test("test fct fusion -- 2 empty lists") {
        assert(fusion(List(), List()).sorted === List())
    }

    // Flatten Function
    test("test fct flatten --  lists") {
        assert(flatten(List(1, List(2, 3, 4), 5, 6, List(7, 8, 9, List(10, 11, 12)))) === List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    }
    test("test fct flatten --  lists with empty lists") {
        assert(flatten(List(1, List(2, 3, 4, List()), 5, 6, List(), List(7, 8, 9, List(10, 11, List(), 12)))) === List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    }
    test("test fct flatten -- Nil") {
        assert(flatten(List()) === List())
    }

    // intersect Function
    test("empty intersect lists") {
        assert(intersection(List(1, 5, 6, 7, 8, 9), List(10, 11, 12)) === List())
    }

    test("intersect lists") {
        assert(intersection(List(1, 5, 6, 7, 8, 9), List(6, 6, 7, 12)).sorted === List(6, 7))
    }
    test("intersect Nil") {
        assert(intersection(List(), List()) === List())
    }

}
