import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws Exception {


		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");	
		WebElement fromcity= driver.findElement(By.xpath("//input[@id='fromCity']"));
		fromcity.sendKeys("Mum");
		fromcity.sendKeys(Keys.ARROW_DOWN);		
		
		
	}

}
