package ComplexCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.findElement(By.id("fromPlaceName")).sendKeys("Ben");
		
		// JavascriptExecutor javascript dom is used to find hidden element as 
		//selenium getText() is not supported to find hidden element

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fromplace = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(fromplace);
		// System.out.println(text);
		int i = 0;
		while (!text.equalsIgnoreCase("MOTEBENNUR")) {
			i++;
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(fromplace);

			if (i > 10) {
				break;
			}

		}
		if (i > 10) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found");
		}

		System.out.println(text);

	}

}
