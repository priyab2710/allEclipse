import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).click();
		WebElement a1= driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
		.click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		a.moveToElement(a1).contextClick().build().perform();

	}

}
