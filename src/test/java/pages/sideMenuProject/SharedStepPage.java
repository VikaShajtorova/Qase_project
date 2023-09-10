package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class SharedStepPage extends BasePage {
    public static final By CREATE_SHARED_STEP_BUTTON = By.xpath("//a//span[@class='ZwgkIF' or text()='Create shared step']");

    public SharedStepPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Create shared step button")
    public CreateSharedStepPage clickCreateSharedStepButton() {
        driver.findElement(CREATE_SHARED_STEP_BUTTON).click();
        log.info("Find the item: " + CREATE_SHARED_STEP_BUTTON + " and click");
        return new CreateSharedStepPage(driver);
    }

    @Step("Get the text of the alert message on the SharedStepPage")
    public String getMessageAboutCreatingSharedStep() {
        String message = driver.findElement(ALERT_MESSAGE).getText();
        log.info("Get a message about creating suites: " + message);
        return message;
    }

    @Step("SharedStepPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_SHARED_STEP_BUTTON);
    }
}
