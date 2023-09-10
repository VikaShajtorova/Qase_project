package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class TestRunsPage extends BasePage {
    protected static final By TEST_RUNS_BUTTON = By.xpath("//a[@aria-label='Test Runs']//span[@class='UYBenG']");
    protected static final By START_NEW_TEST_RUN_BUTTON = By.xpath("(//button//span[@class='ZwgkIF' or text()='Start new test run'])[1]");
    public static final By TABLE_TEST_RUN = By.xpath("//table[@class='cgfcf7']");
    public static final By DROPDOWN_BUTTON_TEST_RUN = By.xpath("//tbody[@class='t57YVN']//td//button");
    public static final By DELETE_BUTTON_IN_DROPDOWN_TEST_RUN = By.xpath("//ul[@role='menu']//button[text()='Delete']");
    public static final By DELETE_BUTTON_IN_MODAL_WINDOW = By.xpath("//button[@type='button']//span[text()='Delete']");

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Test runs button")
    public TestRunsPage clickTestRunButton() {
        driver.findElement(TEST_RUNS_BUTTON).click();
        log.info("Find the item: " + TEST_RUNS_BUTTON + " and click");
        return this;
    }

    @Step("Click the Start new test run button")
    public TestRunsModalPage clickStartNewTestRunsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(START_NEW_TEST_RUN_BUTTON)).click();
        log.info("Find the item: " + START_NEW_TEST_RUN_BUTTON + " and click");
        return new TestRunsModalPage(driver);
    }

    @Step("Get Alert")
    public void getAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        log.info("Get Alert and accept");
    }

    @Step("Click the dropDown test run button")
    public TestRunsPage clickDropDownButtonTestRun() {
        driver.findElement(DROPDOWN_BUTTON_TEST_RUN).click();
        log.info("Find the item: " + DROPDOWN_BUTTON_TEST_RUN + " and click");
        return this;
    }

    @Step("Click the Delete button in dropDown test run")
    public TestRunsPage selectOptionInDropDownButtonTestRun() {
        driver.findElement(DELETE_BUTTON_IN_DROPDOWN_TEST_RUN).click();
        log.info("Find the item: " + DELETE_BUTTON_IN_DROPDOWN_TEST_RUN + " and click");
        return this;
    }

    @Step("Click  the delete button in the modal window")
    public TestRunsPage ClickDeleteButtonInModalWindow() {
        driver.findElement(DELETE_BUTTON_IN_MODAL_WINDOW).click();
        log.info("Find the item: " + DELETE_BUTTON_IN_MODAL_WINDOW + " and click");
        return this;
    }

    @Step("The table test run is displayed")
    public boolean tableTestRunIstDisplayed() {
        boolean isDisplayed = driver.findElement(TABLE_TEST_RUN).isDisplayed();
        log.info("The table test run is displayed: " + isDisplayed);
        return isDisplayed;
    }

    @Step("TestRunsPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(START_NEW_TEST_RUN_BUTTON);
    }
}
