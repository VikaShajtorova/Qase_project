package pages.sideMenuProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
 public class TestPlansPage extends BasePage {
     public static final By TEST_PLAN_BUTTON = By.xpath("//span[text()='Test Plans']");
    public static final By CREATE_PLAN_BUTTON = By.id("createButton");
    public TestPlansPage(WebDriver driver) {
        super(driver);
    }
    public CreateTestPlanPage clickCreatePlanButton(){
        driver.findElement(CREATE_PLAN_BUTTON).click();
        return new CreateTestPlanPage(driver);
    }

    public TestPlansPage clickTestPlanButton(){
        driver.findElement(TEST_PLAN_BUTTON).click();
        return this;
    }

    @Override
    protected boolean isPageOpen() {
        return isExist(CREATE_PLAN_BUTTON);
    }
}
