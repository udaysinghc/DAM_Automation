package com.intelligencebank.pageObjects.mycollections;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCollectionsPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'My Collections']")
    WebElement pageTitle;

    public MyCollectionsPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
