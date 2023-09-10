package pages.sideMenuProject;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class ListOfSuitesInRunPage extends BasePage {
    public static final By TEST_RUN_TITLE = By.xpath("//div[@class='isBlW6']//h1[@class='RxrRkU']");
    public static final By GO_BACK_BUTTON = By.xpath("//div[@class='isBlW6']//a[@title='Test run list']");

    public ListOfSuitesInRunPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Go back button")
    public TestRunsPage clickGoBackButton() {
        driver.findElement(GO_BACK_BUTTON).click();
        log.info("Find the item: " + GO_BACK_BUTTON + " and click");
        return new TestRunsPage(driver);
    }


    @Step("The title of the test run is displayed")
    public boolean titleOfTestRunIsDisplayed() {
        boolean isDisplayed = driver.findElement(TEST_RUN_TITLE).isDisplayed();
        log.info("The title of the test run is displayed: " + isDisplayed);
        return isDisplayed;
    }

    @Step("ListOfSuitesInRunPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(TEST_RUN_TITLE);
    }
}
