package com.mooney_ware.cli_repl

import org.scalatest.FlatSpec

class ArgsParseSpec extends FlatSpec {
  "An empty set" should "have size 0" in {
    assert(Set.empty.size === 0)
  }
}
