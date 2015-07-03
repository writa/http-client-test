lazy val root = (project in file(".")).settings(
  name := "http-client-test",
  version := "0.1.0",
  scalaVersion := "2.11.7"
)

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5"
