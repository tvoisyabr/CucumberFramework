package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EditEmployeePage;
import pages.EmployeeListPage;
import utils.CommonMethods;

import java.util.List;

public class EditEmployeeSteps extends CommonMethods {

    @When("user enters  id {string} and clicks on search button")
    public void user_enters_id_and_clicks_on_search_button(String id) {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        sendText(employeeListPage.idEmployee, id);
        click(employeeListPage.searchBtn);
    }
    @When("user clicks on employee id {string} and clicks on edit button")
    public void user_clicks_on_employee_id_and_clicks_on_edit_button(String id) {
        EditEmployeePage edit = new EditEmployeePage();
        click(driver.findElement(By.xpath("//*[@id = 'tableWrapper']/table/tbody/tr/td[2]")));
        click(edit.editSaveBtn);
    }
    @When("user edits firstname, middlename and lastname and clicks on save button")
    public void user_edits_firstname_middlename_and_lastname_and_clicks_on_save_button() {
        EditEmployeePage edit = new EditEmployeePage();
        sendText(edit.firstNameBox, "Hello");
        sendText(edit.middleNameBox, "Hi");
        sendText(edit.lastNameBox, "Kitty");
        click(edit.editSaveBtn);
    }
    @Then("employee successfully edited")
    public void employee_successfully_edited() {
        System.out.println("Edited");
    }
}
