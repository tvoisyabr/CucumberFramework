Feature: Login

  @mvn
  Scenario: valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in

  @simpletag
  Scenario: valid ess employee login
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  @regression
  Scenario: login with valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then user sees invalid credentials text on login page

  @example
  Scenario Outline: loging with multiple data
    When user enters valid "<username>" and "<password>"
    And user clicks on login button
    Then "<firstname>" appears on the dashboard page
  Examples:
    |username          |password    |firstname|
    |Admin             |Hum@nhrm123 |Admin    |
    |william1236000000 |Syntax12!!!!|William  |


  @error
  Scenario: Login with valid username and invalid password
    When username enters valid username and invalid password and verify the error message is displayed
    |username         |password|errorMessage|
    |Admin            |Human   |Invalid credentials|
    |william1236000000|Syntax  |Invalid credentials|


  @errorvalidation
  Scenario Outline: Login with multiple username and password combinations
    When user enters different "<usernamevalue>" and "<passwordvalue>" and verify the "<error>"
  Examples:
    |usernamevalue|passwordvalue|error|
    |Admin        |Syntax123!   |Invalid credentials     |
    |qwerty1      |Hum@nhrm123! |Invalid credentials     |
    |John         |             |Password cannot be empty|
    |             |Syntax123!   |Username cannot be empty|