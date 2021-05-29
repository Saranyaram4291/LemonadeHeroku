package com.att.lemonade.base;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.log4testng.Logger;

import com.att.lemonade.utilities.ConstantFile;

public class TestCaseSessionDataManger {
	//this hashmap holds data for each test case and each screen.
	//hashmap<testcasekey, Page hashmap<page_key, hashmap<data_key, data_value>>>
	private static Logger log=Logger.getLogger(TestCaseSessionDataManger.class);
	private static HashMap<String,HashMap<String,HashMap<String,String>>> hmSharedSessionData=new HashMap<String,HashMap<String,HashMap<String,String>>> ();

	public static HashMap<String,HashMap<String,String>> getTestCaseData(String testcaseKey) {		
		return hmSharedSessionData.get(testcaseKey);
	}	
	
	public static void addTestCaseData(String testcaseKey, HashMap<String, HashMap<String,String>> hmData) {		
		hmSharedSessionData.put(testcaseKey, hmData);
	}
	
	public static HashMap<String,HashMap<String,String>> getTestCaseData(String testcaseKey, HashMap<String, HashMap<String,String>> hmData) {		
		return hmSharedSessionData.get(testcaseKey);
	}
	
	public static void addPageData(String testcaseKey, String pageKey, HashMap<String, String> pageDataMap) {
		HashMap<String,HashMap<String,String>> testDataMap=hmSharedSessionData.get(testcaseKey);
		if(testDataMap==null) {
			HashMap<String,HashMap<String,String>> hmSharedSessionDataForTestCase=new HashMap<String,HashMap<String,String>>();
			hmSharedSessionDataForTestCase.put(pageKey,pageDataMap);
			hmSharedSessionData.put(testcaseKey, hmSharedSessionDataForTestCase);
		}else {
			HashMap<String,String> pageDataMapOld = testDataMap.get(pageKey);
			if(pageDataMapOld==null) {
				testDataMap.put(pageKey,pageDataMap);
				hmSharedSessionData.put(testcaseKey, testDataMap);
			}else {
				pageDataMapOld.putAll(pageDataMap);
				testDataMap.put(pageKey,pageDataMapOld);
				hmSharedSessionData.put(testcaseKey, testDataMap);
			}
		}
	}
	public static HashMap<String,String> getPageData(String testcaseKey, String pageKey) {
		if(hmSharedSessionData.get(testcaseKey)==null) {
			return null;
		}else {
			HashMap<String,HashMap<String,String>> hmTestData= hmSharedSessionData.get(testcaseKey);
			if(hmTestData==null) {
				return null;
			}else {
				HashMap<String,String> hmPageData = hmTestData.get(pageKey);
				if(hmPageData==null) {
					return null;
				}else {
					return hmPageData;
				}
			}
		}
	}
	public static void addPageDataKeyValue(String testcaseKey, String pageKey, String dataKey, String dataValue) {
		HashMap<String,HashMap<String,String>> testDataMap=hmSharedSessionData.get(testcaseKey);
		if(testDataMap==null) {
			HashMap<String,HashMap<String,String>> hmSharedSessionDataForTestCase=new HashMap<String,HashMap<String,String>>();
			HashMap<String, String> pageDataMap = new HashMap<String, String>();
			pageDataMap.put(dataKey, dataValue);
			hmSharedSessionDataForTestCase.put(pageKey,pageDataMap);
			hmSharedSessionData.put(testcaseKey, hmSharedSessionDataForTestCase);
		}else {
			HashMap<String,String> pageDataMapOld = testDataMap.get(pageKey);
			if(pageDataMapOld==null) {
				HashMap<String, String> pageDataMap = new HashMap<String, String>();
				pageDataMap.put(dataKey, dataValue);
				testDataMap.put(pageKey,pageDataMap);
				hmSharedSessionData.put(testcaseKey, testDataMap);
			}else {
				
				pageDataMapOld.put(dataKey, dataValue);
				testDataMap.put(pageKey,pageDataMapOld);
				hmSharedSessionData.put(testcaseKey, testDataMap);
			}
		}
	}
	public static String getPageData(String testcaseKey, String pageKey, String dataKey) {
		if(hmSharedSessionData.get(testcaseKey)==null) {
			return null;
		}else {
			HashMap<String,HashMap<String,String>> hmTestData= hmSharedSessionData.get(testcaseKey);
			if(hmTestData==null) {
				return null;
			}else {
				HashMap<String,String> hmPageData = hmTestData.get(pageKey);
				if(hmPageData==null) {
					return null;
				}else {
					String dataValue=hmPageData.get(dataKey);
					return dataValue;
				}
			}
		}
	}
	public static String printAllTestData(String testKey) {
			StringBuffer buff=new StringBuffer();
			buff.append("{ \n");
			buff.append(testKey +" {\n");
			HashMap<String,HashMap<String,String>> testDataMap=hmSharedSessionData.get(testKey);
			for(String pageKey: testDataMap.keySet()) {
				int j=0;
				if(j==0) {
					buff.append(pageKey +" {\n");
					j++;
				}else {
					buff.append(","+pageKey +" {\n");
				}
				HashMap<String,String> pageDataMap=testDataMap.get(pageKey);
				for(String dataKey:pageDataMap.keySet()) {
					int k=0;
					if(k==0) {
						buff.append(dataKey +" : "+pageDataMap.get(dataKey)+"\n");
						k++;
					}else {
						buff.append(","+dataKey +" : "+pageDataMap.get(dataKey)+"\n");
					}
				}
				buff.append("}\n");
			}
			buff.append("}\n");
			buff.append("}\n");
			return buff.toString();
	}
	public static void printAllTestData() {
		StringBuffer buff=new StringBuffer();
		buff.append("{ \n");
		int i=0;
		for(String testKey: hmSharedSessionData.keySet()) {
			if(i==0) {
				buff.append(testKey +" {\n");
				i++;
			}else {
				buff.append(","+testKey +" {\n");
			}
			HashMap<String,HashMap<String,String>> testDataMap=hmSharedSessionData.get(testKey);
			for(String pageKey: testDataMap.keySet()) {
				int j=0;
				if(j==0) {
					buff.append(pageKey +" {\n");
					j++;
				}else {
					buff.append(","+pageKey +" {\n");
				}
				HashMap<String,String> pageDataMap=testDataMap.get(pageKey);
				for(String dataKey:pageDataMap.keySet()) {
					int k=0;
					if(k==0) {
						buff.append(dataKey +" : "+pageDataMap.get(dataKey));
						k++;
					}else {
						buff.append(","+dataKey +" : "+pageDataMap.get(dataKey));
					}
				}
				log.info("}");
			}
			log.info("}");
		}
	}
	
