package pages;

import elements.DropDown;
import elements.Input;
import elements.TextEditor;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class SuiteModalPage extends BasePage {
    String label;
    String dropDownLocatorSuite = "//label[text()='Parent suite']/ancestor::div[contains(@class,'qaOPP6')]//span";
    String optionLocator = "//div[@class='vp8Qwu']//div//div//div[text()='%s']";
    public static final By CREATE_NEW_SUITE_TITLE = By.xpath("//h3[@class='r_U3IU']");

    public SuiteModalPage(WebDriver driver) {
        super(driver);
    }

    public SuiteModalPage(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Step("Select an option from the drop-down list")
    public void selectOption(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownLocatorSuite, this.label)))).click();
        log.info("Find the DropDown field by label: " + label + " and clicks");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator, option)))).click();
        log.info("Find the DropDown option field by label: " + label + " and clicks");
    }

    @Step("Сreate a suite by filling in all the fields")
    public SuiteModalPage createSuite() {
        new Input(driver, "Suite name").write("Authorization");
        new SuiteModalPage(driver, "Parent suite").selectOption("Project root");
        new TextEditor(driver, "Description").write("The user fills in the fields on the authorization page");
        new TextEditor(driver, "Description").write("User on the authorization page");
        return this;
    }

    @Step("Create a suite by filling in the required fields")
    public SuiteModalPage createSuiteByFillingInRequiredFields() {
        new Input(driver, "Suite name").write("Authorization");
        return this;
    }

    @Step("Click the Create button")
    public SuiteModalPage clickCreateButton() {
        driver.findElement(CREATE_BUTTON).click();
        log.info("Click the Create button");
        return this;
    }



    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_NEW_SUITE_TITLE);
    }
}
