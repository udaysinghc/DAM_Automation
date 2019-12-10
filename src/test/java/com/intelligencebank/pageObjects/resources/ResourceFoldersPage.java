package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ResourceFoldersPage extends ResourcesBasePage {

    String folderLinkXpath = "//*[@id='folderListView']//a[contains(.,'%s')]";

    @FindBy(css = ".ReactVirtualized__Grid")
    WebElement folderView;

    private String actionsButtonXpath = "//*[@id='folderListView']//div[contains(@class,'_container_')][contains(.,'%s')]//button";
    private By actionsButtonLocator = By.xpath("//*[@id='folderListView']//div[contains(@class,'container')]//button");

    @FindBy(xpath = "//div[@role='menu']//span[contains(@class,'action-menu-item')]//span[contains(.,'Delete Folder')]")
    WebElement deleteFolderMenuOption;

    @FindBy(xpath = "//div[@role='menu']//span[contains(@class,'action-menu-item')]//span[contains(.,'Folder Settings')]")
    WebElement folderSettingsMenuOption;

    @FindBy(xpath = "//div[@role='menu']//span[contains(@class,'action-menu-item')]//span[contains(.,'Clone Structure')]")
    WebElement cloneStructureOption;

    @FindBy(xpath = "//div[@role='menu']//span[contains(@class,'action-menu-item')]//span[contains(.,'Add Folder')]")
    WebElement addFolderMenuOption;

    @FindBy(xpath = "//span[contains(text(), 'Add Folder')]")
    WebElement addFolderLink;

    public ResourceFoldersPage(WebDriver driver) {
        super(driver);
    }

    // For Permissions Testing Only - Will be tightly coupled to test data
    // USER AS GROUP folder Resource Folder Structure:
    // Folder G1
    //      |___File G1.1
    //      |___Folder G2
    //              |___File G2.1
    //              |___Folder G3
    //                      |___File G3.1
    public void iterateOverFoldersAssertingPermissions(List<Map<String, String>> dataTable) throws Throwable {
        for (int i = 0; i < dataTable.size(); i++) {
            switchToIframe(resourcesIframe);
            switchToFolderView();

            Map<String, String> tableRow = dataTable.get(i);
            String folderName = tableRow.get("Folder");

            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            try {
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(resourceFolders));
            } catch(Exception ex) {
                // no need to do anything here
            }

            // click the actions menu button - have to click twice or JS event doesn't fire
            if (tableRow.get("Delete").equals("Hidden")) {
                boolean displayed = isElementPresent(folderSwitcherButton);
                takeScreenshot("Folder_Hidden");
                Assert.assertFalse(displayed);
            } else {
                clickFolderActionButton(folderName);
                Thread.sleep(1000);
                folderPermissionAssertions(tableRow, folderName);
            }
        }
    }

    /**
     * Waits for the folders view
     */
    public void waitForFolders() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            switchToIframe(resourcesIframe);
            wait.until(ExpectedConditions.visibilityOf(folderView));
        } catch (TimeoutException ex) {
            //Continuing does no harm
        }
    }

    /**
     * Clicks the folder action button for a given folder
     * @param folderName The name of the folder
     */
    public void clickFolderActionButton(String folderName) {
        switchToIframe(resourcesIframe);
        waitForFolders();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                actionsButtonLocator));
        WebElement elem;
        try {
            elem = driver.findElement(By.xpath(String.format(actionsButtonXpath, folderName)));
            Actions builder = new Actions(driver);
            builder.moveToElement(elem);
            builder.perform();
            elem = driver.findElement(By.xpath(String.format(actionsButtonXpath, folderName)));
            waitAndClick(elem, 2);
        } catch (ElementClickInterceptedException ex) {
            elem = driver.findElement(By.xpath(String.format(actionsButtonXpath, folderName)));
            Actions builder = new Actions(driver);
            builder.moveToElement(elem);
            builder.perform();
            clickFolderActionButton(folderName);
        }
    }

    /**
     * Selects the clone structure option from the folder actions menu
     * @param folderName The desired folder name
     * @throws InterruptedException
     */
    public void selectCloneStructure(String folderName) throws InterruptedException {
        selectFolderActionsOption(folderName, cloneStructureOption);
    }

    /**
     * Selects the folder settings option from the folder action menu
     * @param foldername The desired folder name
     * @throws InterruptedException
     */
    public void selectFolderSettings(String foldername) throws InterruptedException {
        selectFolderActionsOption(foldername, folderSettingsMenuOption);
    }

    /**
     * Selects the delete folder option from the folder actions menu
     * @param foldername The desired foldername
     * @throws InterruptedException
     */
    public void selectDeleteFolder(String foldername) throws InterruptedException {
        selectFolderActionsOption(foldername, deleteFolderMenuOption);
    }

    /**
     * Clicks on a given folder
     * @param folder The folder you would like to click on
     */
    public void clickFolder(String folder) {
        switchToIframe(resourcesIframe);
        String folderXpath = String.format(folderLinkXpath, folder);
        waitAndIsElementPresent(By.xpath(folderXpath));
        WebElement elem = driver.findElement(By.xpath(folderXpath));
        try {
            waitAndClick(elem, 10);
        } catch (ElementClickInterceptedException ex) {
            Actions builder = new Actions(driver);
            builder.moveToElement(elem, 0, 50);
            builder.sendKeys(Keys.PAGE_DOWN);
            builder.perform();
            clickFolder(folder);
        }
    }

    /**
     * Clicks add folder from the add button menu
     * @throws InterruptedException
     */
    public void addFolder() throws InterruptedException {
        switchToIframe(resourcesIframe);
        waitAndClick(addButton, 5);
        Thread.sleep(1000);
        try {
            waitAndClick(addFolderMenuOption, 5);
        } catch (ElementClickInterceptedException ex) {
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.ESCAPE);
            builder.perform();
            Thread.sleep(1000);
            waitAndClick(addFolderLink, 10);
        } catch (TimeoutException ex) {
            addFolder();
        }
    }

    /**
     * Asserts whether a folder is present
     * @param foldername the folder you would liike to assert
     */
    public void assertFolderPresent(String foldername) {
        switchToIframe(resourcesIframe);
        String folderXpath = String.format(folderLinkXpath, foldername);
        boolean isFolderPresent = waitAndIsElementPresent(By.xpath(folderXpath));
        Assert.assertTrue(isFolderPresent, String.format("The folder %s was not present", foldername));
    }

    /**
     * Asserts that you are on a page
     * @param pagename The page
     */
    public void assertOnPage(String pagename) {
        By by = By.xpath(String.format("//span[text()='%s']", pagename));
        switchToIframe(resourcesIframe);
        assertOnPage(by, pagename);
    }

    private void folderPermissionAssertions(Map<String, String> tableRow, String folderName) throws Throwable {
        if (tableRow.get("Delete").equals("No")) {
            assertFolderOptionNotPresent(deleteFolderMenuOption, "Delete Folder");
        } else if (tableRow.get("Delete").equals("Yes")) {
            assertFolderOptionPresent(deleteFolderMenuOption, "Delete Folder");
        }

        if (tableRow.get("Create Sub Folder").equals("No")) {
            assertFolderOptionNotPresent(addFolderMenuOption, "Add Folder");
        } else if (tableRow.get("Create Sub Folder").equals("Yes")) {
            assertFolderOptionPresent(addFolderMenuOption, "Add Folder");
        }

        if (tableRow.get("Change Settings").equals("No")) {
            assertFolderOptionNotPresent(folderSettingsMenuOption, "Folder Settings");
        } else if (tableRow.get("Change Settings").equals("Yes")) {
            assertFolderOptionPresent(folderSettingsMenuOption, "Folder Settings");
        }

        if (tableRow.get("Add File").equals("No")) {
            closeActionMenu();
            clickFolderElement(folderName);
            Assert.assertFalse(isAddButtonPresent(), "Button was not supposed to be displayed onscreen but was");
        } else if (tableRow.get("Add File").equals("Yes")) {
            closeActionMenu();
            clickFolderElement(folderName);
            Assert.assertTrue(isAddButtonPresent(), "Button was supposed to be displayed onscreen but was not");
        }
    }

    private boolean isAddButtonPresent() {
        return isElementPresent(addButton);
    }

    private void assertFolderOptionNotPresent(WebElement element, String folderOption) {
        Assert.assertFalse(isElementPresent(element),
                String.format("The %s option was present and it shouldn't have been", folderOption));
    }

    private void assertFolderOptionPresent(WebElement element, String folderOption) {
        Assert.assertTrue(isElementPresent(element),
                String.format("The Option '%s' was not in the list and it was supposed to be", folderOption));
    }

    private void selectFolderActionsOption(String foldername, WebElement option) throws InterruptedException {
        clickFolderActionButton(foldername);
        Thread.sleep(1000);
        if(!isElementPresent(option)) {
            clickFolderActionButton(foldername);
            Thread.sleep(1000);
        }
        waitAndClick(option, 5);
    }
}
