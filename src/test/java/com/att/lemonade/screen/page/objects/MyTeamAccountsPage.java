package com.att.lemonade.screen.page.objects;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.lemonade.base.TestCaseSessionDataManger;
import com.att.lemonade.test.data.objects.TCData;
import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.CommonFunctions;
import com.att.lemonade.utilities.ConstantFile;
import com.att.lemonade.utilities.ExcelReader;


public class MyTeamAccountsPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private String testCaseUniqueKey;
	public String record_count;
	
	public MyTeamAccountsPage(WebDriver driver, String testCaseUniqueKey, int timeouts){
		this.driver = driver;
		this.testCaseUniqueKey=testCaseUniqueKey;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeouts), this);
		
	}	
		
	
		//view dropdown
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/span/button")
		public WebElement listViews_dropdown;
		
		//view dropdown values
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/span/div/ul/descendant::a")
		public List<WebElement> listViews_dropdownValues;
		
		
		//user name textbox
		@FindBy (xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[1]/span")
		public WebElement advanceSearch_Field;
		
		
		//search button
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[2]/div/button[1]")
		public WebElement search_Button;
		
		
		//clear field button
		
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[2]/div/button[2]")
		public WebElement clearField_Button;
		
		//global search text bpx
		@FindBy(xpath="//*[@id='ngl_combobox-input_2']")
		public WebElement globalSearch_Textbox;
		
		//global search icon
		@FindBy(xpath="//button[@id='gblSrchBtn']")
		public WebElement globalSearch_icon;
		
		// Account Name text box

		@FindBy(xpath="//input[@field='accountName']")
		public WebElement accountName_Textbox;
		
		//sub acct id text box
		
		@FindBy(xpath="//input[@field='subAccountId']")
		public  WebElement subAcctId_Textbox;
		
		//svid name text box
		
		@FindBy(xpath="//input[@field='svidName']")
		public WebElement svidName_Textbox;
		
		
		
		
		
		//search account details field
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[6]/ngl-expandable-section[1]/h3/button/span")
		public WebElement searchAccountDetails_Field;
		
		//# opptys field
		@FindBy(name="numberOfOptys")
		public WebElement noOfOpptys_Textbox;
		
		
		//Account status dropdown
		@FindBy(xpath="//*[@id='accountStatus']")
		public WebElement accountStatus;
		
		
		//Account status dropdown values
		@FindBy(xpath="//*[@id='accountStatus']/descendant::option")
		public List<WebElement> accountStatusValues;
		
		//Svid textbox
		@FindBy(xpath="//input[@field='svid']")
		public WebElement SVID_textbox;
		
		//Owner Name textbox
		@FindBy(xpath="//input[@field='ownerName']")
		public WebElement ownerName_textbox;
			
				
		//Fiber Eligible dropdown
		@FindBy(xpath="//*[@id='fiberEligibility']")
		public WebElement fiberEligibility_dropdown;
		
		//Fiber Eligible dropdown values
		@FindBy(xpath="//*[@id='fiberEligibility']/descendant::option")
		public List<WebElement> fiberEligibility_dropdownValues;
		
		//% Fiber textbox
		@FindBy(xpath="//*[@id='ngl_input_57']")
		public WebElement percentageFiber_textbox;
		
		//FN indicator dropdown
		@FindBy(xpath="//*[@id='firstNetIndicatorDescription']")
		public WebElement FN_dropdown;
				
		//FN indicator dropdown values
		@FindBy(xpath="//*[@id='firstNetIndicatorDescription']/descendant::option")
		public List<WebElement> FN_dropdownValues;
		

		//SIC code textbox
		@FindBy(xpath="//input[@field='sicCode']")
		public WebElement SICCode_textbox;
		
		//SIC Description
		@FindBy(xpath="//input[@field='sicDesc']")
		public WebElement SICDescription_textbox;
		
		//NAICS category dropdown
		@FindBy(xpath="//*[@id='naicsCode']")
		public WebElement nAICSCategory_dropdown;
			
		//NAICS category dropdown
		@FindBy(xpath="//*[@id='naicsCode']//descendant::option")
		public List<WebElement> nAICSCategory_dropdownValues;
		
		//NAICS Description
		@FindBy(xpath="//input[@field='naicsDesc']")
		public WebElement nAICSDescription_textbox;
		
		//search address & phone
		@FindBy(xpath="/html/body/div[1]/my-app/app-account/app-accountmfe/div/div[1]/div/div[6]/ngl-expandable-section[2]/h3/button/span")
		public WebElement searchAddressPhone_Field;
		
		///Primary phone textbox
		@FindBy(xpath="//input[@field='phoneNumber']")
		public WebElement primaryPhone_textbox;
				
		//Primary Street textbox
		@FindBy(xpath="//input[@field='primaryStreet']")
		public WebElement primaryStreet_textbox;
				
		//Primary City textbox
		@FindBy(xpath="//input[@field='primaryCity']")
		public WebElement primaryCity_textbox;
		
		
		//Primary State textbox
		@FindBy(xpath="//input[@field='primaryState']")
		public WebElement primaryState_textbox;
		
		//Primary zip textbox
		@FindBy(xpath="//input[@field='primaryZip']")
		public WebElement primaryZip_textbox;
		
		//Account details dropdown
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/button")
		
		public WebElement accountDetails_Dropdown;
		
		//Account details dropdownValues
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/div/ul/descendant::a")
		public List<WebElement> accountDetails_Dropdownvalues;
		
		//Account info close button
		@FindBy(xpath="/html/body/div[2]/div/div/ngl-modal/section/div/div/footer/button")
		public WebElement accountInfoClose_button;
				
		//Account team member detail
		
		@FindBy(xpath="/html/body/div[2]/div/div/ngl-modal/section/div/div/div/table/tbody/tr[1]/td[1]/div")
		public WebElement accountTeamMemberDetails;
		
		//Account team close button
		@FindBy(xpath="/html/body/div[2]/div/div/ngl-modal/section/div/div/footer/button")
		public WebElement accountTeamClose_button;
		
		
		//record count
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span")
		public WebElement recordValue;
		
		//NodataFound msg
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr/td")
		public WebElement noDataFound;
		
		//internalServererror msg
		@FindBy(xpath="/html/body/div/my-app/app-account/ngl-alert/div/h2")
		public WebElement internalServerError;
				
				
		static Logger logger = Logger.getLogger(MyTeamAccountsPage.class.getName());
		private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
		public void Search(TCData td) throws Exception{
			
		
			TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_LEMONADE_GUI_CONTENT, ConstantFile.TEST_DESC, td.getDescription());
				
			ExcelReader er=new ExcelReader(ACM.getTestDataFile());
			String responseTime="responseTime";
			String sheet[]=testCaseUniqueKey.split(":");
			System.out.println("Sheet"+sheet[0]+"row"+sheet[1]);
			String row[]=sheet[1].split("data-row-");
			System.out.println("Row"+row[1]);
			Integer row1=Integer.parseInt(row[1]);
			String responseCapturedTime=null;
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(1, TimeUnit.SECONDS)
					.withTimeout(10, TimeUnit.SECONDS)
					.ignoring(TimeoutException.class);
			
			
				CommonFunctions.waitUntillPageLoad(driver);
				CommonFunctions.pause(10);
				//CommonFunctions.waitForElementToBeStable(driver,listViews_dropdown);
				listViews_dropdown.click();
				CommonFunctions.pause(2);
				for(WebElement e:listViews_dropdownValues)
				{
					if(e.getText().equalsIgnoreCase("My Team's Accounts"))
					{
						e.click();
						break;
					}
				}
				CommonFunctions.waitUntillPageLoad(driver);
			
				if(!td.getGlobalSearch().isEmpty())
				{
					
					globalSearch_Textbox.sendKeys(td.getGlobalSearch());
					
					
				}
				else
				{
					this.advanceSearch_Field.isDisplayed();
			
			
					if(!td.getAccountName().isEmpty())
					{
						this.accountName_Textbox.sendKeys(td.getAccountName());
					}
					if(!td.getSubAcctId().isEmpty())
					{
						this.subAcctId_Textbox.sendKeys(td.getSubAcctId());
					}
					if(!td.getSvidName().isEmpty())
					{
						this.svidName_Textbox.sendKeys(td.getSvidName());
					}
			
					this.searchAccountDetails_Field.click();
					CommonFunctions.pause(2);
			
					if(!td.getNoOfOpptys().isEmpty())
					{
						float noOfOpptys=Float.parseFloat(td.getNoOfOpptys());
						//changing No of Opptys from float to int	
						int opptys=Math.round(noOfOpptys);
						//changing No of opptys from int to string
						String noOfOpptys1=Integer.toString(opptys);
				
						this.noOfOpptys_Textbox.sendKeys(noOfOpptys1);
					}
					else
					{
						System.out.println("No of Opptys is empty");
					}
			
					CommonFunctions.pause(2);
			
					if(!td.getAccountStatus().isEmpty())
					{
						this.accountStatus.click();
						for(WebElement element:accountStatusValues)
						{
							if(element.getText().equalsIgnoreCase(td.getAccountStatus()))
							{
								element.click();
							}
						}
					}
			
					//enter the SVID
					if(!td.getSVID().isEmpty())
					{
						this.SVID_textbox.sendKeys(td.getSVID());
					}
			
					//enter the owner name
					if(!td.getOwnerName().isEmpty())
					{
						this.ownerName_textbox.sendKeys(td.getOwnerName());
					}
			
					CommonFunctions.scrollToElement(percentageFiber_textbox, driver);
			
					//enter the fiber percentage
					if(!td.getPercentageFiber().isEmpty())
					{
			
						float perFiber=Float.parseFloat(td.getPercentageFiber());
						//changing float to int
						int perceFiber=Math.round(perFiber);
						//changing percentage fiber from int to string
						String fiberPer=Integer.toString(perceFiber);
						this.percentageFiber_textbox.sendKeys(fiberPer);
					}
			
			
			//select the fiber eligible
			
			
					CommonFunctions.pause(3);
			
					if(!td.getFiberEligible().isEmpty())
					{
						this.fiberEligibility_dropdown.click();
						for(WebElement fiber : fiberEligibility_dropdownValues)
						{
							if(fiber.getText().equalsIgnoreCase(td.getFiberEligible()))
							{
								fiber.click();
							}
						}
					}
			
					CommonFunctions.scrollToElement(FN_dropdown, driver);
			
				
					if(!td.getFNIndicator().isEmpty())
					{
						this.FN_dropdown.click();
						for(WebElement FN : FN_dropdownValues)
						{
							if(FN.getText().equalsIgnoreCase(td.getFNIndicator()))
							{
								FN.click();
							}
						}
					}
		
			
					if(!td.getSICCode().isEmpty())
					{
						this.SICCode_textbox.sendKeys(td.getSICCode());
					}
					
					if(!td.getSICDescription().isEmpty())
					{
						this.SICDescription_textbox.sendKeys(td.getSICDescription());
					}
			
					if(!td.getnAICSCode().isEmpty())
					{
						this.nAICSCategory_dropdown.click();
						for(WebElement element:nAICSCategory_dropdownValues)
						{
							if(element.getText().equalsIgnoreCase(td.getnAICSCode()))
							{
								element.click();
								break;
							}
						}
						
					}
					if(!td.getnAICSDescription().isEmpty())
					{
						this.nAICSDescription_textbox.sendKeys(td.getnAICSDescription());
					}
					
					
					this.searchAddressPhone_Field.click();
					CommonFunctions.pause(1);
			
					CommonFunctions.scrollToElement(primaryCity_textbox,driver);
					if(!td.getPrimaryPhone().isEmpty())
					{
			//enter the primary phone values
						this.primaryPhone_textbox.sendKeys(td.getPrimaryPhone());
					}
			
					if(!td.getPrimaryStreet().isEmpty())
					{
						//enter the primary street values
						this.primaryStreet_textbox.sendKeys(td.getPrimaryStreet());
					}
			
					if(!td.getPrimaryCity().isEmpty())
					{
			//enter the primary City values
						this.primaryCity_textbox.sendKeys(td.getPrimaryCity());
					}
			
					if(!td.getPrimaryState().isEmpty())
					{
			//enter the primary state values
						this.primaryState_textbox.sendKeys(td.getPrimaryState());
					}
			
					if(!td.getPrimaryZip().isEmpty())
					{
			//enter the primary zip values
						float primaryZip=Float.parseFloat(td.getPrimaryZip());
						//changing float to int
						int zip=Math.round(primaryZip);
						//changing percentage fiber from int to string
						String zipCode=Integer.toString( zip);
						this.primaryZip_textbox.sendKeys(zipCode);
						
					}
					
				}
		
				long start;
				
				if(!td.getGlobalSearch().isEmpty())
				{
					System.out.println("Inside global search");
					globalSearch_icon.click();
					start = System.currentTimeMillis();
					
				}
				else
				{
					 
					this.search_Button.click();
					start = System.currentTimeMillis();
				}
				try
				{
					wait.until(ExpectedConditions.visibilityOf(recordValue));
					long finish = System.currentTimeMillis();
					long totalTime = ((finish - start)/1000); 
					 responseCapturedTime=Long.toString(totalTime)+ " Seconds";
					td.setResponseTime(responseCapturedTime);
					System.out.println("Total Time for Response - "+totalTime);
					 
					accountDetails_Dropdown.click();
					Thread.sleep(3000);
					
					WebElement ele=accountDetails_Dropdownvalues.get(0);
					wait.until(ExpectedConditions.elementToBeClickable(ele));
					accountDetails_Dropdownvalues.get(0).click();
													
					CommonFunctions.scrollTo(accountInfoClose_button, driver);
					
					
					Thread.sleep(2000);
					accountDetails_Dropdown.click();
					Thread.sleep(1000);
					accountDetails_Dropdownvalues.get(1).click();
					wait.until(ExpectedConditions.visibilityOf(accountTeamMemberDetails));
					CommonFunctions.scrollTo(accountTeamClose_button, driver);
					System.out.println("Account Team");	
					//driver.findElement(By.xpath("/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span"));
					
					String[] splited_recordCount = this.recordValue.getText().split("\\s+");
				
					if(splited_recordCount.length==3)
					{
				
						record_count=splited_recordCount[1]+" records";
						td.setRecordCount(record_count);
					}
					else
					{
						record_count=splited_recordCount[0]+" records";
						td.setRecordCount(record_count);
					}
				}
				catch(Exception e)
				{
					try
					{
						if(noDataFound.getText().equalsIgnoreCase("No Data Found ...."))
						{
							responseCapturedTime="No data found";
							System.out.println("inside no data found");
							td.setRecordCount("No data found");
							td.setResponseTime("No data found");
						}
						else
						{
							td.setRecordCount(e.getMessage());
							throw e;
						}
					}catch(NoSuchElementException ex)
					{
						if(internalServerError.isDisplayed())
						{
							responseCapturedTime="Server error";
							System.out.println("internal server error");
							td.setRecordCount("Internal server error");
							td.setResponseTime("Server Error");
						}
						else
						{
							td.setRecordCount(ex.getMessage());
							throw ex;
						}
					}
					
						
				}
				finally
				{
					er.setCellData(sheet[0], responseTime, row1,responseCapturedTime);
				}
						
				}
			
		
			
			
}
			
		
		
