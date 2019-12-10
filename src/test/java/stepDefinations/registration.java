package stepDefinations;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import pageObjects.registrationPage;
import utils.DriverFactory;

public class registration extends DriverFactory {
	
	// TODO: Move to pageBucket class and lazy instantiate		
	registrationPage rP = new registrationPage(driver);	 
	
	@And("^user ends the mandatory fields$")
	public void user_ends_the_mandatory_fields() throws Throwable {
        throw new UnsupportedOperationException();
	}

	@And("^user clicks on the Register button$")
	public void user_clicks_on_the_register_button() throws Throwable {
		rP.clickRegisterbutton();
	}
	    
	@Then("^verify the user email for password creation is send$")
	public void verify_the_user_email_for_password_creation_is_send() throws Throwable {
        throw new UnsupportedOperationException();		
	}
	    
	@Then("^verify the correct errormessage is displayed for correct field type (.+), (.+)$")
	public void verify_the_correct_errormessage_is_displayed_for_correct_field_type_(String errormessage, String errorfield) throws Throwable {
        throw new UnsupportedOperationException();				
	}

	@And("^user enters the First Name as (.+)$")
	public void user_enters_the_first_name_as(String firstname) throws Throwable {
		rP.setFirstname(firstname); 
	}

	@And("^user enters the Last Name as (.+)$")
	public void user_enters_the_last_name_as(String lastname) throws Throwable {
		rP.setLastname(lastname);
	}

	@And("^user enters the email as (.+)$")
	public void user_enters_the_email_as(String email) throws Throwable {
		rP.setEmail(email);
	}
}
