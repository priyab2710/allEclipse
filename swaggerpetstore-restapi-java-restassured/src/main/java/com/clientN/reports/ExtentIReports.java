package com.clientN.reports;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author ravi.pratap
 *
 */
public class ExtentIReports implements IReporter {

    
    private static final String OUTPUT_DIR = System.getProperty("user.dir") + File.separator + "Results/";
    private static final String RESPORT_NAME = "Regression.html";
    
    private ExtentReports extent;
    public long startTime;
	public long endTime;
    
	@Override
    public void generateReport(List xmlSuites, List suites, String outputDirectory) {
    	
    	extent = new ExtentReports(OUTPUT_DIR + RESPORT_NAME, true);
        
        for (Object object : suites) {
        	ISuite suite = (ISuite) object;
            Map<String, ISuiteResult> result = suite.getResults();
            
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                
            }
        }
        
        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }
        
        extent.flush();
    }
    
    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
        
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
            	String testName  = result.getTestContext().getName();
            	String suiteName = result.getTestContext().getSuite().getName();
                test = extent.startTest(testName + ": " + result.getMethod().getMethodName());
                
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                
                test.log(LogStatus.INFO, "<a href='" + suiteName + ".html'>HTML Result</a>");
                //test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));
            }
        }
    }
    
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();      
    }
}
