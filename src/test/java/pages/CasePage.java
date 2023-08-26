package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CasePage extends BasePage{
    protected static final By CREATE_TEST_CASE_TITLE = By.xpath("//h1//a[@title='Repository']");
    protected static final By SAVE_BUTTON = By.id("save-case");
    protected static final By SAVE_AND_CREATE_ANOTHER_BUTTON = By.xpath("//button[@type='submit']//span[text()='Save and create another']");


    public CasePage(WebDriver driver) {
        super(driver);
    }

    public CasePage createCase(){
        new BasicCasePage(driver).fillInBasicFields();
        new ConditionsCasePage(driver).fillInConditionsFields();
        return this;
    }

    public RepositoryPage clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();
        return new RepositoryPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_TEST_CASE_TITLE);
    }
}
