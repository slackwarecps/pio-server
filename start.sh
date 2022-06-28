#!/bin/bash

if [ -z "$SPRING_BOOT_VM_OPTIONS" ]
then
  export SPRING_BOOT_VM_OPTIONS="-server -d64 -Xms512m -Xmx1g -Xmn256m -XX:+UseParallelGC"
  echo SPRING_BOOT_VM_OPTIONS=$SPRING_BOOT_VM_OPTIONS
fi


#java $SPRING_BOOT_VM_OPTIONS -jar app.jar $AMBIENTE
java -jar app.jar
