package scalaExamples

class RationalNumber(x : Int, y : Int) {

  def this(x:Int) = this(x, 1)

  require(y != 0, "The Denominator should be NonZero")

  private def gcd(a:Int, b:Int) : Int = {
    if (b==0) a else gcd(b, a%b)
  }

  private val g = gcd(x, y)
  val numer:Int = if (y < 0) -x/g else x/g
  val denom:Int = if (y < 0) -y/g else y/g

  override def toString() = numer + "/" + denom

  def + (other : RationalNumber) : RationalNumber= {
    new RationalNumber(
      numer * other.denom + denom * other.numer , denom * other.denom
    )
  }

  def - (other: RationalNumber) : RationalNumber = {
    new RationalNumber(
      numer * other.denom - denom * other.numer , denom * other.denom
    )
  }

  def * (other: RationalNumber) : RationalNumber = {
    new RationalNumber(
      numer * other.numer, denom * other.denom
    )
  }

  def / (other: RationalNumber) : RationalNumber = {
    new RationalNumber(
      numer * other.denom, denom * other.numer
    )
  }

  def unary_- : RationalNumber = new RationalNumber(-numer, denom)

  def < (other:RationalNumber) : Boolean = numer * other.denom < other.numer * denom

  def > (other:RationalNumber) : Boolean = numer * other.denom > other.numer * denom

}

