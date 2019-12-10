package com.intelligencebank.stepDefinitions.navigation;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class ThenSteps extends StepDefinitionsBase {
    public ThenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Then("^I will see the '(.*)' page$")
    public void see_the_page(String pagename) {
        switch(pagename.toLowerCase()) {
            case "admin":
                Pages().adminBasePage().assertOnPage(pagename);
                break;
            case "agenda":
                Pages().agendaPage().assertOnPage(pagename);
                break;
            case "authenticator":
                Pages().authenticatorPage().assertOnPage(pagename);
                break;
            case "calendar":
                Pages().calendarPage().assertOnPage(pagename);
                break;
            case "custom page":
                Pages().customPagePage().assertOnPage(pagename);
                break;
            case "database":
                Pages().databasePage().assertOnPage(pagename);
                break;
            case "feeds":
                Pages().feedsPage().assertOnPage(pagename);
                break;
            case "my account":
                Pages().myAccountPage().assertOnPage(pagename);
                break;
            case "my collections":
                Pages().myCollectionsPage().assertOnPage(pagename);
                break;
            case "news":
                Pages().newsPage().assertOnPage(pagename);
                break;
            case "people":
                Pages().peoplePage().assertOnPage(pagename);
                break;
            case "resource":
                Pages().resourceFoldersPage().assertOnPage(pagename);
                break;
            case "report":
                Pages().reportPage().assertOnPage(pagename);
                break;
            case "stats":
                Pages().statsPage().assertOnPage(pagename);
                break;
            case "survey":
                Pages().surveyPage().assertOnPage(pagename);
                break;
            case "workflow":
                Pages().workflowPage().assertOnPage(pagename);
                break;
            default:
                throw new PendingException(String.format("The assertion for that page has not been implemented yet"));
        }
    }
}
