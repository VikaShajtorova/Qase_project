package pages;

import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProjectSettingsPage extends BasePage {
    public static final By ARCHIVE_PROJECT_BUTTON = By.xpath("//button//span[@class='ZwgkIF' and text()='Archive project']");
    public static final By UPDATE_SETTINGS_BUTTON = By.xpath("//button//span[@class='ZwgkIF' and text()=' Update settings']");

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectSettingsPage changeDataInProjectFields(Project project) {
        new Input(driver, "Project name").write(project.getProjectName());
        new Input(driver, "Project code").write(project.getProjectCode());
        new TextArea(driver, "Description").write(project.getDescription());
        return this;
    }

    @Step("Get the text of the alert message on the SettingsPage")
    public String getTextAlertMessageOnSettingsPage() {
        String messageDeleteSuite = wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
        log.info("Get a message about creating suites: " + messageDeleteSuite);
        return messageDeleteSuite;
    }

    @Step("Click the Update settings button")
    public ProjectSettingsPage clickUpdateSettingsButton() {
        driver.findElement(UPDATE_SETTINGS_BUTTON).click();
        log.info("Find the item: " + UPDATE_SETTINGS_BUTTON + " and click");
        return this;
    }

    @Step("ProjectSettingsPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(ARCHIVE_PROJECT_BUTTON);
    }
}
