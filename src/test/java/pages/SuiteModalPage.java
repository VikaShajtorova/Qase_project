package pages;

import elements.DropDown;
import elements.Input;
import elements.TextEditor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class SuiteModalPage extends BasePage{
    public static final By CREATE_NEW_SUITE_TITLE = By.xpath("//h3[@class='r_U3IU']");
    public SuiteModalPage(WebDriver driver) {
        super(driver);
    }

    public SuiteModalPage createSuite(){
        new Input(driver,"Suite name").write("Authorization");
        new DropDown(driver,"Parent suite").selectOption("Project root");
        new TextEditor(driver,"Description").write("The user fills in the fields on the authorization page");
        new TextEditor(driver,"Description").write("User on the authorization page");
        return this;
    }

    public SuiteModalPage clickCreateButton() {
        driver.findElement(CREATE_BUTTON).click();
        return this;
    }

    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_NEW_SUITE_TITLE);
    }
}
