package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CloneCaseModalPage extends BasePage {
    public CloneCaseModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the clone button in the modal window of the case")
    public RepositoryPage clickCloneButtonOnCloneCaseModalPage() {
        driver.findElement(CLONE_BUTTON).click();
        log.info("Find the item: " + CLONE_BUTTON + " and click");
        return new RepositoryPage(driver);
    }

    @Step("CloneCaseModalPage loaded")
    @Override
    protected boolean isPageOpen() {
        return false;
    }
}
