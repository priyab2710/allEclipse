package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login1")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(name = "proceed")
	WebElement submit;

	public WebElement username() {
		return username;
	}

	public WebElement password() {
		return password;
	}

	public WebElement submit() {
		return submit;
	}
}
