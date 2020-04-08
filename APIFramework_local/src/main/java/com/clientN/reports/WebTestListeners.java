
package com.clientN.reports;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class WebTestListeners extends BaseTest implements ITestListener 
{private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
}

@Override
public void onStart(ITestContext iTestContext) {
    Properties props = new Properties();
    try {
		props.load(new FileInputStream(System.getProperty("user.dir")+"//src//test//resource//log4j.properties"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    PropertyConfigurator.configure(props);
}


@Override
public void onTestStart(ITestResult iTestResult) {
   
}

@Override
public void onTestSuccess(ITestResult iTestResult) {
    //ExtentReports log operation for passed tests.
   
}

@Override
public void onTestFailure(ITestResult iTestResult) {

    //Get driver from BaseTest and assign to local webDriver variable.
    Object testClass = iTestResult.getInstance();

  

}

@Override
public void onTestSkipped(ITestResult iTestResult) {
    //ExtentReports log operation for skipped tests.
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
