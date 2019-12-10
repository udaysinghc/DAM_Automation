@DPC
Feature: AccessPermissions
  As a test user
  I want to only access resources
  That I have permission to access

  Background:
    Given I am logged in as an 'test1'
    And I select the 'TESTING UAT FOLDER' menu option

  Scenario: Preview Permissions
    Given the user 'test1' has navigated to the 'Test Permissions on subfolders' folder
    When the user has navigated to the 'Preview' folder
    Then the options are available for the 'Preview Subfolder file' file:
      | Function           | Enabled |
      | Reader             | x       |
      | Download           |         |
      | Info               | x       |
      | Email Link         | x       |
      | Add File           |         |
      | Bulk Upload        |         |
      | Edit / New Version |         |
      | Delete File        |         |
      | Move File          |         |
      | Create Alias       |         |
      | Add Folder         |         |

  Scenario: Access Permissions
    Given the user 'test1' has navigated to the 'Test Permissions on subfolders' folder
    When the user has navigated to the 'Access' folder
    Then the options are available for the 'Access Subfolder file' file:
      | Function           | Enabled |
      | Reader             | x       |
      | Download           | x       |
      | Info               | x       |
      | Email Link         | x       |
      | Add File           |         |
      | Bulk Upload        |         |
      | Edit / New Version |         |
      | Delete File        |         |
      | Move File          |         |
      | Create Alias       |         |
      | Add Folder         |         |

  Scenario: Publish Permissions
    Given the user 'test1' has navigated to the 'Test Permissions on subfolders' folder
    When the user has navigated to the 'Publish' folder
    Then the options are available for the 'Publish Subfolder file' file:
      | Function           | Enabled |
      | Reader             | x       |
      | Download           | x       |
      | Info               | x       |
      | Email Link         | x       |
      | Add File           | x       |
      | Bulk Upload        | x       |
      | Edit / New Version | x       |
      | Delete File        | x       |
      | Move File          | x       |
      | Create Alias       | x       |
      | Add Folder         |         |

  Scenario: Admin Permissions
    Given the user 'test1' has navigated to the 'Test Permissions on subfolders' folder
    When the user has navigated to the 'Admin' folder
    Then the options are available for the 'Admin Subfolder file' file:
      | Function           | Enabled |
      | Reader             | x       |
      | Download           | x       |
      | Info               | x       |
      | Email Link         | x       |
      | Add File           | x       |
      | Bulk Upload        | x       |
      | Edit / New Version | x       |
      | Delete File        | x       |
      | Move File          | x       |
      | Create Alias       | x       |
      | Add Folder         | x       |
