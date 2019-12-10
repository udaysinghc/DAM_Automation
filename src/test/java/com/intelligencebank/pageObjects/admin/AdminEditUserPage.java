package com.intelligencebank.pageObjects.admin;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminEditUserPage extends AdminBasePage {

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(name = "lastname")
    WebElement lastNameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "sendPasswordRecoveryEmail")
    WebElement sendPasswordResetEmailCheckbox;

    @FindBy(id = "s2id_status")
    WebElement statusSelectionList;

    @FindBy(id = "s2id_defaultLanguage")
    WebElement defaultLanguageSelectionList;

    @FindAll(@FindBy(xpath = "//li[@class='select2-search-choice']/div"))
    List<WebElement> groupsFieldItems;

    @FindBy(xpath = "//div[@id='s2id_group']//input[contains(@class,'select2-input')]")
    WebElement groupsField;

    @FindBy(id = "s2id_leader")
    WebElement leaderSelectionList;

    @FindBy(id = "externalId")
    WebElement externalIdField;

    @FindBy(id = "userAsGroup")
    WebElement userAsGroupCheckbox;

    @FindBy(id = "additional_detail_label")
    WebElement additionalDetailsLink;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(name = "fsActions[resetBtn]")
    WebElement resetButton;

    public AdminEditUserPage(WebDriver driver) {
        super(driver);
    }

    public void fillInForm(HashMap<String, String> fieldValues) throws InterruptedException {
        for(Map.Entry<String, String> entry : fieldValues.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "firstname":
                    firstNameField.sendKeys(entry.getValue());
                    break;
                case "lastname":
                    lastNameField.sendKeys(entry.getValue());
                    break;
                case "email":
                    emailField.sendKeys(entry.getValue());
                    break;
                case "groups":
                    setGroup(entry.getValue());
                    break;
            }
        }
    }

    public void setUserAsGroupCheckboxChecked() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userAsGroupCheckbox));
        String isChecked = userAsGroupCheckbox.getAttribute("checked");
        if (isChecked.equals("false")) {
            userAsGroupCheckbox.click();
            Assert.assertEquals(userAsGroupCheckbox.getAttribute("checked"), "true",
                    "Checkbox was still not enabled after 1 click, some event didn't fire.");
        }
    }

    public void unsetUserAsGroupCheckbox() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userAsGroupCheckbox));
        String isChecked = userAsGroupCheckbox.getAttribute("checked");
        try{
            if (!isChecked.equals("false")) {
                userAsGroupCheckbox.click();
            }
        } catch (NullPointerException ex) {
            // this is correct behaviour as it's either
        }
    }

    public void setGroup(String groupname) throws InterruptedException {
        boolean nameExists = false;
        Thread.sleep(1000);
        for (int i = 0; i < groupsFieldItems.size(); i++) {
            String groupText = groupsFieldItems.get(i).getText();
            if (groupText.equals(groupname)) {
                nameExists = true;
            }
        }
        if (nameExists == false) {
            groupsField.sendKeys(groupname);
            Thread.sleep(1000);
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.ENTER);
            builder.sendKeys(Keys.TAB);
            builder.perform();
        }
    }

    public void clickSave() {
        saveButton.click();
    }
}
