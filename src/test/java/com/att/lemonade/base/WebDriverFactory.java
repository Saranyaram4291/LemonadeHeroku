package com.att.lemonade.base;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.lemonade.utilities.AplicationConfigurationManager;

public class WebDriverFactory {
	private static AplicationConfigurationManager ACM=AplicationConfigurationManager.getInstance();
	private static Logger log=Logger.getLogger(WebDriverFactory.class);
	@SuppressWarnings("deprecation")
	public static WebDriver getWebDriver(String browserName) throws Exception {
		WebDriver driver=null;
		if("chrome".equalsIgnoreCase(browserName)) {
			if("Y".equalsIgnoreCase(ACM.getRemoteRunChromeHubEnabled())) {
				//provide remote driver
				try{ 
					//configure headless Chrome 
					ChromeOptions chromeOptions = new ChromeOptions(); 
					if(ACM.getChromeDriverOptionsHeadless().equals("Y")) {
						chromeOptions.addArguments("--headless");
					}
					//chromeOptions.addArguments(); 
					chromeOptions.addArguments("--disable-gpu","start-maximized","disable-extensions");
					
					Map<String, Object> prefs = new HashMap<String, Object>();
					// Use File.separator as it will work on any OS
					prefs.put("download.default_directory",
							System.getProperty("user.dir") + File.separator + "target");
					chromeOptions.setExperimentalOption("prefs", prefs);
		 
					DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); 
					desiredCapabilities.setBrowserName("chrome"); 
					desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 
		 
					//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities); 
					driver = new RemoteWebDriver(ACM.getRemoteRunChromeHubURL(), desiredCapabilities); 
					//driver = new ChromeDriver(); 
				} 
				catch(Exception e){ 
					log.debug("Exception getting remote webdriver: "+e.getMessage()+"\n"); 
					throw new Exception("Exception getting remote webdriver: "+e.getMessage()+"\n");
					//driver = new ChromeDriver(); 
				} 
			}else {
				System.setProperty("webdriver.chrome.driver",ACM.getChromeDriverPath());
				ChromeOptions chromeOptions = new ChromeOptions(); 
				if(ACM.getChromeDriverOptionsHeadless().equals("Y")) {
					chromeOptions.addArguments("--headless");
				}
				//chromeOptions.addArguments(); 
				//chromeOptions.addArguments("--disable-gpu","start-maximized","disable-extensions","disable-infobars");
				// Set the download location
				Map<String, Object> prefs = new HashMap<String, Object>();
				// Use File.separator as it will work on any OS
				//prefs.put("download.default_directory",
						//System.getProperty("user.dir") + File.separator + "target");
				//chromeOptions.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(chromeOptions);
				log.debug("Chrome Launched !!!");
			}
		}else if("firefox".equalsIgnoreCase(browserName)) {
			if("Y".equalsIgnoreCase(ACM.getRemoteRunFirefoxHubEnabled())) {
				//provide remote
				//provide remote driver
				try{ 
					//configure headless Chrome 
					FirefoxOptions firefoxOptions = new FirefoxOptions(); 
							if(ACM.getFirefoxDriverOptionsHeadless().equals("Y")) {
								firefoxOptions.addArguments("-headless"); 
								
							}
							
							firefoxOptions.addArguments("--disable-gpu"); 
							DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); 
							desiredCapabilities.setBrowserName("firefox"); 
							desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions); 
		 
					//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities); 
							driver = new RemoteWebDriver(ACM.getRemoteRunFirefoxHubURL(), desiredCapabilities); 
					//driver = new ChromeDriver(); 
				} 
				catch(Exception e){ 
					log.debug("Exception getting remote webdriver: "+e.getMessage()+"\n"); 
					throw new Exception("Exception getting remote webdriver: "+e.getMessage()+"\n");
					//driver = new ChromeDriver(); 
				} 

			}else {
				System.setProperty("webdriver.gecko.driver",ACM.getFirefoxDriverPath());
				
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				
				if(ACM.getFirefoxDriverOptionsHeadless().equals("Y"))
				{
					firefoxOptions.addArguments("-headless");
									
				}
				//firefoxOptions.addArguments("--disable-gpu"); 
				
				//desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);			
			
				driver = new FirefoxDriver(firefoxOptions);	
			}
		}else if("ie".equalsIgnoreCase(browserName)) {
			//No report available at this time.
			System.setProperty("webdriver.ie.driver",ACM.getIeDriverPath());
			driver = new InternetExplorerDriver();
		}else {
			throw new Exception("No Suitable driver found for test execution.");
		}
		
		  driver.get(ACM.getApplicationURL()); 
		  log.debug("Navigated to : " + ACM.getApplicationURL());
		  driver.manage().timeouts().implicitlyWait(ACM.getImplicitWait(),TimeUnit.SECONDS); 
		  WebDriverWait wait = new WebDriverWait(driver, 5);
		  //wait.
		return driver;
	}
}
