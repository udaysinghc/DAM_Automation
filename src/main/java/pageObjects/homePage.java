package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	public WebDriver driver;
	
	@FindBy(how= How.XPATH, using= "//a[@id='menu-language']/li/a")
	WebElement Loginbutton;
	
	
	
	public homePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickLoginbutton() throws InterruptedException
	{
		//boolean a = driver.findElement(By.xpath("//a[@id='menu-language']/li/a")).isDisplayed();
		Loginbutton.click();
		
	}
}
