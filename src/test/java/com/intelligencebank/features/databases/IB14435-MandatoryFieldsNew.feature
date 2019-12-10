@databases
Feature: Save as draft testing
  As a user when I try to save the record as draft
  If I have not entered the title field or have entered invalid format for the fields
  I should be restricted insaving the record as draft with proper error messages
  Background:
  Given Admin on database logs into the system

  Scenario: Verify that user is not allowed to save a record as draft if title field was not entered.
    Given Admin user creates a database with save draft enabled
    When Admin tries to save the record as draft without entering the 'title' field
    Then user should not be allowed to save the record as draft and proper error message should be displayed under 'title' field

  Scenario: Verify that user is not allowed to save a record as draft if title field was not entered.
    Given Admin user creates a database with save draft enabled
    When Admin tries to save the record as draft without entering the 'email' field
    Then user should not be allowed to save the record as draft and proper error message should be displayed under 'email' field

  Scenario: Verify that user is not allowed to save a record as draft if title field was not entered.
    Given Admin user creates a database with save draft enabled
    When Admin tries to save the record as draft without entering the 'phone' field
    Then user should not be allowed to save the record as draft and proper error message should be displayed under 'phone' field

