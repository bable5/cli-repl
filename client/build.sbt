name := "repl-client"

organization := "com.mooney_ware"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= List(
  "org.scribe" % "scribe" % "1.3.2",

  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)
