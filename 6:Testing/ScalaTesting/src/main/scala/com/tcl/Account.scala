package com.tcl

/**
  * Created by julian on 17/08/2016.
  */
class Account(val number: Long, val name: String, val openingBalance: Double = 0.0) {
  private var theBalance: Double = openingBalance
  def balance = theBalance

  def deposit(amount: Double) =
    if (amount > 0.0) {
      theBalance += amount
      true
    }
    else
      false

  def withdraw(amount: Double) =
    if (amount > 0.0 && balance-amount >= 0.0) {
      theBalance -= amount
      true
    }
    else
      false
}
