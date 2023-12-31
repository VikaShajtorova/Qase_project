package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class DropDown {
    WebDriver driver;
    String label;
    WebDriverWait wait;
    String dropDownLocator = "//label[text()='%s']/ancestor::div[contains(@class,'col-sm-12')]//div[@class='Thgbhj euhZGB cfvQxI']";
    String dropDownMilestone = "//label[text()='Milestone']/ancestor::div[contains(@class,'form-group')]" +
            "//div[contains(@class,'notranslate')]";
    String optionLocator = "//div[@class='vp8Qwu']//div//div//div[text()='%s']";
    String optionLocatorMilestone = "//div[@class=' css-7dqksl']//div[text()='%s']";
    String dropDownLocatorSuite = "//label[text()='%s']/ancestor::div[contains(@class,'qaOPP6')]//span";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Select an option from the drop-down list")
    public void selectOption(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownLocator, this.label)))).click();
        log.info("Find the DropDown field by label: " + label + " and clicks");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator, option)))).click();
        log.info("Find the DropDown option field by label: " + label + " and clicks");
    }

    @Step("Select an option from the drop-down list")
    public void selectOptionSuite(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownLocatorSuite, this.label)))).click();
        log.info("Find the DropDown field by label: " + label + " and clicks");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator, option)))).click();
        log.info("Find the DropDown option field by label: " + label + " and clicks");
    }

    @Step("Select an option from the drop-down list")
    public void selectOptionMilestone(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownMilestone, this.label)))).click();
        log.info("Find the DropDown field by label: " + label + " and clicks");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocatorMilestone, option)))).click();
        log.info("Find the DropDown option field by label: " + label + " and clicks");
    }
}
