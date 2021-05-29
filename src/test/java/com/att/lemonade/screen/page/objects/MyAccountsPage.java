package com.att.lemonade.screen.page.objects;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
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


public class MyAccountsPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private String testCaseUniqueKey;
	public String record_count;
	
	public MyAccountsPage(WebDriver driver, String testCaseUniqueKey, int timeouts){
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
		@FindBy(xpath="//*[@id='gblSrchTxt']")
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
		@FindBy(xpath="//input[@field='percentFiberEligibility']")
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
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[6]/ngl-expandable-section[2]/h3/button/span")
		public WebElement searchAddressPhone_Field;
		
		//Primary phone textbox
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
		@FindBy(xpath="//*[@id='mdlCloseBtn']")
		public WebElement accountInfoClose_button;
				
		//Account team member detail
		
		@FindBy(xpath="/html/body/div/div/div/ngl-modal/section/div/div/div/table/tbody/tr[1]/td[1]/div")
		public WebElement accountTeamMemberDetails;
		
		//Account team close button
		@FindBy(xpath="/html/body/div/div/div/ngl-modal/section/div/div/footer/button")
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
				
				
		static Logger logger = Logger.getLogger(MyAccountsPage.class.getName());
		private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
		
		public void Search(TCData td) throws Exception{
			
		
			TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_LEMONADE_GUI_CONTENT, ConstantFile.TEST_DESC, td.getDescription());
			
			ArrayList<String> inputData = new ArrayList<String>();
				
			ExcelReader er=new ExcelReader(ACM.getTestDataFile());
			String responseTime="responseTime";
			String recordCount="recordCount";
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
				CommonFunctions.pause(5);
				//CommonFunctions.waitForElementToBeStable(driver,listViews_dropdown);
				listViews_dropdown.click();
			
				for(WebElement e:listViews_dropdownValues)
				{
					if(e.getText().equalsIgnoreCase("My Accounts"))
					{
						e.click();
						break;
					}
				}
				CommonFunctions.pause(10);
			
				if(!td.getGlobalSearch().isEmpty())
				{
					System.out.println("Global search");
					String str=td.getGlobalSearch();
					String globalValue = null;
					if(CommonFunctions.isNumeric(str) && str.length()<9)
					{
						
						float globalSearch=Float.parseFloat(str);
						//changing float to int
						int global=Math.round(globalSearch);
						//changing percentage fiber from int to string
						globalValue=Integer.toString(global);
						
					}
					else if(CommonFunctions.isNumeric(str))
					{
						globalValue=new BigDecimal(str).toPlainString();
						
					}
					else
					{
						globalValue=str;
						
					}
					
					this.globalSearch_Textbox.sendKeys(globalValue);
					
				}
				else
				{
					this.advanceSearch_Field.isDisplayed();
			
			
					if(!td.getAccountName().isEmpty())
					{
						this.accountName_Textbox.sendKeys(td.getAccountName());
						inputData.add(td.getAccountName());
					}
					
					if(!td.getSubAcctId().isEmpty())
					{
						this.subAcctId_Textbox.sendKeys(td.getSubAcctId());
						inputData.add(td.getSubAcctId());
					}
					
					if(!td.getSvidName().isEmpty())
					{
						this.svidName_Textbox.sendKeys(td.getSvidName());
						inputData.add(td.getSvidName());
					}
			
					this.searchAccountDetails_Field.click();
					CommonFunctions.pause(2);
			
					if(!td.getNoOfOpptys().isEmpty())
					{
						System.out.println("NoOfOppty"+td.getNoOfOpptys());
						float noOfOpptys=Float.parseFloat(td.getNoOfOpptys());
						//changing No of Opptys from float to int	
						int opptys=Math.round(noOfOpptys);
						//changing No of opptys from int to string
						String noOfOpptys1=Integer.toString(opptys);
						System.out.println("updatedNoOfOppty"+noOfOpptys1);
						this.noOfOpptys_Textbox.sendKeys(noOfOpptys1);
						inputData.add(noOfOpptys1);
					}
					
					CommonFunctions.pause(2);
					
					System.out.println("test before min value");
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
						inputData.add(td.getAccountStatus());
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
						inputData.add(td.getSVID());
					}
			
					//enter the owner name
					if(!td.getOwnerName().isEmpty())
					{
						this.ownerName_textbox.sendKeys(td.getOwnerName());
						inputData.add(td.getOwnerName());
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
						inputData.add(fiberPer);
					}
			
			
			//select the fiber eligible
			
			
					CommonFunctions.pause(3);
			
					if(!td.getFiberEligible().isEmpty())
					{
						inputData.add(td.getFiberEligible());
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
						
						inputData.add(td.getFNIndicator());
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
						System.out.println("SICCode"+td.getSICCode());
						float code=Float.parseFloat(td.getSICCode());
						//changing float to int
						int sic=Math.round(code);
						//changing percentage fiber from int to string
						String sicCode=Integer.toString(sic);
						System.out.println("updatedSICCode"+sicCode);
						this.SICCode_textbox.sendKeys(sicCode);
						inputData.add(td.getSICCode());
					}
					
					if(!td.getSICDescription().isEmpty())
					{
						this.SICDescription_textbox.sendKeys(td.getSICDescription());
						inputData.add(td.getSICDescription());
					}
			
					if(!td.getnAICSCode().isEmpty())
					{
						inputData.add(td.getnAICSCode());
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
						inputData.add(td.getnAICSDescription());
					}
					
			
					this.searchAddressPhone_Field.click();
					CommonFunctions.pause(1);
			
					CommonFunctions.scrollToElement(primaryCity_textbox,driver);
					if(!td.getPrimaryPhone().isEmpty())
					{
						//enter the primary phone values
						
						float primaryPhone=Float.parseFloat(td.getPrimaryPhone());
						//changing float to int
						int phone=Math.round(primaryPhone);
						//changing percentage fiber from int to string
						String phoneNo=Integer.toString(phone);
						
						this.primaryPhone_textbox.sendKeys(phoneNo);
						inputData.add(td.getPrimaryPhone());
					}
			
					if(!td.getPrimaryStreet().isEmpty())
					{
						//enter the primary street values
						this.primaryStreet_textbox.sendKeys(td.getPrimaryStreet());
						inputData.add(td.getPrimaryStreet());
					}
			
					if(!td.getPrimaryCity().isEmpty())
					{
						//enter the primary City values
						this.primaryCity_textbox.sendKeys(td.getPrimaryCity());
						inputData.add(td.getPrimaryCity());
					}
			
					if(!td.getPrimaryState().isEmpty())
					{
						//enter the primary state values
						this.primaryState_textbox.sendKeys(td.getPrimaryState());
						inputData.add(td.getPrimaryState());
					}
			
					if(!td.getPrimaryZip().isEmpty())
					{
						//enter the primary zip values
						System.out.println("Zip"+td.getPrimaryZip());
						float primaryZip=Float.parseFloat(td.getPrimaryZip());
						//changing float to int
						int zip=Math.round(primaryZip);
						//changing percentage fiber from int to string
						String zipCode=Integer.toString( zip);
						System.out.println("UpdatedZip"+zipCode);
						this.primaryZip_textbox.sendKeys(zipCode);
						inputData.add(td.getPrimaryZip());
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
					long totalTime = (finish - start); 
					responseCapturedTime=Long.toString(totalTime)+ " Milliseconds";
					td.setResponseTime(responseCapturedTime);
					System.out.println("Total Time for Response - "+totalTime);
					 
					accountDetails_Dropdown.click();
					Thread.sleep(2000);
					accountDetails_Dropdownvalues.get(0).click();
					CommonFunctions.scrollTo(accountInfoClose_button, driver);
					Thread.sleep(2000);
					accountDetails_Dropdown.click();
					/*Thread.sleep(1000);
					accountDetails_Dropdownvalues.get(1).click();
					wait.until(ExpectedConditions.visibilityOf(accountTeamMemberDetails));
					CommonFunctions.scrollTo(accountTeamClose_button, driver);*/
					//driver.findElement(By.xpath("/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span"));
					
					String[] splited_recordCount = this.recordValue.getText().split("\\s+");
					int record=0;
					if(splited_recordCount.length==3)
					{
				
						record_count=splited_recordCount[1]+" records";
						record=Integer.parseInt(splited_recordCount[1]);
						td.setRecordCount(record_count);
					}
					else
					{
						record_count=splited_recordCount[0]+" records";
						record=Integer.parseInt(splited_recordCount[0]);
						td.setRecordCount(record_count);
					}
					
				/*	Hashtable<String,Hashtable <String,String>> table1=new Hashtable<String,Hashtable<String,String>>();
					if(record>10)
					{
						record=10;
					}
					validateMyAccounts validate= new validateMyAccounts();
					
					String sheetName=validate.getResultSheetName();
					System.out.println("sheetName"+sheetName);
					String arg[]={"Account Name","Sub-Acct ID","SVID Name","# Opptys","Primary Phone","Primary Street","Primary City","Primary State","Primary Zip"," Account Status","SVID","Owner Name","Fiber Eligible","% Fiber","FN Indicator","FN Type","SIC Description","NAICS Description"};
					ArrayList<String> result_list = new ArrayList<String>();
					int k=0,row_result;
					
					if(validate.getResultExcelSheetCurrentLastrow()==1)
					{
						row_result=2;
					}
					else
					{
						row_result=validate.getResultExcelSheetCurrentLastrow()+1;
					}
						for(int i=1;i<=record;i++)
						{
							int table=2;
							validate.setTestCaseUniqueKey(sheetName, this.testCaseUniqueKey, row_result);
							
							for(String s:arg)
							{
								
								WebElement ele;
								String value=driver.findElement(By.xpath("/html/body/div[1]/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr["+i+"]/td["+table+"]/div")).getText();
								validate.setResultData(sheetName, s,row_result,value);
								result_list.add(value);
								table++;
													
							}
							
							Boolean flag=inputData.contains(result_list);
							
							if(flag)
							{
								System.out.println("Row matched");
							}
							else
							{
								System.out.println("Row not matched");
							}
							row_result++;
						}*/
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
					td.setRecordCount(ex.getMessage());
					throw ex;
										
				}
				}
				finally
				{
					System.out.println("write in excel sheet");
					er.setCellData(sheet[0], responseTime, row1,responseCapturedTime);
					er.setCellData(sheet[0], recordCount, row1,td.getRecordCount());
				}
		
			
			}

}
			
		
		
