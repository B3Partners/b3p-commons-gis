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
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/customGML.xsd  -types j2 -package nl.b3p.xml.gml.v311
@echo OGC
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/expr.xsd  -types j2 -package nl.b3p.xml.ogc.v110 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/filter.xsd  -types j2 -package nl.b3p.xml.ogc.v110 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/filterCapabilities.xsd  -types j2 -package nl.b3p.xml.ogc.v110 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/sort.xsd  -types j2 -package nl.b3p.xml.ogc.v110 -binding-file binding.xml
@echo OWS
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsAll.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/ows19115subset.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsCommon.xsd -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsDataIdentification.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsExceptionReport.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsGetCapabilities.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsOperationsMetadata.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsServiceIdentification.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/owsServiceProvider.xsd  -types j2 -package nl.b3p.xml.ows.v100 -binding-file binding.xml
@echo XLINK
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/xlinks.xsd  -types j2 -package nl.b3p.xml.xlink
@echo WFS
"%JDK_DIR%\bin\java" -cp %CP% org.exolab.castor.builder.SourceGenerator -i v110/wfs.xsd  -types j2 -package nl.b3p.xml.wfs.v110 -binding-file binding.xml

@echo.
@echo About to compile generated source code... Check for failures
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\xlink\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\gml\v311\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\ogc\v110\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\ows\v100\*.java
@pause
"%JDK_DIR%\bin\javac" -classpath %CP% nl\b3p\xml\wfs\v110\*.java
@pause
@echo removing .class files en .cdr files
@echo off
del /s *.class
del /s *.cdr
@pause