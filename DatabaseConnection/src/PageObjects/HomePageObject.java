package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
WebDriver driver;


  

   public HomePageObject(WebDriver driver) {

     this.driver=driver;
     PageFactory.initElements(driver,this);
}

   @FindBy(xpath="//a[contains(text(),'Sign in')]")
   WebElement signin;
   
   public WebElement signin()
   {
	   return signin;
   }
}
