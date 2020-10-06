package scalaExamples

trait NaturalNumber {
  def isZero: Boolean
  def predecessor: NaturalNumber
  def successor: NaturalNumber = new Succ(this)
  def + (that: NaturalNumber): NaturalNumber
  def - (that: NaturalNumber): NaturalNumber
}


class Zero extends NaturalNumber {

  def isZero = true
  def predecessor: NaturalNumber = throw new NoSuchElementException("Zero.predecessor")
  def + (that : NaturalNumber) : NaturalNumber = that
  def - (that : NaturalNumber) : NaturalNumber = throw new NoSuchElementException("Zero - ")

}

class Succ(n:NaturalNumber) extends NaturalNumber {

  def isZero = false
  override def predecessor: NaturalNumber = n
  def + (that: NaturalNumber): NaturalNumber = new Succ(n + that)
  def - (that: NaturalNumber): NaturalNumber = if (that.isZero) this else n - that.predecessor

}
