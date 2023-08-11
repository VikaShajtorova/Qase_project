package pages;

import elements.Input;
import elements.RadioButton;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectModalPage extends BasePage {
    public static final By CREATE_NEW_PROJECT_TITLE = By.xpath("//h3[@class='r_U3IU' and text()='Create new project']");

    public ProjectModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the create project button")
    public RepositoryPage clickCreateProjectButton() {
        driver.findElement(CREATE_BUTTON).click();
        log.info("Find xpath and click: " + CREATE_BUTTON);
        return new RepositoryPage(driver);
    }

    @Step("Click the cancel button")
    public ProjectsPage clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
        log.info("Find xpath and click: " + CANCEL_BUTTON);
        return new ProjectsPage(driver);
    }

    @Step("Create a new project")
    public RepositoryPage createProject() {
        new Input(driver, "Project name").write("Salesforce");
        new Input(driver, "Project code").write("SF");
        new TextArea(driver, "Description").write("The user goes to the site by following the link");
        new RadioButton(driver, "Private").clickOnRadioButton();
        new RadioButton(driver, "Add all members to this project").clickOnRadioButton();
        return clickCreateProjectButton();

    }

    @Step("Made sure that I went to the ProjectModalPage")
    @Override
    public boolean isPageOpen() {
        log.info("Find xpath: "+CREATE_NEW_PROJECT_TITLE);
        return isExist(CREATE_NEW_PROJECT_TITLE);
    }
}
