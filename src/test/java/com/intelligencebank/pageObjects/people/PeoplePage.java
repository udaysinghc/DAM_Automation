package com.intelligencebank.pageObjects.people;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PeoplePage extends BasePage {

    @FindBy(xpath = "//span[text() = 'People']")
    WebElement pageTitle;

    public PeoplePage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
