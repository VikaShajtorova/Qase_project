package pages.sideMenuProject;

import elements.DropDown;
import elements.TextEditor;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Run;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class TestRunsModalPage extends BasePage {
    public static final By START_A_RUN_BUTTON = By.xpath("//button[@type='submit']//span[@class='ZwgkIF' or text()='Start a run']");
    public static final By SELECT_CASES = By.xpath("//button[@type='button']//span[@class='ZwgkIF' and text()='Select cases']");

    public TestRunsModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Start a run button")
    public ListOfSuitesInRunPage clickStarRunButton() {
        driver.findElement(START_A_RUN_BUTTON).click();
        log.info("Find the item: " + START_A_RUN_BUTTON + " and click");
        return new ListOfSuitesInRunPage(driver);
    }

    @Step("Fill in the Basic fields by label")
    public TestRunsModalPage fillInFieldsModalRun(Run run) {
        new TextEditor(driver, "Description").write(run.getDescription());
        new DropDown(driver, "Environment").selectOptionSuite(run.getEnvironment());
        return this;
    }

    @Step("Click the Select cases button")
    public SelectCasesModalPage clickSelectCasesButton() {
        driver.findElement(SELECT_CASES).click();
        log.info("Find the item: " + SELECT_CASES + " and click");
        return new SelectCasesModalPage(driver);
    }

    @Step("TestRunsModalPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(START_A_RUN_BUTTON);
    }
}
