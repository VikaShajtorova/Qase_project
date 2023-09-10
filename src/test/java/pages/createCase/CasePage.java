package pages.createCase;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

@Log4j2
public class CasePage extends BasePage {
    protected static final By CREATE_TEST_CASE_TITLE = By.xpath("//h1//a[@title='Repository']");
    protected static final By SAVE_BUTTON = By.id("save-case");
    protected static final By SAVE_AND_CREATE_ANOTHER_BUTTON = By.xpath("//button[@type='submit']" +
            "//span[text()='Save and create another']");


    public CasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Save button")
    public RepositoryPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("Find element and click " + SAVE_BUTTON);
        return new RepositoryPage(driver);
    }

    @Step("Case page loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_TEST_CASE_TITLE);
    }
}
