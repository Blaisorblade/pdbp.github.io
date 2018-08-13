// val dottyVersion = "0.8.0"
// val dottyVersion = "0.9.0-bin-20180704-94d8e94-NIGHTLY"
//val dottyVersion = "0.9.0-RC1"

//lazy val root = project
//  .in(file("."))
//  .settings(
//    name := "pdbp",
//    version := "0.1.0",
//
//    scalaVersion := dottyVersion,
//
//    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
//  )


lazy val root = project
  .in(file("."))
  .settings(
    name := "pdbp",
    description := "Program Description Based Programming",
    version := "0.1.0",

    scalaVersion := "0.8.0" // "0.9.0-RC1"
  )