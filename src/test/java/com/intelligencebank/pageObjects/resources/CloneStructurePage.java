package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloneStructurePage extends BasePage {

    private String folderLocator = "//div[@id='cloneModal']//a[contains(.,'%s')]";

    @FindBy(css = "input[name='submitBtn'][value='Clone']")
    WebElement cloneButton;

    @FindBy(id = "name")
    WebElement folderTitle;

    @FindBy(id = "cloneModal")
    WebElement cloneFolderStructureDialog;

    public CloneStructurePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects the folder to clone to
     * @param folderName The desired folder name
     */
    public void selectFolder(String folderName) {
        switchOutOfIframe();
        By by = By.xpath(String.format(folderLocator, folderName));
        waitAndIsElementPresent(by);
        WebElement element = driver.findElement(by);
        Actions builder = new Actions(driver);
        builder.moveToElement(element);
        builder.perform();
        element = driver.findElement(by);
        waitAndClick(element, 5);
    }

    /**
     * Clicks the clone button
     */
    public void clickCloneButton() {
        waitAndClick(cloneButton, 10);
    }

    /**
     * Enters the name of the new folder
     * @param folderName The name of the folder
     */
    public void enterFolderName(String folderName) {
        folderTitle.clear();
        folderTitle.sendKeys(folderName);
    }

    /**
     * After clicking the clone button this test waits for the dialog to disappear
     */
    public void waitForDialogToDisapear() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.invisibilityOf(cloneFolderStructureDialog));
    }
}
