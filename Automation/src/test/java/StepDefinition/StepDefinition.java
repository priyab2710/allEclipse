package StepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
    	System.out.println("User is on login page");
    }

    @When("^user enters username and password$")
    public void user_enters_username_and_password() throws Throwable {
    	System.out.println("user enters username and password");
    }

    @Then("^login is successful$")
    public void login_is_successful() throws Throwable {

       System.out.println("login is successful");
    }

    @And("^user details are displayed $")
    public void user_details_are_displayed() throws Throwable {
    	System.out.println("user details are displayed");
    }

}
