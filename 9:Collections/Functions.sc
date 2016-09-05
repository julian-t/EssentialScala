// Implement an n'th item function for lists
def nth[T](n: Int, lst: List[T]): T = n match {
  case 0 => lst.head
  case k if k > 0 && k < lst.size => nth(k-1, lst.tail)
  case _ => throw new IllegalArgumentException("Index out of range")
}

val l = List(1, 2, 3, 4, 5)
nth(3, l)

val s = List("ab", "cd", "ef")
nth(1, s)

// Throws if index out of range
//nth(5, l)
//nth(-1, l)


// Implement a remove function
// Removes the element at index n
def remove[T](n: Int, lst: List[T]): List[T] = {
  lst.take(n) ++ lst.drop(n+1)
}

remove(2, l)
