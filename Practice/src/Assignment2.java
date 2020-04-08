import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
        
		//Dropdown
		
		WebElement adult = driver.findElement(By.id("Adults"));
		WebElement child = driver.findElement(By.id("Childrens"));
		WebElement infant = driver.findElement(By.id("Infants"));
		WebElement travelclass = driver.findElement(By.cssSelector("[id='Class']"));
	
	    //calender
		WebElement departdate = driver.findElement(By.cssSelector("input[id='DepartDate']"));
		
		//More options link
		WebElement moreoption = driver.findElement(By.xpath("//a[@id='MoreOptionsLink']"));
		WebElement airlineprefer = driver.findElement(By.cssSelector("input[name='airline']"));
		
		// Submit button
		WebElement searchflights = driver.findElement(By.id("SearchBtn"));
		
		Select adult1 = new Select(adult);
		adult1.selectByValue("4");
		Select child1 = new Select(child);
		child1.selectByValue("2");
        Select infant1 = new Select(infant);
		infant1.selectByVisibleText("1");
		
		departdate.click();
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).sendKeys(Keys.ENTER);
		moreoption.click();
		
		Select travelclass1 = new Select(travelclass);
		travelclass1.selectByVisibleText("Premium Economy");
		airlineprefer.sendKeys("Indigo");
		searchflights.click();
		driver.findElement(By.id("homeErrorMessage")).getText();
		//System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
				
	}
}
