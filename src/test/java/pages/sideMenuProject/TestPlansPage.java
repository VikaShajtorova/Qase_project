package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class TestPlansPage extends BasePage {
    public static final By TEST_PLAN_BUTTON = By.xpath("//a[@aria-label='Test Plans']");
    public static final By CREATE_PLAN_BUTTON = By.id("createButton");

    public TestPlansPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Create plan button")
    public CreateTestPlanPage clickCreatePlanButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CREATE_PLAN_BUTTON)).click();
        log.info("Find the item: " + CREATE_PLAN_BUTTON + " and click");
        return new CreateTestPlanPage(driver);
    }

    @Step("Click the Test plan button")
    public TestPlansPage clickTestPlanButton() {
        driver.findElement(TEST_PLAN_BUTTON).click();
        log.info("Find the item: " + TEST_PLAN_BUTTON + " and click");
        return this;
    }

    @Step("Get the text of the alert message on the TestPlansPage")
    public String getTextAlertMessageOnTestPlansPage() {
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
        log.info("Get a message about creating suites: " + message);
        return message;
    }

    @Step("Get Alert")
    public void getAlertOnTestPlanPage() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        log.info("Get Alert and accept");
    }

    @Step("TestPlansPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(CREATE_PLAN_BUTTON);
    }
}
