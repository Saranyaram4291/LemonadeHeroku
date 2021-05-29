/*
 * 
 */
package com.att.lemonade.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.log4testng.Logger;

/**
 * The Class AplicationConfigurationManager.
 */
public class AplicationConfigurationManager extends Properties{
	
	/** The log. */
	private static Logger log =Logger.getLogger(AplicationConfigurationManager.class);
	
	/** The acm. */
	private static AplicationConfigurationManager ACM=null;
	
	/** The hs runnable test case list. */
	private static Hashtable<String,String> hsRunnableTestCaseList=new Hashtable<String,String>();
	
	/**
	 * Instantiates a new aplication configuration manager.
	 */
	
	/**
	 * Gets the single instance of AplicationConfigurationManager.
	 *
	 * @return single instance of AplicationConfigurationManager
	 */
	public static AplicationConfigurationManager getInstance() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		if(ACM==null) {
			ACM=new AplicationConfigurationManager();
			FileInputStream fis=null;
			try{
				String systemPropertyFile=System.getProperty("application.configuration.file");
				if(systemPropertyFile==null) {
					fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
				}else {
					fis = new FileInputStream(systemPropertyFile);
				}
			}catch (FileNotFoundException e) {
				//TODO Auto-generated catch block
				//throw e;
				e.printStackTrace();
			}
			try {
				ACM.load(fis);
				log.debug("Config file loaded !!!");
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						log.debug(e.getCause(), e);
						e.printStackTrace();
					}
				}
			}
			//Load Runnable Test Case Details.
			//Read TestCasesList & Prepare the cache for runMode.
			System.out.println("Test Data File: "+ACM.getTestDataFile());
			File file=new File(ACM.getTestDataFile());
			String strSheetName=ACM.getTestDataTestCasesTab();
			if(file.exists()) {
				ExcelReader excelReader=new ExcelReader(file.getAbsolutePath());
				int rc=excelReader.getRowCount(strSheetName);
				int cc=excelReader.getColumnCount(strSheetName);
				log.debug("Row="+rc+", columns="+cc);
				if(cc<2) {
					log.debug("Number of columns in ["+strSheetName+"] is less than 2. RunMode is missing");
					//throw new Throwable("Number of columns in ["+strSheetName+"] is less than 2. RunMode is missing");
				}else {
					for(int i=2;i<=rc;i++) {
						String tcName=excelReader.getCellData(strSheetName, i, 1);
						String tcRunMode=excelReader.getCellData(strSheetName, i, 2);
						hsRunnableTestCaseList.put(tcName, tcRunMode);
					};
				}
				log.debug("TestCases & RunMode");
				for(String key: hsRunnableTestCaseList.keySet()) {
					System.out.println(key+"check runmode"+hsRunnableTestCaseList.get(key));
					log.debug("Test Case=["+key+"]"+"==>RunMode=["+hsRunnableTestCaseList.get(key)+"]");
				}
			}else {
				log.debug("No Test Cases are defined in tab["+strSheetName+"]");
				//throw new Throwable("No Test Cases are defined in tab["+strSheetName+"]");
			}
			
		}		
		return ACM;		
	}
	
	/**
	 * Checks if is test case runnable.
	 *
	 * @param tcName the tc name
	 * @return true, if is test case runnable
	 */
	public static boolean isTestCaseRunnable(String tcName) {
		String str=hsRunnableTestCaseList.get(tcName);
		System.out.println("String value"+str);
		if(str==null) {
			return false;
		}else {
			if("Y".equalsIgnoreCase(str)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * Gets the broser name.
	 *
	 * @return the broserName
	 */
	public String getBrowserName() {
		
		//return this.getProperty("browser.name");
		return this.checkSystemPropertyAndReturnValue("browser.name","chrome");
	}
	
	/**
	 * Gets the remote run chrome hub enabled.
	 *
	 * @return the remoteRunChromeHubEnabled
	 */
	public String getRemoteRunChromeHubEnabled() {
		//return this.getProperty("remote.run.chromehub.enabled");
		return this.checkSystemPropertyAndReturnValue("remote.run.chromehub.enabled","N");
	}
	
	/**
	 * Gets the remote run chrome hub URL.
	 *
	 * @return the remoteRunChromeHubURL
	 * @throws MalformedURLException the malformed URL exception
	 */
	public URL getRemoteRunChromeHubURL() throws MalformedURLException {
		URL url=new URL(this.checkSystemPropertyAndReturnValue("remote.run.chromehub.url",null));
		
		return url;
	}
	
	/**
	 * Gets the application URL.
	 *
	 * @return the applicationURL
	 */
	public String getApplicationURL() {
		
		//return this.getProperty("application.url");
		return this.checkSystemPropertyAndReturnValue("application.url",null);
	}
	
	public String getApplicationEnv()
	{
		return this.checkSystemPropertyAndReturnValue("application.env","DEV");
	}
	
	
	/**
	 * Gets the implicit wait.
	 *
	 * @return the implicitWait
	 */
	public long getImplicitWait() {
		return Long.valueOf(this.checkSystemPropertyAndReturnValue("implicit.wait","50"));
	}
	
	/**
	 * Gets the test data file.
	 *
	 * @return the testDataFile
	 */
	public String getTestDataFile() {
		return this.checkSystemPropertyAndReturnValue("testdata.file",System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	}
	
	public String getResultDataFile() {
		return this.checkSystemPropertyAndReturnValue("resultdata.file",System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	}
	
	/**
	 * Gets the test data test cases tab.
	 *
	 * @return the testDataTestCasesTab
	 */
	public String getTestDataTestCasesTab() {
		return this.checkSystemPropertyAndReturnValue("testdata.testcases.tab.name","MyPriceTestCases");		
	}
	
	/**
	 * Gets the web driver wait time.
	 *
	 * @return the webDriverWaitTime
	 */
	public long getWebDriverWaitTime() {
		return Long.valueOf(this.checkSystemPropertyAndReturnValue("webdriver.wait.time","300"));
	}
	
	/**
	 * Gets the sleep rate.
	 *
	 * @return the sleepRate
	 */
	public long getSleepRate() {
		return Long.valueOf(this.checkSystemPropertyAndReturnValue("webdriver.sleepRate","1"));
	}
	
	/**
	 * Gets the mail sserver.
	 *
	 * @return the mailSserver
	 */
	public String getMailServer() {
		return this.checkSystemPropertyAndReturnValue("smtp.mail.server","smtp.it.att.com");
	}
	
	/**
	 * Gets the mail sserver.
	 *
	 * @return the mailSserver
	 */
	public String getMailServerPort() {
		return this.checkSystemPropertyAndReturnValue("smtp.mail.server.port","25");
	}
	/**
	 * Gets the mail sserver.
	 *
	 * @return the mailSserver
	 */
	public String getMailServerSocketFactoryPort() {
		return this.checkSystemPropertyAndReturnValue("smtp.mail.socketFactory.port","25");
	}
	
	/**
	 * Gets the mail from.
	 *
	 * @return the mailFrom
	 */
	public String getMailFrom() {
		return this.checkSystemPropertyAndReturnValue("mail.from","vk3768@att.com");
	}
	
	/**
	 * Gets the mail password.
	 *
	 * @return the mailPassword
	 */
	public String getMailPassword() {
		return this.checkSystemPropertyAndReturnValue("mail.password","");
	}
	
	/**
	 * Gets the mail TO.
	 *
	 * @return the mailTO
	 */
	public String[] getMailTO() {
		return this.checkSystemPropertyAndReturnValue("mail.to","vk3768@att.com").split(",");
	}
	
	/**
	 * Gets the mail subject.
	 *
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return this.checkSystemPropertyAndReturnValue("mail.subject","Automated Email Report");
	}
	
	/**
	 * Gets the mail message body.
	 *
	 * @return the mailMessageBody
	 */
	public String getMailMessageBody() {
		return this.checkSystemPropertyAndReturnValue("mail.message.body","=====");
	}
	
	/**
	 * Gets the remote run firefox hub enabled.
	 *
	 * @return the remoteRunFirefoxHubEnabled
	 */
	public String getRemoteRunFirefoxHubEnabled() {
		return this.checkSystemPropertyAndReturnValue("remote.run.firefoxhub.enabled","N");
	}
	
	/**
	 * Gets the remote run firefox hub URL.
	 *
	 * @return the remoteRunFirefoxHubURL
	 * @throws MalformedURLException the malformed URL exception
	 */
	public URL getRemoteRunFirefoxHubURL() throws MalformedURLException {
		URL url=new URL(this.checkSystemPropertyAndReturnValue("remote.run.firefoxhub.url",null));
		return url;
	}
	
	/**
	 * Gets the remote run IE hub enabled.
	 *
	 * @return the remoteRunIEHubEnabled
	 */
	public String getRemoteRunIEHubEnabled() {
		return this.checkSystemPropertyAndReturnValue("remote.run.IEhub.enabled","N");
	}
	
	/**
	 * Gets the remote run IE hub URL.
	 *
	 * @return the remoteRunIEHubURL
	 * @throws MalformedURLException the malformed URL exception
	 */
	public URL getRemoteRunIEHubURL() throws MalformedURLException {
		URL url=new URL(this.checkSystemPropertyAndReturnValue("remote.run.IEhub.url",null));
		return url;
	}
	
	/**
	 * Gets the chrome driver path.
	 *
	 * @return the chromeDriverPath
	 */
	public String getChromeDriverPath() {
		return this.checkSystemPropertyAndReturnValue("chrome.driver.path",System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver_win32/chromedriver.exe");
	}
	
	/**
	 * Gets the chrome driver options headless.
	 *
	 * @return the chromeDriverOptionsHeadless
	 */
	public String getChromeDriverOptionsHeadless() {
		return this.checkSystemPropertyAndReturnValue("chrome.driver.options.headless","N");
	}
	
	/**
	 * Gets the firefox driver path.
	 *
	 * @return the firefoxDriverPath
	 */
	public String getFirefoxDriverPath() {
		return this.checkSystemPropertyAndReturnValue("firefox.driver.path",System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver.exe");
	}
	
	/**
	 * Gets the firefox driver options headless.
	 *
	 * @return the firefoxDriverOptionsHeadless
	 */
	public String getFirefoxDriverOptionsHeadless() {
		return this.checkSystemPropertyAndReturnValue("firefox.driver.options.headless","Y");
	}
	
	/**
	 * Gets the ie driver path.
	 *
	 * @return the ieDriverPath
	 */
	public String getIeDriverPath() {
		return this.checkSystemPropertyAndReturnValue("firefox.driver.path",System.getProperty("user.dir") + "/src/test/resources/executables/IEDriverServer.exe");
	}
	
	/**
	 * Gets the ie driver options headless.
	 *
	 * @return the ieDriverOptionsHeadless
	 */
	public String getIeDriverOptionsHeadless() {
		return this.checkSystemPropertyAndReturnValue("ie.driver.options.headless","N");
	}

	/**
	 * Gets the extent report file path.
	 *
	 * @return the extent report file path
	 */
	public String getExtentReportFilePath() {
		return this.checkSystemPropertyAndReturnValue("extent.report.file.path",System.getProperty("user.dir")+"/target/surefire-reports/html/extent.html");
	}

	/**
	 * Gets the extent report config file.
	 *
	 * @return the extent report config file
	 */
	public File getExtentReportConfigFile() {
		File config=new File(this.checkSystemPropertyAndReturnValue("extent.report.config.file",System.getProperty("user.dir")+"/src/test/resources/extentconfig/ReportsConfig.xml"));
		return config;
	}
	
	/**
	 * Gets the extent report dir path.
	 *
	 * @return the extent report dir path
	 */
	public String getExtentReportDirPath() {
		return this.checkSystemPropertyAndReturnValue("extent.report.dir.path",System.getProperty("user.dir")+"/target/surefire-reports/html/");
	}
	
	/**
	 * Gets the extent report dir path.
	 *
	 * @return the extent report dir path
	 */
	public int getWebElementSendKeyWaitTime() {
		return Integer.valueOf(this.checkSystemPropertyAndReturnValue("webelement.sendkey.wait.time","30"));
	}
	
	/**
	 * Check system property first to see if property has been passed from command line and return value.
	 *
	 * @param str        the the lookup property name
	 * @param defaultVal the default value for the property.
	 * @return the string
	 */
	public String checkSystemPropertyAndReturnValue(String str, String defaultVal) {
		String returnVal=System.getProperty(str);
		log.debug("["+str+"="+returnVal+"]");
		if(returnVal==null) {
			log.debug("No System Property. Querying Application Property.["+str+"="+returnVal+"]");
			return this.getProperty(str, defaultVal);			
		}else {
			return returnVal;
		}
	}
	
	/**
	 * Gets the property from a given name. This is generic method.
	 *
	 * @param propertyName the property name
	 * @return the property from name
	 */
	public String getPropertyFromName(String propertyName) {
		return this.checkSystemPropertyAndReturnValue(propertyName,null);
	}


	
	public boolean isScreenShotCaptureEnabled() {
		boolean sce=false;
		String x= this.checkSystemPropertyAndReturnValue("screenshot.capture.enabled","N");
		if("Y".equalsIgnoreCase(x)) {
			sce=true;
		}else {
			sce=false;
		}
		return sce;
	}
	public boolean isScreenVideoRecordingEnabled() {
		boolean sce=false;
		String x= this.checkSystemPropertyAndReturnValue("screen.video.recording.enabled","N");
		if("Y".equalsIgnoreCase(x)) {
			sce=true;
		}else {
			sce=false;
		}
		return sce;
	}
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("=========================List of all available application properies=========================\n");
		Enumeration<Object> keys = this.keys();
		while (keys.hasMoreElements()) {
		    String key = (String)keys.nextElement();
		    String value = (String)this.get(key);
		    sb.append(key + ": " + value+"\n");
		}
		sb.append("=============================================================================================\n");
		return sb.toString();
	}
	
}
