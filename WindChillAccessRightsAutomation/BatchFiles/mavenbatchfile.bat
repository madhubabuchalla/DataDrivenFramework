REM navigate to the drive in which your project located using d: command
:: set the path of the project using set command
:: navigate to the project location
REM call the maven command using call by spacifying path of the testng.xml file

d:
set projectpath = D:\git-local-repository\DataDrivenFramework\WindChillAccessRightsAutomation\
cd D:\git-local-repository\DataDrivenFramework\WindChillAccessRightsAutomation\
call mvn clean test -DsuiteXmlFile=TestSuites\CADDocumentTestSuite.xml
pause