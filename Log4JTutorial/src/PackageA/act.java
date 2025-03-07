package PackageA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class act {
	private static Logger log1 =LogManager.getLogger(act.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log1.debug("Setting chrome driver property");
		   System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		   log1.info("Window Maximized");
		   log1.debug("Now hitting Amazon server");
		driver.get("https://www.amazon.com/");
		   log1.info("Landed on amazon home page");
		Actions a =new Actions(driver);


		/* a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))) .click().keyDown(Keys.SHIFT).sendKeys("capitalletters").doubleClick().build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();*/


		driver.get("http://jqueryui.com/demos/droppable/");
		   log1.debug("Getting the frames count");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		log1.info("Frames count retreived");
		try
		{
		driver.switchTo().frame(0);
		log1.info("Successfully switched to frame");
		}
		catch(Exception e)
		{
		log1.error("Cannot identify the frame"); 
		}
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		   log1.debug("Identifying Draggable objects");
		       WebElement draggable = driver.findElement(By.id("draggable"));
		       WebElement droppable = driver.findElement(By.id("droppable"));
		       new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
		log1.info("Drag and drop success");
		       
		}
	}


