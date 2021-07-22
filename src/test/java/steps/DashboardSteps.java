package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("verify the following tabs are displayed on dashboard")
    public void verify_the_following_tabs_are_displayed_on_dashboard(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();
        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualTabs = new ArrayList<>();
        for (WebElement element : dashboardPage.dashboardTabs) {
            actualTabs.add(element.getText());
        }
        Assert.assertEquals(expectedTabs, actualTabs);
        System.out.println("PASSED");
    }
}
