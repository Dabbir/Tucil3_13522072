@echo off
set SRC_DIR=src
set BIN_DIR=bin
set NODES_DIR=%SRC_DIR%\nodes
set DICTIONARY_DIR=%SRC_DIR%\dictionary
set ALGORITHMS_DIR=%SRC_DIR%\algorithms
set INTERFACE_DIR=%SRC_DIR%\interfaces
set CLASSPATH=%BIN_DIR%

:: Buat folder bin jika belum ada
if not exist ../%BIN_DIR% mkdir %BIN_DIR%

:: Compile semua file Java ke dalam folder bin
javac -d %BIN_DIR% %ALGORITHMS_DIR%\algorithm.java %ALGORITHMS_DIR%\UCS.java %ALGORITHMS_DIR%\GreedyBFS.java %ALGORITHMS_DIR%\AStar.java
javac -d %BIN_DIR% %DICTIONARY_DIR%\Dictionary.java
javac -d %BIN_DIR% %INTERFACE_DIR%\FunctionValue.java %INTERFACE_DIR%\GValue.java %INTERFACE_DIR%\HValue.java 
javac -d %BIN_DIR% %NODES_DIR%\Nodes.java
javac -d %BIN_DIR% %SRC_DIR%\Driver.java
javac -d %BIN_DIR% %SRC_DIR%\Main.java

:: Periksa exit code dari Java program
if %ERRORLEVEL% NEQ 0 (
  echo Error: Java program exited with an error code.
  exit /b %ERRORLEVEL%
)

:: Jalankan aplikasi Anda dari folder bin
java -cp %CLASSPATH% Main

:: Tunggu sebentar sebelum menutup jendela
pause