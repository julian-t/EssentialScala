// A function to find leap years
def isLeapBase(yr: Int): Boolean = {
  (yr%4 == 0) && (yr%100 != 0) || (yr%400 == 0)
}

// Try it
// 1900, 1990, 2014 are not leap years
// 1980, 1996, 2000, and 2016 are leap years

isLeapBase(1900)
isLeapBase(1980)
isLeapBase(1990)
isLeapBase(1996)
isLeapBase(2000)
isLeapBase(2014)
isLeapBase(2016)

// Overload to work with String
// Let's assume an ISO format YYYY-MM-DD

def isLeap(s: String): Boolean = {
  val v = s.substring(0,4).toInt
  isLeapBase(v)
}

isLeap("2000-12-12")
isLeap("1990-01-01")

// Overload to work with java.util.Date

import java.util.Calendar

def isLeap(d: java.util.Date) = {
  val c = Calendar.getInstance()
  c.setTime(d)
  isLeapBase(c.get(Calendar.YEAR))
}

// 2016 is a leap year
isLeap(new java.util.Date())

// Overload to work with java.Sql.Date
// toString returns a string in the form 'yyyy-mm-dd'
def isLeap(d: java.sql.Date): Boolean = {
  val yr = d.toString.substring(0,4).toInt
  isLeapBase(yr)
}

// 2016 is a leap year
val v = new java.util.Date().getTime()
isLeap(new java.sql.Date(v))

// Overload to work with java.time.LocalDate
def isLeap(d: java.time.LocalDate): Boolean = {
  isLeapBase(d.getYear)
}

// 2016 is a leap year
isLeap(java.time.LocalDate.now())
// 1990 is not
isLeap(java.time.LocalDate.of(1990, 1, 1))