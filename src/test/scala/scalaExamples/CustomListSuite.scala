package scalaExamples

import org.junit._

class CustomListSuite {
  @Test def sampleTest = {
    assert(true)
  }

  import scalaExamples.{Cons, Nil}

  @Test def testNil = {
    import java.util.NoSuchElementException

    try {
      val nil = new Nil
      nil.head
    } catch {
      case e:NoSuchElementException => println("The Nil List has no Head" + e)
    }

    try {
      val nil = new Nil
      nil.tail
    } catch {
      case e:NoSuchElementException => println("The Nil List has no Tail" + e)
    }

  }
  @Test def testStringList = {
    val nil = new Nil
    val lst1 = new Cons("Hi", nil)
    val lst2 = new Cons("Hello", lst1)
    val lst3 = new Cons("How", lst2)
    assert(lst3.length==3, f"Length of List $lst3 is ${lst3.length} ")
  }

  @Test def testIntList = {
    val nil = new Nil
    val lst1 = new Cons(1, nil)
    val lst2 = new Cons(2, lst1)
    val lst3 = new Cons(3, lst2)
    val lst4 = new Cons(20, lst3)
    assert(lst4.length==4, f"Length of List $lst4 is ${lst4.length} ")
  }

  import scalaExamples.CustomListObj.nthElementofListWithIsEmpty

  @Test def testNthElementFunction = {
    val nil = new Nil
    val lst1 = new Cons(1, nil)
    val lst2 = new Cons(2, lst1)
    val lst3 = new Cons(3, lst2)
    val lst4 = new Cons(20, lst3)
    assert(nthElementofListWithIsEmpty(lst4, 1) == 3, f"The 2nd element og List $lst4 is ${nthElementofListWithIsEmpty(lst4, 1)} ")

    assert(try {
      nthElementofListWithIsEmpty(lst4, 10) == 0
    } catch {
      case e:IndexOutOfBoundsException => true
    }, "If the given number is beyond the length of List then IndexOutOfBoundsException should be raised")

    assert(try {
      nthElementofListWithIsEmpty(lst4, -1) == 0
    } catch {
      case e:IndexOutOfBoundsException => true
    }, "If the given number is beyond the length of List then IndexOutOfBoundsException should be raised")
  }
}
