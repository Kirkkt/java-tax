#!/bin/bash

sanitycheck.sh

# compile java
javac -Xlint:deprecation \
    -sourcepath $GITHUB_DIR/java_tax/src \
    -cp $JAVA_CLASS_PATH \
    -d $GITHUB_DIR/java_tax/class \
    src/com/kirkkt/java/tax/*.java \
    src/com/kirkkt/java/tax/forms/*.java \
    src/com/kirkkt/java/tax/forms/input/*.java \
    src/com/kirkkt/java/tax/forms/fillable/*.java \
    src/com/kirkkt/java/tax/forms/fillable/federal/*.java \
    src/com/kirkkt/java/tax/forms/fillable/federal/worksheets/*.java \
    src/com/kirkkt/javatests/tax/*.java \
    src/com/kirkkt/javatests/tax/forms/input/*.java \
    src/com/kirkkt/javatests/tax/forms/fillable/federal/worksheets/*.java

cd class

# run tax test
java \
    -cp $JAVA_CLASS_PATH \
    -ea com/kirkkt/javatests/tax/TestRunner

cd ..
