Feature: UserManagement Functionality
As an admin user
I want to be able to manage the users for my Tenant
So that I can confifgure who can access the Tenant and their permissions

# Migrated from AddUsers.java
@Ignore
Scenario: Add a new user
    Given I am logged in as an Admin
        And I am on the "Manage Users" page
    When I click on "Add User" button
        And I enter "Firstname" into the "Firstname" field
        And I enter "Lastname" into the "Lastname" field
        And I enter "first.last@someemail.com" into the "EMail" field
        And I click on the "Save" button
    Then I expect to see a popup with title ""
    When I click on the "Ok" button
    Then I expect to be on the "Manage Users" page

