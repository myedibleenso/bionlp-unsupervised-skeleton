name := "bionlp-unsupervised-skeleton"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "com.typesafe" % "config" % "1.3.0",
  // Access to BioNLPProcessor, Odin, etc
  // "org.clulab" % "bioresources" % "1.1.8",
  "org.clulab" %% "processors" % "5.8.4",
  "org.clulab" %% "processors" % "5.8.4" classifier "models",
  // for unsupervised learning algorithms
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.apache.spark" % "spark-mllib_2.11" % "1.6.1"
  // "commons-io" % "commons-io" % "2.5"
)
    