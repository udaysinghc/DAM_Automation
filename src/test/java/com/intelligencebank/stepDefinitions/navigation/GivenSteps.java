package com.intelligencebank.stepDefinitions.navigation;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.navigation.data.MenuOption;
import com.intelligencebank.stepDefinitions.navigation.data.Navigation;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Given;

public class GivenSteps extends StepDefinitionsBase {
    public Navigation navigation;
    public GivenSteps(CucumberTestContext context, Navigation navigation) throws Throwable {
        super(context);
        this.navigation = navigation;
    }

    @Given("^I select the '(.*)' menu option$")
    public void i_select_menu_option(String menuOption) throws InterruptedException {
        navigation.menuOption = new MenuOption(menuOption);
        Pages().homePage().clickMenuOption(menuOption);
    }
}
