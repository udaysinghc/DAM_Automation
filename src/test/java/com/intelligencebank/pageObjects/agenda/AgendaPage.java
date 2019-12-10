package com.intelligencebank.pageObjects.agenda;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AgendaPage extends BasePage {

	public WebDriver driver;
	
	@FindBy(xpath = "//*[text()='Agenda']")
	WebElement AgendaMenuLink;

	@FindBy(xpath = "//span[text()='Agendas']")
	WebElement pageTitle;
	
	@FindBy(xpath = "//*[@id='moduleToolbar']/span[1]/a")
	WebElement AddAgendaButton;
	
	@FindBy(xpath = "//*[@name = 'name']")
	WebElement AgendaNameTextBox;
	
	@FindBy(id = "s2id_calendar")
	WebElement SelectCalenderDropDown;
	
	@FindBy(id = "s2id_linkCalendarEvent")
	WebElement SelectCalenderEventDropDown;
	
	@FindBy(xpath = "//input[@value = 'custom']")
	WebElement CustomAgendaTypeRadioButton;
	
	@FindBy(xpath = "//input[@value = 'synced']")
	WebElement SyncAgendaTypeRadioButton;
	
	@FindBy(id = "conversationItem")
	WebElement CustomAgendaItemTextBox;
	
	@FindBy(id = "addConversationItem")
	WebElement CustomAgendaItemAddButton;
	
	@FindBy(id = "addAgendaItemsBtn")
	WebElement ItemAddButton;
	
	@FindBy(id = "addSyncedFolderBtn")
	WebElement ItemAddUpdateButon;
	
	@FindBy(id = "autoNumbering")
	WebElement AutoNumberingCheckBox;
	
	@FindBy(xpath = "//input[@name = 'collapsable']")
	WebElement CollapsableAgendaCheckBox;
	
	@FindBy(xpath = "//input[@value = 'default']")
	WebElement IconTypeDefaultRadioButton;
	
	@FindBy(xpath = "//input[@value = 'custom']")
	WebElement IconTypeCustomRadioButton;
	
	@FindBy(xpath = "//input[@value = 'Save']")
	WebElement SaveButton;
	
	@FindBy(xpath = "//button[@name = 'fsActions[exitBtn]']")
	WebElement CancelButton;
	
	@FindBy(xpath = "//*[@id='agendatoolbarDropdown']")
	WebElement ToolBarDropDown;
	
	@FindBy(xpath = "//span[text() = 'Copy Agenda']")
	WebElement CopyAgendaLink;

	public AgendaPage(WebDriver driver) {
		super(driver);
	}

	public void clickAgendaLink()
	{
		AgendaMenuLink.click();
	}
	
	public void clickAddAgenda() throws InterruptedException 
	{
		AddAgendaButton.click();
		Thread.sleep(5000);
	}
	
	public void addcustomAgendaName(String customAgendaName) throws InterruptedException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());    
		String name = customAgendaName + "_"+ timeStamp;
		AgendaNameTextBox.sendKeys(name);
		Thread.sleep(5000);
	}
	
	public void selectCustomTypeAgenda() throws InterruptedException
	{
		CustomAgendaTypeRadioButton.click();
		Thread.sleep(5000);
	}
	
	public void selectSyncTypeAgenda() throws InterruptedException
	{
		SyncAgendaTypeRadioButton.click();
		Thread.sleep(5000);
	}
	
	public void selectFolderToAdd() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text() = 'review date test']")).click();
		Thread.sleep(5000);
	}
	
	public void clickAddResourceButton() throws InterruptedException
	{
		ItemAddButton.click();
		Thread.sleep(5000);
	}
	
	public void clickAddUpdateButton() throws InterruptedException
	{
		ItemAddUpdateButon.click();
		Thread.sleep(5000);
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		SaveButton.click();
		Thread.sleep(15000);
	}
	
	public void clickCopyAgenda() throws InterruptedException
	{
		ToolBarDropDown.click();
		Thread.sleep(1000);
		CopyAgendaLink.click();
	}

	public void assertOnPage(String pagename) {
		assertOnPage(pageTitle, pagename);
	}
}
