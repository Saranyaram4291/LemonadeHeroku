package com.att.lemonade.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.att.lemonade.base.TestCaseSessionDataManger;
import com.att.lemonade.test.data.objects.TCData;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CommonFunctions {
	
	private static final Logger log = Logger.getLogger(CommonFunctions.class);
	private static AplicationConfigurationManager ACM = AplicationConfigurationManager.getInstance();

	public static void scrollToView(WebElement element, WebDriver driver) {
		/*
		 * Coordinates coordinate=((Locatable)element).getCoordinates();
		 * coordinate.inViewPort();
		 */
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scrollToTop(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public static void webDriverWaitTime(WebDriver driver, WebElement elemet) {
		WebDriverWait wait = new WebDriverWait(driver,ACM.getWebDriverWaitTime());
		wait.until(ExpectedConditions.visibilityOf(elemet));
	}

	public static URL toUrl(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException ex) {
			log.error(ex);
		}
		return null;
	}
	
	public static boolean verifyThatElementIsPresent(WebDriver driver, By recordValue) {
		try {
			driver.findElement(recordValue);
			log.info("Element is present");
			return true;
		} catch (Exception exp) {
			log.info("Element is NOT present");
			return false;
		}
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		System.out.println(new Date());
		try {
			WebDriverWait wait = new WebDriverWait(driver,ACM.getWebDriverWaitTime());
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println(new Date());
	}

	public static void waitForElementToBeStable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ACM.getWebDriverWaitTime());
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static void pause(int sec) {
		try {
			Thread.sleep(sec * ACM.getSleepRate() * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean isElementStale(WebElement e) {
		try {
			e.isDisplayed();
			return false;
		} catch (StaleElementReferenceException ex) {
			return true;
		}
	}

	public static void waitUntillPageLoad(WebDriver driver) {
		
		/*
		 * new WebDriverWait(driver, TestConfig.webDriverWaitTime).until(webDriver ->
		 * ((JavascriptExecutor) webDriver)
		 * .executeScript("return document.readyState").equals("complete"));
		 */
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, ACM.getWebDriverWaitTime());
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
		
	}

	public static void scrollTo(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		}
	
	public static void scrollToElement(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		}

	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	public static void type(WebDriver driver, String locator, String value) {
		WebElement we=findWebElement(driver,locator);;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value', '"+value+"')", we);
		log.debug("Typing in : " + locator + " entered value as " + value);

	}
	public static void type(WebDriver driver, WebElement we, String value) {
		//WebElement we=findWebElement(driver,locator);;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value', '"+value+"')", we);
		log.debug("Typing in : " + we + " entered value as " + value);

	}
	public static void waitIfTextIsNotPresent(WebElement we){
		for(int i=0;i<10;i++){
			if(we.getText()!= null && ! "".equalsIgnoreCase(we.getText())){
				log.debug("waitIfTextIsNotPresent==> : " + we.getText());
				break;
			}else{
				pause(ACM.getWebElementSendKeyWaitTime());
			}
		}	
	}
	public static void typeWithTwoKeyDownOneEnter(WebDriver driver,  WebElement we, String value) {
		log.debug("Typing in : " + we.getTagName() + " entered value as " + value);
		//WebElement we=findWebElement(driver,locator);
		we.sendKeys(value);
		pause(ACM.getWebElementSendKeyWaitTime());
		//waitIfTextIsNotPresent(we);
		we.sendKeys(Keys.DOWN);
		pause(ACM.getWebElementSendKeyWaitTime());
		we.sendKeys(value);
		pause(ACM.getWebElementSendKeyWaitTime());
		//waitIfTextIsNotPresent(we);
		we.sendKeys(Keys.DOWN);
		pause(ACM.getWebElementSendKeyWaitTime());
		we.sendKeys(Keys.ENTER);
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].setAttribute('value', '"+value+"')", we);
		log.debug("Value in : [" + we.getTagName() + "]= [" + we.getText()+"]");
	}
	
	public static void typeWithOneKeyDownOneEnter(WebDriver driver, WebElement we, String value) {
		log.info("Typing in : " + we.getTagName() + " entered value as " + value);
		System.out.println("inside typeWithTwoKeyDownOneEnter!!!!!!!!!!!");
		//WebElement we=findWebElement(driver,locator);
		we.sendKeys(value);
		System.out.println("value entered !!!!!!!!!!!!!!");
		pause(ACM.getWebElementSendKeyWaitTime());
		//waitIfTextIsNotPresent(we);
		we.sendKeys(Keys.DOWN);
		System.out.println("First down key sent !!!!!!!!!!!!!!!!!");
		pause(ACM.getWebElementSendKeyWaitTime());
		/*we.sendKeys(Keys.DOWN);
		System.out.println("Second key down !!!!!!!!!!!!!!!!!!!");
		pause(ACM.getWebElementSendKeyWaitTime());*/
		we.sendKeys(Keys.ENTER);
		System.out.println("Enter key final !!!!!!!!!!!!!!!!!");
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].setAttribute('value', '"+value+"')", we);
		log.info("Value in : [" + we.getTagName() + "]= [" + we.getText()+"]");
	}
	
	public static WebElement findWebElement(WebDriver driver, String selector) {
		WebElement we=null;
		
		if(we == null) {
			try {
				we=driver.findElement(By.xpath(selector));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		if (we==null) {
			
			try {
				we=driver.findElement(By.id(selector));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		if(we == null) {
			try {
				we=driver.findElement(By.name(selector));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(we == null) {
			try {
				we=driver.findElement(By.cssSelector(selector));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(we==null) {
			throw new NoSuchElementException("["+selector+"]=>No Such Element Found");
		}
		return we;
	}

	public static void click(WebDriver driver, String elementLocatorValue) {

		findWebElement(driver, elementLocatorValue).click();
		// test.log(LogStatus.INFO, "Clicking on : " + elementLocatorValue);
	}
	public static String getElementValue(WebDriver driver,By by) {
		try {
			return driver.findElement(by).getText();

		} catch (NoSuchElementException e) {

			return "";

		}

	}
	public static void select(WebDriver driver,String locator, String value) {
		WebElement dropdown =null;
		try {
			dropdown = findWebElement(driver,locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("Selecting from dropdown : " + locator + " value as " + value);		
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;

		}
	}
	public static void verifyEquals(WebDriver driver, String testCaseUniqueKey, String expected, String actual) throws IOException {

		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {
			ExtentTest test=ExtentManager.getExtentTestForTestCase(testCaseUniqueKey);
			String strScreenShot= CommonFunctions.takeScreenshot(driver);
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(strScreenShot));
		}
	}
	@Deprecated
	public static String takeScreenshot(WebDriver driver) throws IOException {
		String screenShotNameTaken=null;
		if(driver==null || ACM.isScreenShotCaptureEnabled()==false) {
			return screenShotNameTaken;
		}
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenShotNameTaken = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File fl=new File(ACM.getExtentReportDirPath() + screenShotNameTaken);
		if(fl.exists()) {
			CommonFunctions.pause(1);
			d = new Date();
			screenShotNameTaken = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		}
		FileUtils.copyFile(scrFile,new File(ACM.getExtentReportDirPath() + screenShotNameTaken));
		
		FileUtils.forceDelete(scrFile);
		return screenShotNameTaken;
	}
	public static String takeScreenshot(String testCaseUniqueKey, WebDriver driver) throws IOException {
		String screenShotNameTaken=null;
		if(driver==null || ACM.isScreenShotCaptureEnabled()==false) {
			return screenShotNameTaken;
		}else {			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			screenShotNameTaken = testCaseUniqueKey+"_"+d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			File fl=new File(ACM.getExtentReportDirPath() + screenShotNameTaken);
			if(fl.exists()) {
				CommonFunctions.pause(1);
				d = new Date();
				screenShotNameTaken = testCaseUniqueKey+"_"+d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			}
			FileUtils.copyFile(scrFile,new File(ACM.getExtentReportDirPath() + screenShotNameTaken));
			FileUtils.forceDelete(scrFile);
			return screenShotNameTaken;
		}
	}
	public static boolean isThisDataRunnable(Hashtable<String, String> hsTestData) {
		boolean runmode=false;

		if(hsTestData.get("runmode")!=null){
			if("Y".equalsIgnoreCase(hsTestData.get("runmode"))) {
				runmode=true;
			}
		}else if(hsTestData.get("Runmode")!=null){
			if("Y".equalsIgnoreCase(hsTestData.get("runmode"))) {
				runmode=true;
			}
		}else if(hsTestData.get("RunMode")!=null){
			if("Y".equalsIgnoreCase(hsTestData.get("runmode"))) {
				runmode=true;
			}
		}
		System.out.println("Inside common runmode"+runmode);
		// TODO Auto-generated method stub
		return runmode;
	}
	public static Object getPageObjectFromHashtable(Hashtable<String,String> hs, Class classObject) throws Exception {
		Object dataObject=null;
		Field fld[] = classObject.getDeclaredFields();
		dataObject=classObject.newInstance();
		for(int i=0;i<fld.length;i++) {
			try {
				dataObject.getClass().getField(fld[i].getName()).set(dataObject, hs.get(fld[i].getName()));
				System.out.print("chekc inside commonfunctions"+hs.get(fld[i].getName()));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return dataObject;
	}

			
		
		public static boolean isNumeric(String strNum) {
			//boolean stringContainsNo = s.matches("^[0-9]*$");
		    if (strNum == null) {
		        return false;
		    }
		    try {
		        double d = Double.parseDouble(strNum);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
		}
		
      
	
	
	public static void prepareExpectedResult(TCData td, String testCaseUniqueKey) {
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.EXPECTED_RESULT,
				ConstantFile.RECORD_COUNT, td.getRecordCount());
		TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.EXPECTED_RESULT,
				ConstantFile.RESPONSE_TIME, td.getResponseTime());
		
		
		

	}
	
	
	
}
