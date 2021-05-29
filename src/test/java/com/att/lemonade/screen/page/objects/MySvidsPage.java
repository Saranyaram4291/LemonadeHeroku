package com.att.lemonade.screen.page.objects;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.att.lemonade.base.TestCaseSessionDataManger;
import com.att.lemonade.test.data.objects.TCData;
import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.CommonFunctions;
import com.att.lemonade.utilities.ConstantFile;
import com.att.lemonade.utilities.ExcelReader;


public class MySvidsPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private String testCaseUniqueKey;
	public String record_count;
	
	public MySvidsPage(WebDriver driver, String testCaseUniqueKey, int timeouts){
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
		public WebElement globalSearch_Icon;
		
		// SVID Name text box
		
		@FindBy(xpath="//input[@field='svidName']")
		public WebElement svidName_Textbox;
		
		//SVID text box
		
		@FindBy(xpath="//input[@field='svid']")
		public  WebElement SVID_Textbox;
		
	
		
		//search account details field
		@FindBy(xpath="//span[@title='Search Account Details']")
		public WebElement searchAccountDetails_Field;
		
		
		//# priorYearTBRMin field
		@FindBy(xpath="//input[@name='previousYear'and @placeholder='Min Value']")
		public WebElement priorYearTBR_minValue;
		

		//# priorYearTBRMax field
		@FindBy(xpath="//input[@name='previousYear' and @placeholder='Max Value']")
		public WebElement priorYearTBR_maxValue;
		
		//DUNSNumber field
		@FindBy(xpath="//input[@field='duns']")
		public WebElement DUNSNumber_Textbox;
		
		
		//DomSubAcct field
		@FindBy(xpath="//input[@field='dominantSubAccount']")
		public WebElement DomSubAcct_Textbox;
		
		
		//Owner Name textbox
		@FindBy(xpath="//input[@field='ownerName']")
		public WebElement ownerName_Textbox;
		
		//SIC Code textbox
		@FindBy(xpath="//input[@field='sicCode']")
		public WebElement SICCode_Textbox;
		
		//SIC Description
		@FindBy(xpath="//input[@field='sicDesc']")
		public WebElement SICDescription_Textbox;
		
		//NAICS category dropdown
		@FindBy(xpath="//*[@id='naicsCode']")
		public WebElement NAICSCategory_Dropdown;
		
		//NAICS category dropdown values
		@FindBy(xpath="//*[@id='naicsCode']/descendant::option")
		public List<WebElement> NAICSCategory_DropdownValues;
		
		//NAICS description
		@FindBy(xpath="//input[@field='naicsDesc']")
		public WebElement NAICSDescription_Textbox;
		
		//search Address 
		@FindBy(xpath="//span[@title='Search Address']")
		public WebElement searchAddress;
		
		//city textbox
		@FindBy(xpath="//input[@field='svidCity']")
		public WebElement City_Textbox;
				
		//state textbox
		@FindBy(xpath="//input[@field='svidState']")
		public WebElement State_Textbox;
		
		//country textbox
		@FindBy(xpath="//input[@field='svidCountry']")
		public WebElement Country_Textbox;
		
		
		//SVID details dropdown
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/button")
		public WebElement SVIDDetails_Dropdown;
		
		//SVID details dropdownValues
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/div/ul/descendant::a")
		public List<WebElement> SVIDDetails_Dropdownvalues;
		
		//SVID info close button
		@FindBy(xpath="//*[@id='mdlCloseBtn']")
		public WebElement SVIDInfoClose_Button;
				
		//SVID team member detail
		
		@FindBy(xpath="/html/body/div/div/div/ngl-modal/section/div/div/div/table/tbody/tr[1]/td[1]/div")
		public WebElement SVIDTeamMemberDetails;
		
		//SVID team close button
		@FindBy(xpath="/html/body/div/div/div/ngl-modal/section/div/div/footer/button")
		public WebElement SVIDTeamClose_Button;
		
		
		//record count
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span")
		public WebElement recordValue;
		
		//NodataFound msg
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr/td")
		public WebElement noDataFound;
		
		//internalServererror msg
		@FindBy(xpath="/html/body/div/my-app/app-account/ngl-alert/div/h2")
		public WebElement internalServerError;
				
				
		static Logger logger = Logger.getLogger(MySvidsPage.class.getName());
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
			String responseCapturedTime=null;
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(1, TimeUnit.SECONDS)
					.withTimeout(10, TimeUnit.SECONDS)
					.ignoring(TimeoutException.class);
			
			
				CommonFunctions.waitUntillPageLoad(driver);
				CommonFunctions.pause(5);
				//CommonFunctions.waitForElementToBeStable(driver,listViews_dropdown);
				listViews_dropdown.click();
				CommonFunctions.pause(2);
				for(WebElement e:listViews_dropdownValues)
				{
					if(e.getText().equalsIgnoreCase("My SVIDs"))
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
							
			
					if(!td.getSvidName().isEmpty())
					{
						this.svidName_Textbox.sendKeys(td.getSvidName());
					}
					if(!td.getSVID().isEmpty())
					{
						this.SVID_Textbox.sendKeys(td.getSVID());
					}
					this.searchAccountDetails_Field.click();

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
					
					if(!td.getDUNSNumber().isEmpty())
					{
						System.out.println("Duns"+td.getDUNSNumber());
					
						String dunsN=new BigDecimal(td.getDUNSNumber()).toPlainString();
						System.out.println("UpdatedDuns"+dunsN);
						this.DUNSNumber_Textbox.sendKeys(dunsN);
					}
					if(!td.getDomSubAcct().isEmpty())
					{
						this.DomSubAcct_Textbox.sendKeys(td.getDomSubAcct());
					}
					if(!td.getOwnerName().isEmpty())
					{
						this.ownerName_Textbox.sendKeys(td.getOwnerName());
					}
					if(!td.getSICCode().isEmpty())
					{
						float sicC=Float.parseFloat(td.getSICCode());
						//changing float to int
						int code=Math.round(sicC);
						//changing percentage fiber from int to string
						String sicCode=Integer.toString(code);
						System.out.println("SICCode"+sicCode);
						this.SICCode_Textbox.sendKeys(sicCode);
					
					}
					if(!td.getSICDescription().isEmpty())
					{
						this.SICDescription_Textbox.sendKeys(td.getSICDescription());
					}					
								
			
					if(!td.getnAICSCode().isEmpty())
					{
						this.NAICSCategory_Dropdown.click();
						for(WebElement element:NAICSCategory_DropdownValues)
						{
							if(element.getText().equalsIgnoreCase(td.getnAICSCode()))
							{
								element.click();
								break;
							}
						}
					}
			
					//enter the SVID
					if(!td.getnAICSDescription().isEmpty())
					{
						this.NAICSDescription_Textbox.sendKeys(td.getnAICSDescription());
					}
					 searchAddress.click();
					CommonFunctions.pause(3);
					if(!td.getPrimaryCity().isEmpty())
					{
						this.City_Textbox.sendKeys(td.getPrimaryCity());
					}
		
					if(!td.getPrimaryState().isEmpty())
					{
						this.State_Textbox.sendKeys(td.getPrimaryState());
					}
					if(!td.getPrimaryCountry().isEmpty())
					{
						this.Country_Textbox.sendKeys(td.getPrimaryCountry());
					}
					
				}	
				long start;
				
				if(!td.getGlobalSearch().isEmpty())
				{
					System.out.println("Inside global search");
					this.globalSearch_Icon.click();
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
					 
					SVIDDetails_Dropdown.click();
					Thread.sleep(2000);
					SVIDDetails_Dropdownvalues.get(0).click();
					CommonFunctions.scrollTo(SVIDInfoClose_Button, driver);
					/*Thread.sleep(2000);
					SVIDDetails_Dropdown.click();
					Thread.sleep(1000);
					SVIDDetails_Dropdownvalues.get(1).click();
					wait.until(ExpectedConditions.visibilityOf(SVIDTeamMemberDetails));
					CommonFunctions.scrollTo(SVIDTeamClose_button, driver);*/
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
							td.setResponseTime("");
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
							System.out.println("internal server error");
							td.setRecordCount("Internal server error");
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

			
		
			
			

			
		
		
