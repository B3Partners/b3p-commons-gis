@echo off
REM Change the following line to set your JDK path
set JDK_DIR=%JAVA_HOME%

@echo Create the classpath
set CP=;
for %%i in (..\lib\*.jar) do call cp.bat %%i
set CP=%CP%;"%JDK_DIR%\lib\tools.jar"
echo %CP%

@echo Codetabellen import
@echo.
@echo Generating classes...

@rem Java 2 style collection types

@echo GML
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/customGML.xsd -f -types j2 -package nl.b3p.xml.gml.v212
@echo OGC
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/filter.xsd -f -types j2 -package nl.b3p.xml.ogc.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/filterCapabilities.xsd -f -types j2 -package nl.b3p.xml.ogc.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/expr.xsd -f -types j2 -package nl.b3p.xml.ogc.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/OGC-exception.xsd -f -types j2 -package nl.b3p.xml.ogc.v100
@echo WFS
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/WFS-basic.xsd -f -types j2 -package nl.b3p.xml.wfs.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/WFS-capabilities.xsd -f -types j2 -package nl.b3p.xml.wfs.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v100/WFS-transaction.xsd -f -types j2 -package nl.b3p.xml.wfs.v100

@echo.
@echo About to compile generated source code... Check for failures
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\gml\v212\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\ogc\v100\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\wfs\v100\*.java
@pause
@echo removing .class files en .cdr files
@echo off
del /s *.class
del /s *.cdr
@pause