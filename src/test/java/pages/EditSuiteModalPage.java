package pages;

import elements.DropDown;
import elements.Input;
import elements.TextEditor;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class EditSuiteModalPage extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//button[@type='submit']//span[@class='ZwgkIF']");

    public EditSuiteModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("The user edits the suite")
    public RepositoryPage editsSuite(Suite editSuite) {
        new Input(driver, "Suite name").write(editSuite.getSuiteName());
        new DropDown(driver, "Parent suite").selectOptionSuite(editSuite.getParentSuite());
        new TextEditor(driver, "Description").write(editSuite.getDescription());
        new TextEditor(driver, "Preconditions").write(editSuite.getPreconditions());
        return clickSaveButton();
    }

    @Step("User click the Save button")
    public RepositoryPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("Find the item: " + SAVE_BUTTON + " and click");
        return new RepositoryPage(driver);
    }

    @Step("EditSuiteModalPage loaded")
    @Override
    protected boolean isPageOpen() {
        return isExist(SAVE_BUTTON);
    }

}
