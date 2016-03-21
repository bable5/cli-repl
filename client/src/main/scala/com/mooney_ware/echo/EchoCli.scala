package com.mooney_ware.echo

import com.mooney_ware.cli_repl.{CliBuilder, Command, Repl}

object EchoCli {

  def main(args: Array[String]): Unit = {
    val builder = CliBuilder() :+ new Echo

    if (args.length == 0) {
      new Repl(">>>").repl(builder)
    } else {
      builder.build().apply(args.toList).foreach(println(_))
    }
  }
}

class Echo extends Command[String] {
  override def name() = "echo"

  override def action(args: Seq[String]) = {
    if( args.nonEmpty){
      args.head
    } else {
      "Nothing to echo!"
    }
  }

}
