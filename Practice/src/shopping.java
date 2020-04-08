import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopping {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/seleniumPractise");
		Thread.sleep(3000);
		String[] veggies = { "Capsicum", "Apple", "Musk Melon", "Carrot" };
		addtocart(driver, veggies);

	}

	public static void addtocart(WebDriver driver, String[] veggies)

	{

		// List<WebElement> products =
		// driver.findElements(By.xpath("//h4[@class='product-name']"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		List<String> veggieslist = Arrays.asList(veggies);

		System.out.println(veggieslist.size());
		// System.out.println(driver.findElements(By.xpath("//h4[@class='product-name']")));
		System.out.println(products.size());
		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			String[] productname = products.get(i).getText().split("-");
			String formattedname = productname[0].trim();

			if (veggieslist.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == veggies.length)
					break;
			}

		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		// Explicit wait for below element
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

	}
}
