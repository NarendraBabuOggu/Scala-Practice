package scalaExamples

object NQueens {
  def nqueens(n:Int) : Set[List[Int]] = {

    def abs(x:Int) : Int = if (x < 0) -x else x

    def isSafe(col:Int, queens:List[Int]) : Boolean = {
      val queen_length = queens.length
      val queen_pairs = (queen_length-1 to 0 by -1) zip queens
      queen_pairs forall {
        case (row, column) => ((column != col) && (queen_length-row != abs(col-column)))
      }
    }

    def placeQueens(k:Int) : Set[List[Int]] = {
      if (k==0) Set(List())
      else {
        for {
          queens <- placeQueens(k-1)
          col <- 0 until n
          if (isSafe(col, queens))
        } yield col :: queens
      }
    }
    placeQueens(n)
  }

  def show(queens:List[Int]):String = {
    val lines = for (col <- queens.reverse) yield {
      Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    }
    "\n" + lines.mkString("\n")
  }

  def main(args:Array[String]) = {
    val n = try {
      args(0).toInt
    } catch {
      case e:ArrayIndexOutOfBoundsException => 5
    }
    val queens = nqueens(n)
    print(queens)
    println(queens.map(show).mkString("\n"))
  }
}
