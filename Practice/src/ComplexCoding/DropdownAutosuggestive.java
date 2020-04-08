package ComplexCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAutosuggestive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("ind");
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
				
	   
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String text= "return document.getElementById(\"autocomplete\").value;";
		String country = (String) js.executeScript(text);
		while(!country.equalsIgnoreCase("India"))
		{
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			country = (String) js.executeScript(text);
		}
		    System.out.println(country); 
	}

}
