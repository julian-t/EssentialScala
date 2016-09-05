class Account(val number: Long, val name: String, val openingBalance: Double=0.0) {
  var theBalance = openingBalance

  def deposit(amount: Double) =
    if (amount > 0.0) {
      theBalance += amount
      true
    }
    else
      false

  def withdraw(amount: Double) =
    if (amount > 0.0 && theBalance-amount >= 0.0) {
      theBalance -= amount
      true
    }
  else
      false

  def balance = theBalance
}

val acc1 = new Account(1000, "My Account")
acc1 deposit 100.0

println(acc1.balance)
val ok = acc1.withdraw(50.0)    // 50 is OK
println(acc1.balance)
val ok2 = acc1.withdraw(100.0)  // 100 should fail
println(acc1.balance)           // balance should be the same

// A CheckingAccount can overdraw up to 100.0
// Note how we pass parameters to the superclass constructor
class CheckingAccount(number: Long, name: String, openingBalance: Double=0.0) extends
  Account(number, name, openingBalance) {
  // We override withdraw to allow an overdraft of 100
  override def withdraw(amount: Double): Boolean =
    if (amount > 0.0 && theBalance-amount >= -100.0) {
      theBalance -= amount
      true
    }
    else
      false
}

// Create a CheckingAccount and verify that you can overdraw
val acc2 = new CheckingAccount(1001, "Checking account")
acc2 deposit(100.0)
acc2.withdraw(120.0)
println(acc2.balance)

// Create a CheckingAccount using an Account reference
val acc3: Account = new CheckingAccount(1002, "Checking Account 2")

// A SavingsAccount has an interest rate
// We don't need to override other members
class SavingsAccount(number: Long, name: String, openingBalance: Double=0.0) extends
  Account(number, name, openingBalance) {
  val interestRate = 1.5
}