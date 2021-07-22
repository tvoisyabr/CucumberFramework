Feature: Adding a job title

  @database
  Scenario: Add a job title and test it from backend and delete it
    And user is logged in with valid admin credentials
    When user clicks on Admin link
    And user click on Job Titles link
    And user clicks on Add button
    And user adds "Test Automation Developer" job title, fills out all fields, uploads a file and clicks on save button
    And user queries HRMS database
    Then user verifies data from backend and frontend, data has to match
    And user deletes added "Test Automation Developer" job title