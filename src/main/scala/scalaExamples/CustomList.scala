package scalaExamples

import java.security.KeyStore.TrustedCertificateEntry
import java.util.NoSuchElementException

trait CustomList[+T] {
  def isEmpty : Boolean
  def head : T
  def tail : CustomList[T]
  def length : Int
  def prepend[U >: T](elem:U) : CustomList[U] = new Cons(elem, this)
}


class Cons[+T](val head:T, val tail : CustomList[T]) extends CustomList[T] {
  def isEmpty : Boolean = false
  def length : Int = 1 + tail.length
  override def toString : String = this.head.toString + " -> " + this.tail.toString
}

object Nil extends CustomList[Nothing] {
  def isEmpty : Boolean = true
  def length : Int = 0
  def head : Nothing = throw new NoSuchElementException("Nil.head")
  def tail : Nothing = throw new NoSuchElementException("Nil.tail")
  override def toString: String = "."
}

object CustomListObj {

  def nthElementofList[T](l : CustomList[T], n:Int) : T = {
    def loop(lst : CustomList[T], bound:Int) : T = {
      try {
        if (bound == 1) lst.head
        else loop(lst.tail, bound-1)
      } catch {
        case e:NoSuchElementException => throw new IndexOutOfBoundsException(f"The List $l does not have $n Elements." +
          f"\nThe Length of the list $l is ${l.length}")
      }
    }
    loop(l, n)
  }

  def nthElementofListWithIsEmpty[T](l : CustomList[T], n:Int) : T = {
    def loop(lst : CustomList[T], bound:Int) : T = {
      if (lst.isEmpty) throw new IndexOutOfBoundsException(f"The List $l does not have $n Elements." +
          f"\nThe Length of the list $l is ${l.length}")
      else if (bound == 0) lst.head
      else loop(lst.tail, bound-1)
    }
    loop(l, n)
  }

  def main(args:Array[String]) = {
    try {
      val nil = Nil
      nil.head
    } catch {
      case e:NoSuchElementException => println("The Nil List has no Head" + e)
    }

    try {
      val nil = Nil
      nil.tail
    } catch {
      case e:NoSuchElementException => println("The Nil List has no Tail" + e)
    }

    val lst1 = new Cons(2:Int, Nil)
    val lst2 = new Cons(5:Int, lst1)

    println("Length of List " + lst2.toString + " is " + lst2.length)

    println(f"The 2nd element og List $lst2 is ${nthElementofListWithIsEmpty(lst2, 1)} ")

  }
}

object CustomList {
  def apply[T](x:T) : CustomList[T] = new Cons(x, Nil)
  def apply[T](x:T, y:T) : CustomList[T] = {
    new Cons(y, new Cons(x, Nil))
  }
  def apply[T](x:T, y:T, z:T) : CustomList[T] = {
    new Cons(z, new Cons(y, new Cons(x, Nil)))
  }
}

object TestCustomListObj extends App {
  def test() = {
    println(CustomList(1))
    println(CustomList(1, 2))
    println(CustomList(1, 2, 3))
    println(CustomList(1, 2, 3).prepend(20))
  }
  test()
}


