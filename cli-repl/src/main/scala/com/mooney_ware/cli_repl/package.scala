package com.mooney_ware

package object cli_repl {
  type Cli[A] = Seq[String] => Seq[A]
  type Printable = {def toString: String}
}
