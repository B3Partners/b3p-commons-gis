@echo off
REM Change the following line to set your JDK path
set JDK_DIR=%JAVA_HOME%

@echo Create the classpath
set CP=;
for %%i in (..\lib\*.jar) do call cp.bat %%i
set CP=%CP%;"c:\dev\castor\lib\castor-1.0.2.jar"
set CP=%CP%;"%JDK_DIR%\lib\tools.jar"
echo %CP%

@echo Codetabellen import
@echo.
@echo Generating classes...

@rem Java 2 style collection types

@echo custom_wfs_1.1.0.xsd
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i custom_wfs_1.1.0.xsd -f -types j2 -package nl.b3p.ogc.wfs.v110
@echo filter.xsd
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i filter.xsd -f -types j2 -package nl.b3p.ogc.filter.v110

@echo.
@echo About to compile generated source code... Check for failures
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\ogc\wfs\v110\*.java

@echo removing .class files en .cdr files
@echo off
del /s *.class
del /s *.cdr
@pause