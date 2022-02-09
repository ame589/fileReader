
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "fileReader",
    mainClass in assembly := Some("com.nttdata.fileReader.Main")
  ).enablePlugins(JavaAppPackaging)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  "fileReader" + "." + artifact.extension
}