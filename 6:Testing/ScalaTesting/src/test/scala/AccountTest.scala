import org.scalatest._
import com.tcl.Account

/**
  * Created by julian on 17/08/2016.
  */
class AccountTest extends FlatSpec with Matchers {
  "An Account" should "have a zero balance when created with no opening balance" in {
    val acc = new Account(100, "Account1")
    acc.balance should be (0.0)
  }

  it should "have the correct balance when given an opening amount" in {
    val acc = new Account(100, "Account1", 150.0)
    acc.balance should be (150.0)
  }

  it should "have the correct balance on a single deposit (no opening balance)" in {
    val acc = new Account(100, "Account1")
    acc.deposit(100.0)
    acc.balance should be (100.0)
  }

  it should "have the correct balance on a single deposit (opening balance)" in {
    val acc = new Account(100, "Account1", 100.0)
    acc.deposit(120.0)
    acc.balance should be (220.0)
  }

  it should "have the correct balance on a multiple deposits (no opening balance)" in {
    val acc = new Account(100, "Account1")
    acc.deposit(100.0)
    acc.deposit(10.0)
    acc.balance should be (110.0)
  }

  it should "have the correct balance on a multiple deposits (opening balance)" in {
    val acc = new Account(100, "Account1", 75.0)
    acc.deposit(100.0)
    acc.deposit(10.0)
    acc.balance should be (185.0)
  }

  it should "have the correct balance on a single withdraw from opening balance" in {
    val acc = new Account(100, "Account1", 100.0)
    acc.withdraw(20.0)
    acc.balance should be (80.0)
  }

  it should "have the correct balance on a multiple withdraws from opening balance" in {
    val acc = new Account(100, "Account1", 100.0)
    acc.withdraw(20.0)
    acc.withdraw(25.0)
    acc.balance should be (55.0)
  }

  it should "have the correct balance on a single withdraw from single deposit" in {
    val acc = new Account(100, "Account1")
    acc.deposit(100.0)
    acc.withdraw(20.0)
    acc.balance should be (80.0)
  }

  it should "have the correct balance on a multiple withdraws from single deposit" in {
    val acc = new Account(100, "Account1")
    acc.deposit(100.0)
    acc.withdraw(20.0)
    acc.withdraw(25.0)
    acc.balance should be (55.0)
  }

  it should "have the correct balance on a multiple withdraws from multiple deposits" in {
    val acc = new Account(100, "Account1")
    acc.deposit(100.0)
    acc.withdraw(20.0)
    acc.deposit(100.0)
    acc.withdraw(25.0)
    acc.balance should be (155.0)
  }
  it should "not overdraw, balance unchanged" in {
    val acc = new Account(100, "Account1")
    acc.deposit(90.0)
    assert(acc.withdraw(100.0) == false)
    acc.balance should be (90.0)
  }

  it should "withdraw to 0.0" in {
    val acc = new Account(100, "Account1")
    acc.deposit(90.0)
    assert(acc.withdraw(90.0) == true)
    acc.balance should be (0.0)
  }
}
