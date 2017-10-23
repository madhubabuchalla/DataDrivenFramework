package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.schneider.windchillaccessrightsvalidation.utilities.ExcelUtil;

public class FetchDataOnRowBase {

    ExcelUtil excel = null;
  String filePath = "C:\\Users\\SESA439753\\git-local-repository\\ssowindchillaccessrightsautomation\\WindChillAccessRightsAutomation\\SourceFiles\\Schneider WindChill Document Types and Access Rights_Manufacturer Part.xls";
  int rowNumber = 2;
  
@BeforeTest
  
    public void init() throws Exception {
    	excel = new ExcelUtil(filePath);
}
    
    @Test
    public void testmethod1() throws Exception{
    	
    	Object[][] rowData = excel.getExcelData("Approver", rowNumber);
    	
    	for(int i = 0; i<16; i++){
    	System.out.println(rowData[rowNumber][i].toString());
    	}
    }
    
    @Test
    public void testmethod2() throws Exception{
    	
    	excel.fetchColumnValue("Approver", 2, "Modify");
    	
    }
}

