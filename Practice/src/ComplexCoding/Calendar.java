package ComplexCoding;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		List<WebElement> days= driver.findElements(By.className("day"));
		List<WebElement> month= driver.findElements(By.className("month"));
		//List<WebElement> days= driver.findElements(By.className("day"));
		System.out.println(days.size());
		 for(int i=0;i<days.size();i++)
		{
			String text= days.get(i).getText();
			if(text.equalsIgnoreCase("23"))
			{
				days.get(i).click();
			    break;
			}
			
		}
	}

}
