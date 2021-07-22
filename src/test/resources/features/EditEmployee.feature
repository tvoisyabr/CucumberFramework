Feature: User should edit employee details

  @smoke
  Scenario: Editing Employee
    When user enters valid admin username and password
    And user clicks on login button
    And user navigates to employee list page
    And user enters  id "15982" and clicks on search button
    And user clicks on employee id "15982" and clicks on edit button
    And user edits firstname, middlename and lastname and clicks on save button
    Then employee successfully edited
