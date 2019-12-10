package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class GroupPermissionsDetailPage extends ResourcesBasePage {

    private String permissionsRowLocator = "//section[contains(@class, 'itemRow')][contains(.,'%s')]//div[contains(@class,'four')]";
    private String permissionsCheckboxLocator = "//span[contains(@class,'custompermissioncheckbox')]";

    @FindBy(id = "cancelRules")
    WebElement cancelButton;

    public GroupPermissionsDetailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Asserts a collection of expected permissions match a collection of the actual permissions
     * @param permissions The expected permissions
     */
    public void assertPermissionsEqual(List<Map<String, String>> permissions) {
        for(Map<String,String> tableRow : permissions) {
            Assert.assertTrue(isPermissionChecked(tableRow));
        }
        clickCancelButton();
    }

    /**
     * Asserts a collection of expected permissions do not match a collection of the actual permissions
     * @param permissions The expected permissions
     */
    public void assertPermissionsNotEqual(List<Map<String, String>> permissions) {
        for(Map<String,String> tableRow : permissions) {
            Assert.assertFalse(isPermissionChecked(tableRow));
        }
        clickCancelButton();
    }

    /**
     * Clicks the cancel Button
     */
    public void clickCancelButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(cancelButton);
        builder.perform();
        waitAndClick(cancelButton, 3);
    }

    private boolean isPermissionChecked(Map<String, String> tableRow) {
        String user = tableRow.get("User");
        String permissionLevel = tableRow.get("Permissions");
        String rowLocator = String.format(permissionsRowLocator, user);
        String permissionLocator = rowLocator + permissionsCheckboxLocator;
        waitAndIsElementPresent(By.xpath(rowLocator), 20);
        List<WebElement> actualPermissions = driver.findElements(By.xpath(permissionLocator));
        int i = 0;
        switch(permissionLevel) {
            case "Preview":
                i = 0;
                break;
            case "Access":
                i = 1;
                break;
            case "Publish":
                i = 2;
                break;
            case "Admin":
                i = 3;
                break;
            default:
                Assert.fail(String.format("The Permission %s doesn't exist", permissionLevel));
        }
        WebElement actualPermission = actualPermissions.get(i);
        String checkedAttribute = actualPermission.getAttribute("defaultChecked");
        try {
            // will be 2 if it's checked
            checkedAttribute.equals("2");
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }
}
