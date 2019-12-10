package com.intelligencebank.pageObjects.custompage;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomPagePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Custom Pages')]")
    WebElement pageTitle;

    public CustomPagePage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
