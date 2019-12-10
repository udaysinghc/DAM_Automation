@Resources @DPC
Feature: Create Folders/Subfolders, navigation and settings
  As a user
  I want to be able to create subfolders
  So I can store files, navigate through then and control the settings

  Background:
    Given I am logged in as an Admin
    And I select the 'TESTING UAT FOLDER' menu option

  @DeleteFolders
  Scenario: Breadcrumbs updated
    Given I add a Folder
    And complete the Add New Folder Form
    When I add a Subfolder within that
    Then the Breadcrumb line is updated
    And the home button works

  @FileSortData
  Scenario Outline: Default Order: <defaultOrderSetting>
    Given I edit folder settings for the folder 'Folder Settings Test'
    When I change the 'Default Order' setting to '<defaultOrderSetting>'
    Then the files are sorted '<sortingType>'
    Examples:
      | defaultOrderSetting | sortingType     |
      | Alphabetical        | Alphabetically  |
      | Resource Date       | Chronologically |

  @ListView
  Scenario Outline: Default Layout: <defaultLayoutSetting>
    Given I edit folder settings for the folder 'Folder Settings Test'
    When I change the 'Default Layout' setting to '<defaultLayoutSetting>'
    Then the '<defaultLayoutSetting>' view is displayed by default
    Examples:
      | defaultLayoutSetting |
      | Images               |
      | List                 |

  @DeleteSubfolder
  Scenario: Force Watermark isn't inherited by subfolders
    Given I edit folder settings for the folder 'Folder Settings Test'
    When the Force Watermark setting is set to 'true'
    And I add a Subfolder
    Then the Force Watermark setting is set to 'false' on the subfolder