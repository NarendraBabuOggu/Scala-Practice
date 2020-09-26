package scalaExamples

object FixedPoint {


  def abs(a:Double) : Double = if (a<0) -a else a

  def pow(a:Double, exp : Int) : Double = {
    def loop(acc:Double, exp:Int) : Double = {
      if (exp == 1) acc
      else loop(acc * a, exp-1)
    }
    loop(a, exp)
  }

  def round(a:Double, decimal_pos:Int) : Double = {
    //println("Value " + a + " Decimal Position " + decimal_pos)
    val res = (a * pow(10, decimal_pos)).round.toDouble / pow(10, decimal_pos)
    //println("Before Rounding " + a + " After Rounding " + res)
    res
  }

  // Using the Currying for function definition
  def fixedPoint(f:Double => Double)(initial : Double) : Double = {

    def isGoodEnough(guess:Double) : Boolean = {
      val eps = 0.0001
      val res = (f(guess) - guess) / guess
      //println("Guess is " + guess + " Function of Guess is " + f(guess) + " Result is " + res)
      if (abs(res) <= eps) true else false
    }

    def iterate(guess:Double) : Double = {
      //println("Current Guess is " + guess)
      if (isGoodEnough(guess)) guess
      else iterate(f(guess))
    }
    round(iterate(initial), 3)
  }

  def sqrt(x:Double) : Double = {
    fixedPoint(y => (y + x/y)/2)(1)
  }

  def main(args:Array[String]) : Unit = {
    println("Fixed Point of the line (1 + x/2) is " + fixedPoint(x => 1+x/2)(1))
    println("Square Root of the 2 is " + sqrt(2))
  }
}
