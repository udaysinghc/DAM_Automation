Feature: Agenda Functionality
As an admin user
I should be able to add sync and custom agenda
so the user can create an online agenda for your Board Meetings.

Background: 
  Given user visits IB platform website
    And an admin user successfully logs in

@overnight @ignore
Scenario: Add a Custom Agenda
  Given user navigates to the Agenda Link
  When user clicks on Add Agenda Item
    And user adds the name to the agenda as "CustomAgenda"
    And user selects the Custom type agenda
    And user selects the folder to be added
    And user clicks on the add button for the folder to be added
    And user clicks on the Save button
  Then verify the custom agenda is successfully added

@overnight @ignore
Scenario: Add a Sync Agenda
  Given user navigates to the Agenda Link
  When user clicks on Add Agenda Item
    And user adds the name to the agenda as "SyncAgenda"
    And user selects the Sync type agenda
    And user selects the folder to be added
    And user clicks on the add update button for the folder to be added
    And user clicks on the Save button
  Then verify the sync agenda is successfully added

@overnight @ignore   
Scenario: Copy a Custom Agenda  
  Given user navigates to the Agenda Link
  When user clicks on Add Agenda Item
    And user adds the name to the agenda as "CustomAgenda"
    And user selects the Custom type agenda
    And user selects the folder to be added
    And user clicks on the add button for the folder to be added
    And user clicks on the Save button
    And user clicks on the drop down and clicks on Copy Agenda
  Then verify the agenda item is copied correctly
    And user adds the name to the agenda as "CopyCustomAgenda"
    And user selects the Custom type agenda
    And user selects the folder to be added
    And user clicks on the add button for the folder to be added
    And user clicks on the Save button
  Then verify the copy custom agenda is successfully added

