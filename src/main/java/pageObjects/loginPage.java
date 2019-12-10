package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;

public class loginPage {

	WebDriver driver;
	
	@FindBy(how= How.NAME, using= "username")
	WebElement usernameTextbox;
	
	@FindBy(how= How.NAME, using= "password")
	WebElement passwordTextbox;
	
	@FindBy(how= How.NAME, using= "submitBtn")
	WebElement Loginbutton;
	
	@FindBy(how=How.XPATH, using= "")
	WebElement errormessage;
	
	
	public loginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void setusername(String username)
	{
		usernameTextbox.sendKeys(username);
		
	}
	
	public void setpassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickloginbutton()
	{
		Loginbutton.click();
	}
	
	public void login(String username, String password)
	{
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		Loginbutton.click();
		//driver.findElement(By.id("menu-userDetail")).isDisplayed();
	}
	

	public void verifyErrormessage(String errormessage)
	{
		WebElement ele = driver.findElement(By.xpath("//*[@id='ib-alerts']/div/ul/li"));
		String message = ele.getText();
		Assert.assertEquals(message, errormessage);
		
	}
}
