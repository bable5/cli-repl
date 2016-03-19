package com.mooney_ware.cli_repl

trait Command[A] {
  def name(): String
  def action(args: Seq[String]): A
}
