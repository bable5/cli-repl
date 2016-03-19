package com.mooney_ware

package object cli_repl {
  type Cli[A] = List[String] => List[A]
}
