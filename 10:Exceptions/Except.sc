import scala.util.{Try, Success, Failure}

//--- Option
// Create a Map[String,String] representing countries and
// their capital cities
val cities = Map("UK" -> "London", "France" -> "Paris",
  "USA" -> "Washington DC")

// Get a valid entry
val c1 = cities("UK")

// A key that doesn't exist will throw
//val c2 = cities("China")

// Using get() will return an Option
val c3 = cities.get("China")

// A list of countries
val l = List("USA", "China", "UK", "France", "India")

// map returns a list of Options
l.map(cities.get)

// flatMap flattens the Options, returning Strings
l.flatMap(cities.get)

//--- Try

// The "toInt" function may throw if the number can't be converted.
// Encapsulate conversion in a function that returns a Try

def convertToInt(s: String): Try[Int] = {
  Try{ s.toInt }
}

val a = convertToInt("123")
val b = convertToInt("abc")

// Experiment with ways to get the value out of the Try
// Pattern matching works

a match {
  case Success(n) => println(n)
  case Failure(ex) => println(ex.getMessage)
}

// So does map
val a1 = a.map(x => x) getOrElse 0
val b1 = b.map(x => x) getOrElse 0

// A function that takes two strings, and tries to convert
// them to numbers and add them

def adder(a: String, b: String): Try[Int] = {
  for {
    n <- Try(a.toInt)
    m <- Try(b.toInt)
  } yield n+m
}

val first = adder("123", "112")
val second = adder("123", "ab")

// Construct a list of strings, some of which represent
// integers and some of which don't

val lst = List("12", "x", "23", "14", "y", "18")

// Use map on the list to try to convert them all to integers
val r = lst.map(convertToInt(_))

// Now use collect on the resulting list to get all the
// valid numbers
r.collect{case Success(x) => x}
