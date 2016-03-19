package com.mooney_ware.cli_repl

class CliBuilder[A](commandList: List[Command[A]] = List.empty) {

  private def addCommand(command: Command[A]) = {
    new CliBuilder(commands :+ command)
  }

  def :+ = addCommand _

  def commands() = this.commandList

  def build() : Cli[A] = findAndExecute

  private def findAndExecute(args: List[String]) = args match {
    case x :: xs => commandList filter { _.name() == x} map { _.action(xs) }
  }
}

object CliBuilder {
  def apply[A]() = new CliBuilder[A]()
}
