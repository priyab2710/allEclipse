package com.clientN.library;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestNGMethod;

import com.clientN.reports.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;

public class AutomationBuddy extends BaseTest{


    
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
    @SuppressWarnings("unchecked")
	public LinkedHashMap<String, HashMap<String,String>> processCriteriaData(JSONObject jobj) throws Exception{
    	
    	LinkedHashMap<String, HashMap<String, String>> testdatamap = new LinkedHashMap<String,HashMap<String,String>>();
    	HashMap<String, HashMap<Object, Object>> hmap = new HashMap<String, HashMap<Object,Object>>();
    	HashMap<String, String> localmap1 = new HashMap<String, String>();
    	HashMap<String, String> localmap2= new HashMap<String, String>();
    	JsonPath jpath = new JsonPath(jobj.toString());
    	List<Object> ls = jpath.getList("Acceptance_Criteria");
        if(ls!=null) {
	    	for (int i = 0; i < ls.size(); i++) {
	    		hmap.put("Val"+i,(HashMap<Object, Object>) ls.get(i));
	    	}
    	}
        
    	if(ls==null){
        	logger.info("Warning..There is no Acceptance Criteria set in the test data, Only status code 200 will be validated for pass Criteria");
        }
        
        String api = jpath.getString("Sandbox_TestURL");
        String endpoint = jpath.getString("endPoint");
        String method = jpath.getString("method");
        String statuscode = jpath.getString("statuscode");
        if(method.equals("post")||method.equals("put")) {
        	String body = jobj.get("body").toString();
        	localmap1.put("body", body);
        }
        localmap1.put("method", method);
        localmap1.put("baseuri", api);
        localmap1.put("endpoint", endpoint);
        localmap1.put("statuscode", statuscode);
		testdatamap.put("testparameters", localmap1);
		for (int i = 0; i <ls.size(); i++) {
        	HashMap<Object, Object> map = hmap.get("Val"+i);
        	Set<Object> keyset = map.keySet();
        	if(keyset ==null){
				logger.info("Exception in Dataprovider..Please check the Acceptance Criteria in TESTDATA.JSON, It should be Serlialized");
				//throw new Exception("Exception in Dataprovider.. Please check the Acceptance Criteria in TESTDATA.JSON, It should be Serlialized");
			}
        	for(Object key : keyset) {
        		localmap2.put(key.toString(), map.get(key).toString());
        	}
			/*
			 * String tovalidate = if(!tovalidate.contains(":[")){ String key =
			 * tovalidate.split(":")[0].replaceAll("\\{\\[",""); testdatamap.put(key,
			 * jpath.getString("Acceptance_Criteria"+i+"."+key)); }else{ String key[] =
			 * tovalidate.split(":\\["); String keya = key[0].replaceAll("\\[","");
			 * testdatamap.put(keya, jpath.getString("Acceptance_Criteria"+i+"."+keya)); }
			 */
	         
		}
        testdatamap.put("acceptance", localmap2);
        return testdatamap;
    }
    
    public HashMap<String, String> processTestData(JsonReader jreader,int loop, LinkedHashMap<String,HashMap<String, String>> value) throws Exception{
    	
    	String key = ""; //to remove after parameterization @prabs
    	
    	
    	HashMap<String, String> finaldatamap = new HashMap<>();
    	String findkey = null;
    	String findvalue = null;
    	String getkey = null;
    	String getvalue = null;
    	JsonPath jp = jreader.getResponse(loop,value);
    	if(value.containsValue("[")){
    		String[] expectvalue = "sdsd,".split(",");
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
    		 ////to update loop here for data param @prabs
    		HashMap<String, String> acceptmap = value.get("acceptance");
    		Set<Entry<String, String>> entryset = acceptmap.entrySet();
    		for(Entry<String,String> accmap : entryset) {
    			String acckey = accmap.getKey();
    			String accvalue = accmap.getValue();
    			String actualvalue = jp.getString(acckey);
    			if(actualvalue.contains("[")) {
    			///// to be updated with array response . Get the API which has array response and rewrite the code @prabs
    				actualvalue = actualvalue.replaceAll("\\[|\\]", "");  
    			}
    			finaldatamap.put(accvalue,actualvalue);
    		}
    		
    		
    	}
    	return finaldatamap;
    }
    
    public void resultAsserter(HashMap<String, String> resultdatamap, LinkedHashMap<String, HashMap<String, String>> Value, String methodname) {
    	//test = extent.startTest("@Testname :"+methodname);
    	Set<Entry<String,String>> map = resultdatamap.entrySet();
		String actualAPIdata = null;
		String expecteddata = null;
		for (Entry<String, String> entry : map) {
			actualAPIdata = entry.getKey();
			expecteddata = entry.getValue();
			
			if(expecteddata.contains("~")){
				expecteddata = expecteddata.replaceFirst("~", "");
				test.log(LogStatus.INFO, "Actualdata="+actualAPIdata +"expected data ="+expecteddata);
				logger.info("Actualdata="+actualAPIdata +" || expected data ="+expecteddata);
				Assert.assertTrue(actualAPIdata.contains(expecteddata), "Validating " + Value +"the value is present in the actual API data");
				
			}else if(expecteddata.contains("=")){
				expecteddata = expecteddata.replaceFirst("=", "");
				test.log(LogStatus.INFO, "Actualdata="+actualAPIdata +"expected data ="+expecteddata);
				logger.info("Actualdata="+actualAPIdata +" || expected data ="+expecteddata);
				Assert.assertEquals(actualAPIdata, expecteddata, "Validating "+ Value +"the value is same as the actual API data");
			}else if(expecteddata.contains("!")){
				expecteddata = expecteddata.replaceFirst("!", "");
				test.log(LogStatus.INFO, "Actualdata="+actualAPIdata +"expected data ="+expecteddata);
				logger.info("Actualdata="+actualAPIdata +" || expected data ="+expecteddata);
				Assert.assertNotEquals(actualAPIdata, expecteddata, "Validating  "+ Value +"the value is not same as the actual API data");
			}else{
			//	test.log(LogStatus.INFO, "Actualdata="+actualAPIdata +"expected data ="+expecteddata);
				logger.info("Actualdata="+actualAPIdata +" || expected data ="+expecteddata);
				Assert.assertEquals(actualAPIdata, expecteddata, "Validating "+ Value +"the value is same as the actual API data");
				
			}
		}
    }
    
    public Object[][] dataprovider(ITestNGMethod test) throws Exception{
    	
    	JsonReader jread = new JsonReader();
    	JSONObject jpath = jread.processJsonTestData(test.getMethodName());
    	LinkedHashMap<String, HashMap<String,String>> testdatamap = processCriteriaData(jpath);
    	Object[][] obj = new Object[testdatamap.size()-1][2];
    	for (int i=0;i<obj.length;i++) {
			obj[i][0] = 0;
			obj[i][1] = testdatamap;
		}
    	
    	return obj;
    	
    }

}
