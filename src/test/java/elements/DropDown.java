package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class DropDown {
    WebDriver driver;
    String label;
    String dropDownLocator = "//label[text()='%s']/../..//span";
    String optionLocator = "//div[@class='vp8Qwu']//div[text()='Authorizat']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Step("Select an option from the drop-down list")
    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(dropDownLocator, this.label, this.label))).click();
        log.info("Finds the xpath DropDown by its name and clicks" + dropDownLocator);
        driver.findElement(By.xpath(String.format(optionLocator, option, option))).click();
        log.info("Finds the xpath DropDown option by its name and clicks" + optionLocator);
    }
}
