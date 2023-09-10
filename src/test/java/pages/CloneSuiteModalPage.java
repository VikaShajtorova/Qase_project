package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CloneSuiteModalPage extends BasePage {
    public CloneSuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Clone button on SuiteModalPage")
    public RepositoryPage clickCloneButtonOnSuiteModalPage() {
        driver.findElement(CLONE_BUTTON).click();
        log.info("Find the item: " + CLONE_BUTTON + " and click");
        return new RepositoryPage(driver);
    }

    @Step("CloneSuiteModalPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(CLONE_BUTTON);
    }
}
