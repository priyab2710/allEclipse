package com.clientN.reports;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class BaseExtent {
		
	protected ExtentReports extent;
 	protected ExtentTest test;
 	
 	public String suite;
    
    public String path = System.getProperty("user.dir");
    public  String testName;
	    
	 
    @BeforeMethod
    public void beforeMethod(Method method) {
 	   System.out.println("CURRENT METHOD: " + method.getName());
    }
    
    @AfterMethod
    protected void afterMethod(ITestResult result) throws IOException, AWTException {
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
    
    
   @BeforeTest
   public void beforeTest(ITestContext ctx) {
    	
	   	String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
        String testName = ctx.getName();
        this.testName = testName;
        getData();
    	suite = suiteName(ctx);
    	System.out.println("CURRENT SUITE: " + suiteName);
        
    	//String filePath = path+"\\Results\\"+suiteName+"_"+testName+".html";
    	String filePath = path+"\\Results\\"+suiteName+".html";
    	
    	extent = new ExtentReports(filePath, NetworkMode.ONLINE);
    	try {
			String hostname = java.net.InetAddress.getLocalHost().getHostName();
			extent
            	.addSystemInfo("Host Name", hostname)
            	.addSystemInfo("Environment", (new BaseExtent()).getData("URL"));
			
			extent.loadConfig(new File("config.xml"));
			
        } catch (UnknownHostException e) {
			e.printStackTrace();
		}
        System.out.println("Report will be saved to '"+filePath+"'");
    }
    
    //@BeforeSuite
    public void beforeSuite(ITestContext context) {
    	getData();
    	suite = suiteName(context);
    	System.out.println("CURRENT SUITE: " + suiteName(context));
    }
   

    
    public void initExtent(ExtentReports extent, String testName){
    	String filePath = path+"\\Result_"+testName+".html"; //\\Result
    	extent = new ExtentReports(filePath, NetworkMode.OFFLINE);
    	try {
			String hostname = java.net.InetAddress.getLocalHost().getHostName();
			extent
            	.addSystemInfo("Host Name", hostname)
            	.addSystemInfo("Environment", (new BaseExtent()).getData("URL"));
			
			extent.loadConfig(new File("config.xml"));
			
        } catch (UnknownHostException e) {
			e.printStackTrace();
		}
        System.out.println("Report will be saved to '"+filePath+"'");
    }
    
    public static String timeStamp(){
    	return new SimpleDateFormat("dd-MMM-yy_HH-mm-ss").format(new Date());
    }
    
    public static void getData(){
    	try{
    		File file = new File("Property.properties");
			FileInputStream fileInput = new FileInputStream(file);
			
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
    
    public String getData(String key){
    	File file = new File("Property.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String data = properties.getProperty(key);
    	
    	return data;
    	
    }
    
   
    
    public String suiteName(ITestContext context) {
    	return context.getCurrentXmlTest().getSuite().getName();
	}
}