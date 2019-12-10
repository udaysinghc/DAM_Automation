Feature: Add folders
  As a user
  I want to be able to add folders and delete them

  @smoke
  Scenario: Add Folders
    Given I am logged in as an Admin
    And I select the 'Resource' menu option
    When I add a Folder
    And complete the Add New Folder Form
    Then the new folder is visible in the folders view