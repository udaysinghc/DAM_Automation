package com.intelligencebank.pageObjects.report;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Report']")
    WebElement pageTitle;

    public ReportPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
