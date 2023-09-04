package pages.sideMenuProject;

import elements.ExpandableTextArea;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.TestPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class CreateTestPlanPage extends BasePage {

    public static final By CREATE_TEST_PLAN = By.xpath("//h1[text()='Create test plan']");
    public static final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");
    public CreateTestPlanPage(WebDriver driver) {
        super(driver);
    }

    public CreateTestPlanPage fillInTitleAndDescriptionField(TestPlan testPlan){
        new Input(driver,"Title").write(testPlan.getTitle());
        new ExpandableTextArea(driver,"Description").write(testPlan.getDescription());
        return this;
    }
    public SelectTestCasesPage clickAddCasesButton(){
        driver.findElement(ADD_CASES_BUTTON).click();
        return new SelectTestCasesPage(driver);
    }

    @Override
    protected boolean isPageOpen() {
        return isExist(CREATE_TEST_PLAN);
    }
}
