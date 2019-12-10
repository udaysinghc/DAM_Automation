package com.intelligencebank.pageObjects;

import com.intelligencebank.utils.CucumberTestContext;
import com.intelligencebank.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class BasePage {

	protected WebDriver driver;

	@FindBy(xpath="//a[contains(text(),'Admin')]")
	WebElement Admin;	

	@FindBy(xpath="//a[contains(text(),'Database')]")
	WebElement Database;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMenuAdmin() throws InterruptedException {
		Admin.click();
		Thread.sleep(5000);
	}

	public void clickMenuDatabase() throws InterruptedException {
		waitAndClick(Database, 20);
	}

	public WebElement waitAndReturnElement(By by, long timeoutSecs) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutSecs);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException ex) {
			Assert.fail("Element was not returned in time");
		}
		return driver.findElement(by);
	}

	public void waitAndClick(WebElement webElement, long timeOutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}

	public void waitAndClick(By by, long timeOutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	public void switchOutOfIframe() {
		driver.switchTo().defaultContent();
	}

	public void waitAndAssertVisibility(long timeOut, WebElement element, String errorText) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException ex) {
			Assert.fail(errorText);
		}
	}

	public void waitAndAssertVisibility(long timeOut, By by, String errorText) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
		try {
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException ex) {
			Assert.fail(errorText);
		}
	}

	public void selectReactSelectionListOpt(String wantedOption, By menuLocator) {
		WebElement element = driver.findElement(menuLocator)
				.findElement(By.xpath(String.format(".//div[text()='%s']", wantedOption)));
		element.click();
	}

    public void tryClickHandleIframe(WebElement elementToClick, WebElement iframeElement, long timeoutSecs) {
        try{
            waitAndClick(elementToClick, timeoutSecs);
        } catch (NoSuchElementException ex) {
            switchToIframe(iframeElement);
            waitAndClick(elementToClick, timeoutSecs);
        }
    }

    public void switchToIframe(WebElement iframeElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        try {
			webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
		} catch (TimeoutException ex) {
        	// not doing anything with this because you might just want to continue anyway
		}
    }

	protected void takeScreenshot(String screenshotFilename) throws Throwable {
		CucumberTestContext tc = new CucumberTestContext();
		String scenarioName = tc.getScenarioContext().getValue("ScenarioName").toString();

		WebDriverManager webDriverManager = tc.getWebDriverManager();
		webDriverManager.takeScreenshot(scenarioName, screenshotFilename);
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void waitAndSendKeys(WebElement element, String keysToSend, long timeOutSecs) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutSecs);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception ex) {
			Assert.fail(String.format("Problem sending keys to element"));
		}
		element.sendKeys(keysToSend);
	}

    public boolean isElementPresent(WebElement element) {
        boolean isDisplayed;
        try {
            isDisplayed = element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean isElementPresent(By by) {
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(by).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean waitAndIsElementPresent(WebElement element) {
		return waitAndIsElementPresent(element, 5);
    }

    public boolean waitAndIsElementPresent(By by) {
		return waitAndIsElementPresent(by, 5);
    }

    public boolean waitAndIsElementPresent(WebElement element, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException ex) {
			return false;
		}
		return true;
	}

	public boolean waitAndIsElementPresent(By by, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException ex) {
			return false;
		}
		return true;
	}

    public void assertOnPage(WebElement elem, String pagename) {
		boolean isPresent = waitAndIsElementPresent(elem);
		String errorMessage = String.format("The element was not on the page, indicating the %s page hasnt loaded",
				pagename);
		Assert.assertTrue(isPresent, errorMessage);
	}

	public void assertOnPage(By by, String pagename) {
		boolean isPresent = waitAndIsElementPresent(by);
		String errorMessage = String.format("The element was not on the page, indicating the %s page hasnt loaded",
				pagename);
		Assert.assertTrue(isPresent, errorMessage);
	}
}
