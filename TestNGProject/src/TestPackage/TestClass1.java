package TestPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass1 {

	@Test(groups= {"Smoke"})
	public void method1()
	{
		System.out.println("method1");
	}
	@Test(groups= {"Sanity"})
	public void method2()
	{		
		System.out.println("method11"); 
	}
	
	@Parameters({"url"})
	@Test
	public void method12(String uname)
	{		
		System.out.println("parameterization on method12 "+ uname); 
	}
	
	@Test
	
}
