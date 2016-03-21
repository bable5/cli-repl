package com.mooney_ware.cli_repl

import scala.annotation.tailrec

class Repl(prompt: String) {
  def repl(builder: CliBuilder[String]) = {
    val cli = (builder :+ new ExitCommand) build()

    @tailrec
    def replImpl(): Unit = {
      try {
        eval(read(), cli) foreach{ println }
      } catch {
        case e: ExitReplException => println("Good Bye"); return
        case e: Exception => System.err.println(e.getMessage)
      }
      replImpl()
    }

    replImpl()
  }

  def read(): List[String] = {
    print(s"$prompt ")
    scala.io.StdIn.readLine.trim.split("\\s").toList
  }

  def eval(args: Seq[String], cli: Cli[String]) = cli.apply(args)
}

object Repl {
  def apply(prompt: String) = new Repl(prompt)
}

private class ExitCommand extends Command[String] {
  override def name() = "exit"

  override def action(args: Seq[String]) = throw new ExitReplException
}

private class ExitReplException extends RuntimeException
