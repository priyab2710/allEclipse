package ComplexCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableComp {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/batting");
		WebElement tableDriver= driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-rank-tabs']"));
		int rowcount=tableDriver.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']")).size();
		System.out.println(rowcount);
		for(int i=0; i<rowcount;i++)
		{
			
		}

	}

}
