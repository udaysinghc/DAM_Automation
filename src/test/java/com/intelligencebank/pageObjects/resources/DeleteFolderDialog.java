package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteFolderDialog extends BasePage {

    @FindBy(css = "input[value='Delete Folder']")
    private WebElement deleteFolderButton;

    @FindBy(id = "deleteModal")
    private WebElement deleteFolderDialog;

    public DeleteFolderDialog(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects Delete in the delete folder dialog then waits for the dialog to disappear for up to 10 secs
     */
    public void clickDeleteFolder() {
        switchOutOfIframe();
        waitAndClick(deleteFolderButton, 10);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(deleteFolderDialog));
    }
}
