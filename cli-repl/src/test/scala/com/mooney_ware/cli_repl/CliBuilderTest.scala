package com.mooney_ware.cli_repl

import org.scalatest.FlatSpec

class CliBuilderTest extends FlatSpec {

  "An empty builder" should "add a new command" in {
    val someCommand = TestCommand("c")
    val builder = CliBuilder[Int]() :+ someCommand

    assert(builder.commands === List(someCommand))
  }

  "An existing builder" should "extend its command list" in {
    val command1 = TestCommand("1")
    val builder = new CliBuilder(List(command1))

    val command2: TestCommand = TestCommand("Second")
    val builder2 = builder :+ command2

    assert(builder2.commands === List(command1, command2))
  }

  "Building a list of commands" should "produce a function that can execute commands" in {
    val command1 = TestCommand("1", 1)
    val command2 = TestCommand("Second", 2)

    val cli: Cli[Int] = new CliBuilder(List(command1, command2)).build()
    assert(cli.apply("Second" :: Nil) == List(2))
  }

  case class TestCommand(testCommand: String, value: Int = 1) extends Command[Int] {
    override def name(): String = testCommand

    override def action(args: Seq[String]): Int = value
  }

}
