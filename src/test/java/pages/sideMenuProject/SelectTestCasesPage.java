package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

@Log4j2
public class SelectTestCasesPage extends BasePage {
    public static final By SELECT_TEST_CASES_TITLE = By.xpath("//h3[text()='Select test cases ']");
    public static final By LIST_SUITES = By.xpath("//div[@class='suite']//div[@class='checkbox']//span");
    public static final By DONE_BUTTON = By.xpath("//button//span[text()='Done']");

    public SelectTestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select a suite from list")
    public SelectTestCasesPage selectSuiteFromList() {
        List<WebElement> list = driver.findElements(LIST_SUITES);
        list.get(0).click();
        log.info("Put suites in the list and click");
        return this;
    }

    @Step("Click the Done button")
    public CreateTestPlanPage clickDoneButton() {
        driver.findElement(DONE_BUTTON).click();
        log.info("Find the item: " + DONE_BUTTON + " and click");
        return new CreateTestPlanPage(driver);
    }

    @Step("SelectTestCasesPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(SELECT_TEST_CASES_TITLE);
    }
}
