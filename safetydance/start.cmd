del /s /q *.class
@echo off
javac -cp ".;sqlite-jdbc-3.49.1.0.jar" Planer.java
@echo on
java -cp ".;sqlite-jdbc-3.49.1.0.jar" Planer
pause