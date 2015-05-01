#!/bin/bash

if [ -z "$GITHUB_DIR" ] ; then
  echo "please define \$GITHUB_DIR"
fi

if [ -z "$JAVA_CLASS_PATH" ] ; then
  echo "please define \$JAVA_CLASS_PATH"
fi

# TODO(kirktdev): check third-party packages
