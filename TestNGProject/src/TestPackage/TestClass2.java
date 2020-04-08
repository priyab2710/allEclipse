package TestPackage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass2 {

	
	@Test
	public void method2() 
	{
		System.out.println("method2");
		Assert.assertTrue(false);
	}
	
	@Test(groups= {"Smoke"})
	public void method22() 
	{
		System.out.println("method22");
	}
	
	
}
