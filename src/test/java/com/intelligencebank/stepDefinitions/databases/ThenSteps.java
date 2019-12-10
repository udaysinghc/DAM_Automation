package com.intelligencebank.stepDefinitions.databases;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

import cucumber.api.java.en.Then;

public class ThenSteps extends StepDefinitionsBase {
    public ThenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Then("user should not be allowed to save the record as draft and proper error message should be displayed under {string} field")
    public void userShouldNotBeAllowedToSaveTheRecordAsDraftAndProperErrorMessageShouldBeDisplayedUnderTitleField(String fieldtype) {
        Pages().databaseRecordPage().clickonCloseRecordIcon();
        switch(fieldtype.toLowerCase()){
            case "title":
                Pages().databaseRecordPage().errorMessageForTitle();
                break;
            case "email":
                Pages().databaseRecordPage().errorMessageForEmail();
                break;

            case "phone":
                Pages().databaseRecordPage().errorMessageForPhone();
                break;
        }
    }

    @Then("the user see {string} button on the record page")
    public void user_see_button_on_the_record_page(String string) throws InterruptedException {
        Pages().databasePage().enterTextValue();
        Pages().databasePage().enterNumberValue();
        Pages().databasePage().clickSaveAsDraftButton();
    }

    @Then("the user should allow to publish drafted record")
    public void user_should_allow_to_publish_drafted_record() throws InterruptedException {
        Pages().databasePage().editTextField();
        Pages().databasePage().editNumberField();
        Pages().databasePage().clickSaveAndExitButton();
    }

    @Then("the user should allow to complete staged record")
    public void user_should_allow_to_complete_staged_record() throws InterruptedException {
        Pages().databasePage().editTextField();
        Pages().databasePage().editNumberField();
        Pages().databasePage().clickSaveAndNextButton();
        Pages().databasePage().enterTextValueInStage2();
        Pages().databasePage().enterEmailValueInStage2();
        Pages().databasePage().enterPhoneValueInStage2();
        Pages().databasePage().clickSaveAndExitButton();
    }

    @Then("the user should allow to save staged record as draft")
    public void user_should_allow_to_save_staged_record_as_draft() throws InterruptedException {
        Pages().databasePage().clickOnContinueButton();
        Pages().databasePage().editTextField();
        Pages().databasePage().editNumberField();
        Pages().databasePage().clickSaveAsDraftButton();
    }

    @Then("^the database will be created$")
    public void database_will_be_created() {
        Pages().databasePage().checkSaveAndExitButton();
    }
}
