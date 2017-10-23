package com.schneider.windchillaccessrightsvalidation.genericlibraries;

import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author SESA439753
 *
 */

public class Driver  {

	public static WebDriver driver = null;
	public static WebDriver ExistingchromeBrowser;
	public static WebDriver ExistingmozillaBrowser;
	public static WebDriver ExistingIEBrowser;
	
	private static Logger log = Logger.getLogger(Driver.class);
	
	
	public static void driverManager() throws Exception {
		
		try {

			if (Config.BROWSER == null) {

				log.warn("Driver is NOT Specified in Config.java file for the BROWSER variable");

			} else {
				
	// Check If any previous webdriver browser Instance Is exist then run new test in that existing webdriver browser Instance.

				 if (Config.BROWSER.equalsIgnoreCase("chrome") && ExistingchromeBrowser != null) {
					driver = ExistingchromeBrowser;
					log.info("taken the existing chrome instance");
					return;
				}

				 if (Config.BROWSER.equalsIgnoreCase("Chrome")) {
					// Load Chrome driver Instance.
					if(Config.EXECUTE_ON.equalsIgnoreCase("local")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
					driver = new ChromeDriver();
					ExistingchromeBrowser = driver;
					log.info("Chrome Driver Instance loaded successfully.");
					
					} else if(Config.EXECUTE_ON.equalsIgnoreCase("remote")){
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setBrowserName("chrome");
					cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(Config.HUB_URL), cap);
					ExistingchromeBrowser = driver;
					}
					
					driver.manage().window().maximize();

				 }
			}

		} catch (Exception e) {
			log.info(e);
		}
	}
		public static void main(String[] arg)throws Exception{
			driverManager();
		}
}
