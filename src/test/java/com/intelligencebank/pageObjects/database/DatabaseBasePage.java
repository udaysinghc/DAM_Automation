package com.intelligencebank.pageObjects.database;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatabaseBasePage  extends BasePage {
    public DatabaseBasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[contains(.,'Add')]")
    WebElement databaseAddButton;

    @FindBy(xpath="//a[contains(text(),'Database')]")
    WebElement Database;

    @FindBy(xpath="//iframe[contains(@id,'phoenix-iframe')]")
    WebElement Switchiframe;

    // Click on add database button
      public void addDatabase()
    {
        switchToIframe(Switchiframe);
        waitAndClick(databaseAddButton,50);
    }
}
