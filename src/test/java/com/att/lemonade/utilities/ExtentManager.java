package com.att.lemonade.utilities;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.att.lemonade.utilities.AplicationConfigurationManager;

public class ExtentManager {
	
	private static ExtentReports extentReports;
	private static AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
	private static HashMap<String,WebDriver> testCaseDriverMapping = new HashMap<String,WebDriver>();
	private static Hashtable<String,ExtentTest> testCaseExtentTestMapping=new Hashtable<String,ExtentTest>();
	private static Logger log = Logger.getLogger(ExtentManager.class);
	public static ExtentReports getInstance(){
		
		if(extentReports==null){
			
			
			extentReports = new ExtentReports(ACM.getExtentReportFilePath(),true, DisplayOrder.OLDEST_FIRST);//,true,DisplayOrder.OLDEST_FIRST);
			extentReports.loadConfig(ACM.getExtentReportConfigFile());//new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
			
		}
		
		return extentReports;
		
	}
	public static void addTestDriverMapping(String tcName, WebDriver driver ) {
		testCaseDriverMapping.put(tcName,driver);
	}
	 
	public static WebDriver getDriverForTestCase(String tcName) {
		return testCaseDriverMapping.get(tcName);
	}
	
	public static HashMap<String, WebDriver> getAllDrivers(){
		 return testCaseDriverMapping;
	}
	
	public static void cleanUpAllDrivers() {
		for(String key: testCaseDriverMapping.keySet()) {
			WebDriver driver= testCaseDriverMapping.get(key);
			try {
				driver.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try {
				driver.quit();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static void cleanUpAllDrivers(String testUniqueKey) {
		for(String key: testCaseDriverMapping.keySet()) {
			if (testUniqueKey.equalsIgnoreCase(key)) {
				WebDriver driver= testCaseDriverMapping.get(key);
				try {
					if (driver != null) {
						driver.close();
					}

				}catch(Throwable ex){
					System.out.println(ex.getStackTrace());
					System.out.println(ex.getMessage());
				}
				try {
					if (driver != null) {
						driver.quit();
					}
				}catch(Throwable ex){
					System.out.println(ex.getStackTrace());
					System.out.println(ex.getMessage());
				}
			}
		}
	}
	
	public static void addTestExtentTestMapping(String tcName, ExtentTest test ) {
		testCaseExtentTestMapping.put(tcName,test);
	}
	 
	public static ExtentTest getExtentTestForTestCase(String tcName) {
		return testCaseExtentTestMapping.get(tcName);
	}
	
	public static String getTestKey(String testCaseName, Hashtable<String,Hashtable<String,String>> testData) {
		//Hashtable<String,String> hsTestData=null;
		Set<String> st=testData.keySet();
		String key1=null;
		for(String key : st) {
			key1=key;
			log.info("Key="+key+"["+testData.get(key)+"]");
		}
		return testCaseName.toUpperCase()+":data-row-"+key1;
	}
	
	public static String getTestKey(ITestResult arg0) {
		Object[] obj=arg0.getParameters();
		String testUniqueKey=null;
		if(obj.length==0) {
			testUniqueKey=arg0.getName().toUpperCase();
		}else {
			Hashtable<String,Hashtable<String,String>> hs=(Hashtable<String, Hashtable<String, String>>) arg0.getParameters()[0];
			testUniqueKey=ExtentManager.getTestKey(arg0.getName(), hs);
		}
		return testUniqueKey;
	}
	
	
	
	
}