val x = 5
var x:Int = 5

val y:Double = 5.23

var y: Double = 54.1

val lst :List[Int] = List(1, 2, 3, 4)

print {
  "List data :" + lst.slice(0, 2)
}

val lst_2 = 1.to(10).toList

print(lst_2(3))
print(lst_2.length)

print(lst_2)


val c = 'c'

val s = "string"


import scala.collection.mutable.ArrayBuffer

val arr = new ArrayBuffer[Int]() // Mutable array or List of same type

print(arr)

arr++=(1.to(30).toTraversable) // to append data

arr(1) // to index (starts with 0)

arr.dropRight(2) // to drop data from right side

arr.length


val arr_lst = arr.toList

arr_lst.map(_*2)

arr.map(_*2)


val arr_2 = Array(2, 4, 7, 0)

arr_2.array

arr_2.length


arr_2.update(2, 20)

arr_2.foreach(println)



val tup = (1, 2, 3, 4, 6, "string")

tup._2

val tup = (1, arr_2, arr, arr_lst, s)




val key_val_map = Map("1" -> 1, "2" -> 2, "3" -> 3)

key_val_map.contains("4")

key_val_map.toList

key_val_map.mapValues(_*3) // cannot transform a key in a Map Object

key_val_map + ("4" -> 4, "5" -> 5)

case class record(k:String, v:Int)

record


arr_lst.map{
  _%2 match {
    case 0 => println("Even")
    case 1 => println("Odd")
    case other => println("UnKnown")
  }
}

arr_lst.map{
  _ match {
    case x:Int => x*2
    case other => "Some Other"
  }
}


val arr_lst = List("1", "2", "3", "4")

arr_lst.map{
  _ match {
    case s:String => s
    case other => "Other"
  }
}

def patternMatchtest(param:Any) : Any = {
param match {
case x:Int => x*2
case c:Char => c + ' ' + c
case s:String => s + ' ' + s
case l:List[AnyVal] => l.mkString("List [", ", ", "] ")
case a:ArrayBuffer[AnyVal] => a.mkString("Array Buffer (", ", ", ") ")
case other => "Other"
}
}

patternMatchtest("Hi")
patternMatchtest(List(1, 2, 3, 4))
patternMatchtest(List("Hi", "hello", "Greet"))
patternMatchtest(234.456)


val x:Double = 1.41453667

(x * 1000).round.toDouble / 1000

def pow(a:Double, exp : Int) : Double = {
  def loop(acc:Double, exp:Int) : Double = {
    if (exp == 1) acc
    else loop(acc * a, exp-1)
  }
  loop(a, exp)
}

pow(10, 3)



import scalaExamples.RationalNumber

val rational = new RationalNumber(2)