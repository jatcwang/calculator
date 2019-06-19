package com.example

import org.scalatest.{Matchers, WordSpec}

class MySpec extends WordSpec with Matchers {
  import App._

  "simple case" in {
    parse("234+343") shouldBe Add(234.lit, 343.lit)
  }

  "simple case single lit" in {
    parse("2") shouldBe 2.lit
  }

  "paren first" in {
    parse("(1+2)+2") shouldBe Add(Add(1.lit, 2.lit), 2.lit)
  }
}
