package com.att.lemonade.testcases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.att.lemonade.base.TestCaseSessionDataManger;
import com.att.lemonade.base.WebDriverFactory;
import com.att.lemonade.screen.page.objects.AccountsAdminPage;
import com.att.lemonade.screen.page.objects.LoginPage;
import com.att.lemonade.test.data.objects.TCData;
import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.CommonFunctions;
import com.att.lemonade.utilities.ConstantFile;
import com.att.lemonade.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC01_Accounts_Admin {
	
	
	private Logger log = Logger.getLogger(TC01_Accounts_Admin.class);
	
	private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
	HashMap<String, HashMap<String,String>> testValues = null;
	
		
	@Test(dataProvider = "getGenericTestData", dataProviderClass = com.att.lemonade.test.data.providers.TestDataProviderParallel.class, retryAnalyzer = com.att.lemonade.base.TestCaseRetryManager.class) // (dataProvider
	public void TC01_Accounts_Admin_Flow(Hashtable<String,Hashtable<String,String>> testData) throws Exception {
		System.out.println("validate");
		String testCaseUniqueKey = ExtentManager.getTestKey("TC01_Accounts_Admin_Flow", testData);
		ExtentTest et=ExtentManager.getExtentTestForTestCase(testCaseUniqueKey);
		Hashtable<String,String> hsTestData=null;
		Set<String> st=testData.keySet();
		int i=0;
		String key1=null;
		for(String key : st) {
			key1=key;
			System.out.println(key+"check the set"+testData.get(key));
			log.info(i+"Key="+key+"["+testData.get(key)+"]");
			hsTestData=testData.get(key);
		}
		TCData td=(TCData)CommonFunctions.getPageObjectFromHashtable(hsTestData,TCData.class);    
		if(CommonFunctions.isThisDataRunnable(hsTestData)==false) {
			log.debug("Row# ["+key1+"] Skipped. RunMode is not Y");
			
			throw new SkipException("Row# ["+key1+"] Skipped. RunMode is not Y");
		};
		WebDriver driver = WebDriverFactory.getWebDriver(ACM.getBrowserName());
		ExtentManager.addTestDriverMapping(testCaseUniqueKey,driver);
		
		driver.manage().window().maximize();
		
		
		et.log(LogStatus.INFO, testCaseUniqueKey+"==>Read Test Data");
		//System.out.println("IT=>" + td.toString());
		
		try
		{
	
			LoginPage lp = new LoginPage(driver, 0);
		
			lp.loginSTEnv(td);
			et.log(LogStatus.INFO,testCaseUniqueKey+"==>"+"Login Completed"); 
			et.log(LogStatus.INFO,testCaseUniqueKey+"==>"+"Navigating to Accounts admin Page"); 
			
			AccountsAdminPage ap=new AccountsAdminPage(driver,testCaseUniqueKey,0);
			ap.Search(td);
				
			et.log(LogStatus.INFO,testCaseUniqueKey+"==>"+"Posting the search results"); 
			
			
			//testValues=TestCaseSessionDataManger.getTestCaseData(testCaseUniqueKey);
			//et.log(LogStatus.INFO, TestCaseSessionDataManger.printAllTestData(testCaseUniqueKey));
			//printSessionData(et,testCaseUniqueKey,testValues);
			} catch (Throwable ex) {
				System.out.println(" Inside throwable catch");
			ex.printStackTrace();
			log.debug("Failed.");
			et.log(LogStatus.ERROR,testCaseUniqueKey+"==>"+ex.getMessage()); 
			String curUrl = driver.getCurrentUrl();
			TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_MAIN_PAGE, "ERROR_MESSAGE", ex.getMessage());
			TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_MAIN_PAGE, "FAILED_URL", curUrl);
			//testValues=TestCaseSessionDataManger.getTestCaseData(testCaseUniqueKey);
			//printSessionData(et,testCaseUniqueKey,testValues);
			
			Assert.fail(testCaseUniqueKey+"=>Lemonade Flow Not Successful");
		}
		finally
		{
			CommonFunctions.prepareExpectedResult(td,testCaseUniqueKey);
			et.log(LogStatus.INFO, TestCaseSessionDataManger.printAllTestData(testCaseUniqueKey));
			if (driver != null) {
				driver.close();
			}
		}
		
		
		log.info("End of Accounts admin Flow");

	}


	}
	
