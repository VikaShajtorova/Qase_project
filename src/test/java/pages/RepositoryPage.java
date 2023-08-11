package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RepositoryPage extends BasePage {
    public static final By REPOSITORY_TITLE = By.xpath("//h1[@class='fGDnu0']");
    public static final By SUITE_BUTTON = By.id("create-suite-button");

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the project code")
    public String getProjectCode() {
        String projectCode = driver.findElement(REPOSITORY_TITLE).getText();
        log.info("Find xpath and get the project code: " + REPOSITORY_TITLE);
        return projectCode;
    }

    @Step("Click Suite button")
    public SuiteModalPage clickSuiteButton() {
        driver.findElement(SUITE_BUTTON).click();
        log.info("Find xpath and click: " + SUITE_BUTTON);
        return new SuiteModalPage(driver);
    }

    @Step("Made sure that I went to the repository page")
    @Override
    public boolean isPageOpen() {
        return isExist(REPOSITORY_TITLE);
    }
}
