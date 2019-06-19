package com.example
import Expression._

object App {

  implicit class IntExtensions(i: Int) {
    def lit: Expression = Literal(i)
  }

  val str = "3+1*(2+5+3)"

  "3 + 1 + 2"

  "(3 + 1) + 2"

  Add(Add(Literal(3), Literal(1)), Literal(2))

  def main(args: Array[String]) = {

  }

  val operatorChars = Set[Char]('+', '*', '(', ')')

  def parse(str: String): Expression = {
    val idx = str.indexWhere(c => operatorChars.contains(c))

    if (idx < 0) str.toInt.lit else {
      val (first, second) = str.splitAt(idx)
      val (op, restExp) = second.splitAt(1)
      val firstLiteral = first.toInt.lit
      if (op.isEmpty) firstLiteral else {
        op.charAt(0) match {
          case '+' => Add(firstLiteral, parse(restExp))
          case '*' => Multiple(firstLiteral, parse(restExp))
        }
      }

    }
  }

  def evaluate(expr: Expression): Int = ???

}
