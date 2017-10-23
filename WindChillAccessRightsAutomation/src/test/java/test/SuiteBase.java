package test;

import java.io.UnsupportedEncodingException;

import org.testng.annotations.AfterSuite;

import com.schneider.windchillaccessrightsvalidation.genericlibraries.GenericFunctionLibrary;

/**
 * @author MADHUBABU
 * 30-Nov-2016
 */
public class SuiteBase {
@AfterSuite

public void quitBrowser() throws UnsupportedEncodingException{
	GenericFunctionLibrary.closeDriver();
	EmailNotification.sendMailwithAttachment("This is to Test Email Notification");
}

/*
@BeforeSuite
public void launchBrowser() throws IOException, InterruptedException{
	GenericFunctionLibrary.launchServer();
}
*/

}
