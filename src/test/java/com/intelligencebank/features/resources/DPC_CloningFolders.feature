Feature: Cloning folders
  As a user
  I want to be able to clone folders and delete the clones
  In a timely manner

  @DeleteClonedFolders @DPC
  Scenario: Clone folders should take less than 1 minute
    Given I am logged in as an Admin
    And I select the 'TESTING UAT FOLDER' menu option
    When I clone a folder 'Clone "From" Folder (1 folder with 46 sub folders)' to 'TESTING - UAT'
    Then it should take less than 60 seconds