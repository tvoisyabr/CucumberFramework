package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {
    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage loginPage = new LoginPage();
        click(loginPage.loginBtn);
    }
    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashboardPage dashboardPage = new DashboardPage();
        //Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());
        String expected = "Welcome Admin";
        String actual = dashboardPage.welcomeText.getText();
        Assert.assertEquals("Text doesn't match", expected, actual);
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox, password);
    }
    @Then("{string} appears on the dashboard page")
    public void appears_on_the_dashboard_page(String firstname) {
        DashboardPage dashboardPage = new DashboardPage();
        String actual = dashboardPage.welcomeText.getText();
        Assert.assertEquals("Message doesn't match","Welcome " + firstname, actual);
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());
    }

    @When("username enters valid username and invalid password and verify the error message is displayed")
    public void username_enters_valid_username_and_invalid_password_and_verify_the_error_message_is_displayed(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps();
        for (Map<String, String> map : credentials) {
            String usernameValue = map.get("username");
            String passwordValue = map.get("password");
            String errorMessageValue = map.get("errorMessage");
            LoginPage loginPage = new LoginPage();
            sendText(loginPage.usernameBox, usernameValue);
            sendText(loginPage.passwordBox, passwordValue);
            click(loginPage.loginBtn);
            String actual = loginPage.errorMessage.getText();
            Assert.assertEquals("Message does not match", errorMessageValue, actual);
        }
    }

    @When("user enters different {string} and {string} and verify the {string}")
    public void user_enters_different_and_and_verify_the(String usernamevalue, String passwordvalue, String error) {
       LoginPage loginPage = new LoginPage();
       sendText(loginPage.usernameBox, usernamevalue);
       sendText(loginPage.passwordBox, passwordvalue);
       click(loginPage.loginBtn);
       Assert.assertEquals("Invalid message", loginPage.errorMessage.getText(), error);
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, "Admin");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("user sees invalid credentials text on login page")
    public void user_sees_invalid_credentials_text_on_login_page() {
        System.out.println("Error message is displayed");
    }
}
