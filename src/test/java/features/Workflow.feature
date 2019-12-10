Feature: Workflows
Create different type of Workflows

Background: 
  Given user visits IB platform website
    And an admin user successfully logs in
  
@overnight
Scenario: Create Publish Workflow for Resources
  Given user navigates to the admin page
    And user clicks on Workflows Tab
  When user clicks on Create Workflow button
    And user adds the workflow name as "TestPublishWorkFlow"
    And user selects the worklow type as "Publish"
    And user selects the tool as "Resources"
    And user selects review process as "Standard"
    And user selects Global as "Yes"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Yes with Comments as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
  Then verify the publish workflow is created

@overnight
Scenario: Create Feedback Workflow for Resources
  Given user navigates to the admin page
    And user clicks on Workflows Tab
  When user clicks on Create Workflow button
    And user adds the workflow name as "TestFeedbackWorkFlow"
    And user selects the worklow type as "Feedback"
    And user selects the tool as "Resources"
    And user selects review process as "Standard"
    And user selects Global as "Yes"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Yes with Comments as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
    Then verify the publish workflow is created
     
@overnight
Scenario: Create Download Workflow for Resources
  Given user navigates to the admin page
    And user clicks on Workflows Tab
  When user clicks on Create Workflow button
    And user adds the workflow name as "TestDownloadWorkFlow"
    And user selects the worklow type as "Download"
    And user selects the tool as "Resources"
    And user selects Global as "Yes"
    And user selects Request Form as "Default"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
  Then verify the publish workflow is created
     
@overnight
Scenario: Create Publish Workflow for Database
  Given user navigates to the admin page
    And user clicks on Workflows Tab
  When user clicks on Create Workflow button
    And user adds the workflow name as "TestPublishWorkFlow"
    And user selects the worklow type as "Publish"
    And user selects the tool as "Databases"
    And user selects review process as "Standard"
    And user selects Global as "Yes"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Yes with Comments as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
  Then verify the publish workflow is created
       
@overnight
Scenario: Create Feedback Workflow for Database
  Given user navigates to the admin page
    And user clicks on Workflows Tab
    When user clicks on Create Workflow button
    And user adds the workflow name as "TestFeedbackWorkFlow"
    And user selects the worklow type as "Feedback"
    And user selects the tool as "Databases"
    And user selects review process as "Standard"
    And user selects Global as "Yes"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Yes with Comments as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
    Then verify the publish workflow is created
     
@overnight
Scenario: Create Publish Workflow for Survey
  Given user navigates to the admin page
    And user clicks on Workflows Tab
    When user clicks on Create Workflow button
    And user adds the workflow name as "TestPublishWorkFlow"
    And user selects the worklow type as "Publish"
    And user selects the tool as "Survey"
    And user selects review process as "Standard"
    And user selects Global as "Yes"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Yes with Comments as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
    Then verify the publish workflow is created
       
@overnight
Scenario: Create Feedback Workflow for Survey
  Given user navigates to the admin page
    And user clicks on Workflows Tab
  When user clicks on Create Workflow button
    And user adds the workflow name as "TestFeedbackWorkFlow"
    And user selects the worklow type as "Feedback"
    And user selects the tool as "Survey"
    And user selects review process as "Standard"
    And user selects Global as "Yes"
    And user selects Mandatory as "Yes"
    And user selects Reviewers as "Requesters Choice"
    And user selects Auto Complete When Declined as "Yes"
    And user selects Yes with Comments as "Yes"
    And user selects Required By Field as "Yes"
    And user selects Allow Empty Comments as "Yes"
    And user selects Comments Field Type as "Basic"
    And user selects User Notifications as "Yes"
    And user clicks on the Save button on workflow page
  Then verify the publish workflow is created

  