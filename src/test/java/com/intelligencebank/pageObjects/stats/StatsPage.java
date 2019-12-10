package com.intelligencebank.pageObjects.stats;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatsPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Stats']")
    WebElement pageTitle;

    public StatsPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
