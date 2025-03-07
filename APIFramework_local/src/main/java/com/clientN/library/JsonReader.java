package com.clientN.library;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.ConnectionConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;


public class JsonReader {

  private static Logger logger = Logger.getLogger(JsonReader.class.getName());
  
  private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream in = new URL(url).openStream();
    
    System.out.println("I am in readJsonFromUrl method");
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      in.close();
    }
  }

  public JsonPath readJson() throws IOException, JSONException {
	 // logger.info("the end point url is : "+AutomationBuddy.globalmap.get("url"));
	  System.out.println("I am in readJson method "+AutomationBuddy.globalmap.get("url"));
	  RestAssuredConfig config = RestAssured.config().connectionConfig(ConnectionConfig.connectionConfig());
	  config = config.connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponse());
	  config.set();

	  RestAssured.baseURI  = AutomationBuddy.globalmap.get("baseuri");
	     	Response respApi = given().contentType("application/json").when().get(AutomationBuddy.globalmap.get("endpoint"));
	     	Assert.assertEquals(respApi.getStatusCode(), 200 , "Expected response code 200 is not returned. The response code is  :"+respApi.getStatusCode());
      JSONObject json = readJsonFromUrl(AutomationBuddy.globalmap.get("url"));
	  JsonPath jp = new JsonPath(json.toString());
	  
	 return jp;
    
   
  }
  
  public JsonPath processJsonTestData(String filename) throws Exception{
	  JSONParser jsonParser = new JSONParser();
      String directory = System.getProperty("user.dir")+"/src/test/resource/testdata/"+filename+".json";
	  
      try (FileReader reader = new FileReader(directory))
      {
          //Read JSON file
          Object obj = jsonParser.parse(reader);
          org.json.simple.JSONObject jobj = (org.json.simple.JSONObject) obj;
          JsonPath jp = new JsonPath(jobj.toString());
         
          return jp;
       } catch (FileNotFoundException e) {
    	  throw new Exception(e);
      } catch (IOException e) {
    	  throw new Exception(e);
      } catch (ParseException e) {
    	  throw new Exception(e);
      }
  }
  
}


