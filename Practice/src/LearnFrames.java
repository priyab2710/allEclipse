import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnFrames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement drag= driver.findElement(By.id("draggable"));
		a.dragAndDropBy(drag, 235, 8).build().perform();
		
	}
}
