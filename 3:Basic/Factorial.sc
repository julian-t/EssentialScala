// A recursive factorial function
// Assume positive values only!
def fact(n: Int):Int = {
  if (n == 0) 1
  else n * fact(n-1)
}

// Try it
fact(0)
fact(3)
fact(4)
