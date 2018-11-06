@ECHO OFF
REM This run.bat file should be ran inside /src folder.
ECHO Compiling code.
javac ie/ucd/the/game/of/life/*.java

IF /I "%ERRORLEVEL%" NEQ "0" (
    ECHO COMPILATION FAILED
)

IF /I "%ERRORLEVEL%" EQU "0" (
    ECHO Running compiled code.
    java ie.ucd.the.game.of.life.Main
)

