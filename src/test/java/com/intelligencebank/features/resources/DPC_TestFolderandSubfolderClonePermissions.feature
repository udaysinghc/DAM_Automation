Feature: Folder and Sub-Folder permissions are cloned
  As a user
  I want folder and subfolder permissions to be cloned when I clone a folder
  To save the effort in re-configuring the permissions every tim I clone folders

  Background:
    Given the permissions on the 'Clone Folder - Test Permissions' folder are:
      | User         | Permissions |
      | Test Group 1 | Preview     |
      | Test Group 2 | Access      |
      | Test Group 3 | Publish     |
      | Test Group 4 | Admin       |

  @DPC @DeleteClonedPermissionsFolders
  Scenario: Clone permissions
    Given I am logged in as an Admin
    And I select the 'TESTING UAT FOLDER' menu option
    When I clone a folder 'Clone Folder - Test Permissions' to 'Clone "To" Folder'
    Then the cloned subfolder 'This subfolder has no permissions set' has no permissions set
    But the cloned subfolder 'This subfolder has permissions set' has permissions set the same as its parent folder