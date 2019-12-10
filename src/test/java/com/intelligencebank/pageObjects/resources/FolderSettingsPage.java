package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FolderSettingsPage extends BasePage {

    @FindBy(id = "additional_detail_label")
    WebElement advancedOptionsLink;

    @FindBy(xpath = "//div[contains(@class,'input-wrapper')][contains(.,'Resource Date')]")
    WebElement defaultOrderSelectionList;

    @FindBy(xpath = "//div[contains(@class,'input-wrapper')][contains(.,'List')]")
    WebElement defaultLayoutSelectionList;

    @FindBy(css = "[name='forceWatermark'][type='checkbox']")
    WebElement forceWatermarkCheckboxUnchecked;

    @FindBy(css = "[name='forceWatermark'][type='checkbox'][checked='checked']")
    WebElement forceWatermarkCheckboxChecked;

    @FindBy(id = "popPermissionGridBtn")
    WebElement permissionDetailsButton;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    public FolderSettingsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the default Sort Order
     * @param settingValue The value you want to set, this is used in the selection list search box
     * @throws InterruptedException
     */
    public void setDefaultOrder(String settingValue) throws InterruptedException {
        setFolderSettingsSelectionListValue(defaultOrderSelectionList, settingValue);
    }

    /**
     * Sets the default view
     * @param settingValue The value you want to set, this is used in the selection list search box
     * @throws InterruptedException
     */
    public void setDefaultView(String settingValue) throws InterruptedException {
        setFolderSettingsSelectionListValue(defaultLayoutSelectionList, settingValue);
    }

    /**
     * Makes sure the force watermark checkbox is ticked
     * @throws InterruptedException
     */
    public void setForceWatermarkTrue() throws InterruptedException {
        clickAdvancedOptions();
        boolean isChecked = waitAndIsElementPresent(forceWatermarkCheckboxChecked, 3);
        if(!isChecked) {
            forceWatermarkCheckboxUnchecked.click();
        }
        waitAndClick(saveButton, 3);
    }

    /**
     * Clicks the Permissions Details Button
     */
    public void clickPermissionsDetailsButton() throws InterruptedException {
        switchOutOfIframe();
        clickAdvancedOptions();
        waitAndClick(permissionDetailsButton, 3);
    }

    /**
     * Checks if if Force Watermark is disabled
     * @throws InterruptedException
     */
    public void assertForceWatermarkFalse() throws InterruptedException {
        clickAdvancedOptions();
        Actions builder = new Actions(driver);
        builder.moveToElement(forceWatermarkCheckboxUnchecked);
        boolean isForceWatermark = waitAndIsElementPresent(forceWatermarkCheckboxChecked);
        Assert.assertFalse(isForceWatermark, "The force watermark checkbox was ticked");
    }

    private void setFolderSettingsSelectionListValue(WebElement selectionList, String value) throws InterruptedException {
        clickAdvancedOptions();
        // selection list is tricky, have to do a lot of work arounds to operate it
        Actions builder = new Actions(driver);
        builder.moveToElement(selectionList);
        builder.perform();
        waitAndClick(selectionList, 5);
        // Using the selection list search box is the simplest method of finding things
        builder.sendKeys(value);
        builder.sendKeys(Keys.ENTER);
        builder.perform();
        builder.sendKeys(Keys.ESCAPE);
        builder.perform();
        // Have to sleep because the selection list can be a bit slow to close
        Thread.sleep(500);
        // Save it
        waitAndClick(saveButton, 5);
    }

    private void clickAdvancedOptions() throws InterruptedException {
        // v2 page, no iframes
        switchOutOfIframe();
        // have to wait ages for the advanced link
        waitAndAssertVisibility(10, advancedOptionsLink, "The advanced options link did not appear after 10 seconds");
        Thread.sleep(1000);
        // expand advanced Options
        waitAndClick(advancedOptionsLink, 5);
    }

}
