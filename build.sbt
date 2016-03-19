//name := "cli-repl-parent"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

lazy val root = project.in( file("."))
    .aggregate(cli_repl)

lazy val cli_repl = project.in( file("cli-repl"))

