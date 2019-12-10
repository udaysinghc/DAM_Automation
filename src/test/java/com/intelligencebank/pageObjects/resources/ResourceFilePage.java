package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.stepDefinitions.resources.data.File;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ResourceFilePage extends ResourcesBasePage {

    private String fileLocator = "//div[contains(@class,'_container_')][contains(.,'%s')]";

    private String fileActionLocator = "//span[contains(@class, 'action-menu-item')][contains(.,'%s')]";

    private String readerButtonLocator = "//button[contains(.,'reader')]";

    private String downloadButtonLocator = "//button[contains(.,'file_download')]";

    private String infoButtonLocator = "//button[contains(.,'info')]";

    private String emailLinkButtonLocator = "//a[contains(.,'Email Link')]";

    private String actionMenuButton = "//div[contains(@class,'_container_')][contains(.,'%s')]//button[contains(.,'more_vert')]";

    @FindAll(@FindBy(xpath = "//div[contains(@class,'file-name')]//span"))
    List<WebElement> filenames;

    @FindBy(xpath = "//div[@role='menu']")
    WebElement actionMenu;

    @FindAll(@FindBy(css = "div[role='menu'] span.action-menu-item span"))
    List<WebElement> fileActionsList;

    @FindBy(css = ".ReactVirtualized__Grid")
    WebElement fileView;

    @FindBy(id = "resourceListView")
    WebElement listView;

    @FindBy(id = "resourceElasticThumbnailView")
    WebElement imagesView;

    public ResourceFilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Asserts which view you are in!
     * @param view The view you want to check
     */
    public void assertView(String view) {
        switchToIframe(resourcesIframe);
        switch(view.toLowerCase()) {
            case "list":
                waitAndAssertVisibility(10, listView, "The list view was not displayed");
                break;
            case "images":
                waitAndAssertVisibility(10, imagesView, "The images view was not displayed");
                break;
            default:
                Assert.fail(String.format("The %s view does not exist", view));
        }
    }

    /**
     * Waits for files to load
     */
    public void waitForFiles() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            switchToIframe(resourcesIframe);
            wait.until(ExpectedConditions.visibilityOf(fileView));
        } catch (TimeoutException ex) {
            //Continuing does no harm
        } catch (StaleElementReferenceException ex) {
            // if the Iframe is stale, continue anyway, it will be refreshed next time
        }
    }

    /**
     * Compares the indexes of a list of expected order to an idex of a list of actual order, both should be Equal
     * @param expectedItems The List of FIle objects to compare
     */
    public void assertFilePosition(List<File> expectedItems) throws InterruptedException {
        switchToIframe(resourcesIframe);
        waitForFiles();
        Thread.sleep(1000);
        for (int i = 0; i < expectedItems.size(); i++) {
            String expectedFileName = expectedItems.get(i).getName();
            String actualFileName = filenames.get(i).getText();
            Assert.assertEquals(actualFileName, expectedFileName, "Files are not sorted as expected");
        }
    }

    /**
     * Switches to the iFrame then tries to switch to the file view, if it is already in the file view the exception
     * is caught and the test can proceed
     */
    public void switchToFileView() {
        switchToIframe(resourcesIframe);
        try {
            waitAndClick(fileSwitcherButton, 4);
        } catch (TimeoutException ex) {
            // if it's not clickable it's OK to continue
        }
    }

    /**
     * Switches to the iFrame (of just continues if already there) then clicks the file Action button of the
     * given filename.
     * @param fileName The given filename to click the action button.
     * @throws InterruptedException
     */
    public void clickFileActionButton(String fileName) throws InterruptedException {
        switchToIframe(resourcesIframe);
        closeActionMenu();
        if(!waitAndIsElementPresent(actionMenu, 5)) {
            By by = By.xpath(String.format(actionMenuButton, fileName));
            Actions builder = new Actions(driver);
            builder.moveToElement(waitAndReturnElement(by, 5));
            builder.perform();
            waitAndClick(waitAndReturnElement(by, 2), 2);
            Thread.sleep(1000);
        }
    }

    /**
     * Asserts whether a file is present in the file list view
     * @param fileName The name of the file
     */
    public void assertFilePresent(String fileName) {
        Assert.assertTrue(waitAndIsElementPresent(By.xpath(String.format(actionMenuButton, fileName)), 5),
                String.format("The file %s is not present", fileName));
    }

    /**
     * Selects the move file option from the file action menu (must click the file action button first)
     */
    public void selectMoveFileOption() {
        waitAndClick(By.xpath(String.format(fileActionLocator, "Move File")), 10);
    }

    /**
     * Asserts a collection of permission options are applied to a file resource
     * @param fileName The filename to assert
     * @param availableOptions A collection of options to assert
     */
    public void assertFilePermissions(String fileName, List<Map<String, String>> availableOptions) throws InterruptedException {
        switchToIframe(resourcesIframe);
        for(Map<String, String> currentOption : availableOptions) {
            String function = currentOption.get("Function");
            String isEnabled = currentOption.get("Enabled");
            String fileLocator = String.format(this.fileLocator, fileName);
            switch(function) {
                case "Reader":
                    assertFileActionIcon(isEnabled, fileLocator, readerButtonLocator, function);
                    break;
                case "Download":
                    assertFileActionIcon(isEnabled, fileLocator, downloadButtonLocator, function);
                    break;
                case "Info":
                    assertFileActionIcon(isEnabled, fileLocator, infoButtonLocator, function);
                    break;
                case "Email Link":
                    boolean isEmailLinkPresent = waitAndIsElementPresent(By.xpath(emailLinkButtonLocator));
                    if (isEnabled.equals("x")){
                        if(!isEmailLinkPresent) {
                            clickFileActionButton(fileName);
                            isEmailLinkPresent = waitAndIsElementPresent(By.xpath(String.format(fileActionLocator, function)));
                        }
                        Assert.assertTrue(isEmailLinkPresent, String.format("%s option was not available and should be", function));
                    }
                    break;
                case "Edit / New Version":
                case "Delete File":
                case "Create Alias":
                case "Move File":
                    clickFileActionButton(fileName);
                    if (isEnabled.equals("x")){
                        waitAndAssertVisibility(5, By.xpath(String.format(fileActionLocator, function)),
                                String.format("%s option was not available and should be", function));
                    } else {
                        Assert.assertFalse(waitAndIsElementPresent(By.xpath(fileActionLocator), 5),
                                String.format("%s option was available and should not be", function));
                    }
                    break;
                case "Add File":
                case "Bulk Upload":
                case "Add Folder":
                    if (isEnabled.equals("x")){
                        Assert.assertTrue(isMenuOptionVisible(function),
                                String.format("%s option was not available and should be", function));
                    } else {
                        boolean isPresent = waitAndIsElementPresent(addButton, 3);
                        if (isPresent) {
                            isPresent = isMenuOptionVisible(function);
                        }
                        Assert.assertFalse(isPresent,
                                String.format("%s option was available and should not be", function));
                    }
                    break;
                default:
                    Assert.fail(String.format("The access level %s doesn't exist", function));
            }
        }
    }

    private void assertFileActionIcon(String isEnabled, String fileLocator, String infoButtonLocator, String function)
            throws InterruptedException {
        closeActionMenu();
        if (isEnabled.equals("x")) {
            waitAndAssertVisibility(5, By.xpath(fileLocator + infoButtonLocator),
                    String.format("%s option was not available and should be", function));
        } else {
            Assert.assertFalse(waitAndIsElementPresent(By.xpath(fileLocator + infoButtonLocator), 5),
                    String.format("%s option was available and should not be", function));
        }
    }
}
