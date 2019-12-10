@databases
Feature: Saving records as a Draft status
  As a admin user on database module 
  I want to save a record as draft
  So I can save and continue with drafted record prior to the initial submission

 Background:
    Given the user logged in as an Admin on database

  Scenario: Enable Save As Draft option in Single database
    Given the user opens the Database Settings page
    When the user enabled 'Enable Draft RecordCustomPlural' checkbox in Single database
    Then the user see 'Save As Draft' button on the record page

  Scenario: Edit the drafted record and publish
    Given the user opens the Database Settings page
    And the user enabled 'Enable Draft RecordCustomPlural' checkbox in Single database
    And the user creates draft record
    When the user edits draft record
    Then the user should allow to publish drafted record

  Scenario: Enable Save As Draft option in Staged database
    Given the user opens the Database Settings page
    When the user enabled 'Enable Draft RecordCustomPlural' checkbox in Staged database
    Then the user see 'Save As Draft' button on the record page

  Scenario: Continue the drafted record and complete
    Given the user opens the Database Settings page
    And the user enabled 'Enable Draft RecordCustomPlural' checkbox in Staged database
    And the user creates draft record
    When the user continue draft record
    Then the user should allow to complete staged record

  Scenario: Revert the completed record and save as draft
    Given the user opens the Database Settings page
    And the user enabled 'Enable Draft RecordCustomPlural' checkbox in Staged database
    And the user submit a record
    When the user revert a record
    Then the user should allow to save staged record as draft