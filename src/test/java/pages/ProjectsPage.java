package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final By PROJECTS_TITLE = By.xpath("//div[@class='col-lg-12']//h1[text()='Projects']");
    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");

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
        driver.findElement(By.xpath("//tr[@class='project-row'][last()]//a[@class='project-name']")).click();
        log.info("Find xpath and click: " + "//tr[@class='project-row'][last()]//a[@class='project-name']");
        return new RepositoryPage(driver);

    }

    @Step("Made sure that I went to the ProjectPage")
    @Override
    public boolean isPageOpen() {
        log.info("Find xpath: " + PROJECTS_TITLE);
        return isExist(PROJECTS_TITLE);
    }
}
