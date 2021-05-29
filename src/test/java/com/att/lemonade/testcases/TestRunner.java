/*package com.att.lemonade.testcases;

import java.util.List;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.att.lemonade.listeners.CustomListeners;
import com.att.lemonade.listeners.EventCapture;

public class TestRunner {
	static TestNG testNg;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomListeners cus=new CustomListeners();
		//EventCapture eve=new EventCapture();
		testNg=new TestNG();
		testNg.addListener((ITestListener) cus);
		List<String> suite=Lists.newArrayList();
		suite.add(".\\src\\test\\resources\\runner\\testng.xml");
		testNg.setTestSuites(suite);
		//testNg.setTestClasses(new Class[] {TC01_Accounts_Admin.class});
		testNg.run();
	}

}*/