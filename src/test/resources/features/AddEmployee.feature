Feature: Adding employees

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM link
    And user clicks on Add Employee option

  @smoke
  Scenario: adding employee from Add employee page

    And user enters firstname, middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @smoke
  Scenario: adding employee from Add employee page via feature file
    And user enters firstname "Juan", middlename "Batist" and lastname "Grenui"
    And user clicks on save button
    Then employee added successfully

    @example
    Scenario Outline: Adding employee from Add employee page via feature file
      And user enters "<FirstName>", "<MiddleName>" and "<LastName>" in the application
      And user clicks on save button
      Then employee added successfully

      Examples:
        |FirstName |MiddleName|LastName|
        |Test123456| MS       |Test9876|
        |Test1212  | MS       |Test7654|
        |Test3232  | MS       |Test5454|

  @datatable
  Scenario: Adding multiple employees in a single execution
    When add multiple employees and verify they are added succesfully
    |FirstName|MiddleName|LastName |
    |Alla     |MS        |Pugacheva|
    |Sofia    |MS        |Vratyaru |
    |Artur    |MS        |Pirojkov |

  @excel
  Scenario: Adding the employee from excel file
    When user adds multiple employees from excel file "newData" and verify they are added

  @database
  Scenario: Add employee and test it from backend
    And user enters firstname "Juan", middlename "Batist" and lastname "Grenui"
    And capture the employeeId
    And user clicks on save button
    Then query the HRMS database
    And verify data from frontend and backend


