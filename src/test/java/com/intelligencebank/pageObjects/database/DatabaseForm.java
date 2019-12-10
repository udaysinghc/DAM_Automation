package com.intelligencebank.pageObjects.database;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.concurrent.TimeUnit;

public class DatabaseForm extends DatabaseSettingsPage {

 //   @FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Text']")
    @FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Text']")
    WebElement click_textField;
    @FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Email']")
    WebElement click_emailField;
    @FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Phone']")
    WebElement click_phoneField;
    @FindBy(xpath = "//div[contains(@class,'_textContainer_psmgei')]//input[@type='text']")
    WebElement enter_Field_name;
    @FindBy(xpath = "//div[contains(@class,'_stickyButtonContainer')]//span[text()='Save & Close']")
    WebElement save_textField;
   // @FindBy(xpath = "//ul[contains(@class,'breadcrumbs')]//a[text()=dbname2]")
    //WebElement click_ondatabase;
    @FindBy(xpath="//iframe[contains(@id,'phoenix-iframe')]")
    WebElement Switchiframe;
    @FindBy(xpath="//ul[contains(@class,'breadcrumbs')]//a[@id='breadcrumbs-profilerIndex']")
    WebElement breadcrumb;

    public DatabaseForm(WebDriver driver) {super(driver);}

    //Selecting the text field from left menu
     public void selectTextField(){
         switchToIframe(Switchiframe);
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         click_textField.click();
    }

    // Selecting the email field from left menu
    public void selectEmailField(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click_emailField.click();
    }

    // Selecting the phone field from left menu
    public void selectPhoneField() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click_phoneField.click();
    }

    //Entering the text field name
    public void enterTextFieldName( ){

        enter_Field_name.sendKeys("Text Field");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //Entering the phone  field name
    public void enterPhoneFieldName( ){

        enter_Field_name.sendKeys("Phone Field");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //Entering the email  field name
    public void enterEmailFieldName( ){

        enter_Field_name.sendKeys("Email Field");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //saving the  field in the form
    public void saveFieldInForm() {

        save_textField.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    // Clicking on the breadcrumb
    public void clickOnBreadCrumb(){
        breadcrumb.click();
    }
}
