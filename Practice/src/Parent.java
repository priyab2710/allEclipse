import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		/*driver.findElement(By.id("email")).sendKeys("priyab710");
		driver.findElement(By.id("pass")).sendKeys("saurabh");
		driver.findElement(By.id("loginbutton")).click();
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("priyab2710");
		driver.findElement(By.cssSelector("#pass")).sendKeys("password");
		driver.findElement(By.cssSelector("#loginbutton")).click(); */
		
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("priyab2710");
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("pass");
        driver.findElement(By.cssSelector("input[value*='Log']")).click();
      //  driver.findElement(By.xpath("//input[contains(@id,'u_0')]")).click();
         
			
	}

}
