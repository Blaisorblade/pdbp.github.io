// val dottyVersion = "0.7.0-RC1"
val dottyVersion = "0.8.0-bin-20180401-14187e2-NIGHTLY"

lazy val root = (project in file(".")).
  settings(
    name := "dotty-simple",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
