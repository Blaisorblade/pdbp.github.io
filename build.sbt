val dottyVersion = "0.8.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "pdbp",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
