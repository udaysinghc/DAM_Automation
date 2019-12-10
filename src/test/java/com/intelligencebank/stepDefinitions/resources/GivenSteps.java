package com.intelligencebank.stepDefinitions.resources;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.resources.data.Folder;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Given;

public class GivenSteps extends StepDefinitionsBase {

    Resources resources;

    public GivenSteps(CucumberTestContext context, Resources resources) throws Throwable {
        super(context);
        this.resources = resources;
    }

    @Given("I am on the Resources page")
    public void i_am_on_the_Resources_page() throws InterruptedException {
        Pages().homePage().clickResourceButton();
    }

    @Given("^I edit folder settings for the folder '(.*)'$")
    public void i_edit_folder_settings(String foldername) throws InterruptedException {
        resources.folder = new Folder(foldername);
        Pages().resourceFoldersPage().selectFolderSettings(foldername);
    }
}
