name := "Tutorial-3-CoreNLP"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq (
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0" classifier "models",
  "com.google.protobuf" % "protobuf-java" % "2.6.1"
)