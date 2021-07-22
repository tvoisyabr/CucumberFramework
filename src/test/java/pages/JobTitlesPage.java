package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class JobTitlesPage extends CommonMethods {

    @FindBy(id = "btnAdd")
    public WebElement addBtn;

    @FindBy(id = "jobTitle_jobTitle")
    public WebElement jobTitleTextBox;

    @FindBy(id = "jobTitle_jobDescription")
    public WebElement jobDescription;

    @FindBy(id = "jobTitle_jobSpec")
    public WebElement jobSpecFileUpload;

    @FindBy(id = "jobTitle_note")
    public WebElement noteTextBox;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    public JobTitlesPage() {
        PageFactory.initElements(driver, this);
    }
}
