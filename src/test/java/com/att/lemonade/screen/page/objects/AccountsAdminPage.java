package com.att.lemonade.screen.page.objects;
import java.util.List;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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


public class AccountsAdminPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private String testCaseUniqueKey;
	public String record_count;
	
	public AccountsAdminPage(WebDriver driver, String testCaseUniqueKey, int timeouts){
		this.driver = driver;
		this.testCaseUniqueKey=testCaseUniqueKey;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeouts), this);
		
	}	
		
	
		//view dropdown
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/span/button")
		public WebElement listViews_Dropdown;
		
		//view dropdown values
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/span/div/ul/descendant::a")
		public List<WebElement> listViews_DropdownValues;
		
		//ATTUID field
		@FindBy(xpath="//*[@id='gblAttSrch']")
		public WebElement attuid_Textbox;
		
		//attuid field search icon
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[2]/div[2]/button")
		public WebElement attuid_SearchIcon;
		
		
		//user name textbox
		@FindBy (xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[1]/span")
		public WebElement advanceSearch_Field;
		
		
		//search button
		@FindBy(xpath="//*[@id='advSrchBtn']")
		public WebElement search_Button;
		
		
		//clear field button
		
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[2]/div/button[2]")
		public WebElement clearField_Button;
		
		//global search text bpx
		@FindBy(xpath="//*[@id='gblSrchTxt']")
		public WebElement globalSearch_Textbox;
		
		//global search icon
		@FindBy(xpath="//button[@id='gblSrchBtn']")
		public WebElement globalSearch_Icon;
		
		//Account name textbox
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
		
		
		//# priorYearTBRMin field
		@FindBy(xpath="//input[@name='previousYear'and @placeholder='Min Value']")
		public WebElement priorYearTBR_minValue;
		

		//# priorYearTBRMax field
		@FindBy(xpath="//input[@name='previousYear' and @placeholder='Max Value']")
		public WebElement priorYearTBR_maxValue;
		
		
		//Account status dropdown
		@FindBy(xpath="//*[@id='accountStatus']")
		public WebElement accountStatus;
		
		
		//Account status dropdown values
		@FindBy(xpath="//*[@id='accountStatus']/descendant::option")
		public List<WebElement> accountStatusValues;
		
		//Svid textbox
		@FindBy(xpath="//input[@field='svid']")
		public WebElement SVID_Textbox;
		
		//Owner Name textbox
		@FindBy(xpath="//input[@field='ownerName']")
		public WebElement ownerName_Textbox;
		
		//Fiber Eligible dropdown
		@FindBy(xpath="//*[@id='fiberEligibility']")
		public WebElement fiberEligibility_Dropdown;
		
		//Fiber Eligible dropdown values
		@FindBy(xpath="//*[@id='fiberEligibility']/descendant::option")
		public List<WebElement> fiberEligibility_DropdownValues;
		
		//% Fiber textbox
		@FindBy(xpath="//input[@field='percentFiberEligibility']")
		public WebElement percentageFiber_Textbox;
		
		//FN indicator dropdown
		@FindBy(xpath="//*[@id='firstNetIndicatorDescription']")
		public WebElement FN_Dropdown;
				
		//FN indicator dropdown values
		@FindBy(xpath="//*[@id='firstNetIndicatorDescription']/descendant::option")
		public List<WebElement> FN_DropdownValues;
		
		//SIC code textbox
		@FindBy(xpath="//input[@field='sicCode']")
		public WebElement SICCode_Textbox;
		
		//SIC Description
		@FindBy(xpath="//input[@field='sicDesc']")
		public WebElement SICDescription_Textbox;
		
		//NAICS category dropdown
		@FindBy(xpath="//*[@id='naicsCode']")
		public WebElement nAICSCategory_Dropdown;
			
		//NAICS category dropdown
		@FindBy(xpath="//*[@id='naicsCode']//descendant::option")
		public List<WebElement> nAICSCategory_DropdownValues;
		
		//NAICS Description
		@FindBy(xpath="//input[@field='naicsDesc']")
		public WebElement nAICSDescription_Textbox;

		//search address & phone
		@FindBy(xpath="/html/body/div[1]/my-app/app-account/app-accountmfe/div/div[1]/div/div[6]/ngl-expandable-section[2]/h3/button/span")
		public WebElement searchAddressPhone_Field;
		
		//Primary phone textbox
		@FindBy(xpath="//input[@field='phoneNumber']")
		public WebElement primaryPhone_Textbox;
				
		//Primary Street textbox
		@FindBy(xpath="//input[@field='primaryStreet']")
		public WebElement primaryStreet_Textbox;
				
		//Primary City textbox
		@FindBy(xpath="//input[@field='primaryCity']")
		public WebElement primaryCity_Textbox;
		
		
		//Primary State textbox
		@FindBy(xpath="//input[@field='primaryState']")
		public WebElement primaryState_Textbox;
		
		//Primary zip textbox
		@FindBy(xpath="//input[@field='primaryZip']")
		public WebElement primaryZip_Textbox;
				
		
		//ATTUID error msg
		@FindBy(xpath="//*[@id='error_ngl_input_46']")
		public WebElement attuid_Erromsg;
		
		//Account details dropdown
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/button")
		
		public WebElement accountDetails_Dropdown;
		
		//Account details dropdownValues
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/div/ul/descendant::a")
		public List<WebElement> accountDetails_DropdownValues;
		
		//Account info close button
		@FindBy(xpath="//*[@id='mdlCloseBtn']")
		public WebElement accountInfoClose_Button;
				
		//Account team member detail
		
		@FindBy(xpath="/html/body/div/div/div/ngl-modal/section/div/div/div/table/tbody/tr[1]/td[1]/div")
		public WebElement accountTeamMemberDetails;
		
		//Account team close button
		@FindBy(xpath="/html/body/div/div/div/ngl-modal/section/div/div/footer/button")
		public WebElement accountTeamClose_Button;
		
		
		//record count
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span")
		public WebElement recordValue;
		
		//NodataFound msg
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr/td")
		public WebElement noDataFound;
		
		//internalServererror msg
		@FindBy(xpath="/html/body/div/my-app/app-account/ngl-alert/div/h2")
		public WebElement internalServerError;
				
				
		static Logger logger = Logger.getLogger(AccountsAdminPage.class.getName());
		
		private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
		public void Search(TCData td) throws Exception{
			
		
			TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_LEMONADE_GUI_CONTENT, ConstantFile.TEST_DESC, td.getDescription());
				
			ExcelReader er=new ExcelReader(ACM.getTestDataFile());
			String responseTime="responseTime";
			String recordCount="recordCount";
			String sheet[]=testCaseUniqueKey.split(":");
			System.out.println("Sheet"+sheet[0]+"row"+sheet[1]);
			String row[]=sheet[1].split("data-row-");
			System.out.println("Row"+row[1]);
			Integer row1=Integer.parseInt(row[1]);
			
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(1, TimeUnit.SECONDS)
					.withTimeout(10, TimeUnit.SECONDS)
					.ignoring(TimeoutException.class);
			
			FluentWait<WebDriver> wait_min = new FluentWait<WebDriver>(driver)
					.pollingEvery(1, TimeUnit.SECONDS)
					.withTimeout(5, TimeUnit.SECONDS)
					.ignoring(TimeoutException.class);
			
			
				String responseCapturedTime=null;
			
				CommonFunctions.waitUntillPageLoad(driver);
				/*listViews_Dropdown.click();
				CommonFunctions.pause(5);
				for(WebElement e:listViews_DropdownValues)
				{
					if(e.getText().equalsIgnoreCase("Accounts Admin"))
					{
						e.click();
						break;
					}
				}
			*/
				
				if(!td.getAttuid().isEmpty())
				{
					attuid_Textbox.sendKeys(td.getAttuid());
					attuid_SearchIcon.click();
					CommonFunctions.pause(5);
				}
				/*try
				{
					wait_min.until(ExpectedConditions.visibilityOf(attuid_Erromsg));
					if(attuid_Erromsg.isDisplayed())
					{
						td.setRecordCount("Invalid Attuid");
						responseCapturedTime="invalid attuid";
						
					}
				}
				catch(NoSuchElementException ex1)
				{*/
				
				
					if(!td.getGlobalSearch().isEmpty())
					{
						System.out.println("Inside global search1"+td.getGlobalSearch());
						
						this.globalSearch_Textbox.sendKeys(td.getGlobalSearch());
						
						
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
							CommonFunctions.pause(2);
							
							if(!td.getPriorYearTBRMinValue().isEmpty())
							{
								System.out.println("test min value");
								this.priorYearTBR_minValue.sendKeys(td.getPriorYearTBRMinValue());
							}
							
							if(!td.getPriorYearTBRMaxValue().isEmpty())
							{
								this.priorYearTBR_maxValue.sendKeys(td.getPriorYearTBRMaxValue());
							}
				
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
							this.SVID_Textbox.sendKeys(td.getSVID());
						}
				
						//enter the owner name
						if(!td.getOwnerName().isEmpty())
						{
							this.ownerName_Textbox.sendKeys(td.getOwnerName());
						}
				
						CommonFunctions.scrollToElement(percentageFiber_Textbox, driver);
				
						//enter the fiber percentage
						if(!td.getPercentageFiber().isEmpty())
						{
				
							float perFiber=Float.parseFloat(td.getPercentageFiber());
							//changing float to int
							int perceFiber=Math.round(perFiber);
							//changing percentage fiber from int to string
							String fiberPer=Integer.toString(perceFiber);
							this.percentageFiber_Textbox.sendKeys(fiberPer);
						}
				
				
				//select the fiber eligible
				
				
						CommonFunctions.pause(3);
				
						if(!td.getFiberEligible().isEmpty())
						{
							this.fiberEligibility_Dropdown.click();
							for(WebElement fiber : fiberEligibility_DropdownValues)
							{
								if(fiber.getText().equalsIgnoreCase(td.getFiberEligible()))
								{
									fiber.click();
								}
							}
						}
				
						CommonFunctions.scrollToElement(FN_Dropdown, driver);
				
					
						if(!td.getFNIndicator().isEmpty())
						{
							this.FN_Dropdown.click();
							for(WebElement FN : FN_DropdownValues)
							{
								if(FN.getText().equalsIgnoreCase(td.getFNIndicator()))
								{
									FN.click();
								}
							}
						}
			
						if(!td.getSICCode().isEmpty())
						{
							this.SICCode_Textbox.sendKeys(td.getSICCode());
						}
						
						if(!td.getSICDescription().isEmpty())
						{
							this.SICDescription_Textbox.sendKeys(td.getSICDescription());
						}
				
						if(!td.getnAICSCode().isEmpty())
						{
							this.nAICSCategory_Dropdown.click();
							Thread.sleep(2000);
							for(WebElement ele:nAICSCategory_DropdownValues)
							{	
								if(ele.getText().equalsIgnoreCase(td.getnAICSCode()))
								{
								ele.click();
								}
							}		
						}
						if(!td.getnAICSDescription().isEmpty())
						{
							this.nAICSDescription_Textbox.sendKeys(td.getnAICSDescription());
						}
						this.searchAddressPhone_Field.click();
						CommonFunctions.pause(1);
				
						CommonFunctions.scrollToElement(primaryCity_Textbox,driver);
						if(!td.getPrimaryPhone().isEmpty())
						{
				//enter the primary phone values
							this.primaryPhone_Textbox.sendKeys(td.getPrimaryPhone());
						}
				
						if(!td.getPrimaryStreet().isEmpty())
						{
							//enter the primary street values
							this.primaryStreet_Textbox.sendKeys(td.getPrimaryStreet());
						}
				
						if(!td.getPrimaryCity().isEmpty())
						{
				//enter the primary City values
							this.primaryCity_Textbox.sendKeys(td.getPrimaryCity());
						}
				
						if(!td.getPrimaryState().isEmpty())
						{
				//enter the primary state values
							this.primaryState_Textbox.sendKeys(td.getPrimaryState());
						}
				
						if(!td.getPrimaryZip().isEmpty())
						{
				//enter the primary zip values
							float primaryZip=Float.parseFloat(td.getPrimaryZip());
							//changing float to int
							int zip=Math.round(primaryZip);
							//changing percentage fiber from int to string
							String zipCode=Integer.toString( zip);
							this.primaryZip_Textbox.sendKeys(zipCode);
							
						}
						
					}
			
					long start;
					
					if(!td.getGlobalSearch().isEmpty())
					{
						System.out.println("Inside global search");
						globalSearch_Icon.click();
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
						long totalTime = (finish - start); 
						responseCapturedTime=Long.toString(totalTime)+ " MilliSeconds";
						td.setResponseTime(responseCapturedTime);
						System.out.println("Total Time for Response - "+totalTime);
									
						accountDetails_Dropdown.click();
						/*CommonFunctions.pause(2);
						accountDetails_DropdownValues.get(0).click();
						CommonFunctions.scrollTo(accountInfoClose_Button, driver);
						CommonFunctions.pause(2);
						accountDetails_Dropdown.click();
						CommonFunctions.pause(2);
						/*accountDetails_DropdownValues.get(1).click();
						wait.until(ExpectedConditions.visibilityOf(accountTeamMemberDetails));
						CommonFunctions.scrollTo(accountTeamClose_Button, driver);*/
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
							if(noDataFound.getText().contains("No Data Found"))
							{
								responseCapturedTime="No data found";
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
								responseCapturedTime="internal server error";
								td.setRecordCount("Internal server error");
								td.setResponseTime("Server error");
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
						er.setCellData(sheet[0], recordCount, row1,td.getRecordCount());
					}
				}
			}

			
		
		
