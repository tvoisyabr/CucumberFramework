package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class SystemUsersPage extends CommonMethods {

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement jobTitlesLink;

    @FindBy(id = "menu_admin_Job")
    public WebElement jobDD;

    public SystemUsersPage() {
        PageFactory.initElements(driver, this);
    }
}
