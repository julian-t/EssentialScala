// Case class to represent a transaction on the account
case class Transaction(amount: Double, description: String, when: java.time.LocalDateTime)

// Simplified Account that uses transactions
class Account(val number: Long, val name: String, val openingBalance: Double=0.0) {
  // Use a mutable buffer because we're going to add to it, and no-one will
  // see this outside the class
  private val tx = scala.collection.mutable.ListBuffer[Transaction]()

  // We no longer have a balance variable
  //private var theBalance = openingBalance

  // The first transaction is created when the account is opened
  tx += Transaction(openingBalance, "Account opening", java.time.LocalDateTime.now())

  def deposit(amount: Double, reason: String = "<Deposit>") =
    if (amount > 0.0) {
      tx += Transaction(amount, reason, java.time.LocalDateTime.now())
      true
    }
    else
      false

  def withdraw(amount: Double, reason: String = "<Withdraw>") =
    if (amount > 0.0 && balance-amount >= 0.0) {
      tx += Transaction(-amount, reason, java.time.LocalDateTime.now())
      true
    }
    else
      false

  // We now need to calculate the balance
  def balance = {
    tx.foldLeft(0.0)((a,b) => a + b.amount)
  }

  // Return an immutable list as a statement on the account
  def transactions: List[Transaction] = tx.toList
}

val acc = new Account(1000, "Account1", 100.0)
acc deposit(50.0, "Check")
acc balance   // should be 150.0

acc withdraw(30, "Meal")
acc deposit(50.0, "Bonus")
acc.balance   // should be 170.0

acc deposit(500.0, "Salary")
acc deposit(50.0, "Gift")
acc withdraw(100, "Insurance")

// Print the transaction list
acc.transactions foreach println

// Only print deposits
acc.transactions
    .filter(_.amount > 0.0)
    .foreach(println)

// What are the totals for deposits and withdrawals?
acc.transactions
    .groupBy(_.amount > 0)
    .values
    .map(_.foldLeft(0.0)(_ + _.amount))
    .toList
