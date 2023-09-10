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
    public static final By NAME_FILTER = By.xpath("//div[@class='filter-item']//span");
    public static final By LAST_SUITE_ON_LIST = By.xpath("(//div[@class='sNpl0d']//i)[last()]");
    public static final By DELETE_BUTTON_IN_DROPDOWN = By.xpath("//div//i[@class='fas fa-trash' or text()='Delete']");
    public static final By EDIT_BUTTON_IN_DROPDOWN = By.xpath("//div[@class='Cr3S77']//i[@class='far fa-pencil']");
    public static final By CLONE_BUTTON_IN_DROPDOWN = By.xpath("//div[@class='Cr3S77']//i[@class='far fa-clone']");
    public static final By CREATE_SUITE_BUTTON_IN_DROPDOWN = By.xpath("//div[@class='Cr3S77']//i[@class='far fa-plus']");
    public static final By CREATE_CASE_BUTTON_IN_DROPDOWN = By.xpath("//a[@class='Cr3S77']//i[@class='far fa-plus']");
    public static final By DELETE_BUTTON = By.xpath("//button[@type='submit']//span[text()='Delete']");
    public static final By SHARED_STEPS_BUTTON = By.xpath("//a[@title='Shared Steps']");
    public static final By LIST_SUITES = By.xpath("//div[@class='sNpl0d']");
    protected static final By CASE_LIST = By.xpath("(//div[@class='WVGvc_ wq7uNh'])[1]");

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUITE_BUTTON)).click();
        log.info("Find the item: " + SUITE_BUTTON + " and click");
        return new SuiteModalPage(driver);
    }

    @Step("Click Case button")
    public CasePage clickCaseButton() {
        driver.findElement(CASE_BUTTON).click();
        log.info("Find the item: " + CASE_BUTTON + " and click");
        return new CasePage(driver);
    }

    @Step("Get the text of the alert message on the RepositoryPage")
    public String getTextAlertMessageOnRepositoryPage() {
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
        log.info("Get a message about creating suites: " + message);
        return message;
    }

    @Step("Make sure that the element is not visible")
    public RepositoryPage invisibilityOfElementLocated() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ALERT_MESSAGE));
        log.info("Make sure that the element is not visible: " + ALERT_MESSAGE);
        return this;
    }


    @Step("Click Shared Steps button")
    public SharedStepPage clickSharedStepsButton() {
        driver.findElement(SHARED_STEPS_BUTTON).click();
        log.info("Find the item: " + SHARED_STEPS_BUTTON + " and click");
        return new SharedStepPage(driver);
    }

    @Step("Select a suite from list")
    public RepositoryPage selectSuiteFromList() {
        List<WebElement> list = driver.findElements(LIST_SUITES);
        list.get(0).click();
        log.info("Put suites in the list and click");
        return this;
    }

    @Step("Click to the last suite in the list")
    public RepositoryPage clickToLastSuiteInList() {
        driver.findElement(LAST_SUITE_ON_LIST).click();
        log.info("Find the item: " + LAST_SUITE_ON_LIST + " and click");
        return this;
    }

    @Step("Click the Delete button in drop down")
    public RepositoryPage clickDeleteButtonInDropDown() {
        driver.findElement(DELETE_BUTTON_IN_DROPDOWN).click();
        log.info("Find the item: " + DELETE_BUTTON_IN_DROPDOWN + " and click");
        return this;
    }

    @Step("Click the Edit button in drop down")
    public EditSuiteModalPage clickEditButtonInDropDown() {
        driver.findElement(EDIT_BUTTON_IN_DROPDOWN).click();
        log.info("Find the item: " + EDIT_BUTTON_IN_DROPDOWN + " and click");
        return new EditSuiteModalPage(driver);
    }

    @Step("Click the Clone button in drop down")
    public CloneSuiteModalPage clickCloneButtonInDropDown() {
        driver.findElement(CLONE_BUTTON_IN_DROPDOWN).click();
        log.info("Find the item: " + CLONE_BUTTON_IN_DROPDOWN + " and click");
        return new CloneSuiteModalPage(driver);
    }

    @Step("Click the Create suite button in drop down")
    public SuiteModalPage clickCreateSuiteButtonInDropDown() {
        driver.findElement(CREATE_SUITE_BUTTON_IN_DROPDOWN).click();
        log.info("Find the item: " + CREATE_SUITE_BUTTON_IN_DROPDOWN + " and click");
        return new SuiteModalPage(driver);
    }

    @Step("Click the Create case button in drop down")
    public CasePage clickCreateCaseButtonInDropDown() {
        driver.findElement(CREATE_CASE_BUTTON_IN_DROPDOWN).click();
        log.info("Find the item: " + CREATE_CASE_BUTTON_IN_DROPDOWN + " and click");
        return new CasePage(driver);
    }

    @Step("Click the Delete button")
    public RepositoryPage clickDeleteButton() {
        driver.findElement(DELETE_BUTTON).click();
        log.info("Find the item: " + DELETE_BUTTON + " and click");
        return this;
    }

    @Step("Click the Add filter button")
    public RepositoryPage clickAddFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_FILTER_BUTTON)).click();
        log.info("Find the item: " + ADD_FILTER_BUTTON + " and click");
        return this;
    }

    @Step("Select filter from list")
    public RepositoryPage selectFilterFromList() {
        List<WebElement> list = driver.findElements(LIST_FILER);
        list.get(0).click();
        log.info("Select filter from list and click");
        return this;
    }

    @Step("Select option from checkbox")
    public RepositoryPage selectOptionFromCheckbox() {
        List<WebElement> list = driver.findElements(LIST_CHECKBOX);
        list.get(0).click();
        log.info("Select option from checkbox and click");
        return this;
    }

    @Step("Get a text name filter")
    public String getTextNameFilter() {
        String textNameFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_FILTER)).getText();
        log.info("Get a text name filter: " + textNameFilter);
        return textNameFilter;
    }

    @Step("Select a Case from the list")
    public CaseModalPage selectCaseFromList() {
        List<WebElement> list = driver.findElements(CASE_LIST);
        list.get(0).click();
        log.info("Select a Case from the list and click");
        return new CaseModalPage(driver);
    }

    @Step("Checks that list cases is displayed")
    public boolean checksThatListIsDisplayed() {
        boolean isDisplayed = driver.findElement(CASE_LIST).isDisplayed();
        log.info("Checks that list cases is displayed");
        return isDisplayed;
    }


    @Step("RepositoryPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(REPOSITORY_TITLE);
    }
}
