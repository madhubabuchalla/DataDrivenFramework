cd d:
set projectpath = D:\git-local-repository\DataDrivenFramework\WindChillAccessRightsAutomation\
cd %projectpath%
call mvn clean test -DsuiteXmlFile=TestSuites\CADDocumentTestSuite.xml
pause