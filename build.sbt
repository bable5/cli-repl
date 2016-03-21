name := "cli-repl-parent"

version := "1.0"

scalaVersion := "2.11.7"

lazy val root = project.in( file("."))
    .aggregate(cli_repl)


lazy val cli_repl = project.in( file("cli-repl"))

lazy val client = project.in( file("client")).dependsOn(cli_repl)

