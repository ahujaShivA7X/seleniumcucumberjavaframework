Feature: Login
  Navigate to a website and validate its login functionality

  Scenario: Validate login of Insly
    Given Open "Chrome" and navigate to Insly login "URL"
    And I enter 'companyName' as "shivaCompany"
    And I type 'inslyAdd' as "shiva"
    And I select company profile as "Software Developer Insurance"
    And I select country as 'India'
    And I select Number of employees as '1-5'
    Then I select myself as 'A tech guy'
