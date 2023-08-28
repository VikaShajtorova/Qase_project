package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final By PROJECTS_TITLE = By.xpath("//div[@class='col-lg-12']//h1[text()='Projects']");
    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By LATEST_PROJECT = By.xpath("//tr[@class='project-row'][last()]//a[@class='project-name']");
    public static final By DROPDOWN_DELETE_LATEST_PROJECT = By.xpath("//tr[@class='project-row'][last()]//a[@class='btn btn-dropdown']");
    public static final By DELETE_BUTTON = By.xpath("//tr[@class='project-row'][last()]//div[@class='dropdown']//button[text()='Delete']");
    public static final By DELETE_BUTTON_MODAL = By.xpath("//span[text()='Delete project']/ancestor::div[contains(@class,'ReactModal__Content')]//span[text()='Delete project']");
public static final  By LIST_PROJECT = By.xpath("//tr[@class='project-row']");
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open ProjectsPage")
    public ProjectsPage open() {
        driver.get(BASE_URL + "projects");
        log.info("Go to the ProjectPage by: " + BASE_URL + "projects");
        return this;
    }

    @Step("Click create new project button")
    public ProjectModalPage clickCreateNewProjectButton() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        log.info("Find xpath and click: " + CREATE_NEW_PROJECT_BUTTON);
        return new ProjectModalPage(driver);
    }

    @Step("Find the last project in the list and click")
    public RepositoryPage getLatestProjectInListAndClick() {
        driver.findElement(LATEST_PROJECT).click();
        log.info("Find xpath and click: " + "//tr[@class='project-row'][last()]//a[@class='project-name']");
        return new RepositoryPage(driver);

    }
    public ProjectsPage deleteLatestProject(){
        driver.findElement(DROPDOWN_DELETE_LATEST_PROJECT).click();
        driver.findElement(DELETE_BUTTON).click();
        driver.findElement(DELETE_BUTTON_MODAL).click();
        return this;
    }

    public int getSizeListOfProjects(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LIST_PROJECT));
        List<WebElement> list = driver.findElements(LIST_PROJECT);
        return list.size();
    }

    @Step("Project page loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(PROJECTS_TITLE);
    }
}
