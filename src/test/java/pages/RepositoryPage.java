package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.createCase.CasePage;
import pages.sideMenuProject.SharedStepPage;

import java.util.List;

@Log4j2
public class RepositoryPage extends BasePage {
    public static final By REPOSITORY_TITLE = By.xpath("//h1[@class='fGDnu0']");
    public static final By SUITE_BUTTON = By.id("create-suite-button");
    public static final By CASE_BUTTON = By.id("create-case-button");
    public static final By CREATE_SUITE_MESSAGE = By.xpath("//div[@role='alert']//span[text()='Suite was successfully created.']");
    public static final By SHARED_STEPS_BUTTON = By.xpath("//a[@title='Shared Steps']");
    public static final By LIST_SUITES = By.xpath("//div[@class='sNpl0d']");
    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the project code")
    public boolean getProjectCode() {
        boolean projectCode = driver.findElement(REPOSITORY_TITLE).isDisplayed();
        log.info("Find xpath and get the project code: " + REPOSITORY_TITLE);
        return projectCode;
    }

    @Step("Click Suite button")
    public SuiteModalPage clickSuiteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUITE_BUTTON));
        driver.findElement(SUITE_BUTTON).click();
        log.info("Find xpath and click: " + SUITE_BUTTON);
        return new SuiteModalPage(driver);
    }
    @Step("Click Case button")
    public CasePage clickCaseButton(){
        driver.findElement(CASE_BUTTON).click();
        log.info("");//TODO
        return new CasePage(driver);
    }

    @Step("Get a message about creating suites")
    public String getTextOfMessageAboutCreationOfSuite() {
        log.info("Get a message about creating suites: " + getTextOfMessageAboutCreationOfSuite());
        return driver.findElement(CREATE_SUITE_MESSAGE).getText();
    }
    public SharedStepPage clickSharedStepsButton(){
        driver.findElement(SHARED_STEPS_BUTTON).click();
        return new SharedStepPage(driver);
    }

    public RepositoryPage selectSuiteFromList(){
        List<WebElement> list = driver.findElements(LIST_SUITES);
        list.get(0).click();
        return this;
    }

    @Step("Made sure that I went to the repository page")
    @Override
    public boolean isPageOpen() {
        return isExist(REPOSITORY_TITLE);
    }
}
