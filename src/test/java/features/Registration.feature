Feature: Registration Functionaliy
As a person new to the system
I want to be able to register
So I can start using the system

@overnight @ignore
Scenario: Successful Registration
  Given user visits IB platform website 
  When user clicks on the login button for homepage
    And user clicks on the Register link on the login page
    And user ends the mandatory fields
    | FirstName | LastName | Email          | 
    | Test      | Test     | test@email.com | 
    And user clicks on the Register button
  Then verify the user email for password creation is send
          
@overnight @ignore
Scenario Outline: Verify different error message
  Given user visits IB platform website 
    When user clicks on the login button for homepage
    And user clicks on the Register link on the login page
    And user enters the First Name as <firstname>
    And user enters the Last Name as <lastname>
    And user enters the email as <email>
    And user clicks on the Register button
  Then verify the correct errormessage is displayed for correct field type <errormessage>, <errorfield>
  
  Examples: 
    | firstname | lastname | email                    | errormessage                                                                                                                                                              | errorfield | 
    |           |          |                          | We found errors while submitting your registration request. Update the information below, or check that this email address has not been registered already and try again. | general    | 
    |           | Saraiya  | namreshsaraiya@gmail.com | Value is required and can't be empty                                                                                                                                      | firstname  | 
    | Namresh   |          | namreshsaraiya@gmail.com | Value is required and can't be empty                                                                                                                                      | lastname   | 
    | Namresh   | Saraiya  |                          | Value is required and can't be empty                                                                                                                                      | emailempty | 
    | Namresh   | Saraiya  | n@g.                     | The Email Address is in an invalid format, e.g. myemail@myaddress.com!                                                                                                    | wrongemail | 

