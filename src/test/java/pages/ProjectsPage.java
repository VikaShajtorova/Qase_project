package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final By PROJECTS_TITLE = By.xpath("//div[@class='col-lg-12']//h1[text()='Projects']");
    public static final By PROJECTS_BUTTON = By.xpath("//a[text()='Projects']");
    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By LATEST_PROJECT = By.xpath("//tr[@class='project-row'][last()]//a[@class='project-name']");
    public static final By DROPDOWN_DELETE_LATEST_PROJECT = By.xpath("(//tr[@class='project-row']//div//a//i)[last()]");
    public static final By DROPDOWN_PROJECT = By.xpath("(//tr[@class='project-row']//div//a//i)[last()]");
    public static final By DELETE_BUTTON = By.xpath("(//tr[@class='project-row']//div//div[@class='dropdown-item'])[last()]");
    public static final By OPTION_DROPDOWN_SETTINGS = By.xpath("(//div[@class='dropdown']//div[@class='dropdown-item']//a)[last()]");
    public static final By DELETE_BUTTON_MODAL = By.xpath("//button[@type='button']" +
            "/ancestor::div[contains(@class,'ReactModal__Content')]//span[text()='Delete project']");
    public static final By LIST_PROJECT = By.xpath("//tr[@class='project-row']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Project button")
    public ProjectsPage clickProjectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PROJECTS_BUTTON)).click();
        log.info("Find the item: " + PROJECTS_BUTTON + " and click");
        return this;
    }

    @Step("Click create new project button")
    public ProjectModalPage clickCreateNewProjectButton() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        log.info("Find the item: " + CREATE_NEW_PROJECT_BUTTON + " and click");
        return new ProjectModalPage(driver);
    }

    @Step("Find the last project in the list and click")
    public RepositoryPage getLatestProjectInListAndClick() {
        driver.findElement(LATEST_PROJECT).click();
        log.info("Find the item: " + LATEST_PROJECT + " and click");
        return new RepositoryPage(driver);

    }

    @Step("Click the Dropdown button on ProjectsPage")
    public ProjectsPage clickDropdownProject() {
        driver.findElement(DROPDOWN_PROJECT).click();
        log.info("Find the item: " + DROPDOWN_PROJECT + " and click");
        return this;
    }

    @Step("Click the Settings button in drop down on ProjectsPage")
    public ProjectSettingsPage clickSettingsButton() {
        driver.findElement(OPTION_DROPDOWN_SETTINGS).click();
        log.info("Find the item: " + OPTION_DROPDOWN_SETTINGS + " and click");
        return new ProjectSettingsPage(driver);
    }

    @Step("Delete the latest project")
    public ProjectsPage deleteLatestProject() {
        wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_DELETE_LATEST_PROJECT)).click();
        log.info("Find the item: " + DROPDOWN_DELETE_LATEST_PROJECT + " and click");
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_BUTTON)).click();
        log.info("Find the item: " + DELETE_BUTTON + " and click");
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_BUTTON_MODAL)).click();
        log.info("Find the item: " + DELETE_BUTTON_MODAL + " and click");
        return this;
    }

    @Step("Delete the latest project after the test")
    public ProjectsPage deleteLatestProjectAfterTest() {
        wait.until(ExpectedConditions.elementToBeClickable(PROJECTS_BUTTON)).click();
        log.info("Find the item: " + PROJECTS_BUTTON + " and click");
        wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_DELETE_LATEST_PROJECT)).click();
        log.info("Find the item: " + DROPDOWN_DELETE_LATEST_PROJECT + " and click");
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_BUTTON)).click();
        log.info("Find the item: " + DELETE_BUTTON + " and click");
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_BUTTON_MODAL)).click();
        log.info("Find the item: " + DELETE_BUTTON_MODAL + " and click");
        return this;
    }

    @Step("Get size list of projects")
    public int getSizeListOfProjects() {
        List<WebElement> list = driver.findElements(LIST_PROJECT);
        log.info("Put projects in the list and get the size of the list");
        return list.size();
    }

    @Step("ProjectPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(PROJECTS_TITLE);
    }
}
