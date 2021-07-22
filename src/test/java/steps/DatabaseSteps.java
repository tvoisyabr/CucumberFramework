package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.DatabaseUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DatabaseSteps extends CommonMethods {

    @Then("query the HRMS database")
    public void query_the_hrms_database() {
        String query = "SELECT emp_firstname, emp_middle_name, emp_lastname FROM hs_hr_employees WHERE emp_number ="
                + GlobalVariables.empId;
        List<Map<String, String>> list = DatabaseUtils.getTableDataAsList(query);
        GlobalVariables.dbFirstName = list.get(0).get("emp_firstname");
        GlobalVariables.dbMiddleName = list.get(0).get("emp_middle_name");
        GlobalVariables.dbLastName = list.get(0).get("emp_lastname");
    }

    @When("user queries HRMS database")
    public void user_queries_hrms_database() {
        String query = "SELECT job_title FROM ohrm_job_title where job_title = "
                + GlobalVariables.jobTitle;
        List<Map<String, String>> list = DatabaseUtils.getTableDataAsList(query);
        GlobalVariables.dbJobTitle = list.get(0).get("job_title");
    }
}
