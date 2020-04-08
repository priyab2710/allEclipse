import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("Priya");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
      //  driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		driver.findElement(By.xpath("//div[@class='margTop10']/div/input")).click();
	    
	}

}
