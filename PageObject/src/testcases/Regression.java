package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectrepository.HomePage;
import objectrepository.LoginPage;

public class Regression {

	@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		HomePage hp=new HomePage(driver);
		hp.signin().click();
		LoginPage LP = new LoginPage(driver);
		LP.username().sendKeys("priya");
		LP.password().sendKeys("test");
		//LP.submit().click();
		
    }
	
}
