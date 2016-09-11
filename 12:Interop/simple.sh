#!/bin/sh
# compile the Scala
scalac Test.scala

# compile the Java, using the Scala library
javac -cp $SCALA_HOME/lib/scala-library.jar:. Prog.java

# run the code
java -cp $SCALA_HOME/lib/scala-library.jar:. Prog

