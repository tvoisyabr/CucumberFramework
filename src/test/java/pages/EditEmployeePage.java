package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditEmployeePage {

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement firstNameBox;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement middleNameBox;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement lastNameBox;

    @FindBy(id = "btnSave")
    public WebElement editSaveBtn;
}
