package com.example


sealed trait Expression

object Expression {

  final case class Add(l: Expression, r: Expression) extends Expression

  final case class Multiple(l: Expression, r: Expression) extends Expression

  final case class Literal(value: Int) extends Expression

}


