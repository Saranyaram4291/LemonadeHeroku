package com.att.lemonade.screen.page.objects;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.att.lemonade.test.data.objects.TCData;
import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.CommonFunctions;

public class LoginPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
	
	public LoginPage(WebDriver driver, int timeouts){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeouts), this);
		
	}	
		//user name textbox
		@FindBy (xpath="//*[@id='GloATTUID']")
		public WebElement userName_Textbox;
		
		//user name textbox
		@FindBy (xpath="//*[@id='username']")
		public WebElement userName1_Textbox;
		
		//password textbox
		
		@FindBy (xpath="//*[@id='GloPassword']")
		@CacheLookup
		public WebElement password_Textbox;
		
		@FindBy (xpath="//*[@id='password']")
		@CacheLookup
		public WebElement password1_Textbox;
		
		
		//login button
		
		@FindBy (xpath="//*[@id='GloPasswordSubmit']")
		@CacheLookup
		public WebElement login_button;
		
		@FindBy (xpath="//*[@id='Login']")
		@CacheLookup
		public WebElement login1_button;
		
		
		//login confirmation button
		@FindBy(xpath="//*[@id='successButtonId']")
		@CacheLookup
		public WebElement success_button;
				
		
		static Logger logger = Logger.getLogger(LoginPage.class.getName());
		
		public void loginSTEnv(TCData td) throws Exception{
			
			CommonFunctions.waitUntillPageLoad(driver);	
			
			System.out.println("appication env"+ACM.getApplicationEnv());
			if(ACM.getApplicationEnv().equals("DEV"))
			{
				
				System.out.println("Inside dev function");
			this.userName1_Textbox.clear();
			highLightElement(driver, userName1_Textbox);
			this.userName1_Textbox.sendKeys("saranyaram@in.ibm.com.prod.devss5212");
			logger.info("Entering Login Details.");	
			
			highLightElement(driver, password1_Textbox);
			this.password1_Textbox.clear();
			CommonFunctions.pause(2);
			this.password1_Textbox.sendKeys("February@2021");
			logger.info("Clicking on OK button.");
			this.login1_button.click();
			//CommonFunctions.waitUntillPageLoad(driver);	
		//	CommonFunctions.waitForElementToBeClickable(driver, success_button);
			
			//this.success_button.click();
			logger.info("Clicking on confirmation button.");
			CommonFunctions.waitUntillPageLoad(driver);
			}
			else if(ACM.getApplicationEnv().equals("UAT")) {
				
				System.out.println("Inside UAT function");
				this.userName1_Textbox.clear();
				logger.info("Entering Login Details.");
				CommonFunctions.pause(1);
				this.userName1_Textbox.sendKeys("sr644a@dev.abssales.att.com.tst1");
				CommonFunctions.pause(1);
				this.password1_Textbox.clear();
				this.password1_Textbox.sendKeys("March@2021");
				this.login1_button.click();
				CommonFunctions.waitUntillPageLoad(driver);	
			}
			
		}	
		
		
		
		
		
		
	
}