package scalaExamples

import org.junit._

class FixedPointSuite {

  @Test def sampleTest() = {
    assert(1+2 == 3)
  }

  import FixedPoint._

  @Test def fixedPointSuite() = {

    assert(2.0 == fixedPoint(x => 1+x/2)(1), "Fixed Point of the line (1 + x/2) is 2.0")
    assert(1.414 == sqrt(2), "Square Root of the 2 is 1.414")
  }

}
