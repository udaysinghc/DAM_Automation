Feature: Navigate through site
  As an Admin User
  I want to navigate around the site
  To verify the site is up and running

  @smoke
  Scenario Outline: Top menu navigation
    Given I am logged in as an Admin
    When I select the '<menuOption>' menu option
    Then I will see the '<menuOption>' page
    Examples:
      | menuOption     |
      | My Collections |
      | My Account     |
      | Authenticator  |
      | Admin          |
      | News           |
      | Custom Page    |
      | Resource       |
      | Feeds          |
      | Report         |
      | Stats          |
      | People         |
      | Workflow       |
      | Database       |
      | Survey         |
      | Calendar       |
