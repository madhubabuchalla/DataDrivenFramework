package test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.schneider.windchillaccessrightsvalidation.utilities.ExcelUtil;

public class TestDataProvider {
	Object[][] retObjArr = null;
    int rowCount; 
    int colCount;
    ExcelUtil excel = null;
  String filePath = "C:\\Users\\SESA439753\\git-local-repository\\ssowindchillaccessrightsautomation\\WindChillAccessRightsAutomation\\SourceFiles\\Schneider WindChill Document Types and Access Rights_Manufacturer Part.xls";
  
  
   @DataProvider
    public Object[][] getExcelData() throws Exception {
    	excel = new ExcelUtil(filePath);
        retObjArr = excel.getTableArray("Approver");
        System.out.println("getExcelData function executed!!");
        return retObjArr;
    }


  @Test(dataProvider = "getExcelData")
    public void printdata(String ObjectName, String Status, String Template, String Role, String Create, String CreateByMove, String Read, String Download, String Modify, String MC, String MI, String Dlt, String Revise, String SS, String CD, String CC){
           System.out.println(ObjectName);
           System.out.println(Status);
           System.out.println(Template);
           System.out.println(Role);
           System.out.println(Create);
           System.out.println(CreateByMove);
           System.out.println(Read);
           System.out.println(Download);
           System.out.println(Modify);
           System.out.println(MC);
           System.out.println(MI);
           System.out.println(Dlt);
           System.out.println(Revise);
           System.out.println(SS);
         
    }

   
   
}

