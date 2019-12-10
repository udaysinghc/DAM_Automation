package com.intelligencebank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	public WebElement LogoutLink;

	@FindBy(id = "menu-userDetail")
	WebElement userDetailMenu;

	@FindBy(linkText = "Logout")
	WebElement logoutMenuOption;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean logoutLinkExists() {
		try	{
			WebElement logoutLinkExist = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			return (logoutLinkExist != null);	
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean login() {
		return this.LogoutLink.isDisplayed();
	}

	public void logoutFromMenu() {
		waitAndClick(userDetailMenu, 10);
		waitAndClick(logoutMenuOption, 10);
	}

	public void clickMenuOption(String menuOption) throws InterruptedException {
		switchOutOfIframe();
		By by = By.linkText(menuOption);
		Actions builder = new Actions(driver);
		builder.moveToElement(waitAndReturnElement(by, 10));
		builder.perform();
		Thread.sleep(1000);
		waitAndClick(by, 10);
	}

	public void clickResourceButton() throws InterruptedException {
		clickMenuOption("Resource");
	}
}
