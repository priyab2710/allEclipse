package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	 

	   public LoginPageObjects(WebDriver driver) {

	     this.driver=driver;
	     PageFactory.initElements(driver,this);
	}
	   
	   @FindBy(id="email")
	   WebElement email;
	   
	   @FindBy(id="passwd")
	   WebElement password;
       
	   @FindBy(id="SubmitLogin")
	   WebElement Submit;
	   
	   public WebElement email()
	   {
		   return email;
	   }
	  
	   public WebElement password()
	   {
		   return password;
	   }
	   
	   public WebElement Submit()
	   {
		   return Submit;
	   }
}
