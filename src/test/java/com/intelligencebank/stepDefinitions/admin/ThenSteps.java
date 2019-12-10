package com.intelligencebank.stepDefinitions.admin;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.admin.data.Admin;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Then;

public class ThenSteps extends StepDefinitionsBase {
    Admin admin;

    public ThenSteps(CucumberTestContext context, Admin admin) throws Throwable {
        super(context);
        this.admin = admin;
    }

    @Then("^the user is created$")
    public void then_user_created() throws InterruptedException {
        Pages().adminUsersPage().assertUserExists(String.format("%s %s", admin.firstname.getValue(), admin.lastname.getValue()));
    }
}
