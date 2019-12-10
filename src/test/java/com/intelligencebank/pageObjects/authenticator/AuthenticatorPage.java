package com.intelligencebank.pageObjects.authenticator;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticatorPage extends BasePage {

    @FindBy(xpath = "//h4[contains(text(),'Authenticators')]")
    WebElement pageTitle;

    public AuthenticatorPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnPage(String pagename) {
        assertOnPage(pageTitle, pagename);
    }
}
