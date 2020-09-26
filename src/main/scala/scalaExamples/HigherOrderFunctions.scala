package scalaExamples

object HigherOrderFunctions {

  def higherOrderFunction(f:Int => Int, g:(Int, Int) => Int, a:Int, b:Int) : Int = {
    /**
     f is the function to apply on each element (ex :- square of each a and b)
     g is the function to apply on all the elements at a time (ex :- sum of a,b)
     */
    g(f(a), f(b))
  }

  def factorial(n:Int) : Int = {
    def loop(n:Int, acc:Int) : Int = {
      if (n==1 || n==0) acc
      else if (n > 1) loop(n-1, multiply(acc, n))
      else -1
    }
    loop(n, 1)
  }
  
  def sum(a:Int, b:Int) : Int = a + b

  def multiply(a:Int, b:Int) : Int = a * b

  def subtract(a:Int, b:Int) : Int = a - b

  def square(a:Int) : Int = a * a

  def cube(a:Int) : Int = a * a * a

  def same(a:Int) : Int = a


  def main(args:Array[String]) = {
    val a:Int = 2 ; val b:Int = 4
    val generalSum = higherOrderFunction(same, sum, a, b)
    println(f"Sum of $a and $b is $generalSum")

    val sum_of_squares = higherOrderFunction(square, sum, a, b)
    println(f"Sum of $a and $b is $sum_of_squares")

    val sum_of_cubes = higherOrderFunction(cube, sum, a, b)
    println(f"Sum of $a and $b is $sum_of_cubes")

    val difference = higherOrderFunction(same, subtract, a, b)
    println(f"Difference of $a and $b is $difference")

    val difference_of_squares = higherOrderFunction(square, subtract, a, b)
    println(f"Difference of Squares of $a and $b is $difference_of_squares")

    val difference_of_cubes = higherOrderFunction(cube, subtract, a, b)
    println(f"Difference of Cubes of $a and $b is $difference_of_cubes")

    val product = higherOrderFunction(same, multiply, a, b)
    println(f"Product of $a and $b is $product")

    val product_of_squares = higherOrderFunction(square, multiply, a, b)
    println(f"Product of Squares of $a and $b is $product_of_squares")

    val product_of_cubes = higherOrderFunction(cube, multiply, a, b)
    println(f"Product of Cubes of $a and $b is $product_of_cubes")

    val fact = factorial(a)
    println(f"Factorial of $a is $fact")

    val sum_of_factorials = higherOrderFunction(factorial, sum, a, b)
    println(f"Sum of Factorials of $a $b is $sum_of_factorials")

    val difference_of_factorials = higherOrderFunction(factorial, subtract, a, b)
    println(f"Difference of Factorials of $a $b is $difference_of_factorials")

    val product_of_factorials = higherOrderFunction(factorial, multiply, a, b)
    println(f"Product of Factorials of $a $b is $product_of_factorials")

  }
}
