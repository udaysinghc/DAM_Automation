package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MoveFolderPage extends BasePage {

    String destinationFolderLinkLocator = "//div[@id='moveModal']//a[contains(.,'%s')]";

    @FindBy(css = "input[name='submitBtn'][value='Move']")
    protected WebElement moveButton;

    @FindBy(id = "moveModal")
    protected WebElement moveFolderDialog;

    public MoveFolderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the link lement for the destination folder in the tree view
     * @param destinationFolderName The name of the destination folder
     */
    public void clickDestinationFolderLink(String destinationFolderName) {
        switchOutOfIframe();
        String folderToSelectLocator = String.format(destinationFolderLinkLocator, destinationFolderName);
        waitAndClick(By.xpath(folderToSelectLocator), 10);
    }

    /**
     * Clicks the move button
     */
    public void clickMoveButton() {
        waitAndClick(moveButton, 10);
    }

    /**
     * Waits for the move dialog to disappear before allowing the test to proceed
     */
    public void waitForDialogToDisapear() {
        WebDriverWait wait = new WebDriverWait(driver, 400);
        try {
            wait.until(ExpectedConditions.invisibilityOf(moveFolderDialog));
        } catch (TimeoutException ex) {
            // happy to go onto assertion as it has already taken too long
        }
    }
}
