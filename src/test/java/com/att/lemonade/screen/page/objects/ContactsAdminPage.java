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


public class ContactsAdminPage extends CommonFunctions{
	
	private  WebDriver driver;
	Logger Log = Logger.getLogger(LoginPage.class);
	private String testCaseUniqueKey;
	public String record_count;
	
	public ContactsAdminPage(WebDriver driver, String testCaseUniqueKey, int timeouts){
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
		
		//globalSearch_icon
		@FindBy(xpath="//*[@id='gblSrchBtn']")
		public WebElement globalSearch_icon;
		
		//column diplay icon
		@FindBy(xpath="//*[@title='Column Setting']")
		public WebElement columnDisplay_icon;
		
		//column display availble Fields
		@FindBy(xpath="//div[@class='slds-dueling-list']/div[1]//descendant::ul")
		public List<WebElement> columnAvailable_Fields;
		
		//column display visible Fields
		@FindBy(xpath="//div[@class='slds-dueling-list']/div[3]//descendant::ul/li/div/span")
		public List<WebElement> columnVisible_Fields;
		
		//move to availble side
		@FindBy(xpath="//div[@class='slds-dueling-list']/div[2]/button[2]")
		public WebElement availableSide_Button;
		
		//column display save button
		@FindBy(xpath="//footer[@class='slds-modal__footer']/button[2]")
		public WebElement columnDisplay_SaveButton;
		
		//attuid_Textbox
		
		@FindBy(xpath="//*[@id='gblAttSrch']")
		public WebElement attuid_Textbox;
		
		//attuid searchicon
		
		@FindBy(xpath="//*[@id='attSrchBtn']")
		public WebElement attuid_SearchIcon;
		
		//Account Name text bpx
		@FindBy(xpath="//*[@id='ngl_input_66']")
		public WebElement accountName_Textbox;
		
				
		//SubAcctId text bpx
		@FindBy(xpath="//*[@id='ngl_input_67']")
		public WebElement subAcctID_Textbox;
		
		
		//svid text bpx
		@FindBy(xpath="//*[@id='ngl_input_68']")
		public WebElement svid_Textbox;
				
		//svidName text bpx
		@FindBy(xpath="//*[@id='ngl_input_69']")
		public WebElement svidName_Textbox;
		
		
		//search Contact details section
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[7]/ngl-expandable-section[1]/h3/button/span")
		public WebElement searchContactDetails_Section;
		
		//First Name text bpx
		@FindBy(xpath="//*[@id='ngl_input_71']")
		public WebElement firstName_Textbox;
				
						
		// Last Name text bpx
		@FindBy(xpath="//*[@id='ngl_input_72']")
		public WebElement lastName_Textbox;
				
				
		//phone text bpx
		@FindBy(xpath="//*[@id='ngl_input_73']")
		public WebElement phone_Textbox;
		

		//filteronEmailAndPhone
		
		@FindBy(xpath="//*[@id='emailorphone']")
		public WebElement filterOnEmailAndPhone_button;
		
		//filteronEmailAndPhone Values
		
		@FindBy(xpath="//*[@id='emailorphone']//descendant::option")
		public List<WebElement> filterOnEmailAndPhone_values;
						
		//title text bpx
		@FindBy(xpath="//*[@id='ngl_input_74']")
		public WebElement title_Textbox;
		
		//Department text bpx
		@FindBy(xpath="//*[@id='ngl_input_75']")
		public WebElement department_Textbox;
				
		//Management Level text bpx
		@FindBy(xpath="//*[@id='ngl_input_76']")
		public WebElement managementLevel_Textbox;
		
		//search Account details section
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[1]/div/div[7]/ngl-expandable-section[2]/h3/button/span")
		public WebElement searchAccountDetails_Section;
				
		//city text bpx
		@FindBy(xpath="//*[@id='ngl_input_78']")
		public WebElement city_Textbox;
						
								
		// state text bpx
		@FindBy(xpath="//*[@id='ngl_input_79']")
		public WebElement state_Textbox;
						
						
		//zip text bpx
		@FindBy(xpath="//*[@id='ngl_input_80']")
		public WebElement zip_Textbox;
								
		//title text bpx
		@FindBy(xpath="//*[@id='ngl_input_81']")
		public WebElement country_Textbox;
		
		//record value
		@FindBy(xpath="/html/body/div/my-app/app-account/div/div/div/div/div[2]/div[1]/div/div[2]/span")
		public WebElement recordValue;
		
		//no data found
		@FindBy(xpath="/html/body/div/my-app/app-account/app-accountmfe/div/div[2]/table/tbody/tr/td")
		public WebElement noDataFound;
		
		static Logger logger = Logger.getLogger(MyContactPage.class.getName());
		private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
		public void Search(TCData td) throws Exception{
			
			System.out.println("Inside Contact Admin Page");
		
			TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_LEMONADE_GUI_CONTENT, ConstantFile.TEST_DESC, td.getDescription());
			
			ExcelReader er=new ExcelReader(ACM.getTestDataFile());
		
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(1, TimeUnit.SECONDS)
					.withTimeout(10, TimeUnit.SECONDS)
					.ignoring(TimeoutException.class);
			
			String responseTime="responseTime";
			String recordCount="recordCount";
			String sheet[]=testCaseUniqueKey.split(":");
			System.out.println("Sheet"+sheet[0]+"row"+sheet[1]);
			String row[]=sheet[1].split("data-row-");
			System.out.println("Row"+row[1]);
			Integer row1=Integer.parseInt(row[1]);
			String responseCapturedTime=null;
		//	CommonFunctions.waitUntillPageLoad(driver);
			CommonFunctions.pause(5);
			//CommonFunctions.waitForElementToBeStable(driver,listViews_dropdown);
			listViews_dropdown.click();
			
			for(WebElement e:listViews_dropdownValues)
			{
				if(e.getText().equalsIgnoreCase("Contacts Admin"))
				{
					e.click();
					break;
				}
			}
			CommonFunctions.pause(5);
			
			if(!td.getAttuid().isEmpty())
			{
				attuid_Textbox.sendKeys(td.getAttuid());
				attuid_SearchIcon.click();
				CommonFunctions.pause(5);
			}
			
		
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
				if(!td.getAccountName().isEmpty())
				{
					this.accountName_Textbox.sendKeys(td.getAccountName());
					
				}
				if(!td.getSubAcctId().isEmpty())
				{
					
					this.subAcctID_Textbox.sendKeys(td.getSubAcctId());
				}
				if(!td.getSvidName().isEmpty()) {
					
				
					this.svidName_Textbox.sendKeys(td.getSvidName());
				}
				if(!td.getSVID().isEmpty())
				{
					
					this.svid_Textbox.sendKeys(td.getSVID());
				}
				
				this.searchContactDetails_Section.click();
				CommonFunctions.pause(5);
				System.out.println("Inside contact details");
			
				
				CommonFunctions.scrollToElement(firstName_Textbox,driver);
				
				if(!td.getFirstName().isEmpty())
				{
					
					this.firstName_Textbox.sendKeys(td.getFirstName());
				}
				
				if(!td.getLastName().isEmpty())
				{
					
					this.lastName_Textbox.sendKeys(td.getLastName());
				}
				
				if(!td.getPrimaryPhone().isEmpty())
				{
					
					this.phone_Textbox.sendKeys(td.getPrimaryPhone());
				}
				
				if(!td.getFilterOnEmailAndPhone().isEmpty())
				{
					this.filterOnEmailAndPhone_button.click();
					CommonFunctions.pause(1);
					for(WebElement e:filterOnEmailAndPhone_values)
					{
						System.out.println("Selected value"+td.getFilterOnEmailAndPhone());
						
						if(e.getText().equalsIgnoreCase(td.getFilterOnEmailAndPhone()))
						{
							e.click();
							break;
						}
					}
				}
				
				CommonFunctions.scrollToElement(title_Textbox,driver);
				
				if(!td.getTitle().isEmpty())
				{
					
					this.title_Textbox.sendKeys(td.getTitle());
				}
				
				if(!td.getDepartment().isEmpty())
				{
					
					this.department_Textbox.sendKeys(td.getDepartment());
				}
				
				if(!td.getManagementLevel().isEmpty())
				{
					
					this.managementLevel_Textbox.sendKeys(td.getManagementLevel());
					
				}
				
				
				CommonFunctions.scrollToElement(searchAccountDetails_Section,driver);
				
				this.searchAccountDetails_Section.click();
				CommonFunctions.pause(5);
				System.out.println("Inside account details");
				
				if(!td.getPrimaryCity().isEmpty())
				{
					
					this.city_Textbox.sendKeys(td.getPrimaryCity());
				}
				
				if(!td.getPrimaryState().isEmpty())
				{
					
					this.state_Textbox.sendKeys(td.getPrimaryState());
				}
				
				if(!td.getPrimaryZip().isEmpty())
				{
					
					this.zip_Textbox.sendKeys(td.getPrimaryZip());
				}
				
				if(!td.getPrimaryCountry().isEmpty())
				{
					
					this.country_Textbox.sendKeys(td.getPrimaryCountry());
				}
				
			}
			CommonFunctions.scrollToElement(search_Button,driver);
				
								
				long start;
				
				if(!td.getGlobalSearch().isEmpty())
				{
					System.out.println("Inside global search");
					globalSearch_icon.click();
					start = System.currentTimeMillis();
					
				}
				else
				{
					System.out.println("Inside advance search");
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
				if(!td.getColumnDisplayVisible().isEmpty())
				{
					String visibleFields[]=td.getColumnDisplayVisible().split(",");
					
					columnDisplay_icon.click();
					CommonFunctions.pause(5);
					System.out.println("Available Fields are ");
					for(WebElement e:columnAvailable_Fields)
					{
						System.out.println(e.getText());
					}
					System.out.println("Visible Fields are ");
					
					for(String count:visibleFields)
					{
						for(WebElement el:columnVisible_Fields)
						{
							if(el.getText().equalsIgnoreCase(count))
							{
								el.click();
								availableSide_Button.click();
								CommonFunctions.pause(2);
							}
						}
					}
					for(String count:visibleFields)
					{
						for(WebElement el:columnAvailable_Fields)
						{
							if(el.getText().equalsIgnoreCase(count))
							{
								CommonFunctions.pause(2);
								System.out.println(count+" column moved successfully");
							}
						}
						
					}
					columnDisplay_SaveButton.click();
					
				}
			
		}

		
}