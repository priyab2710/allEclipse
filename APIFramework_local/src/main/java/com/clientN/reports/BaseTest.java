package com.clientN.reports;


import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
 
public class BaseTest {
 
	protected ExtentReports extent;
 	protected ExtentTest test;
 	 public  String testName;
 	public String suite;
    
    @BeforeClass
    public void classLevelSetup() {
      System.out.println("I am in Before Class");
    }
    
    @BeforeTest
    public void beforeTest(ITestContext ctx) {
     	
    	System.out.println("I am in Before Test");
    	String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
         String testName = ctx.getName();
         this.testName = testName;
        suite = suiteName(ctx);
     	System.out.println("CURRENT SUITE: " + suiteName);
         
     	//String filePath = path+"\\Results\\"+suiteName+"_"+testName+".html";
     	String filePath = System.getProperty("user.dir")+"\\"+suiteName+".html";
     	
     	extent = new ExtentReports(filePath, NetworkMode.ONLINE);
     	try {
 			String hostname = java.net.InetAddress.getLocalHost().getHostName();
 			extent
             	.addSystemInfo("Host Name", hostname);
 			
 			extent.loadConfig(new File("config.xml"));
 			
         } catch (UnknownHostException e) {
 			e.printStackTrace();
 		}
         System.out.println("Report will be saved to '"+filePath+"'");
     }
 
    @BeforeMethod
    public void beforeMethod(Method method) {
    	System.out.println("I am in Before Class");
 	   System.out.println("CURRENT METHOD: " + method.getName());
    }
    
    @AfterMethod
    protected void afterMethod(ITestResult result) throws IOException, AWTException {
    	System.out.println("I am in After Method");
        try {
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, "Test Failed");
				test.log(LogStatus.FAIL, result.getThrowable());
			} else if (result.getStatus() == ITestResult.SKIP) {
			    test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
			} else if (result.getStatus() == ITestResult.SUCCESS){
			    test.log(LogStatus.PASS, "Test passed");
			}
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			extent.endTest(test);        
		    extent.flush();
		}
    }
 
    @AfterClass
    public void teardown() {
    	
    	System.out.println("I am in After Class");
    }
    
    
    public String suiteName(ITestContext context) {
    	return context.getCurrentXmlTest().getSuite().getName();
	}
}