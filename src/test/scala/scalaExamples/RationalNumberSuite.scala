package scalaExamples

import org.junit._

class RationalNumberSuite {

  @Test def sampleTest() = {
    assert(1+2 == 3)
  }

  import scalaExamples.RationalNumber

  val rational1 = new RationalNumber(1, 2)
  val rational2 = new RationalNumber(5, 3)

  @Test def testRationalNumberSum() = {

    assert((rational1 + rational2).toString == new RationalNumber(13, 6).toString,
      "Sum of Rational Numbers " + rational1.toString + " and " + rational2.toString + " is 13/6")
  }

  @Test def testRationalNumberProduct() = {

    assert((rational1 * rational2).toString == new RationalNumber(5, 6).toString,
      "Product of Rational Numbers " + rational1.toString + " and " + rational2.toString + " is 5/6")
  }

  @Test def testRationalNumberDifference() = {

    assert((rational1 - rational2).toString == new RationalNumber(-7, 6).toString,
      "Difference of Rational Numbers " + rational1.toString + " and " + rational2.toString + " is -7/6")
  }

  @Test def testRationalNumberDivision() = {

    assert((rational1 / rational2).toString == new RationalNumber(3, 10).toString,
    "Division of Rational Numbers " + rational1.toString + " and " + rational2.toString + " is 3/10")
  }

  @Test def testRationalNumberLessOrNot() = {

    val rational1 = new RationalNumber(1, 3)
    val rational2 = new RationalNumber(2, 3)
    assert((rational1 < rational2), "1/3 is Less than 2/3")
  }

  @Test def testRationalNumberUnaryNeg() = {

    val rational1 = new RationalNumber(1, -3)
    val rational2 = new RationalNumber(1, 3)
    assert(((-rational1).toString() == rational2.toString()), "1/3 is Less than 2/3")
  }

  @Test def testRationalNumberWithoutDenom() = {

    val rational1 = new RationalNumber(1)
    val rational2 = new RationalNumber(1, 1)
    assert((rational1.toString() == rational2.toString()),
      "Rational Number use 1 as denominator if not given")
  }

}
