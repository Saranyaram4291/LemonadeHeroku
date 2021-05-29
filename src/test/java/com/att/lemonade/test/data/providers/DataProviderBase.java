package com.att.lemonade.test.data.providers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import org.testng.log4testng.Logger;

import com.att.lemonade.utilities.ExcelReader;

public class DataProviderBase {
	
	
	
	private Logger log = Logger.getLogger(DataProviderBase.class);
	public Object[] createDataObject(String dataWorkbookPath, String sheetName, Class classObject) throws Exception {
		Object dataObject[]=null;
		ExcelReader er = new ExcelReader(dataWorkbookPath);
		Field[] flds=classObject.getDeclaredFields();
		HashMap<String,Field> hm=new HashMap<String, Field>();
		for(Field fld: flds) {
			hm.put(fld.getName(), fld);
		}
		int columnCount = er.getColumnCount(sheetName);
		ArrayList<String> columns=new ArrayList<String>();
		for(int i=1;i<=columnCount;i++) {
			String columnName=er.getCellData(sheetName, 1, i);
			if(!hm.containsKey(columnName)) {
				throw new Exception("Column["+columnName+"] is not found in Object["+classObject.getName()+"]. Datasheet columns and dataObject fields must match.");
			}
			columns.add(columnName);
		}
		int rowCount=er.getRowCount(sheetName);
		dataObject = new Object[rowCount-1];
		
		for(int i=2;i<=rowCount;i++) {
			dataObject[i-2]=classObject.newInstance();
			for(int j=1;j<=columnCount;j++) {
				dataObject[i-2].getClass().getField(columns.get(j-1)).set(dataObject[i-2], er.getCellData(sheetName, i, j));;
			}
		}
		return dataObject;
	}

	public Hashtable<String,Hashtable<String,String>>[] createGenericDataObject(String dataWorkbookPath, String sheetName) throws Exception {
		//Hashtable<String,String> hsTestData[]=new Hashtable<String,String>[];
		ExcelReader er = new ExcelReader(dataWorkbookPath);
		boolean bl=er.isSheetExist(sheetName);
		if(bl==false) {
			return new Hashtable[0];
		}
		String columnNames[];
		int columnCount = er.getColumnCount(sheetName);
		columnNames=new String[columnCount];
		System.out.println("Coulumn Count="+columnCount);
		HashMap<String,String> hmColNames=new HashMap<String, String>();

		for(int i=1;i<=columnCount;i++) {
			String columnName=er.getCellData(sheetName, 1, i);
			hmColNames.put(String.valueOf(i),columnName);
			columnNames[i-1]=columnName;
		}
		int rowCount=er.getRowCount(sheetName);
		log.debug("Rows Count="+rowCount);
		System.out.println("Rows Count="+rowCount);
		Hashtable<String,Hashtable<String,String>>[] hsTestData = new Hashtable[rowCount-1];
		
		for(int i=2;i<=rowCount;i++) {
			Hashtable<String,String> hmRowData=new Hashtable<String,String>();
			for(int j=1;j<=columnCount;j++) {
				hmRowData.put(columnNames[j-1],er.getCellData(sheetName, i, j) );	
			}
			hsTestData[i-2]=new Hashtable<String,Hashtable<String,String>>();
			hsTestData[i-2].put(String.valueOf(i), hmRowData);
		}
		return hsTestData;
	}
}
	
