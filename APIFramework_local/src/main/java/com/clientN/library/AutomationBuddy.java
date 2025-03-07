package com.clientN.library;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.ITestNGMethod;

import com.jayway.restassured.path.json.JsonPath;

public class AutomationBuddy {


    
    private static Logger logger = Logger.getLogger(AutomationBuddy.class.getName());
    public final static String env = "Sandbox";
    
    public static String environment;
    
    public static String emailrec;

	public final static String systemdir = System.getProperty("user.dir");
    
    public final static String testdatafolder = "//src//test//resource//testdata//";
    
    public final static String resultfolder = System.getProperty("user.dir")+"//test-output//Results";
    
    public final static LinkedHashMap<String, String> globalmap = new LinkedHashMap<>();
        
    
     
    
    
    /**
     * @param jpath
     * @return
     * @throws Exception
     */
    public static LinkedHashMap<String, String> processCriteriaData(JsonPath jpath) throws Exception{
    	
    	
    	System.out.println("I am in processCriteriaData ");
    	LinkedHashMap<String, String> testdatamap = new LinkedHashMap<>();
    	int criterialoop = 0;
    	String strtovalidate = jpath.get().toString();
        String arr[] = strtovalidate.split(",");
        
        for (String string : arr) {
				if(string.contains("Acceptance_Criteria")){
					criterialoop++;
				}
			}
        if(criterialoop==0){
        	logger.error("Exception in Dataprovider..There is no Acceptance Criteria set in the test data, NO test will execute");
        	throw new Exception("Exception in Dataprovider..There is no Acceptance Criteria set in the test data, NO test will execute");
        }
        String api = jpath.getString("Sandbox_TestURL");
        System.out.println("URI = "+ api);
        String endpoint = jpath.getString("endPoint");
        System.out.println("endpoint = "+ endpoint);
        globalmap.put("baseuri", api);
        globalmap.put("endpoint", endpoint);
    	if(endpoint!=null){
    		api+=endpoint;
    	}
    	
    	globalmap.put("url", api);
        for (int i = 1; i <=criterialoop; i++) {
			String tovalidate = jpath.getString("Acceptance_Criteria"+i);
			if(tovalidate ==null){
				logger.error("Exception in Dataprovider..Please check the Acceptance Criteria in TESTDATA.JSON, It should be Serlialized");
				throw new Exception("Exception in Dataprovider.. Please check the Acceptance Criteria in TESTDATA.JSON, It should be Serlialized");
			}
			System.out.println(tovalidate);
			if(!tovalidate.contains(":[")){
				String key = tovalidate.split(":")[0].replaceAll("\\[","");
				testdatamap.put(key, jpath.getString("Acceptance_Criteria"+i+"."+key));
				//System.out.println("key "+key);
				//System.out.println("value "+jpath.getString("Acceptance_Criteria"+i+"."+key));
			}else{
				String key[] = tovalidate.split(":\\[");
				String keya = key[0].replaceAll("\\[","");
				testdatamap.put(keya, jpath.getString("Acceptance_Criteria"+i+"."+keya));
			}
	         
		}
        
        System.out.println("testdatamap "+testdatamap);
        return testdatamap;
    }
    
    public static HashMap<String, String> processTestData(JsonReader jreader,String key, String value) throws Exception{
    	HashMap<String, String> finaldatamap = new HashMap<>();
    	String findkey = null;
    	String findvalue = null;
    	String getkey = null;
    	String getvalue = null;
    	JsonPath jp = jreader.readJson();
    	if(value.contains("[")){
    		String[] expectvalue = value.split(",");
    		for (String string : expectvalue) {
				if(string.contains("~")||string.contains("!")||string.contains("=")){
					String dummyarr[] = string.replaceAll("\\[|\\]","").split(":");
					getkey = dummyarr[0].trim();
					getvalue = dummyarr[1].trim();
				}else{
					String dummyarr[] = string.replaceAll("\\[|\\]","").split(":");
					findkey = dummyarr[0].trim();
					findvalue = dummyarr[1].trim();
				}
			}
    		if(findkey!=null){
    			int count =0;
    			List<String> atr = jp.getList(key+"."+findkey);
    			for (int i = 0; i < atr.size(); i++) {
    				if(atr.get(i).equals(findvalue)){
    					count = i;
    					break;
    				}
				}
    			String actualvalue;
    			try{
    			 actualvalue = jp.getString(key+"."+getkey+"["+count+"]").replaceAll("\n", "");
    			}catch(NullPointerException e){
    				logger.error("**********\nThe expected JSON value is not present in the API response \n The expected value should have '~ , ! , = '\n Please correct the input \n**********");
        			throw new Exception("**********\nThe expected JSON value is not present in the API response \n The expected value should have '~ , ! , = '\n Please correct the input \n**********");
            	}catch (Exception e) {
            		logger.error("**********\nThe expected JSON value is not present in the API response \n Please check is your validation valid?\n**********");
    				throw new Exception("**********\nThe expected JSON value is not present in the API response \n Please check is your validation valid?\n**********");
        		}
    			
    			finaldatamap.put("Actualvalue",actualvalue);
        		finaldatamap.put("Expectedvalue",getvalue);
    		}
    	}else{
    		finaldatamap.put("Actualvalue", jp.getString(key));
    		finaldatamap.put("Expectedvalue", value);
    	}
    	return finaldatamap;
    }
     
    public static Object[][] dataprovider(ITestNGMethod test) throws Exception{
    	
    	JsonReader jread = new JsonReader();
    	JsonPath jpath = jread.processJsonTestData(test.getMethodName());
    	LinkedHashMap<String, String> testdatamap = processCriteriaData(jpath);
    	Object[][] obj = new Object[testdatamap.size()][2];
    	int index =0 ;
    	for (String keys : testdatamap.keySet()) {
			obj[index][0] = keys;
			obj[index][1] = testdatamap.get(keys);
			index++;
		}
    	
    	return obj;
    	
    }

}
