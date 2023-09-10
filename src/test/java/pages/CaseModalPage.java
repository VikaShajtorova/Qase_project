package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.createCase.CasePage;

@Log4j2
public class CaseModalPage extends BasePage {
    public static final By DELETE_BUTTON = By.xpath("//span[@class='ZwgkIF']//i[@class='far fa-trash']");
    public static final By CLONE_BUTTON = By.xpath("//span[@class='ZwgkIF']//i[@class='far fa-clone']");
    public static final By EDIT_BUTTON = By.xpath("//span[@class='ZwgkIF']//i[@class='far fa-pencil']");
    public static final By DELETE_BUTTON_IN_MODAL = By.xpath("//button[@type='button']" +
            "/ancestor::div[contains(@class,'ReactModal__Content')]//span[text()='Delete']");

    public CaseModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Delete a case")
    public RepositoryPage deleteCase() {
        driver.findElement(DELETE_BUTTON).click();
        log.info("Find the item: " + DELETE_BUTTON + " and click");
        driver.findElement(DELETE_BUTTON_IN_MODAL).click();
        log.info("Find the item: " + DELETE_BUTTON_IN_MODAL + " and click");
        return new RepositoryPage(driver);
    }

    @Step("Click the Clone button on CaseModalPage")
    public CloneCaseModalPage clickCloneButtonOnCaseModalPage() {
        driver.findElement(CLONE_BUTTON).click();
        log.info("Find the item: " + CLONE_BUTTON + " and click");
        return new CloneCaseModalPage(driver);
    }

    @Step("Click the Edit button")
    public CasePage clickEditButtonOnCaseModalPage() {
        driver.findElement(EDIT_BUTTON).click();
        log.info("Find the item: " + EDIT_BUTTON + " and click");
        return new CasePage(driver);
    }
    @Step("CaseModalPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(DELETE_BUTTON);
    }
}
