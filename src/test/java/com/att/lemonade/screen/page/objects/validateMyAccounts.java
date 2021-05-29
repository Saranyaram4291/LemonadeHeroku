package com.att.lemonade.screen.page.objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.att.lemonade.test.data.objects.TCData;
import com.att.lemonade.utilities.AplicationConfigurationManager;
import com.att.lemonade.utilities.ExcelReader;

public class validateMyAccounts {
	
	private WebDriver driver;
	
	AplicationConfigurationManager ACM=AplicationConfigurationManager.getInstance();
	ExcelReader er=new ExcelReader(ACM.getResultDataFile());
	static String sheetName;
	int result_row=2;
	public validateMyAccounts(){
		
	}
	
	
	public void resultExcelSheetAddition()
	{
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();  
		 System.out.println(dtf.format(now));
		this.sheetName="Result"+dtf.format(now);
		System.out.println("sheetName inside resultExcel"+this.sheetName);
	  	er.addSheet(sheetName);
	  	
	  	
	}
	
	public String getResultSheetName()
	{
		System.out.println("sheetName inside getResult"+this.sheetName);
		return this.sheetName;
	}
	
	
	
	public boolean setResultExcelColumns(String sheetName)
	{
		String arg[]={"Account Name","Sub-Acct ID","SVID Name","# Opptys","Primary Phone","Primary Street","Primary City","Primary State","Primary Zip"," Account Status","SVID","Owner Name","Fiber Eligible","% Fiber","FN Indicator","FN Type","SIC Description","NAICS Description"};
		er.addColumn(sheetName, "testCaseUniqueKey");
		for(String s:arg)
		{
			
			er.addColumn(sheetName, s);
		}
		return true;
		
	}
	
	public int getResultExcelSheetCurrentLastrow()
	{
		int resultExcel_row = er.getRowCount(this.sheetName);
		return resultExcel_row;
	
	}
	
	public boolean setResultData(String sheetName,String S,int row,String data)
	{
		
		System.out.println("Row updated"+row);
		er.setCellData(sheetName, S, row, data);
		
		return true;
	}
	public boolean setTestCaseUniqueKey(String sheetName,String testCaseUniquekey,int row)
	{
		
		er.setCellData(this.sheetName, "testCaseUniqueKey", row, testCaseUniquekey);
		return true;
	}
	
}
