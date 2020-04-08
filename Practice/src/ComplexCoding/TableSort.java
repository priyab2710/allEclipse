package ComplexCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSort {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// WebElement table= driver.findElement(By.id("sortableTable"));
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		List<WebElement> a = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> copiedList = new ArrayList<String>();

		for (int i = 0; i < a.size(); i++) {
			originalList.add((a.get(i).getText()));
		}

		for (int i = 0; i < originalList.size(); i++) {
			copiedList.add(originalList.get(i));

		}

		Collections.sort(copiedList);
		Collections.reverse(copiedList);

		Assert.assertTrue(originalList.equals(copiedList), "List does not match");
	}

}
