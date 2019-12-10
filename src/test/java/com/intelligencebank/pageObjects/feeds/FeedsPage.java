package com.intelligencebank.pageObjects.feeds;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedsPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Feeds']")
    WebElement pageTitle;

    public FeedsPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
