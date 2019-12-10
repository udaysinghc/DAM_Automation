Feature: Login Functionality
As a user 
I want to be able to login
So I can use the system personalised to me

@smoke @ignore
Scenario Outline: Successful Login
    Given user visits IB platform website 
	When user clicks on the login button for homepage
	    And user enters the username as "<username>"
        And user enters the password as "<password>"
	    And user clicks on the Login button
	Then verify the login is successfull
	
    Examples:
	    | username                              | password | 
        | firstname.lastname@ibtest.com         | Test123* | 

@overnight
Scenario Outline: Verify error message for the unsuccessful login
  
    Given user visits IB platform website
    When user clicks on the login button for homepage
        And user enters the username as "<username>"
        And user enters the password as "<password>"
        And user clicks on the Login button
    Then verify the correct error message is displayed <errormessasge>
  
    Examples: 
      | username                   | password | errormessasge                                                                                                                                                     | 
      | NotExisting                | Test123  | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the "Forgot your Password?" link below. | 
      |                            | Test123  | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the "Forgot your Password?" link below. | 
      | NotExisting                |          | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the "Forgot your Password?" link below. | 
      | Not.Existing@ibtest.com    | Test123* | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the "Forgot your Password?" link below. | 
      | Not.Existing@ibtest.com    | Test123* | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the "Forgot your Password?" link below. | 
	
	