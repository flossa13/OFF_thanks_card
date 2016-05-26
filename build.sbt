name := """thanks_card_pj"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1101-jdbc41"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)
