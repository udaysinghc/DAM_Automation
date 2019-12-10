package com.intelligencebank.pageObjects.calendar;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Calendars')]")
    WebElement pageTitle;

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
