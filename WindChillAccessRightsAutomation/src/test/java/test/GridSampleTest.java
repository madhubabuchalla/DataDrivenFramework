package test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GridSampleTest {

	public RemoteWebDriver driver;
	public static String appURL = "http://www.google.com";
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
	//	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//cap.setVersion("60.0.3112.101");
		cap.setBrowserName("chrome");
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	
		driver = new RemoteWebDriver(new URL("http://10.179.198.182:4444/wd/hub"), cap);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInIEBrowser() {
		System.out.println("*** Navigation to Application ***");
		//driver.get(appURL);
		driver.navigate().to(appURL);
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}

