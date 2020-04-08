import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Test123 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(@text,'GWL')]")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BKK']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@data-month='1']//a[contains(.,'10')]")).click();
		     Thread.sleep(2000);                      
		driver.findElement(By.id("divpaxinfo")).click();
		
		// Dropdown
		WebElement adult = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		WebElement child = driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
		WebElement infant = driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		// Checkbox
		WebElement friendsfamily = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		
		//Submit
		WebElement search = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		
		Select s = new Select(adult);
		s.selectByValue("4");
		
		Select s1 = new Select(child);
		s1.selectByIndex(1);
		
		Select s2 = new Select(infant);
		s2.selectByVisibleText("2");
		
		Select s3 = new Select(currency);
		s3.selectByValue("AED");
		
		Assert.assertFalse(friendsfamily.isSelected());
		
		friendsfamily.click();
		
		Assert.assertTrue(friendsfamily.isSelected());
		
		search.click();
		
		driver.close();
		
		    	
	    }

}
