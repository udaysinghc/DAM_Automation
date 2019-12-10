package com.intelligencebank.pageObjects.database;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatabaseRecordPage  extends DatabaseForm{

    public DatabaseRecordPage(WebDriver driver) {super(driver); }


    @FindBy(xpath = "//div[contains(@class,'header-add-button')]//span[text()='Add']")
    WebElement addRecordButton;
    @FindBy(xpath = "//div[contains(@class,'_textContainer_psmgei')]//input[@type='text']")
    WebElement enterTextField;
    @FindBy(xpath = "//div[contains(@class,'_textContainer_psmgei')]//input[@type='email']")
    WebElement enterEmailField;
    @FindBy(xpath = "//div[contains(@class,'_textContainer_psmgei')]//input[@type='tel']")
    WebElement enterPhoneField;
    @FindBy(xpath = "//div[contains(@class,'button-row')]//span[text()='Save As Draft']")
    WebElement saveDraftButton;
    @FindBy(xpath = "//div[contains(@class,'button-row')]//span[text()='Save & Exit']")
    WebElement saveReecordAndExit;
    @FindBy(xpath = " //div[contains(@class,'_textContainer_psmgei')]//span[text()='This field cannot be empty']")
    WebElement errormessageForTitleField;
    @FindBy(xpath = " //div[contains(@class,'_textContainer_psmgei')]//span[text()='Please enter a valid email address']")
    WebElement errormessageForEmailField;
    @FindBy(xpath = " //div[contains(@class,'_textContainer_psmgei')]//span[text()='Please enter a valid phone number']")
    WebElement errormessageForPhoneField;
    @FindBy(xpath="//iframe[contains(@id,'phoenix-iframe')]")
    WebElement Switchiframe;
    @FindBy(xpath="//div[contains(@class,'_headerActions_')]//span[text()='\uE14C']\n")
    WebElement closeRecordIcon;

    //Click on add record buttn
    public void addRecordButton(){
        switchToIframe(Switchiframe);
        addRecordButton.click();
    }

    //Enter value in the text field
    public void enterValueInTextField(){
        enterTextField.sendKeys("Entered by UI Automation Test");
    }

    public void enterValueInEmailField(){
        enterEmailField.sendKeys("automation@");
    }

    public void enterValueInPhoneField(){
        enterPhoneField.sendKeys("ABCPHONE");
    }
    // Click on the save as draft button
    public void clickonsaveasDraftButton(){
        saveDraftButton.click();
            }

    // Switching to Iframe
    public void switchToIframe(){
        switchToIframe(Switchiframe);
    }

    // Click on the close icon
    public void clickonCloseRecordIcon(){
        closeRecordIcon.click();
    }


    //Verify that error message is displayed when save as draft is clicked without entering title field
    public void errorMessageForTitle(){
        try {
            errormessageForTitleField.isDisplayed();
        }
        catch (Exception e) {
            System.out.println("Error message should be displayed if user tries to save draft without entering title field");
        }
    }

    //Verify that error message is displayed when save as draft is clicked without entering valid email
    public void errorMessageForEmail(){

        try {
            errormessageForEmailField.isDisplayed();
        }
        catch (Exception e) {
            System.out.println("Error message should be displayed if user tries to save draft without entering valid email address");
        }
    }

    //Verify that error message is displayed when save as draft is clicked without entering valid phone number
    public void errorMessageForPhone(){

        try {
            errormessageForPhoneField.isDisplayed();
        }
        catch (Exception e) {
            System.out.println("Error message should be displayed if user tries to save draft without entering valid email address");
        }
    }
}
