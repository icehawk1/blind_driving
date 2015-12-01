REM Change to directory where .jar is located
cd /D %~dp0
echo %~dp0
java -cp ".:HCI-Exercise-Blind-Driving.jar:lib/freetts.jar:lib/freetts-jsapi10.jar" de.mhaug.blinddriving.Main
