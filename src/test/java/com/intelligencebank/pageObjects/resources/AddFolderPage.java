package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddFolderPage extends ResourcesBasePage {

    @FindBy(id = "folderName")
    WebElement folderNameTextBox;
    @FindBy(xpath = "//input[@value = 'default']")
    WebElement defaultRadioButton;
    @FindBy(xpath = "//input[@value = 'custom']")
    WebElement customRadioButton;
    @FindBy(id = "btnSave")
    WebElement saveButton;

    public AddFolderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the folder name in the folder name text box
     * @param foldername The name you would like to set
     */
    public void setFolderName(String foldername) {
        waitAndSendKeys(folderNameTextBox, foldername, 5);
    }

    /**
     * Clicks the Save button
     */
    public void clickSaveButton() {
        waitAndClick(saveButton, 5);
    }
}
