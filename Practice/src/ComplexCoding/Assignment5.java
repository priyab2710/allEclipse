package ComplexCoding;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment5 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Work_pri\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		//driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		String opt =driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();	
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select s=new Select(dropdown);
	    s.selectByVisibleText(opt);	
	    driver.findElement(By.xpath("//fieldset[@class='pull-right']/input[@id='name']")).sendKeys(opt);
	    driver.findElement(By.id("alertbtn")).click();
	    String text= driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    if(text.contains(opt))
	    {
	    	System.out.println("Pass");
	    }
	    else {
	    	System.out.println("Fail");}
	    driver.close();
		}   	
	
	}

