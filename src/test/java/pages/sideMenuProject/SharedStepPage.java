package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class SharedStepPage extends BasePage {
    public static final By CREATE_SHARED_STEP_BUTTON = By.xpath("//span[text()='Create shared step']");
    public static final By CREATE_SHARED_STEP_MESSAGE = By.xpath("//span[text()='Shared step was created successfully!']");
    public SharedStepPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click the Create shared step button")
    public CreateSharedStepPage clickCreateSharedStepButton(){
        driver.findElement(CREATE_SHARED_STEP_BUTTON).click();
        log.info("Click the Create shared step button");
        return new CreateSharedStepPage(driver);
    }
    public String getMessageAboutCreatingSharedStep(){
        String message = driver.findElement(CREATE_SHARED_STEP_MESSAGE).getText();
        return message;
    }

    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_SHARED_STEP_BUTTON);
    }
}
