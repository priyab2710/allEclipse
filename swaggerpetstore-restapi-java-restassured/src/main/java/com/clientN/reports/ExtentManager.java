
package com.clientN.reports;

import java.io.File;
import java.net.UnknownHostException;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;
    
    public static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath);//, NetworkMode.OFFLINE);
            try {
				String hostname = java.net.InetAddress.getLocalHost().getHostName();
				extent
                	.addSystemInfo("Host Name", hostname)
                	.addSystemInfo("Environment", (new BaseExtent()).getData("URL"));
				
				extent.loadConfig(new File("config.xml"));
				
            } catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        
        return extent;
    }
}