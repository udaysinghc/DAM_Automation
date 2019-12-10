package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ResourcesBasePage extends BasePage {

    @FindBy(xpath = "//button[contains(., 'Add')]")
    WebElement addButton;
    private String breadcrumbItemXpath = "//div[contains(@class, '_breadcrumbContainer_')]//span[contains(.,'%s')]";

    private String addMenuLocator = "//div[@role='menu']//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[contains(text(), 'home')]")
    WebElement homeBreadcrumb;

    @FindBy(id = "phoenix-iframe")
	WebElement resourcesIframe;

	@FindBy(how=How.XPATH, using = "//a[text() = 'Resource']")
	WebElement ResourceMenuLink;
	
	@FindBy(how=How.XPATH, using = "//span[text() = 'Add Folder']")
	WebElement AddFolderButton;

	@FindBy(how=How.XPATH, using = "//textarea[@name = 'description']")
	WebElement DescriptionTextBox;

	@FindBy(how=How.XPATH, using = "//button[@name = 'fsActions[resetBtn]']")
	WebElement ResetButton;
	
	@FindBy(how=How.ID, using = "cancelSubmit")
	WebElement CancelButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='folderListView']/div[1]/div/div/div[1]/div[1]/div")
	WebElement NewlyCreatedFolderPath;

	@FindAll(@FindBy(xpath = "//*[@id='folderListView']//div[contains(@class,'container')]"))
    List<WebElement> resourceFolders;

    @FindAll(@FindBy(xpath = "//*[@id='folderListView']//div[contains(@class,'container')]//a[contains(@class,'title')]//span"))
    List<WebElement> folderTitles;

    @FindBy(xpath = "//div[contains(@class,'switcher')]//span[contains(.,'folder')]")
    WebElement folderSwitcherButton;

    @FindBy(xpath = "//div[contains(@class,'switcher')]//span[contains(.,'files')]")
    WebElement fileSwitcherButton;

    @FindBy(xpath = "//div[@role='menu']")
    WebElement addMenu;

    public ResourcesBasePage(WebDriver driver) {
		super(driver);
	}

	public void clickAddButton() {
		switchToIframe(resourcesIframe);
		waitAndClick(addButton, 3);
	}

	public boolean isMenuOptionVisible(String menuOption) throws InterruptedException {
        switchToIframe(resourcesIframe);
        closeActionMenu();
        if(!waitAndIsElementPresent(addMenu, 3)) {
            clickAddButton();
        }
        By menuOptionLocator = By.xpath(String.format(addMenuLocator, menuOption));
        return waitAndIsElementPresent(menuOptionLocator, 5);
    }

    protected void closeActionMenu() throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ESCAPE);
        builder.sendKeys(Keys.ESCAPE);
        builder.perform();
        Thread.sleep(1000);
    }

    public void assertBreadcrumbItem(String item) {
        switchToIframe(resourcesIframe);
        By by = By.xpath(String.format(breadcrumbItemXpath, item));
        waitAndAssertVisibility(10, by, String.format("The breadcrumb %s was not present", item));
    }

    public void clickBreadcrumbItem(String name) {
        switchToIframe(resourcesIframe);
        By by = By.xpath(String.format(breadcrumbItemXpath, name));
        waitAndClick(by, 5);
    }

    // Had to create a custom wait for the menu to disappear as there is no suitable webdriver wait
    // Element was obscured by menu making it not clickable "ElementClickInterceptedException"
    protected void clickFolderElement(String folderName) throws InterruptedException {
        int numberOfAttempts = 8;
        for (int i = 0; i <= numberOfAttempts; i++) {
            boolean isClicked = false;
            try {
                // Try to click it
                getFolderElement(folderName).click();
                // If it works it will get to this code, set state to isClicked
                isClicked = true;
            } catch (Exception ex) {
                // If it wasn't clicked exception is thrown and you will end up here (it never got to isClicked so that
                // should still be false...

                // But wait for 1 second
                Thread.sleep(200);
                // ...just to be sure:
                isClicked = false;
                // When we have waited for the correct number of iterations (about 1 second per loop)
                // we want to fail meaningfully and gracefully
                if (i == numberOfAttempts) {
                    Assert.fail("element wasn't clickable as menu hadn't collapsed");
                }
            }
            // If it's been clicked...
            if (isClicked) {
                //...we need to break the loop
                break;
            }
        }
    }

    protected WebElement getFolderElement(String folderName) {
        for (int i = 0; i < resourceFolders.size(); i++) {
            WebElement currentElement = resourceFolders.get(i);
            WebElement nameObject = folderTitles.get(i);
            String currentFolderName = nameObject.getText();
            if(currentFolderName.equals(folderName)) {
                return currentElement;
            }
        }
        return null;
    }

    public void switchToFolderView() {
        boolean isFolderSwitcherDisplayed = false;
        try {
            isFolderSwitcherDisplayed = folderSwitcherButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            // fall through cos I want to continue anyway
        }

        if (isFolderSwitcherDisplayed) {
            folderSwitcherButton.click();

        }
    }

    public void clickHomeBreadcrumb() {
        switchToIframe(resourcesIframe);
        waitAndClick(homeBreadcrumb, 5);
    }
}
