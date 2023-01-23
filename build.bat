@echo off
cd src
javac --release 8 -d ../bin/classes game24/**.java
cd ../bin/classes
jar -cef game24.Game24 ../libs/Game24.jar *
cd ../..