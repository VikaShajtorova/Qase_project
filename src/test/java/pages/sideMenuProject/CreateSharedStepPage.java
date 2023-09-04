package pages.sideMenuProject;

import elements.ExpandableTextArea;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.SharedStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class CreateSharedStepPage extends BasePage {
    public static final By SHARED_STEPS_LIST_TITLE = By.xpath("//a[@title='Shared steps list']");
    public static final By ADD_STEP_BUTTON = By.id("addStep");
    public static final By CREATE_BUTTON = By.xpath("//button[@type='submit' and text()='Create']");

    public CreateSharedStepPage(WebDriver driver) {
        super(driver);
    }

    public CreateSharedStepPage inputInFieldSharedStepTitle(SharedStep stepTitle) {
        new Input(driver, "Shared step title").write(stepTitle.getSharedStepTitle());
        return this;
    }

    @Step("Click Add step button")
    public CreateSharedStepPage clickAddStepButton() {
        driver.findElement(ADD_STEP_BUTTON).click();
        log.info("Click the Add step button");
        return this;
    }

    @Step("Create shared steps")
    public CreateSharedStepPage createSharedSteps(SharedStep step) {
        new ExpandableTextArea(driver, "Action").write(step.getAction());
        new ExpandableTextArea(driver, "Input data").write(step.getInputData());
        new ExpandableTextArea(driver, "Expected result").write(step.getExpectedResult());
        return this;
    }

    @Step("Click the Create button")
    public SharedStepPage clickCreateButton() {
        driver.findElement(CREATE_BUTTON).click();
        log.info("Click the Create button");
        return new SharedStepPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SHARED_STEPS_LIST_TITLE);
    }
}
