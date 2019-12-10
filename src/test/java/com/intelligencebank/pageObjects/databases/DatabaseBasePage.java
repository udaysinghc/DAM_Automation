package com.intelligencebank.pageObjects.databases;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatabaseBasePage extends BasePage {

    @FindBy(id = "phoenix-iframe")
    WebElement databaseIframe;

	@FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addDatabaseButton;
	
    public DatabaseBasePage(WebDriver driver)
    {
		super(driver);
    }

    public void addDatabase()
    {
        switchToIframe(databaseIframe);
    	waitAndClick(addDatabaseButton, 30);
    }

}