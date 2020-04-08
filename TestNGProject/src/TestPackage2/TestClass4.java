package TestPackage2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;



public class TestClass4 {
	
public WebDriver driver=null;
	
	@Test
	public void method4() throws IOException
	{
		/*Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\pbhamare\\eclipse-workspace\\TestNGProject\\datadriven.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").contains("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (prop.getProperty("browser").contains("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		System.out.println("method4"); */
	}
}

