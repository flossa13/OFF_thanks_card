name := """thanks_card_pj"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1205-jdbc4"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.mindrot" % "jbcrypt" %  "0.3m"
  )
