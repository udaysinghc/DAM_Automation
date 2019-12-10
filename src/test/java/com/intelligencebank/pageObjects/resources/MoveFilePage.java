package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoveFilePage extends BasePage {

    @FindBy(name = "goToFolderBtn")
    WebElement gotoFolderButton;

    public MoveFilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the goto folder button
     */
    public void clickGotoFolderButton() {
        waitAndClick(gotoFolderButton, 10);
    }

    /**
     * Detects the presence or not of the goto folder button
     * @return true or false depending on presence of the folder
     */
    public boolean isGotoFolderButton() {
        boolean isDisplayed = true;
        try {
            isDisplayed = gotoFolderButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
