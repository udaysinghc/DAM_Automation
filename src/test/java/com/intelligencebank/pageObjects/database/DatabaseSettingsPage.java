package com.intelligencebank.pageObjects.database;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DatabaseSettingsPage extends DatabaseBasePage {
    @FindBy(xpath = "//input[@id='name']")
    WebElement databaseName;
    @FindBy(xpath = "//div//textarea[@id='description']")
    WebElement databaseDescription;
    @FindBy(xpath = "//input[@value='single']")
    WebElement databaseType;
    @FindBy(xpath="//div[contains(@class,'row collapse')]//input[@id='enableDraft']")
    WebElement databaseSaveDraftOption;
    @FindBy(xpath ="//input[@type='submit' and @value='Save and Create Form']")
    WebElement databaseSave;

    String dateselected;
   // String dbname1 = "Automation Database";
    String dbname2;

     public DatabaseSettingsPage(WebDriver driver) { super(driver); }

     public void getcurrenttime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dateselected = formatter.format(date);
        dbname2 = "Automation Database " + " " + dateselected;
    }

    //entering database name
    public void enterDatabaseName() {

        databaseName.sendKeys(dbname2);
    }

    //entering database description
    public void enterDatabaseDesc() {
        databaseDescription.sendKeys("DatabaseTest  description entered by automation at  "+ dateselected);
    }

    //Selecting database type
    public void selectDatabaseType(){
        databaseType.click();
    }

    //Selecting draft option in database
    public void selectDraftOption(){
        databaseSaveDraftOption.click();
    }

    //Clicking save and create form button
    public void createDatabase(){
        waitAndClick(databaseSave,15);
    }

}

