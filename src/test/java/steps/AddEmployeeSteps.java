package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariables;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM link")
    public void user_clicks_on_pim_link() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.pimLink);
    }
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.addEmployee);
    }
    @When("user enters firstname, middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Elton");
        sendText(addEmployeePage.middleName, "Gay");
        sendText(addEmployeePage.lastName, "John");
    }

    @When("user enters firstname {string}, middlename {string} and lastname {string}")
    public void user_enters_firstname_middlename_and_lastname(String firstname, String middlename, String lastname) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstname);
        sendText(addEmployeePage.middleName, middlename);
        sendText(addEmployeePage.lastName, lastname);
        GlobalVariables.firstName = firstname;
        GlobalVariables.middleName = middlename;
        GlobalVariables.lastName = lastname;
    }

    @When("user enters {string}, {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, FirstName);
        sendText(addEmployeePage.middleName, MiddleName);
        sendText(addEmployeePage.lastName, LastName);
    }

    @When("add multiple employees and verify they are added succesfully")
    public void add_multiple_employees_and_verify_they_are_added_succesfully(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeData = dataTable.asMaps();
        for (Map<String, String> map : employeeData) {
            String firstNameValue = map.get("FirstName");
            String middleNameValue = map.get("MiddleName");
            String  lastNameValue = map.get("LastName");
            System.out.println(firstNameValue + " " + middleNameValue + " " + lastNameValue);
            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, firstNameValue);
            sendText(addEmployeePage.middleName, middleNameValue);
            sendText(addEmployeePage.lastName, lastNameValue);
            click(addEmployeePage.saveBtn);
            //assertion as HW
            //profile-pic
           /* String actual = driver.findElement(By.id("profile-pic")).getText();
            String expected = firstNameValue + " " + middleNameValue + " " + lastNameValue;
            Assert.assertEquals("Data doesn't match", expected, actual);*/
            Thread.sleep(4000);
            DashboardPage dashboardPage = new DashboardPage();
            click(dashboardPage.addEmployee);
            Thread.sleep(4000);
        }
    }

    @When("user adds multiple employees from excel file {string} and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_and_verify_they_are_added(String sheet) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheet);
        DashboardPage dashboardPage = new DashboardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();

        Iterator<Map<String, String>> iterator = newEmployees.iterator();
        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();
            sendText(addEmployeePage.firstName, map.get("FirstName"));
            sendText(addEmployeePage.middleName, map.get("MiddleName"));
            sendText(addEmployeePage.lastName, map.get("LastName"));
            click(addEmployeePage.saveBtn);
            //assertion HW
        }
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("capture the employeeId")
    public void capture_the_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        GlobalVariables.empId = addEmployeePage.employeeId.getAttribute("value");
    }

    @Then("verify data from frontend and backend")
    public void verify_data_from_frontend_and_backend() {
        System.out.println("Backend");
        System.out.println("DBFirstName " + GlobalVariables.dbFirstName);
        System.out.println("DBMiddleName " + GlobalVariables.dbMiddleName);
        System.out.println("DBLastName " + GlobalVariables.dbLastName);
        System.out.println("--------------------------------------------");
        System.out.println("Frontend");
        System.out.println("FirstName " + GlobalVariables.firstName);
        System.out.println("MiddleName " + GlobalVariables.middleName);
        System.out.println("LastName " + GlobalVariables.lastName);

        Assert.assertEquals(GlobalVariables.firstName, GlobalVariables.dbFirstName);
        Assert.assertEquals(GlobalVariables.middleName, GlobalVariables.dbMiddleName);
        Assert.assertEquals(GlobalVariables.lastName, GlobalVariables.dbLastName);
    }
}
