package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashboardPage extends CommonMethods {

    @FindBy(id = "welcome")
    public WebElement welcomeText;

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminLink;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimLink;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployee;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;

    @FindBy(xpath = "//*[@class = 'menu']/ul/li")
    public List<WebElement> dashboardTabs;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
}
