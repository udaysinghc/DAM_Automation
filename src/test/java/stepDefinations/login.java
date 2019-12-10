package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import pageObjects.homePage;
import pageObjects.loginPage;
import utils.DriverFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

public class login extends DriverFactory{
		
	loginPage lp ;
	homePage hp ;

	@Given("^user visits IB platform website$")
    public void user_visits_ib_platform_website() throws Throwable {
        // TODO: Move to pageBucket class and lazy instantiate		
		lp = new loginPage(driver);
		hp = new homePage(driver);		       
    }
	
    @When("^user clicks on the login button for homepage$")
    public void user_clicks_on_the_login_button_for_homepage() throws Throwable {
        // TODO: Implement
        // throw new UnsupportedOperationException();
    }

    @And("^user enters the username as \"([^\"]*)\"$")
    public void user_enters_the_username_as_something(String username) throws Throwable {
    	lp.setusername(username);
    }

    @Then("^verify the login is successfull$")
    public void verify_the_login_is_successfull() throws Throwable {
    	Assert.assertEquals(driver.findElement(By.id("menu-userDetail")).isDisplayed(), true);
    }
    
    @Then("^verify the correct error message is displayed (.+)$")
    public void verify_the_correct_error_message_is_displayed(String errormessasge) throws Throwable {
    	lp.verifyErrormessage(errormessasge);
    }

    @And("^user enters the password as \"([^\"]*)\"$")
    public void user_enters_the_password_as_something(String password) throws Throwable {    	
    	lp.setpassword(password);
    }

    @And("^user clicks on the Login button$")
    public void user_clicks_on_the_login_button() throws Throwable {    	
    	lp.clickloginbutton();
    }
    
    @And("^user clicks on the Register link on the login page$")
    public void user_clicks_on_the_register_link_on_the_login_page() throws Throwable {
        throw new UnsupportedOperationException();        
    }
    
    @And("^an admin user successfully logs in$")
    public void an_admin_user_successfully_logs_in() throws Throwable {
        lp.login("update.to.valid.user@ibtest.com", "*********");
    }
}
