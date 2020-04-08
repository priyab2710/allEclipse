import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test34 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.tagName("title")).getText());
		driver.navigate();
		
		

	}

}
