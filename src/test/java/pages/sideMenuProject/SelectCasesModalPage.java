package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class SelectCasesModalPage extends BasePage {
    public static final By SELECT_TEST_CASES_TITLE = By.xpath("//h3[@class='r_U3IU' and text()='Select test cases ']");
    public static final By SELECT_CHECKBOX = By.xpath("//div[@class='suites-column']" +
            "//label//span[@class='custom-control-indicator']");
    public static final By DONE_BUTTON = By.xpath("//button[@type='button']//span[text()='Done']");

    public SelectCasesModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("The Select Checkbox and Click")
    public SelectCasesModalPage selectCasesFromCheckboxAndClick() {
        driver.findElement(SELECT_CHECKBOX).click();
        log.info("Find the item: " + SELECT_CHECKBOX + " and click");
        return this;
    }

    @Step("Click the Done button")
    public TestRunsModalPage clickDoneButton() {
        driver.findElement(DONE_BUTTON).click();
        log.info("Find the item: " + DONE_BUTTON + " and click");
        return new TestRunsModalPage(driver);
    }

    @Step("SelectCasesModalPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(SELECT_TEST_CASES_TITLE);
    }
}
