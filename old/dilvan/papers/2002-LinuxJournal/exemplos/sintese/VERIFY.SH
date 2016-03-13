#!/bin/sh

# 
# Execute the Hello program.  You must first execute the install procedure
# (install.sh) as root.
# 

export CLASSPATH=/usr/local/jdk1.2.2/ibmjs/lib/ibmjs.jar:$CLASSPATH
export LD_LIBRARY_PATH=/usr/local/jdk1.2.2/ibmjs/lib:$LD_LIBRARY_PATH
. vvsetenv
java -native sintese_exemplo4

