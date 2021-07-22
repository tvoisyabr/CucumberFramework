Feature: Dashboard tab functionality

  @dashboardTabs
  Scenario: Dashboard tab verification
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    Then verify the following tabs are displayed on dashboard
      |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|