#!/usr/bin/env bash

# Build CLASS_PATH
for j in `find conf lib -name "*"`; do
    CLASS_PATH=$CLASS_PATH:$j
done

JAVA_CMD=$([ -n "${JAVA_HOME}" ] && echo ${JAVA_HOME}/bin/)java

${JAVA_CMD} \
    -cp ${CLASS_PATH} \
    -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
    ychernenko.examples.rest.standalone.Main

