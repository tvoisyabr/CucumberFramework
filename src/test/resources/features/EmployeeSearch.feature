Feature: Employee Search

  Background:
    And user is logged in with valid admin credentials
    And user navigates to employee list page

  @smoke
  Scenario: Search employee by ID
    When user enters valid employee id
    And click on search button
    Then user sees employee information is displayed

  @smoke
  Scenario: Search employee by name
    When user enters valid employee name
    And click on search button
    Then user sees employee information is displayed