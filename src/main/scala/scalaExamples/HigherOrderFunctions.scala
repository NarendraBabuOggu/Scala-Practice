package scalaExamples

object HigherOrderFunctions {

  def higherOrderFunction(f:Int => Int, g:(Int, Int) => Int, a:Int, b:Int) : Int = {
    /**
     f is the function to apply on each element (ex :- square of each a and b)
     g is the function to apply on all the elements at a time (ex :- sum of a,b)
     */
    g(f(a), f(b))
  }

  def sum(a:Int, b:Int) : Int = a + b

  def multiply(a:Int, b:Int) : Int = a * b

  def subtract(a:Int, b:Int) : Int = a - b

  def square(a:Int) : Int = a * a

  def cube(a:Int) : Int = a * a * a

  def same(a:Int) : Int = a


  def main(args:Array[String]) = {
    val a:Int = 8 ; val b:Int = 10
    val sum = higherOrderFunction(this.same, this.sum, a, b)
    println(f"Sum of $a and $b is $sum")

    val sum_of_squares = higherOrderFunction(this.square, this.sum, a, b)
    println(f"Sum of $a and $b is $sum_of_squares")

    val sum_of_cubes = higherOrderFunction(this.cube, this.sum, a, b)
    println(f"Sum of $a and $b is $sum_of_cubes")

    val difference = higherOrderFunction(this.same, this.subtract, a, b)
    println(f"Difference of $a and $b is $difference")

    val difference_of_squares = higherOrderFunction(this.square, this.subtract, a, b)
    println(f"Difference of Squares of $a and $b is $difference_of_squares")

    val difference_of_cubes = higherOrderFunction(this.cube, this.subtract, a, b)
    println(f"Difference of Cubes of $a and $b is $difference_of_cubes")

    val product = higherOrderFunction(this.same, this.multiply, a, b)
    println(f"Product of $a and $b is $product")

    val product_of_squares = higherOrderFunction(this.square, this.multiply, a, b)
    println(f"Product of Squares of $a and $b is $product_of_squares")

    val product_of_cubes = higherOrderFunction(this.cube, this.multiply, a, b)
    println(f"Product of Cubes of $a and $b is $product_of_cubes")

  }
}
