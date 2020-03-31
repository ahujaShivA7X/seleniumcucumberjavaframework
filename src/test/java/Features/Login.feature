Feature: Login
  Navigate to a website and validate its login functionality

  Scenario: Validate login of MakeMyTrip
    Given Open "Chrome" and navigate to Insly login "https://www.makemytrip.com/"
    And I enter 'companyName' as "Warsaw"
    And I type 'inslyAdd' as "shiva"
    And I select company profile as "Software Developer Insurance"
    And I select country as 'India'
    And I select Number of employees as '1-5'
    Then I select myself as 'A tech guy'
