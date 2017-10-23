package com.schneider.windchillaccessrightsvalidation.utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {
	
	public static String foderPath = "C:\\Users\\SESA439753\\Desktop\\";
	
	public String runTimeURL = null;
	public String runTimeBrowser  = null;
	public String runTimeRole  = null;
	public String runTimeRow = null;
	
	private static Properties Environment_property;
		
	public static void propertyInitialization()throws Exception{
		
		FileInputStream fis = new FileInputStream(foderPath+"Runtime Parameters.properties");
		Environment_property = new Properties();
		Environment_property.load(fis);
		
	}
}
