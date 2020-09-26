package scalaExamples

import org.junit._
import org.junit.Assert.assertEquals

class HigherOrderFunctionSuite {
  @Test def sampleTest() = {
    assert(1+2 == 3)
  }

  import HigherOrderFunctions._

  @Test def higherOrderFunctionSuite = {

    assertEquals("1 + 1 should be 2", 2, higherOrderFunction(same, sum, 1, 1))

    assertEquals("square(1) + square(1) should be 2", 2, higherOrderFunction(square, sum, 1, 1))

    assertEquals("cube(1) + cube(1) should be 2", 2, higherOrderFunction(cube, sum, 1, 1))

    assertEquals("1 - 1 should be 0", 0, higherOrderFunction(same, subtract, 1, 1))

    assertEquals("square(1) - square(1) should be 0", 0, higherOrderFunction(square, subtract, 1, 1))

    assertEquals("cube(1) - cube(1) should be 0", 0, higherOrderFunction(cube, subtract, 1, 1))

    assertEquals("1 * 1 should be 1", 1, higherOrderFunction(same, multiply, 1, 1))

    assertEquals("square(1) * square(1) should be 1", 1, higherOrderFunction(square, multiply, 1, 1))

    assertEquals("cube(1) * cube(1) should be 1", 1, higherOrderFunction(cube, multiply, 1, 1))

  }
}
