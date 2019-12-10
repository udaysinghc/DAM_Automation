package com.intelligencebank.pageObjects.databases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabasePage extends DatabaseBasePage {

	@FindBy(xpath = "//span[contains(text(),'Databases')]")
	WebElement pageTitle;

	@FindBy(xpath = "//input[@id='name']")
    WebElement databaseName;

	@FindBy(xpath = "//input[@type='checkbox'][@id='enableDraft']")
    WebElement enableDraftRecords;

	@FindBy(xpath = "//input[@name='fsActions[submitAndGoToFormBtn]']")
    WebElement saveAndCreateFormButton;
	
	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Text']")
    WebElement textElement;

	@FindBy(xpath="//div[contains(@class,'_textContainer_')][contains(.,'Enter Field Label')]//input")
	WebElement addTextFieldTitle;

	@FindBy(xpath="//div[contains(@class,'_buttonControls_')]//span[text()='Save & Close']")
	WebElement saveAndCloseButton;

	@FindBy(xpath="//*[@id=\"breadcrumbs-profilerIndex\"]")
	WebElement databaseLink;

	@FindBy(xpath="//div[contains(@class,'header-add-button')]//span[text()='Add']")
	WebElement addRecordButton;

	@FindBy(xpath="//div[contains(@class,'_overlayBody_')]//span[text()='Save As Draft']")
	WebElement saveAsDraftbutton;

	@FindBy(xpath="//input[@placeholder='What are you looking for?']")
	WebElement searchDatabase;

	@FindBy(xpath="//div[contains(@class,'_searchIcon_')]//span[text()='search']")
	WebElement searchDatabaseIcon;

	@FindBy(xpath="//div[contains(@class,'_textField_')][contains(.,'t')]//input")
	WebElement enterTextValue;

	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Number']")
	WebElement numberElement;

	@FindBy(xpath="//div[contains(@class,'_textContainer_')][contains(.,'Enter Field Label')]//input")
	WebElement addNumberFieldTitle;

	@FindBy(xpath="//div[contains(@class,'_entireNumberContainer_')][contains(.,'t')]//input")
	WebElement enterNumberValue;

	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Date']")
	WebElement dateElement;

	@FindBy(xpath="//div[contains(@class,'_textContainer_')][contains(.,'Enter Field Label')]//input")
	WebElement addDateFieldTitle;

	@FindBy(xpath="//input[@type='checkbox'] [@name='defaultToday']")
	WebElement setDefaultToToday;

	@FindBy(xpath="//div[contains(@class,'_container_')]//span[text()='edit']")
	WebElement recordEditAction;

	@FindBy(xpath="//div[contains(@class,'_container_')]//span[text()='close']")
	WebElement closeSearchBar;

	@FindBy(xpath="//div[contains(@class,'right')]//span[text()='Save & Exit']")
	WebElement saveAndExitButton;

	@FindBy(xpath = "//span[text()='Save & Exit']")
	WebElement addRecordSaveAndExitButton;

	@FindBy(xpath="//div[contains(@class,'input-wrapper four columns collapse')][contains(.,'Staged')]//input[@value='staged']")
	WebElement stagedDatabaseOption;

	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Stage']")
	WebElement stageElement;

	@FindBy(xpath="//div[contains(@class,'_textField_')][contains(.,'t')]//input")
	WebElement enterStageName;

	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Section']")
	WebElement sectionElement;

	@FindBy(xpath="//div[contains(@class,'_textField_')][contains(.,'t')]//input")
	WebElement enterSectionName;

	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Email']")
	WebElement emailElement;

	@FindBy(xpath = "//div[contains(@class,'_elementControlsList_')]//span[text()='Phone']")
	WebElement phoneElement;

	@FindBy(xpath = "//div[contains(@class,'_textField_')][contains(.,'t')]//input")
	WebElement addEmailTitle;

	@FindBy(xpath = "//div[contains(@class,'_textField_')][contains(.,'t')]//input")
	WebElement addPhoneTitle;

	@FindBy(xpath="//div[contains(@class,'_container_')]//span[text()='arrow_forward']")
	WebElement continueButton;

	@FindBy(xpath="//div[contains(@class,'right')]//span[text()='Save & Next']")
	WebElement saveAndNextButton;

	@FindBy(xpath="//div[contains(@class,'_textContainer_psmgei')]//input[@type='email']")
	WebElement enterEmailValue;

	@FindBy(xpath="//div[contains(@class,'_textContainer_psmgei')]//input[@type='tel']")
	WebElement enterPhoneValue;

	@FindBy(xpath="//div[contains(@class,'_container_')]//span[text()='arrow_back']")
	WebElement revertButton;

	@FindBy(xpath="//div[contains(@class,'_selectContainer_')]//span[text()='Select Stage']")
	WebElement revertStagePopup;

	@FindBy(xpath="//div[contains(@class,'_selectContainer_')]//span[text()='Re-Open Stage 1']")
	WebElement revertToStageOne;

	@FindBy(xpath="//span[text()='Revert']")
	WebElement revertButtonInPopup;

	public DatabasePage(WebDriver driver) {
		super(driver);
	}

	public void setDatabaseName(String databasename) throws InterruptedException
    {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String name = databasename + "_" + timeStamp;
        waitAndSendKeys(databaseName, name, 30);
	}

	public void setSaveAsDraftOn() throws InterruptedException {
		waitAndClick(enableDraftRecords, 20);
	}

    public void clickSaveAndCreateButton() throws InterruptedException
    {
    	waitAndClick(saveAndCreateFormButton, 20);
    }

	public void clickOnEmailElement() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		waitAndClick(emailElement, 20);
	}

	public void clickOnRevertPopup() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		waitAndClick(revertStagePopup, 20);
		waitAndClick(revertToStageOne, 20);
		waitAndClick(revertButtonInPopup, 20);
	}

	public void clickOnPhoneElement() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		waitAndClick(phoneElement, 20);
	}

    public void clickOnTextElement() throws InterruptedException
    {
    	switchToIframe(databaseIframe);
    	waitAndClick(textElement, 20);
    }

	public void clickOnContinueButton() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		//waitAndClick(continueButton, 50);
		continueButton.click();
		Thread.sleep(2000);
	}

	public void clickOnRevertButton() throws InterruptedException
	{
		waitAndClick(revertButton, 20);
	}

	public void clickOnStageElement() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		waitAndClick(stageElement, 20);
	}

	public void clickOnSectionElement() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		waitAndClick(sectionElement, 20);
	}

	public void enterTextFieldTitle() throws InterruptedException
	{
		waitAndClick(addTextFieldTitle, 20);
		addTextFieldTitle.sendKeys("Brief Initiator");
		waitAndClick(saveAndCloseButton, 20);
	}

	public void enterPhoneFieldTitle() throws InterruptedException
	{
		waitAndClick(addPhoneTitle, 20);
		waitAndSendKeys(addPhoneTitle, "Collaborator Contact Number", 20);
		waitAndClick(saveAndCloseButton, 20);
	}

	public void enterEmailFieldTitle() throws InterruptedException
	{
		waitAndClick(addEmailTitle, 20);
		waitAndSendKeys(addEmailTitle, "Collaborator Email", 20);
		waitAndClick(saveAndCloseButton, 20);
	}

	public void enterTextFieldTitleStage2() throws InterruptedException
	{
		waitAndClick(addTextFieldTitle, 20);
		addTextFieldTitle.sendKeys("Summary of Business Recommendation");
		waitAndClick(saveAndCloseButton, 20);
	}

	public void enterStageTitle() throws InterruptedException
	{
		waitAndClick(enterStageName, 20);
		enterStageName.sendKeys(" - Legal Opinion Request");
		waitAndClick(saveAndCloseButton, 20);
	}

	public void enterSectionTitle() throws InterruptedException
	{
		waitAndClick(enterSectionName, 20);
		enterSectionName.sendKeys("Legal Collaborators ");
		waitAndClick(saveAndCloseButton, 20);
	}

	public void clickDatabaseLink() throws InterruptedException
	{
		//waitAndClick(databaseLink, 50);
		databaseLink.click();
		Thread.sleep(2000);
	}

	public void clickAddRecordButton() throws InterruptedException
	{
		switchToIframe(databaseIframe);
		//waitAndClick(addRecordButton, 70);
		addRecordButton.click();
		Thread.sleep(2000);
	}

	public void enterTextValue() throws InterruptedException
	{
		enterTextValue.click();
		waitAndSendKeys(enterTextValue, "Amila Rathnayaker", 20);
	}

	public void enterEmailValueInStage2() throws InterruptedException
	{
		enterEmailValue.click();
		waitAndSendKeys(enterEmailValue, "amila@gmail.com", 20);
	}

	public void enterPhoneValueInStage2() throws InterruptedException
	{
		enterPhoneValue.click();
		waitAndSendKeys(enterPhoneValue, "0423554578", 20);
	}

	public void enterTextValueInStage2() throws InterruptedException
	{
		enterTextValue.click();
		waitAndSendKeys(enterTextValue, "Summary", 20);
	}

	public void clickOnNumberElement() throws InterruptedException
	{
		waitAndClick(numberElement, 20);
	}

	public void selectStagedDatabase() throws InterruptedException
	{
		waitAndClick(stagedDatabaseOption, 20);
	}

	public void enterNumberFieldTitle() throws InterruptedException
	{
		waitAndClick(addNumberFieldTitle, 20);
		addNumberFieldTitle.sendKeys("Form ID");
		waitAndClick(saveAndCloseButton, 20);
	}

	public void enterNumberValue() throws InterruptedException
	{
		waitAndClick(enterNumberValue, 20);
		waitAndSendKeys(enterNumberValue, "112233", 20);
	}

	public void clickOnDateElement() throws InterruptedException
	{
		waitAndClick(dateElement, 20);
	}

	public void enterDateFieldTitle() throws InterruptedException
	{
		addDateFieldTitle.click();
		addDateFieldTitle.sendKeys("Submitted Date");
		setDefaultToToday.click();
		waitAndClick(saveAndCloseButton, 20);
	}

	public void clickSaveAsDraftButton() throws InterruptedException
	{
		//waitAndClick(saveAsDraftbutton, 40);
		saveAsDraftbutton.click();
		Thread.sleep(2000);
	}

	public void clickRecordEditAction() throws InterruptedException
	{
		//waitAndClick(recordEditAction, 50);
		recordEditAction.click();
		Thread.sleep(2000);
	}

	public void closeSearchBar() throws InterruptedException
	{
		//waitAndClick(closeSearchBar, 40);
		closeSearchBar.click();
		Thread.sleep(2000);
	}

	public void editTextField() throws InterruptedException
	{
        WebElement toClear = driver.findElement(By.xpath("//div[contains(@class,'_textField_')][contains(.,'t')]//input"));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        waitAndSendKeys(enterTextValue, "Sihas De Silva", 20);
	}

    public void editNumberField() throws InterruptedException
    {
        WebElement toClear = driver.findElement(By.xpath("//div[contains(@class,'_entireNumberContainer_')][contains(.,'t')]//input"));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        waitAndSendKeys(enterNumberValue, "88888888", 20);
    }

	public void clickSaveAndExitButton() throws InterruptedException
	{
		//waitAndClick(saveAndExitButton, 30);
		saveAndExitButton.click();
		Thread.sleep(2000);
	}

	public void clickSaveAndNextButton() throws InterruptedException
	{
		//waitAndClick(saveAndNextButton, 30);
		saveAndNextButton.click();
		Thread.sleep(2000);
	}

	public void checkSaveAndExitButton() {
		waitAndAssertVisibility(10, addRecordSaveAndExitButton,
				"The Save and Exit buton was not diplayed so it is likely you are not on the add record page");
	}

	public void assertOnPage(String pagename) {
		switchToIframe(databaseIframe);
		assertOnPage(pageTitle, pagename);
	}
}
