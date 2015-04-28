#!/bin/bash

sanitycheck.sh

# compile java
javac \
    -sourcepath $GITHUB_DIR/java_tax/src \
    -cp $JAVA_CLASS_PATH \
    -d $GITHUB_DIR/java_tax/class \
    src/com/kirkkt/java/tax/*.java \
    src/com/kirkkt/java/tax/forms/*.java \
    src/com/kirkkt/java/tax/forms/input/*.java \
    src/com/kirkkt/java/tax/forms/fillable/*.java \
    src/com/kirkkt/java/tax/forms/fillable/federal/worksheets/*.java

cd class

# run prod
java \
    -cp $JAVA_CLASS_PATH \
    com/kirkkt/java/tax/ProdRunner

cd ..
