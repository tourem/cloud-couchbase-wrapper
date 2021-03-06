name := "couchbasestreamswrapper"

organization := "io.dronekit"

version := "2.4.1"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-language:postfixOps")

resolvers += "Artifactory" at "https://dronekit.artifactoryonline.com/dronekit/libs-snapshot-local/"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

isSnapshot := true

publishTo := {
  val artifactory = "https://dronekit.artifactoryonline.com/"
  if (isSnapshot.value)
    Some("snapshots" at artifactory + s"dronekit/libs-snapshot-local;build.timestamp=${new java.util.Date().getTime}")
  else
    Some("snapshots" at artifactory + "dronekit/libs-release-local")
}

libraryDependencies ++= {
  val scalaTestV = "2.2.6"
  val akkaV = "2.4.4"
  Seq(
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaV,
    "io.spray" %%  "spray-json" % "1.3.2",
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
    "com.couchbase.client" % "java-client" % "2.2.6",
    "io.reactivex" % "rxjava-reactive-streams" % "1.0.1",
    "io.reactivex" %% "rxscala" % "0.26.1",
    "joda-time" % "joda-time" % "2.9.1",
    "org.scalatest" %% "scalatest" % scalaTestV % "test"
  )
}
