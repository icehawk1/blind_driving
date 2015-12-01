#!/bin/sh
# Change to directory where .jar is located
# DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$( dirname "${BASH_SOURCE[0]}" )
echo $DIR
cd $DIR
java -cp .:./HCI-Exercise-Blind-Driving.jar:lib/freetts.jar:lib/freetts-jsapi10.jar de.mhaug.blinddriving.Main
