Feature: Login
  Navigate to a website and validate its login functionality

  Scenario: Validate login of MakeMyTrip
   # Given Open "Chrome" and navigate to Insly login "https://www.makemytrip.com/"
    Given Go to the website "https://www.katalon.com/"
    And Click on the button "Sign In"
    And enter email id as "luxoft@test.com"
    And enter the password as "teste1234"
    And Uncheck the option "Remember me"
    Then validate the message "Incorrect email or password. Please try again"
