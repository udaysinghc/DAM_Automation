package com.intelligencebank.stepDefinitions.admin;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.admin.data.*;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.When;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class WhenSteps extends StepDefinitionsBase {

    public Admin admin;

    public WhenSteps(CucumberTestContext context, Admin admin) throws Throwable {
        super(context);
        this.admin = admin;
    }

    @When("^I fill in the new user form$")
    public void when_I_fill_in_new_user_form() throws InterruptedException {
        HashMap<String, String> data = new HashMap<>();
        String randomString = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String randomEmail = String.format("%s@intelligencebank.com", randomString);
        admin.firstname = new Name(randomString);
        admin.lastname = new Name(randomString);
        data.put("firstname", randomString);
        data.put("lastname", randomString);
        data.put("email", randomEmail);
        data.put("groups", "Admin");
        Pages().adminUsersPage().clickAddUserIcon();
        Pages().adminEditUserPage().fillInForm(data);
        Pages().adminEditUserPage().clickSave();
    }
}
