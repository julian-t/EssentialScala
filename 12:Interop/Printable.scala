// Trait with one implemented method
trait Printable {
  def print(s: String)
  def println()
  def println(s: String) { print(s); println() }
}
