package pages.sideMenuProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class SelectTestCasesPage extends BasePage {
    public static final By SELECT_TEST_CASES_TITLE = By.xpath("//h3[text()='Select test cases ']");
    public static final By LIST_SUITES = By.xpath("//div[@class='suite']//div[@class='checkbox']//span");
    public static final By DONE_BUTTON = By.xpath("//button//span[text()='Done']");
    public SelectTestCasesPage(WebDriver driver) {
        super(driver);
    }

    public SelectTestCasesPage selectSuiteFromList(){
        List<WebElement> list = driver.findElements(LIST_SUITES);
        list.get(0).click();
        return this;
    }

    public CreateTestPlanPage clickDoneButton(){
        driver.findElement(DONE_BUTTON).click();
        return new CreateTestPlanPage(driver);
    }

    @Override
    protected boolean isPageOpen() {
        return isExist(SELECT_TEST_CASES_TITLE);
    }
}
