package TestPackage2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass3 {

	@Test(groups= {"Smoke"})
	public void method3()
	{
		System.out.println("method3");
	}
	
	
	@Test(dataProvider="getData")
	public void method33(String user,String pass)
	{
		System.out.println("method33 dataprovider example username and password "+ user +" "+ pass);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="test1";
		obj[0][1]="pass1";
		
		obj[1][0]="test2";
		obj[1][1]="pass2";
		
		obj[2][0]="test3";
		obj[2][1]="pass3";
		
		return obj;
	}
}
