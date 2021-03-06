package com.schneider.windchillaccessrightsvalidation.testdatacreation;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schneider.windchillaccessrightsvalidation.genericlibraries.Authentication;
import com.schneider.windchillaccessrightsvalidation.genericlibraries.Config;
import com.schneider.windchillaccessrightsvalidation.genericlibraries.GenericFunctionLibrary;
import com.schneider.windchillaccessrightsvalidation.utilities.ExcelUtil;


/**
 * @author MADHUBABU
 * 30-Oct-2016
 */

public class ChangeNoticeTestDataCreation {
	
	static Logger log = Logger.getLogger(ChangeNoticeTestDataCreation.class);
	private static final Logger reportLog = Logger.getLogger("reportsLogger");
	String ObjectType =Config.CHANGE_NOTICE;	
		
	String documentName = null;
	String currentRole = null;
	String currentTemplate = null;
	String status = null;
	Authentication auth = new Authentication();
	//String filename="DONOTDELETE_TESTING_FOR_CHANGENOTICE";
	TestDataCreationUtil testDataUtil = new TestDataCreationUtil();
	
	ExcelUtil excel = null;
	
// ExcelInput = "C:\\Users\\SESA439753\\Desktop\\Schneider Documents and Access Rights.xls";
	
	String ExcelInput = Config.NEXTGEN_ACCESS_RIGHTS_MANAGEMENT_FILEPATH;

	@BeforeClass
	public void init() {
		excel = new ExcelUtil(ExcelInput);
		log.info(ExcelInput+ " is initiated");
	}

@Test
public void testDataCreationForForChangeNotice() throws Exception {
	
	log.info("####################### "+ObjectType+ " Test Data Creation Script Execution started  ##################################"  );
	reportLog.info("####################### "+ObjectType+ " Test Data Creation Script Execution started  ##################################"  );
	
	int initialRowNumber = Config.changeNoticeTestDataSuiteInitialRowNumber-1;
	for (int i = initialRowNumber; i <= excel.getRowCount(ObjectType); i++) {

		
		log.info("####################### Execution Started for the Row Number "+ (i+1) +" in " +ObjectType+" Sheet ##################################"  );
		reportLog.info("####################### Execution Started for the Row Number "+ (i+1) +" in " +ObjectType+" Sheet ##################################"  );
		
		currentRole = excel.getData(ObjectType, i, "Role").trim();
		currentTemplate = excel.getData(ObjectType, i, "Product / Library Template").trim();
		status = excel.getData(ObjectType, i, "Status").trim();
		
		log.info("Object Type is : "+ObjectType + " and Current Template is : " + currentTemplate + " and Status of the "+ ObjectType   + " is : "+ status);
		reportLog.info("Object Type is : "+ObjectType + " and Current Template is : " + currentTemplate + " and Status of the "+ ObjectType   + " is : "+ status);
		
		String deleteAccess = excel.getData(ObjectType, i, "Delete").trim();	
		String setStateAccess = excel.getData(ObjectType, i, "Set State").trim();
	
		

			if(currentTemplate.contains("Product")){
				   currentRole = "Product Manager";
				  } else if(currentTemplate.contains("Library")){
				   currentRole = "Library Manager";
				  }
			
			if(currentTemplate.contains("Restricted")){
				documentName = Config.RESTRICTED+Config.CHANGE_NOTICE_NAME;
				  } else {
					  documentName = Config.CHANGE_NOTICE_NAME;  
				  }
			
			String Role = auth.getUserRole(currentTemplate);
			
			System.out.println(Role);
			
			if (Role.equalsIgnoreCase(Config.PRODUCT_MANAGER)||Role.equalsIgnoreCase(Config.LIBRARY_MANAGER)){
				
				//if(WindChillAccessRightsValidationUtil.navigateToRequiredLocation(currentTemplate, Config.fetchContainerOrLibrary(currentTemplate))){
				
				log.info("User is Navigated to " + currentTemplate +" and "+ Config.fetchContainerOrLibrary(currentTemplate));
			
			GenericFunctionLibrary.refreshWindow();
			Thread.sleep(2000);
			
			
				//testDataUtil.isContentAvailableAndClick(Config.TESTDATA_FOLDER);		
		
int k=1;
		
		if(deleteAccess.equals("P")){
			k=k+1;
		}
		
		if(setStateAccess.equals("P")){
			k=k+1;
		}
		
log.info("No of Records required for " +(i+1)+" row is "+k);
		
		for( int j=1;j<=k;j++)	{				
					
					 String fileName=testDataUtil.createChangeNoticeAccessRightValidation(Config.DESCRIBEDOCUMENT_FOR_CHANGE_NOTICE, currentTemplate, Config.fetchContainerOrLibrary(currentTemplate), documentName);
					 log.info("Create document Name is : "+fileName);
						
						
							if (!fileName.equals(null)) {
								reportLog.debug("Created data set Name is : "+fileName);	
							
					 if(!status.equals("Open"))	{				
						 if(testDataUtil.setStateRightAccessValidationWithAdvSearch(fileName, status, ObjectType)){
							 reportLog.debug("data set has changed to : " +status + " status ");
						 }else{
							 reportLog.error("data set has not changed to : " +status + " status ");
						 }
					 }else{
							reportLog.info("expected state is " +status + " status hence No need to change the state");
						}
					
							}else{
								log.info("document is not created. Set State action cannot be executed");
								reportLog.info("document is not created. Set State action cannot be executed");
							}

				
						
			} // for j loop end
			
					
				}else {
					
					log.info("User is not Valid. This User ID is not mapped in Authentication Details SSO.xls");
					reportLog.warn("User is not Valid. This User ID is not mapped in Authentication Details SSO.xls");
				}
				
				log.info("####################### Execution Completed for the Row Number "+ (i+1) +" in " +ObjectType+" Sheet ##################################"  );
				reportLog.info("####################### Execution Completed for the Row Number "+ (i+1) +" in " +ObjectType+" Sheet ##################################"  );
				
					
							
	}// for i loop end

	}

	}



