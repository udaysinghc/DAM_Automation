package com.intelligencebank.pageObjects.admin;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminBasePage extends BasePage {

	@FindBy(xpath = "//a[contains(.,'Groups')]")
	WebElement groupsTab;

	@FindBy(xpath="//a[contains(text(),'Users')]")
	WebElement usersTab;
	
	@FindBy(xpath="//*[text()='Workflows']")
	WebElement workflowsTab;

	public AdminBasePage(WebDriver driver) {
		super(driver);
	}

	public void selectTab(String tabName) {
		switch(tabName.toLowerCase()) {
			case "users":
				clickUserTab();
				break;
			case "groups":
				clickGroupsTab();
				break;
			case "workflows":
				clickWorkflowsTab();
				break;
		}
	}

	public void clickGroupsTab() {
		waitAndClick(groupsTab, 10);
		waitAndClick(groupsTab, 10);
	}

	public void clickUserTab() {
		try {
			waitAndClick(usersTab, 10);
		} catch (NoSuchElementException ex) {
			// likely you are already on the tab
		}
	}

	public void clickWorkflowsTab() {
		waitAndClick(workflowsTab, 10);
	}

	protected WebElement getElementByText(List<WebElement> elements, String desiredText) throws InterruptedException {
		Thread.sleep(1000);
		for(int i = 0; i < elements.size(); i++) {
			String elementText = elements.get(i).getText();
			if(elementText.equals(desiredText)) {
				return elements.get(i);
			}
		}
		return null;
	}

	public void assertOnPage(String pagename) {
		assertOnPage(groupsTab, pagename);
		assertOnPage(usersTab, pagename);
		assertOnPage(workflowsTab, pagename);
	}
}
