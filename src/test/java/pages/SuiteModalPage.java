package pages;

import elements.DropDown;
import elements.Input;
import elements.TextEditor;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SuiteModalPage extends BasePage {
    public static final By CREATE_NEW_SUITE_TITLE = By.xpath("//h3[@class='r_U3IU']");

    public SuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create a suite by filling in all the fields")
    public SuiteModalPage createSuite(Suite suite) {
        new Input(driver, "Suite name").write(suite.getSuiteName());
        new DropDown(driver, "Parent suite").selectOption("Project root");
        new TextEditor(driver, "Description").write(suite.getDescription());
        new TextEditor(driver, "Preconditions").write(suite.getPreconditions());
        return this;
    }

    @Step("Create a suite by filling in the required fields")
    public SuiteModalPage createSuiteByFillingInRequiredFields(Suite suite) {
        new Input(driver, "Suite name").write(suite.getSuiteName());
        return this;
    }

    @Step("Click the Create button")
    public RepositoryPage clickCreateButton() {
        driver.findElement(CREATE_BUTTON).click();
        log.info("Find the item: " + CREATE_BUTTON + " and click");
        return new RepositoryPage(driver);
    }

    @Step("SuiteModalPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_NEW_SUITE_TITLE);
    }
}
