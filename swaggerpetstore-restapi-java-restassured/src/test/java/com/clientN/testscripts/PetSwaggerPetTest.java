package com.clientN.testscripts;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clientN.library.AutomationBuddy;
import com.clientN.library.JsonReader;
import com.clientN.reports.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Unit test for simple Api.
 * @author Divs
 */
public class PetSwaggerPetTest extends BaseTest{

	private static Logger logger = Logger.getLogger(PetSwaggerPetTest.class.getName());
	JsonReader jreader = new JsonReader();
	AutomationBuddy ab = new AutomationBuddy();
	String methodname;
	/**
	 * @throws Exception 
	 */
	
	
	
   /**
	 * @param key
	 * @param Value
	 * @throws Exception
	 */
	@Test(dataProvider="testScripts")
    public void postpet(int loop,LinkedHashMap<String,HashMap<String, String>> Value) throws Exception{
		test = extent.startTest("@Testname :"+methodname +" :   Validate :=" + Value );
		HashMap<String, String> resultdatamap = ab.processTestData(jreader,loop, Value);
		ab.resultAsserter(resultdatamap,Value,methodname);
	
	}

	/**
	 * @param key
	 * @param Value
	 * @throws Exception
	 */
	/*
	 * @Test(dataProvider="testScripts") public void getpet(int
	 * loop,LinkedHashMap<String,HashMap<String, String>> Value) throws Exception{
	 * test = extent.startTest("@Testname :"+methodname +" :   Validate :=" + Value
	 * ); HashMap<String, String> resultdatamap = ab.processTestData(jreader,loop,
	 * Value); ab.resultAsserter(resultdatamap,Value,methodname);
	 * 
	 * }
	 */
	
	
	/**
	 * @return 
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] testScripts(ITestNGMethod test) throws Exception {
		methodname = test.getMethodName();
		return ab.dataprovider(test);
		
	}
}
