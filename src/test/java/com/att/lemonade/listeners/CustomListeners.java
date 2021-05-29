package com.att.lemonade.listeners;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.att.lemonade.screen.page.objects.validateMyAccounts;
import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.CommonFunctions;
import com.att.lemonade.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners implements ITestListener,ISuiteListener {
	/* To track test cases and add 
	 * 
	 */
	
	private AplicationConfigurationManager ACM=AplicationConfigurationManager.getInstance();
	public 	String messageBody;
	//private ExtentTest extentTest;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub		
	}

	public void onStart(ITestContext arg0) {
		//TODO Auto-generated method stub
		//ExtentTest extentTest=ExtentManager.getInstance().startTest(arg0.getName());
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		String screenShotPath=null;
		String testUniqueKey=ExtentManager.getTestKey(arg0);
		ExtentTest extentReport=ExtentManager.getExtentTestForTestCase(testUniqueKey);
		
		try {
			WebDriver driver=ExtentManager.getDriverForTestCase(testUniqueKey);
			screenShotPath=CommonFunctions.takeScreenshot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReport.log(LogStatus.FAIL, testUniqueKey+" Failed with exception : "+ arg0.getThrowable());
		if(screenShotPath!=null) {
			extentReport.log(LogStatus.FAIL, screenShotPath);
		}
		ExtentManager.getInstance().endTest(extentReport);
		ExtentManager.getInstance().flush();
		ExtentManager.cleanUpAllDrivers(testUniqueKey);
	}

	public void onTestSkipped(ITestResult arg0) {
		String testUniqueKey=ExtentManager.getTestKey(arg0);
		ExtentTest extentReport=ExtentManager.getExtentTestForTestCase(testUniqueKey);
		
		if(arg0.wasRetried()) {
			extentReport.log(LogStatus.FAIL, testUniqueKey+" Test Fail, Test Retried: " + arg0.wasRetried() + " . Reason For Fail: " + arg0.getSkipCausedBy() + " Details: " + arg0.getThrowable() );
		} else {
			extentReport.log(LogStatus.SKIP, testUniqueKey+" Skipped this test case.");
		}
		
		ExtentManager.getInstance().endTest(extentReport);
		ExtentManager.getInstance().flush();
		ExtentManager.cleanUpAllDrivers(testUniqueKey);
	}

	public void onTestStart(ITestResult arg0) {
		String testUniqueKey=ExtentManager.getTestKey(arg0);
		ExtentTest extentTest = ExtentManager.getInstance().startTest(testUniqueKey);
		ExtentManager.addTestExtentTestMapping(testUniqueKey,extentTest);
		boolean runMode=ACM.isTestCaseRunnable(arg0.getName());
		
		if(runMode==false) {
			//extentTest.log(LogStatus.SKIP, "Test Case["+testUniqueKey+"]==>is disabled. RunMode=N");
			throw new SkipException("Test Case["+testUniqueKey+"]==>is disabled",new Throwable("Test Case["+testUniqueKey+"]==>is disabled"));
		}
	}

	public void onTestSuccess(ITestResult arg0) {
		String testUniqueKey=ExtentManager.getTestKey(arg0);
		ExtentTest extentReport=ExtentManager.getExtentTestForTestCase(testUniqueKey);
		extentReport.log(LogStatus.PASS, testUniqueKey+" PASS");
		ExtentManager.getInstance().endTest(extentReport);
		ExtentManager.getInstance().flush();
		ExtentManager.cleanUpAllDrivers(testUniqueKey);
	}

	public void onFinish(ISuite arg0) {
		//get all drivers and close them.
		ExtentManager.getInstance().flush();
		ExtentManager.cleanUpAllDrivers();
		
//		MonitoringMail mail = new MonitoringMail();
//		 
//		try {
//			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}	
//		try {
//			mail.sendMail(ACM.getMailServer(), ACM.getMailFrom(), ACM.getMailTO(), ACM.getMailSubject(), messageBody);
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
	}

	public void onStart(ISuite arg0) {
		System.out.println("SUITE=>===>"+arg0.getName());
		//String testUniqueKey=ExtentManager.getTestKey(arg0);
	/*	validateMyAccounts validate= new validateMyAccounts();
		validate.resultExcelSheetAddition();
		String sheetName=validate.getResultSheetName();
		validate.setResultExcelColumns(sheetName);*/
		
	}
}