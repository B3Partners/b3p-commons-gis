@echo off
REM Change the following line to set your JDK path
set JDK_DIR=%JAVA_HOME%

@echo Create the classpath
set CP=;
for %%i in (..\..\..\dist\lib\*.jar) do call cp.bat %%i
set CP=%CP%;"%JDK_DIR%\lib\tools.jar"
echo %CP%

@echo Codetabellen import
@echo.
@echo Generating classes...

@rem Java 2 style collection types

@echo WFS1
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i ../v100/WFS-capabilities.xsd -types j2 -package nl.b3p.xml.wfs.v100.capabilities -binding-file WFS-capabilities_binding.xml

@pause