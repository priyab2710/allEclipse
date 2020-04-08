import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiWindows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Try it Yourself')]")).click();
		System.out.println(driver.getTitle());
		//Actions a= new Actions(driver);
		Set<String> hs= driver.getWindowHandles();
		Iterator<String> i=hs.iterator();
		String parentid= i.next();
		String childid= i.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[contains(text(),'Run')]")).click();
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());
		
		

	}

}
