package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import pageObjects.addnewresourcePage;
import pageObjects.resourcePage;
import utils.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class resource extends DriverFactory {
	
	resourcePage rP;
	addnewresourcePage anrP;
	
	@Given("^user navigates to the Resource page$")
    public void user_navigates_to_the_resource_page() throws Throwable {
	    // TODO: Move to pageBucket class and lazy instantiate		
        rP = new resourcePage(driver);
		rP.clickResourceMenuLink();
    }

    @When("^user clicks on Add button$")
    public void user_clicks_on_add_button() throws Throwable {
        rP.clickAddButton();
    }
    
    @When("^user clicks on the newly created folder$")
    public void user_clicks_on_the_newly_created_folder() throws Throwable {
        rP.clickNewlyCreatedFolder();
    }

    @Then("^verify the new folder is added$")
    public void verify_the_new_folder_is_added() throws Throwable {
    	driver.switchTo().frame(0);
		Thread.sleep(1000);

        WebElement folderadded = driver.findElement(By.xpath("//*[@id='folderListView']/div[1]/div/div/div[1]/div[1]/div/div[2]/div[1]/a/div"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		String name = "TestFolder_" + timeStamp;
		String foldername = folderadded.getText();
		//System.out.println(foldername);
		//System.out.println(name);
		Assert.assertTrue(foldername.contains(name));
    }

    @And("^user clicks on Add New Folder button$")
    public void user_clicks_on_add_new_folder_button() throws Throwable {
        rP.clickAddNewFolderButton();
    }

    @And("^user enters the name for the folder as \"([^\"]*)\"$")
    public void user_enters_the_name_for_the_folder_as_something(String foldername) throws Throwable {
        rP.setFolderName(foldername);
    }

    @And("^user clicks on the default radio button for icon type$")
    public void user_clicks_on_the_default_radio_button_for_icon_type() throws Throwable {
        rP.selectDefaultRadioButton();
    }

    @And("^user clicks on the Save button on add new folder page$")
    public void user_clicks_on_the_save_button_on_add_new_folder_page() throws Throwable {
    	rP.clickSaveButton();
    }
    
    @And("^user creates a new folder with folder name as \"([^\"]*)\"$")
    public void user_creates_a_new_folder_with_folder_name_as_something(String foldername) throws Throwable {
        rP.AddNewFolder(foldername);
    }
    
    @And("^user clicks on Add Resource button from the empty folder$")
    public void user_clicks_on_add_resource_button_from_the_empty_folder() throws Throwable {
	    // TODO: Move to pageBucket class and lazy instantiate		
        anrP = new addnewresourcePage(driver);
        anrP.clickAddResourceButton();
    }
    
    @And("^user selects the type as File$")
    public void user_selects_the_type_as_file() throws Throwable {
        anrP.clickFileRadioButton();
    }
    
    @And("^user enters the name for the resource as \"([^\"]*)\"$")
    public void user_enters_the_name_for_the_resource_as_something(String name) throws Throwable {
    	anrP.setName(name);
    }

    @And("^user selects the watermark type as None$")
    public void user_selects_the_watermark_type_as_none() throws Throwable {
        anrP.clickwatermarkType();
    }

    @And("^user selects the file type icon as Default$")
    public void user_selects_the_file_type_icon_as_default() throws Throwable {
        anrP.clickfileiconType();
    }

    @And("^user clicks on the Save button on add new resource page$")
    public void user_clicks_on_the_save_button_on_add_new_resource_page() throws Throwable {
    	anrP.clickSaveButton();       
    }
    
    @And("^user upload the single file$")
    public void user_upload_the_single_file() throws Throwable {
        anrP.uploadSingleFile();
    }
    
    @Then("^verify the resource is added successfully$")
    public void verify_the_resource_is_added_successfully() throws Throwable {
    	driver.switchTo().frame(0);
		Thread.sleep(1000);
    	WebElement resourcepath = driver.findElement(By.xpath("//*[@id='resourceListView']/div[1]/div/div/div/div/div[3]/div[2]/div[1]/div/span"));
    	//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		//String name = "testNewResource_" + timeStamp;
		String foldername = resourcepath.getText();
		Assert.assertTrue(foldername.contains("testNewResource_"),foldername);        
    }
}
