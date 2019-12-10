package com.intelligencebank.stepDefinitions.databases;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.When;

import javax.print.attribute.standard.PagesPerMinute;

public class WhenSteps extends StepDefinitionsBase {
    public WhenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @When("the user enabled {string} checkbox in Single database")
    public void user_enable_checkbox(String string) throws InterruptedException {
        create_database(true);
    }

    @When("the user fills in the Database form and clicks save")
    public void fill_form_and_save_db() throws InterruptedException {
        create_database(false);
    }

    private void create_database(boolean isSaveDraft) throws InterruptedException {
        Pages().databasePage().setDatabaseName("Test Single Database");
        if (isSaveDraft) {
            Pages().databasePage().setSaveAsDraftOn();
        }
        Pages().databasePage().clickSaveAndCreateButton();
        Pages().databasePage().clickOnTextElement();
        Pages().databasePage().enterTextFieldTitle();
        Pages().databasePage().clickOnNumberElement();
        Pages().databasePage().enterNumberFieldTitle();
        Pages().databasePage().clickOnDateElement();
        Pages().databasePage().enterDateFieldTitle();
        Pages().databaseBasePage().switchOutOfIframe();
        Pages().databasePage().clickDatabaseLink();
        Pages().databasePage().clickAddRecordButton();
    }

    @When("the user enabled {string} checkbox in Staged database")
    public void user_enable_checkbox_staged(String string) throws InterruptedException {
        Pages().databasePage().setDatabaseName("Test Staged Database");
        Pages().databasePage().selectStagedDatabase();
        Pages().databasePage().setSaveAsDraftOn();
        Pages().databasePage().clickSaveAndCreateButton();
        Pages().databasePage().clickOnTextElement();
        Pages().databasePage().enterTextFieldTitle();
        Pages().databasePage().clickOnNumberElement();
        Pages().databasePage().enterNumberFieldTitle();
        Pages().databasePage().clickOnDateElement();
        Pages().databasePage().enterDateFieldTitle();
        Pages().databasePage().clickOnStageElement();
        Pages().databasePage().enterStageTitle();
        Pages().databasePage().clickOnSectionElement();
        Pages().databasePage().enterSectionTitle();
        Pages().databasePage().clickOnTextElement();
        Pages().databasePage().enterTextFieldTitleStage2();
        Pages().databasePage().clickOnEmailElement();
        Pages().databasePage().enterEmailFieldTitle();
        Pages().databasePage().clickOnPhoneElement();
        Pages().databasePage().enterPhoneFieldTitle();
        Pages().databaseBasePage().switchOutOfIframe();
        Pages().databasePage().clickDatabaseLink();
        Pages().databasePage().clickAddRecordButton();
    }

    @When("the user creates draft record")
    public void user_creates_draft_record() throws Throwable {
        Pages().databasePage().enterTextValue();
        Pages().databasePage().enterNumberValue();
        Pages().databasePage().clickSaveAsDraftButton();
    }

    @When("the user submit a record")
    public void user_submit_a_record() throws Throwable {
        Pages().databasePage().enterTextValue();
        Pages().databasePage().enterNumberValue();
        Pages().databasePage().clickSaveAndNextButton();
        Pages().databasePage().enterTextValueInStage2();
        Pages().databasePage().enterEmailValueInStage2();
        Pages().databasePage().enterPhoneValueInStage2();
        Pages().databasePage().clickSaveAndExitButton();
    }

    @When("the user edits draft record")
    public void user_edits_draft_record() throws Throwable {
        Pages().databasePage().closeSearchBar();
        Pages().databasePage().clickRecordEditAction();
    }

    @When("the user continue draft record")
    public void user_continue_draft_record() throws Throwable {
        Pages().databasePage().closeSearchBar();
        Pages().databasePage().clickOnContinueButton();
    }

    @When("the user revert a record")
    public void user_revert_a_record() throws Throwable {
        Pages().databasePage().closeSearchBar();
        Pages().databasePage().clickOnRevertButton();
        Pages().databasePage().clickOnRevertPopup();
    }

    @When("^Admin tries to save the record as draft without entering the '(.*)' field$")
    public void admin_tries_to_save_the_record_as_draft_without_entering_title_field(String fieldname) {
        Pages().databaseRecordPage().addRecordButton();

        switch (fieldname.toLowerCase()) {
            case "title":
                Pages().databaseRecordPage().clickonsaveasDraftButton();
                break;
            case "email":
                Pages().databaseRecordPage().enterValueInTextField();
                Pages().databaseRecordPage().enterValueInEmailField();
                Pages().databaseRecordPage().clickonsaveasDraftButton();
                break;
            case "phone":
                Pages().databaseRecordPage().enterValueInTextField();
                Pages().databaseRecordPage().enterValueInPhoneField();
                Pages().databaseRecordPage().clickonsaveasDraftButton();
                break;
        }
    }
}
