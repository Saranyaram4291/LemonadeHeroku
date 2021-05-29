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


public class MyTeamSvidsPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private String testCaseUniqueKey;
	public String record_count;
	
	public MyTeamSvidsPage(WebDriver driver, String testCaseUniqueKey, int timeouts){
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
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[1]/div/div[2]/div/button[1]")
		public WebElement search_Button;
		
		
		//clear field button
		
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[1]/div/div[2]/div/button[2]")
		public WebElement clearField_Button;
		
		//global search text bpx
		@FindBy(xpath="//*[@id='ngl_combobox-input_2']")
		public WebElement globalSearch_Textbox;
		
		//global search icon
		@FindBy(xpath="//button[@id='gblSrchBtn']")
		public WebElement globalSearch_icon;
		
		// SVID Name text box

		@FindBy(xpath="//input[@field='svidName']")
		public WebElement svidName_Textbox;
		
		//SVID text box
		
		@FindBy(xpath="//input[@field='svid']")
		public  WebElement SVID_Textbox;


		
		//search account details field
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[1]/div/div[5]/ngl-expandable-section[1]/h3/button/span")
		public WebElement searchAccountDetails_Field;
		
		//DUNSNumber field
		@FindBy(xpath="//input[@field='duns']")
		public WebElement DUNSNumber_Textbox;
		
		
		//DomSubAcct field
		@FindBy(xpath="//input[@field='dominantSubAccount']")
		public WebElement DomSubAcct_Textbox;
		
		
		//Owner Name textbox
		@FindBy(xpath="//input[@field='ownerName']")
		public WebElement ownerName;
		
		//SIC Code textbox
		@FindBy(xpath="//input[@field='sicCode']")
		public WebElement SICCode_textbox;
		
		//SIC Description
		@FindBy(xpath="//input[@field='sicDesc']")
		public WebElement SICDescription_textbox;
		
		//NAICS category dropdown
		@FindBy(xpath="//*[@id='naicsCode']")
		public WebElement NAICSCategory_dropdown;
		
		//NAICS category dropdown values
		@FindBy(xpath="//*[@id='naicsCode']/descendant::option")
		public List<WebElement> NAICSCategory_dropdownValues;
		
		//NAICS description
		@FindBy(xpath="//input[@field='naicsDesc']")
		public WebElement NAICSDescription_textbox;
		
		//search Address 
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[1]/div/div[5]/ngl-expandable-section[2]/h3/button/span")
		public WebElement searchAddress;
		
		//city textbox
		@FindBy(xpath="//input[@field='svidCity']")
		public WebElement City_textbox;
				
		//state textbox
		@FindBy(xpath="//input[@field='svidState']")
		public WebElement State_textbox;
		
		//country textbox
		@FindBy(xpath="//input[@field='svidCountry']")
		public WebElement Country_Textbox;
		
		
		//SVID details dropdown
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/button")
		public WebElement SVIDDetails_Dropdown;
		
		//SVID details dropdownValues
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[2]/table/tbody/tr[1]/td[1]/div/p/span/div/ul/descendant::a")
		public List<WebElement> SVIDDetails_Dropdownvalues;
		
		//SVID info close button
		@FindBy(xpath="/html/body/div[2]/div/div/ngl-modal/section/div/div/footer/button")
		public WebElement SVIDInfoClose_button;
				
		//SVID team member detail
		
		@FindBy(xpath="/html/body/div[2]/div/div/ngl-modal/section/div/div/div/table/tbody/tr[1]/td[1]/div")
		public WebElement SVIDTeamMemberDetails;
		
		//SVID team close button
		@FindBy(xpath="/html/body/div[2]/div/div/ngl-modal/section/div/div/footer/button")
		public WebElement SVIDTeamClose_button;
		
		
		//record count
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span")
		public WebElement recordValue;
		
		//NodataFound msg
		@FindBy(xpath="/html/body/div/my-app/app-account/app-svidmfe/div/div[2]/table/tbody/tr/td")
		public WebElement noDataFound;
		
		//internalServererror msg
		@FindBy(xpath="/html/body/div/my-app/app-account/ngl-alert/div/h2")
		public WebElement internalServerError;
				
				
		static Logger logger = Logger.getLogger(MyTeamSvidsPage.class.getName());
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
					if(e.getText().equalsIgnoreCase("My Team's SVIDs"))
					{
						e.click();
						break;
					}
				}
				
				CommonFunctions.waitUntillPageLoad(driver);
				CommonFunctions.pause(5);
				if(!td.getGlobalSearch().isEmpty())
				{
					
					globalSearch_Textbox.sendKeys(td.getGlobalSearch());
					
					
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
					
					if(!td.getDUNSNumber().isEmpty())
					{
						float dunsNo=Float.parseFloat(td.getDUNSNumber());
						//changing No of Opptys from float to int	
						int dunsNum=Math.round(dunsNo);
						//changing No of opptys from int to string
						String dunsNumber=Integer.toString(dunsNum);
						
					
						this.DUNSNumber_Textbox.sendKeys(dunsNumber);
					}
					if(!td.getDomSubAcct().isEmpty())
					{
						this.DomSubAcct_Textbox.sendKeys(td.getDomSubAcct());
					}
					if(!td.getOwnerName().isEmpty())
					{
						this.ownerName.sendKeys(td.getOwnerName());
					}
					if(!td.getSICCode().isEmpty())
					{
						float sicCode=Float.parseFloat(td.getSICCode());
						//changing No of Opptys from float to int	
						int sicCode1=Math.round(sicCode);
						//changing No of opptys from int to string
						String sicCode2=Integer.toString(sicCode1);
				
						
						this.SICCode_textbox.sendKeys(sicCode2);
					}
					if(!td.getSICDescription().isEmpty())
					{
						this.SICDescription_textbox.sendKeys(td.getSICDescription());
					}					
								
			
					if(!td.getnAICSCode().isEmpty())
					{
						this.NAICSCategory_dropdown.click();
						for(WebElement element:NAICSCategory_dropdownValues)
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
						this.NAICSDescription_textbox.sendKeys(td.getnAICSDescription());
					}
					 searchAddress.click();
					CommonFunctions.pause(3);
					if(!td.getPrimaryCity().isEmpty())
					{
						this.City_textbox.sendKeys(td.getPrimaryCity());
					}
		
					if(!td.getPrimaryState().isEmpty())
					{
						this.State_textbox.sendKeys(td.getPrimaryState());
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
					 
					SVIDDetails_Dropdown.click();
					Thread.sleep(2000);
					SVIDDetails_Dropdownvalues.get(0).click();
					CommonFunctions.scrollTo(SVIDInfoClose_button, driver);
					Thread.sleep(2000);
					SVIDDetails_Dropdown.click();
					Thread.sleep(1000);
					/*SVIDDetails_Dropdownvalues.get(1).click();
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
							responseCapturedTime="No Data found";
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
							responseCapturedTime="Server Error";
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

			
		
			
			

			
		
		
