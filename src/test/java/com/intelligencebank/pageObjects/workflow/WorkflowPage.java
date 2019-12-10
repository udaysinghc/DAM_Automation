package com.intelligencebank.pageObjects.workflow;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkflowPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Workflow']")
    WebElement pageTitle;

    public WorkflowPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
