Feature: Move large files
  As a user
  I want to be able to move large files
  In a timely manner

  @MoveFileBack @DPC
  Scenario: Moving large files should take less than 1 minute
    Given I am logged in as an Admin
    And I select the 'TESTING UAT FOLDER' menu option
    When I move the file '415mb file for large file testing' in 'Large File for Move Testing' to 'Move "To"'
    Then it should take less than 120 seconds