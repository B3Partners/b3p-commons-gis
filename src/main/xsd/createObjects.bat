@echo off
REM Change the following line to set your JDK path
set JDK_DIR=%JAVA_HOME%

@echo Create the classpath
set CP=;
for %%i in (..\dist\lib\*.jar) do call cp.bat %%i
set CP=%CP%;"%JDK_DIR%\lib\tools.jar"
echo %CP%

@echo Codetabellen import
@echo.
@echo Generating classes...

@rem Java 2 style collection types

@echo GML
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/customGML.xsd -f -types j2 -package nl.b3p.xml.gml.v311
@echo OGC
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/expr.xsd -f -types j2 -package nl.b3p.xml.ogc.v110
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/filter.xsd -f -types j2 -package nl.b3p.xml.ogc.v110
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/filterCapabilities.xsd -f -types j2 -package nl.b3p.xml.ogc.v110
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/sort.xsd -f -types j2 -package nl.b3p.xml.ogc.v110
@echo OWS
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsAll.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/ows19115subset.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsCommon.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsDataIdentification.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsExceptionReport.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsGetCapabilities.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsOperationsMetadata.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsServiceIdentification.xsd -f -types j2 -package nl.b3p.xml.ows.v100
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/owsServiceProvider.xsd -f -types j2 -package nl.b3p.xml.ows.v100
@echo XLINK
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/xlinks.xsd -f -types j2 -package nl.b3p.xml.xlink
@echo WFS
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i WFS110/v110/wfs.xsd -f -types j2 -package nl.b3p.xml.wfs.v110

@echo.
@echo About to compile generated source code... Check for failures
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\gml\v311\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\ogc\v110\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\ows\v100\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\xlink\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\wfs\v110\*.java
@pause
@echo removing .class files en .cdr files
@echo off
del /s *.class
del /s *.cdr
@pause