package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.pimLink);
        click(dashboardPage.employeeList);

    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        sendText(employeeListPage.idEmployee, "15518");

    }

    @When("click on search button")
    public void click_on_search_button() {
       EmployeeListPage employeeListPage = new EmployeeListPage();
       click(employeeListPage.searchBtn);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        sendText(employeeListPage.employeeNameBox, "sofiia");
    }

    @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Employee name is displayed");
        tearDown();
    }
}
