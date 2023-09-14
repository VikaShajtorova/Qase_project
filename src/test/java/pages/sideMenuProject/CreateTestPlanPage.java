package pages.sideMenuProject;

import elements.ExpandableTextArea;
import elements.Input;
import elements.TextEditor;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.RepositoryPage;

@Log4j2
public class CreateTestPlanPage extends BasePage {

    public static final By CREATE_TEST_PLAN = By.xpath("//h1[text()='Create test plan']");
    public static final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");

    public CreateTestPlanPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input in fields shared step Title and Description")
    public CreateTestPlanPage fillInTitleAndDescriptionField(TestPlan testPlan) {
        new Input(driver, "Title").write(testPlan.getTitle());
        new TextEditor(driver, "Description").write(testPlan.getDescription());
        return this;
    }

    @Step("Click the Add cases button")
    public SelectTestCasesPage clickAddCasesButton() {
        driver.findElement(ADD_CASES_BUTTON).click();
        log.info("Find the item: " + ADD_CASES_BUTTON + " and click");
        return new SelectTestCasesPage(driver);
    }

    @Step("Click the Create plan button")
    public TestPlansPage clickCreatePlanButton() {
        driver.findElement(CREATE_BUTTON).click();
        log.info("Find the item: " + CREATE_BUTTON + " and click");
        return new TestPlansPage(driver);
    }

    @Step("CreateTestPlanPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(CREATE_TEST_PLAN);
    }
}
