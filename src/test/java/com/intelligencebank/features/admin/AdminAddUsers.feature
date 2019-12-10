Feature: Add a User
  As an Admin
  I want to Add Users
  So they can use the system

  @smoke @DeleteUser
  Scenario: Add User Fields
    Given I am logged in as an Admin
    And I select the 'Admin' menu option
    And I select the 'Users' admin tab
    When I fill in the new user form
    Then the user is created