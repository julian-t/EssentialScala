package com.tcl

// Import what we need
import scala.util.{Random, Success, Failure}
import scala.concurrent._
import ExecutionContext.Implicits.global

/**
  * Created by julian on 11/09/2016.
  */
object Futures {
  def main(args: Array[String]): Unit = {
    println("Futures!")

    val r = new Random

    // Create two Futures
    val f1 = Future {
      Thread.sleep(r.nextInt(1000))
      val t = r.nextInt(100)
      println(s"f1: $t")
      t}

    val f2 = Future {
      Thread.sleep(r.nextInt(1000))
      val t = r.nextInt(100)
      println(s"f2: $t")
      t}

    // Combine their result in a for
    val result = for {
      val1 <- f1
      val2 <- f2
    } yield val1 > val2

    result.foreach(n => println(n))
    result.failed.foreach(ex => println("failed!"))

    Thread.sleep(2000)
  }
}
