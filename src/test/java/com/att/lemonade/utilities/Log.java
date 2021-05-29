package com.att.lemonade.utilities;

import org.apache.log4j.Logger;

@Deprecated
public class Log {

	// Initialize Log4j logs

	private static Logger Log = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite

	public static void startTestCase(String testCaseName) {
		Log.info("****************************************************************************************");
		Log.info("\t\t\t\t" + testCaseName + " Starts");
		Log.info("****************************************************************************************");
	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String testCaseName) {
		Log.info("****************************************************************************************");
		Log.info("\t\t\t\t" + testCaseName + " Ends");
		Log.info("****************************************************************************************");
	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message, Throwable throwable) {
		Log.error(message, throwable);
	}

	public static void fatal(Object message) {
		Log.fatal(message);
	}

	public static void debug(Object message) {
		Log.debug(message);
	}

}