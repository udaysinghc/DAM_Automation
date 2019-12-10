package com.intelligencebank.pageObjects.survey;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurveyPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Survey']")
    WebElement pageTitle;

    public SurveyPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
