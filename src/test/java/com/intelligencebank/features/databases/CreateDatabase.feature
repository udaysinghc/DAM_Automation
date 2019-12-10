@databases
Feature: Creating a Database
  As a admin user on database module
  I want to create a database
  So that I can smoke test the application

  Background:
    Given the user logged in as an Admin on database

  @smoke
  Scenario: Create Database
    Given the user opens the Database Settings page
    When the user fills in the Database form and clicks save
    Then the database will be created