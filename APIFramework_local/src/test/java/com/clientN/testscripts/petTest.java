package com.clientN.testscripts;

import com.clientN.library.JSON_file_read;
import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

public class petTest {

	
	@Test
	public void Testcase1() throws IOException
	{
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		given().log().all().header("Content-Type","application/json")
		.body(JSON_file_read.GenerateStringFromJsonFile("C:\\Users\\pbhamare\\eclipse-workspace\\APIFramework_local\\src\\test\\resource\\TestCase.json"))
		.when().post("/pet")
		.then().log().all().assertThat().statusCode(200);
	}
}
