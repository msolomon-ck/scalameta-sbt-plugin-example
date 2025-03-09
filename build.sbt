import Dependencies._

ThisBuild / scalaVersion := "2.13.13"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val parseTree = taskKey[Unit]("parse the source code")

libraryDependencies ++= Seq(
  "org.scalameta" %% "scalameta" % "4.13.3",
  "org.scalameta" %% "munit" % "0.7.29" % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "scalameta-example"
  )