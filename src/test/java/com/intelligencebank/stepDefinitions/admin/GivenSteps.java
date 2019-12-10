package com.intelligencebank.stepDefinitions.admin;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Given;

public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Given("^I select the '(.*)' admin tab$")
    public void given_select_tab(String tabName) {
        Pages().adminBasePage().selectTab(tabName);
    }
}
