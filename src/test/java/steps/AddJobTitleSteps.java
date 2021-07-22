package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;
import pages.JobTitlesPage;
import pages.SystemUsersPage;
import utils.CommonMethods;
import utils.GlobalVariables;

public class AddJobTitleSteps extends CommonMethods {

    @When("user clicks on Admin link")
    public void user_clicks_on_admin_link() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.adminLink);
    }

    @When("user click on Job Titles link")
    public void user_click_on_job_titles_link() {
        SystemUsersPage systemUsersPage = new SystemUsersPage();
        Actions action = new Actions(driver);
        action.moveToElement(systemUsersPage.jobDD).perform();
        click(systemUsersPage.jobTitlesLink);
    }

    @When("user clicks on Add button")
    public void user_clicks_on_add_button() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage();
        click(jobTitlesPage.addBtn);
    }


    @When("user adds {string} job title, fills out all fields, uploads a file and clicks on save button")
    public void user_adds_job_title_fills_out_all_fields_uploads_a_file_and_clicks_on_save_button(String jobTitle) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage();
        sendText(jobTitlesPage.jobTitleTextBox, jobTitle);
        GlobalVariables.jobTitle = jobTitle;
        sendText(jobTitlesPage.jobDescription, "Description");
        sendText(jobTitlesPage.jobSpecFileUpload, "C://Users//neper//OneDrive//Рабочий стол//SeleniumNotes/GIT.docx");
        sendText(jobTitlesPage.noteTextBox, "Note");
        click(jobTitlesPage.saveBtn);
    }

    @Then("user verifies data from backend and frontend, data has to match")
    public void user_verifies_data_from_backend_and_frontend_data_has_to_match() {
        System.out.println("Frontend: " + GlobalVariables.jobTitle);
        System.out.println("Backend: " + GlobalVariables.dbJobTitle);
        Assert.assertEquals(GlobalVariables.jobTitle, GlobalVariables.dbJobTitle);
    }

    @Then("user deletes added {string} job title")
    public void user_deletes_added_job_title(String jobTitle) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage();
    }
}
