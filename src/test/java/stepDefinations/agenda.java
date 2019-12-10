package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import pageObjects.agendaPage;
import utils.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class agenda extends DriverFactory{

	agendaPage ap;
	
	@Given("^user navigates to the Agenda Link$")
	public void user_navigates_to_the_agenda_link() throws Throwable {
        // TODO: Move to pageBucket class and lazy instantiate		
		ap = new agendaPage(driver);
		ap.clickAgendaLink();		
	}
	 
	@When("^user clicks on Add Agenda Item$")
	public void user_clicks_on_add_agenda_item() throws Throwable {
		ap.clickAddAgenda();
	}
	 
	@And("^user adds the name to the agenda as \"([^\"]*)\"$")
	public void user_adds_the_name_to_the_agenda_as_something(String customAgendaName) throws Throwable {
		ap.addcustomAgendaName(customAgendaName);
	}
	
	@And("^user selects the Custom type agenda$")
	public void user_selects_the_custom_type_agenda() throws Throwable {
		ap.selectCustomTypeAgenda();
	}
	
	@And("^user selects the Sync type agenda$")
	public void user_selects_the_sync_type_agenda() throws Throwable {
		ap.selectSyncTypeAgenda();
	}
	
	@And("^user selects the folder to be added$")
	public void user_selects_the_folder_to_be_added() throws Throwable {
		ap.selectFolderToAdd();
	}
	
	@And("^user clicks on the add button for the folder to be added$")
	public void user_clicks_on_the_add_button_for_the_folder_to_be_added() throws Throwable {
		ap.clickAddResourceButton();
	}
	    
	@And("^user clicks on the add update button for the folder to be added$")
	public void user_clicks_on_the_add_update_button_for_the_folder_to_be_added() throws Throwable {
		ap.clickAddUpdateButton();
	}
	
	@And("^user clicks on the Save button$")
	public void user_clicks_on_the_save_button() throws Throwable {
		ap.clickSaveButton();
	}
	
	@Then("^verify the custom agenda is successfully added$")
	public void verify_the_custom_agenda_is_successfully_added() throws Throwable {
		WebElement ele = driver.findElement(By.xpath("//*[@id='ib-alerts']/div"));
		String message = ele.getText();
		Assert.assertTrue(message.contains("Success"));
		WebElement agendaadded = driver.findElement(By.xpath("//*[@id='agendaContainer']/section[3]/section[1]/div[2]/h6/a"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String name = "CustomAgenda_" + timeStamp;
		String foldername = agendaadded.getText();
		Assert.assertTrue(foldername.contains(name));
	}
	    
	@Then("^verify the sync agenda is successfully added$")
	public void verify_the_sync_agenda_is_successfully_added() throws Throwable {
		WebElement ele = driver.findElement(By.xpath("//*[@id='ib-alerts']/div"));
		String message = ele.getText();
		Assert.assertTrue(message.contains("Success"));
		WebElement agendaadded = driver.findElement(By.xpath("//*[@id='agendaContainer']/section[3]/section[1]/div[2]/h6/a"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String name = "SyncAgenda_" + timeStamp;
		String foldername = agendaadded.getText();
		Assert.assertTrue(foldername.contains(name));
	}
	
	@Then("^verify the agenda item is copied correctly$")
	public void verify_the_agenda_item_is_copied_correctly() throws Throwable {
		WebElement ele = driver.findElement(By.xpath("//*[@id='agendaContentContainer']/ol/li/ol/li/span[1]"));
		String message = ele.getText();
		Assert.assertTrue(message.contains("BDD-101-Ebook"));	        
	}

	@And("^user clicks on the drop down and clicks on Copy Agenda$")
	public void user_clicks_on_the_drop_down_and_clicks_on_copy_agenda() throws Throwable {
		ap.clickCopyAgenda();
	}
	
	@Then("^verify the copy custom agenda is successfully added$")
	public void verify_the_copy_custom_agenda_is_successfully_added() throws Throwable {
		WebElement ele = driver.findElement(By.xpath("//*[@id='ib-alerts']/div"));
		String message = ele.getText();
		Assert.assertTrue(message.contains("Success"));

		WebElement agendaadded = driver.findElement(By.xpath("//*[@id='agendaContainer']/section[3]/section[1]/div[2]/h6/a"));
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String name = "CopyCustomAgenda_" + timeStamp;
		String foldername = agendaadded.getText();
		Assert.assertTrue(foldername.contains(name));
	}
}
