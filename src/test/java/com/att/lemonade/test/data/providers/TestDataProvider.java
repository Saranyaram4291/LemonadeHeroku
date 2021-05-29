package com.att.lemonade.test.data.providers;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

import com.att.lemonade.test.data.objects.LoginDetails;
import com.att.lemonade.utilities.AplicationConfigurationManager;

public class TestDataProvider extends DataProviderBase{
	private AplicationConfigurationManager ACM= AplicationConfigurationManager.getInstance();
	private Logger log =Logger.getLogger(TestDataProvider.class);
	
	@DataProvider
	public LoginDetails[] getTestData() throws Exception {
		log.debug("In LoginDataProvider.getTestData");
		LoginDetails ld[]=null;
		try {
			Object obj[]=this.createDataObject(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx", "LoginScreen", LoginDetails.class);
			log.debug("In LoginDataProvider.getTestData+ "+obj.length);
			ld=new LoginDetails[obj.length];
			for(int i=0;i<obj.length;i++) {
				ld[i]=(LoginDetails)obj[i];
			}
			return ld;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		//return (super.LoginDetails[]);
	}
	
	@DataProvider //(parallel=true)
	public Hashtable<String,Hashtable<String,String>>[]  getGenericTestData(Method m) throws Exception {
		String testDataFile=ACM.getTestDataFile();
		log.debug("Looking for data in tab:["+m.getName()+"] in Data File ["+testDataFile+"]");
		if(testDataFile!=null) {
			return this.createGenericDataObject(testDataFile, m.getName());
		}else {
			return new Hashtable[0];	
		}
	}
	
}
