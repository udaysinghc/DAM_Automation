Feature: Resource Functionality
As a user 
I want to be able to upload resources
So that I can share it later

Background: 
  Given user visits IB platform website
    And an admin user successfully logs in

@smoke @ignore
Scenario: Add a new folder in resource module
  Given user navigates to the Resource page
  When user clicks on Add button
    And user clicks on Add New Folder button
    And user enters the name for the folder as "TestFolder"
    And user clicks on the default radio button for icon type
    And user clicks on the Save button on add new folder page
  Then verify the new folder is added
  
@smoke @ignore
Scenario: Add a single resource to the newly created folder
  Given user navigates to the Resource page
    And user creates a new folder with folder name as "TestFolder"
  When user clicks on the newly created folder
    And user clicks on Add Resource button from the empty folder
    And user selects the type as File
    And user upload the single file
    And user enters the name for the resource as "NewResource"
    And user selects the watermark type as None
    And user selects the file type icon as Default
    And user clicks on the Save button on add new resource page
  Then verify the resource is added successfully
