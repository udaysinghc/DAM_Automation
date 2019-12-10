package pageObjects;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class resourcePage {

	WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//a[text() = 'Resource']")
	WebElement ResourceMenuLink;
	
	@FindBy(how=How.XPATH, using = ".//*[text()='Add']/ancestor::button")
	WebElement AddButton;
	
	@FindBy(how=How.XPATH, using = "//span[text() = 'Add Folder']")
	WebElement AddFolderButton;
	
	@FindBy(how=How.ID, using = "folderName")
	WebElement FolderNameTextBox;
	
	@FindBy(how=How.XPATH, using = "//textarea[@name = 'description']")
	WebElement DescriptionTextBox;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'default']")
	WebElement DefaultRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'custom']")
	WebElement CustomRadioButton;
	
	@FindBy(how=How.ID, using = "btnSave")
	WebElement SaveButton;
	
	@FindBy(how=How.XPATH, using = "//button[@name = 'fsActions[resetBtn]']")
	WebElement ResetButton;
	
	@FindBy(how=How.ID, using = "cancelSubmit")
	WebElement CancelButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='folderListView']/div[1]/div/div/div[1]/div[1]/div")
	WebElement NewlyCreatedFolderPath;
	
	public resourcePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickResourceMenuLink() throws InterruptedException
	{
		ResourceMenuLink.click();
		Thread.sleep(5000);
	}
	
	public void clickAddButton() throws InterruptedException
	{
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		AddButton.click();
		Thread.sleep(1000);
	}
	
	public void clickAddNewFolderButton() throws InterruptedException
	{
		AddFolderButton.click();
		Thread.sleep(1000);
	}
	
	public void setFolderName(String foldername) throws InterruptedException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		String name = foldername + "_" + timeStamp;
		FolderNameTextBox.sendKeys(name);
		Thread.sleep(1000);
	}
	
	public void selectDefaultRadioButton() throws InterruptedException
	{
		DefaultRadioButton.click();
		Thread.sleep(1000);
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		SaveButton.click();
		Thread.sleep(5000);
	}
	
	public void AddNewFolder(String foldername) throws InterruptedException
	{
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		AddButton.click();
		Thread.sleep(1000);
		AddFolderButton.click();
		Thread.sleep(1000);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		String name = foldername+ "_" + timeStamp;
		FolderNameTextBox.sendKeys(name);
		Thread.sleep(1000);
		DefaultRadioButton.click();
		Thread.sleep(1000);
		SaveButton.click();
		Thread.sleep(5000);
	}
	
	public void clickNewlyCreatedFolder() throws InterruptedException
	{
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		NewlyCreatedFolderPath.click();
		Thread.sleep(1000);
	}
	
}
