package scalaExamples

trait Expr {
  def eval:Double = this match {
    case Number(n) => n
    case Sum(n1, n2) => n1.eval + n2.eval
    case Prod(n1, n2) => n1.eval * n2.eval
    case Var(name) => throw new NoSuchElementException("Variable cannot be Evaluated")
  }

  def == (that : Expr) : Boolean = {
    (this, that) match {
      case (Number(n1), Number(n2)) => if (n1==n2) true else false
      case (Sum(n1, n2), Sum(n3, n4)) => if (n1==n3 && n2==n4) true else if (n1==n4 && n2==n3) true else false
      case (Prod(n1, n2), Prod(n3, n4)) => if (n1==n3 && n2==n4) true else if (n1==n4 && n2==n3) true else false
      case (Var(n1), Var(n2)) => if (n1==n2) true else false
      case other => false
    }
  }

  def show:String = this match {
    case Prod(n, s:Sum) => n.show + " * (" + s.show + ")"
    case Prod(s:Sum, n) => "(" + s.show + ") * " + n.show
    case Number(n) => n.toString
    case Sum(n1, n2) => n1.show + " + " + n2.show
    case Prod(n1, n2) => n1.show + " * " + n2.show
    case Var(name) => name
  }

  def simplify:Expr = this match {
    case Number(n) => Number(n)
    case Var(s) => Var(s)
    case Sum(n1, n2) => if (n1.simplify == n2.simplify) Prod(Number(2), n1.simplify) else Sum(n1.simplify, n2.simplify)
    case Prod(n1, n2) => Prod(n1.simplify, n2.simplify)
  }
}

case class Number(n:Double) extends Expr
case class Sum(n1:Expr, n2:Expr) extends Expr
case class Prod(n1:Expr, n2:Expr) extends Expr
case class Var(name:String) extends Expr

object TestPatternMatching extends App {
  def test = {
    val n1 = Number(2)
    val n2 = Number(5)

    val sum = Sum(n1, n2)
    val prod = Prod(n1, n2)

    println(sum.show + " = " + sum.eval)
    println(prod.show + " = " + prod.eval)

    println(Prod(Var("x"), Sum(Var("y"), Var("z"))).show)
    println(Prod(Sum(Var("y"), Var("z")), Var("x")).show)
    println(Sum(Prod(Var("x"), Sum(Var("y"), Var("z"))), Prod(Sum(Var("y"), Var("z")), Var("x"))).show +
      " = " +
      Sum(Prod(Var("x"), Sum(Var("y"), Var("z"))), Prod(Sum(Var("y"), Var("z")), Var("x"))).simplify.show)
    println(Sum(Prod(Var("x"), Sum(Var("x"), Var("x"))), Prod(Sum(Var("x"), Var("x")), Var("x"))).show +
      " = " +
      Sum(Prod(Var("x"), Sum(Var("x"), Var("x"))), Prod(Sum(Var("x"), Var("x")), Var("x"))).simplify.show)
  }
  test
}