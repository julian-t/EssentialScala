// A case class representing an Address
case class Address(city: String, country: String)

case class Account(number: Long, name: String,
                   address: Address, openingBalance: Double=0.0) {
  var theBalance = openingBalance

  // Methods implemented using pattern matching
  def deposit(amount: Double) = amount match {
    case amt if amt > 0.0 =>
      theBalance += amount
      true
    case _ => false
  }

  def withdraw(amount: Double) = amount match {
    case amt if amount > 0.0 && theBalance - amount >= 0.0 =>
      theBalance -= amount
      true
    case _ => false
  }

  def balance = theBalance
}

val add1 = Address("London", "UK")

val acc1 = Account(1000, "Julian", add1)
acc1 deposit 100.0

println(acc1.address.city)

def isOverdrawn(acc: Account) = acc match {
  case a: Account if a.balance > 0.0 => println("Account has funds")
  case a: Account if a.balance == 0.0 => println("Account has no funds")
  case a: Account if a.balance < 0.0 => println("Account is overdrawn")
}

isOverdrawn(acc1)

// Print name and city
acc1 match {
  case Account(_, n, Address(c, _), _) => println(s"$n is located in $c")
}

