package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.addnewworkflowPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import utils.DriverFactory;

public class workflow extends DriverFactory{
	
	addnewworkflowPage anP;	
	
	@Given("^user navigates to the admin page$")
    public void user_navigates_to_the_admin_page() throws Throwable {
	    // TODO: Move to pageBucket class and lazy instantiate		
		anP= new addnewworkflowPage(driver);
		anP.clickAdminMenuLink();        
    }

    @When("^user clicks on Create Workflow button$")
    public void user_clicks_on_create_workflow_button() throws Throwable {
        anP.clickCreateWorkflowButton();
    }

    @Then("^verify the publish workflow is created$")
    public void verify_the_publish_workflow_is_created() throws Throwable {
        // TODO: Implement
        // throw new UnsupportedOperationException();        
    }

    @And("^user clicks on Workflows Tab$")
    public void user_clicks_on_workflows_tab() throws Throwable {
    	anP.clickWorkflowLink();
    }

    @And("^user adds the workflow name as \"([^\"]*)\"$")
    public void user_adds_the_workflow_name_as_something(String workflowname) throws Throwable {
    	anP.setName(workflowname);        
    }

    @And("^user selects the worklow type as \"([^\"]*)\"$")
    public void user_selects_the_worklow_type_as_something(String workflowtype) throws Throwable {
    	anP.selectWorkflow(workflowtype);
    }

    @And("^user selects the tool as \"([^\"]*)\"$")
    public void user_selects_the_tool_as_something(String tooltype) throws Throwable {
    	anP.selectToolType(tooltype);        
    }

    @And("^user selects review process as \"([^\"]*)\"$")
    public void user_selects_review_process_as_something(String reviewprocess) throws Throwable {
        anP.selectReviewProcess(reviewprocess);
    }

    @And("^user selects Global as \"([^\"]*)\"$")
    public void user_selects_global_as_something(String globalsettings) throws Throwable {
    	anP.selectGlobalSettings(globalsettings);
    }

    @And("^user selects Mandatory as \"([^\"]*)\"$")
    public void user_selects_mandatory_as_something(String mandatoryfields) throws Throwable {
    	anP.selectMandatory(mandatoryfields);
    }

    @And("^user selects Reviewers as \"([^\"]*)\"$")
    public void user_selects_reviewers_as_something(String reviewers) throws Throwable {
    	anP.selectReviewers(reviewers);
    }

    @And("^user selects Auto Complete When Declined as \"([^\"]*)\"$")
    public void user_selects_auto_complete_when_declined_as_something(String autocomplete) throws Throwable {
    	anP.selectAutomCompleteSettings(autocomplete);
    }

    @And("^user selects Yes with Comments as \"([^\"]*)\"$")
    public void user_selects_yes_with_comments_as_something(String commentssettings) throws Throwable {
    	anP.selectCommentSettings(commentssettings);
    }

    @And("^user selects Required By Field as \"([^\"]*)\"$")
    public void user_selects_required_by_field_as_something(String requirebyfield) throws Throwable {
    	anP.selectRequireByFieldSettings(requirebyfield);
    }

    @And("^user selects Allow Empty Comments as \"([^\"]*)\"$")
    public void user_selects_allow_empty_comments_as_something(String emptycommentsoption) throws Throwable {
    	anP.selectCommentOptionSettings(emptycommentsoption);
    }

    @And("^user selects Comments Field Type as \"([^\"]*)\"$")
    public void user_selects_comments_field_type_as_something(String commentsfieldtype) throws Throwable {
    	anP.selectCommentFieldTypeSettings(commentsfieldtype);
    }

    @And("^user selects User Notifications as \"([^\"]*)\"$")
    public void user_selects_user_notifications_as_something(String usernotifications) throws Throwable {
    	anP.selectUserNotificationSettings(usernotifications);
    }
    
    @And("^user selects Request Form as \"([^\"]*)\"$")
    public void user_selects_request_form_as_something(String requestformType) throws Throwable {
    	anP.selectRequestFormType(requestformType);
    }

    @And("^user clicks on the Save button on workflow page$")
    public void user_clicks_on_the_save_button_on_workflow_page() throws Throwable {
        anP.clickSaveButton();
    }
}
