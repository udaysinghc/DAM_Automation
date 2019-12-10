package com.intelligencebank.stepDefinitions.databases;

import com.intelligencebank.stepDefinitions.CommonSteps;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Given;

public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Given("^(?:Admin on database logs into the system|the user logged in as an Admin on database)$")
    public void i_am_logged_in_as_an_Admin_on_database() throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("Home");
        Pages().loginPage().loginAdmin(cucumberTestContext);
    }

    @Given("the user opens the Database Settings page")
    public void user_open_the_Database_Settings_page() throws InterruptedException {
        Pages().basePage().clickMenuDatabase();
        Pages().databaseBasePage().addDatabase();
    }

    @Given("Admin user creates a database with save draft enabled")
    public void admin_user_creates_a_database_with_save_draft_enabled() throws InterruptedException {
        // Database and the fields are added in the form
        Pages().basePage().clickMenuDatabase();
        Pages().databaseBasePage().addDatabase();
        Pages().databaseSettingsPage().getcurrenttime();
        Pages().databaseSettingsPage().enterDatabaseName();
        Pages().databaseSettingsPage().enterDatabaseDesc();
        Pages().databaseSettingsPage().selectDatabaseType();
        Pages().databaseSettingsPage().selectDraftOption();
        Pages().databaseSettingsPage().createDatabase();
        Pages().databaseForm().selectTextField();
        Pages().databaseForm().enterTextFieldName();
        Pages().databaseForm().saveFieldInForm();
        Pages().databaseRecordPage().selectEmailField();
        Pages().databaseForm().enterEmailFieldName();
        Pages().databaseForm().saveFieldInForm();
        Pages().databaseForm().selectPhoneField();
        Pages().databaseForm().enterPhoneFieldName();
        Pages().databaseForm().saveFieldInForm();
        Pages().basePage().switchOutOfIframe();
        Pages().databaseForm().clickOnBreadCrumb();
    }
}