	public static ArrayList<String> compareExpectedDataVsRateLetter(String testCaseUniqueKey) {
		HashMap<String, String> rateLetterHm = getPageData(testCaseUniqueKey,
				ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT);
		HashMap<String, String> expectedHm = getPageData(testCaseUniqueKey, ConstantFile.EXPECTED_RESULT);
		ArrayList<String> diffList = new ArrayList<String>();

		for (String expectedKey : expectedHm.keySet()) {
			if (expectedKey.equalsIgnoreCase(ConstantFile.TOTAL_MRC)
					|| expectedKey.equalsIgnoreCase(ConstantFile.TOTAL_NRC)) {
				if (Math.round(Double.parseDouble(expectedHm.get(expectedKey))) != Math
						.round(Double.parseDouble(rateLetterHm.get(expectedKey)))) {
					diffList.add(expectedKey);
					TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_MAIN_PAGE,
							ConstantFile.DIFF_RATE_LETTER_VS_EXPECTED_DATA, expectedKey);
				}
			} else if (!expectedHm.get(expectedKey).equalsIgnoreCase(rateLetterHm.get(expectedKey))) {
				diffList.add(expectedKey);
				TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey, ConstantFile.PAGE_KEY_MAIN_PAGE,
						ConstantFile.DIFF_RATE_LETTER_VS_EXPECTED_DATA, expectedKey);
			}
		}
		
		return diffList;

		// System.out.println( new ArrayList<String>( rateLetterHm.values()
		// ).equals(new ArrayList<String>( expectedHm.values() )) );
		// return (new ArrayList<String>(rateLetterHm.values()).equals(new
		// ArrayList<String>(expectedHm.values())));
	}
	
	
/*	public static ArrayList<String> compareGUIDataVsRateLetter(String testCaseUniqueKey) {
		HashMap<String, String> rateLetterHm = getPageData(testCaseUniqueKey,
				ConstantFile.PAGE_KEY_RATE_LETTER_PDF_CONTENT);
		HashMap<String, String> guiHm = getPageData(testCaseUniqueKey, ConstantFile.PAGE_KEY_LEMONADE_GUI_CONTENT);
		ArrayList<String> diffList = new ArrayList<String>();

		for (String expectedKey : guiHm.keySet()) {
			if(expectedKey.equals(ConstantFile.TEST_DESC)){
				continue;
			}
			else if(expectedKey.equals(ConstantFile.REQUEST_ID)){
				String requestId = guiHm.get(expectedKey);
				if(requestId !=null && requestId.contains("Request:")) {
					requestId = requestId.replace("Request:", "");
					if(requestId.contains(".")) {
						String[] requestIdFormat = requestId.split("\\.");
						if(requestIdFormat.length == 3) {
							System.out.println(requestIdFormat[0]);
							System.out.println(requestIdFormat[1]);
							System.out.println(requestIdFormat[2]);
							if (!requestIdFormat[0].equalsIgnoreCase(rateLetterHm.get(expectedKey))) {
								diffList.add(expectedKey);
								TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
										ConstantFile.PAGE_KEY_MAIN_PAGE, ConstantFile.DIFF_RATE_LETTER_VS_GUI_DATA,
										expectedKey);
							}
						}
						
					}
				}
			}
			else if (expectedKey.equalsIgnoreCase(ConstantFile.TOTAL_MRC)
					|| expectedKey.equalsIgnoreCase(ConstantFile.TOTAL_NRC)) {
				if (Math.round(Double.parseDouble(guiHm.get(expectedKey))) != Math
						.round(Double.parseDouble(rateLetterHm.get(expectedKey)))) {
					diffList.add(expectedKey);
					TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
							ConstantFile.PAGE_KEY_MAIN_PAGE, ConstantFile.DIFF_RATE_LETTER_VS_GUI_DATA,
							expectedKey);
				}
			}else if (!guiHm.get(expectedKey).equalsIgnoreCase(rateLetterHm.get(expectedKey))) {
				diffList.add(expectedKey);
				TestCaseSessionDataManger.addPageDataKeyValue(testCaseUniqueKey,
						ConstantFile.PAGE_KEY_MAIN_PAGE, ConstantFile.DIFF_RATE_LETTER_VS_GUI_DATA,
						expectedKey);
			}
		}
		return diffList;

		// System.out.println( new ArrayList<String>( rateLetterHm.values()
		// ).equals(new ArrayList<String>( expectedHm.values() )) );
		// return (new ArrayList<String>(rateLetterHm.values()).equals(new
		// ArrayList<String>(expectedHm.values())));
	}*/
	
}
