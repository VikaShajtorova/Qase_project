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
    public static final By ADD_FILTER_BUTTON = By.xpath("//div[@class='add-filter-outer']");
    public static final By LIST_FILER = By.xpath("//button[@class='add-filter-option']");
    public static final By LIST_CHECKBOX = By.xpath("//div[@class='checkbox']");
    public static final By NAME_FILTER = By.xpath("//div[@class='filter-item']");
    public static final By LAST_SUITE_ON_LIST = By.xpath("(//div[@class='sNpl0d']//i)[last()]");
    public static final By DELETE_BUTTON_IN_DROPDOWN = By.xpath("//div//i[@class='fas fa-trash' or text()='Delete']");
    public static final By DELETE_BUTTON = By.xpath("//button[@type='submit']//span[text()='Delete']");
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
        log.info("Click Case button");
        return new CasePage(driver);
    }


    @Step("Пet the text of the alert message on the RepositoryPage")
    public String getTextAlertMessageOnRepositoryPage() {
        String messageDeleteSuite = wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
        log.info("Get a message about creating suites: " +messageDeleteSuite);
        return messageDeleteSuite;
    }

    @Step("Click Shared Steps button")
    public SharedStepPage clickSharedStepsButton(){
        driver.findElement(SHARED_STEPS_BUTTON).click();
        log.info("Click Shared Steps button");
        return new SharedStepPage(driver);
    }

    public RepositoryPage selectSuiteFromList(){
        List<WebElement> list = driver.findElements(LIST_SUITES);
        list.get(0).click();
        return this;
    }

    @Step("Click to the last suite in the list")
    public RepositoryPage clickToLastSuiteInList() {
        driver.findElement(LAST_SUITE_ON_LIST).click();
        log.info("Click to the last suite in the list");
        return this;
    }

    @Step("Click the Delete button in drop down")
    public RepositoryPage clickDeleteButtonInDropDown(){
        driver.findElement(DELETE_BUTTON_IN_DROPDOWN).click();
        log.info("Click the Delete button in drop down");
        return this;
    }

    @Step("Click the Delete button")
    public RepositoryPage clickDeleteButton(){
        driver.findElement(DELETE_BUTTON).click();
        log.info("Click the Delete button");
        return this;
    }
    @Step("Click the Add filter button")
    public RepositoryPage clickAddFilterButton(){
       wait.until(ExpectedConditions.elementToBeClickable(ADD_FILTER_BUTTON)).click();
        log.info("Click the Add filter button");
        return this;
    }
    public RepositoryPage selectFilterFromList(){
        List<WebElement> list = driver.findElements(LIST_FILER);
        list.get(0).click();
        return this;
    }

    public RepositoryPage selectOptionFromCheckbox(){
        List<WebElement> list = driver.findElements(LIST_CHECKBOX);
        list.get(0).click();
        return this;
    }
    public String getTextNameFilter(){
        String textNameFilter = driver.findElement(NAME_FILTER).getText();
        return textNameFilter;
    }

    @Step("Made sure that I went to the repository page")
    @Override
    public boolean isPageOpen() {
        return isExist(REPOSITORY_TITLE);
    }
}
