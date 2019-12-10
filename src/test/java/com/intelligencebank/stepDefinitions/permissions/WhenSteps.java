package com.intelligencebank.stepDefinitions.permissions;

import com.intelligencebank.stepDefinitions.admin.data.Admin;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

public class WhenSteps extends StepDefinitionsBase {
    Admin admin;

    public WhenSteps(CucumberTestContext context, Admin admin) throws Throwable {
        super(context);
        this.admin = admin;
    }

    @When("^'(.*)' has navigated to '(.*)'$")
    public void has_navigated_to(String uname, String page) throws Throwable {
        Pages().homePage().logoutFromMenu();
        Pages().loginPage().login(cucumberTestContext, uname, admin);
        Pages().homePage().clickMenuOption(page);
    }

    @When("^the user has navigated to the '(.*)' folder$")
    public void has_navigated_to_folder(String folder) {
        Pages().resourceFoldersPage().clickFolder(folder);
    }
}
