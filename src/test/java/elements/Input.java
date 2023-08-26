package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {
    WebDriver driver;
    String label;
    String inputLocator = "//label[text()='%s']/../..//input";
    String inputTestCaseSteps = "//p[@data-placeholder='%s']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;

    }

    @Step("Clear and write the text in Input")
    public void write(String text) {
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).clear();
        log.info("Find the input field by label: "+label+" and clear: ");
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
        log.info("Find the input field by label: "+label+" and write text: " +text);

    }

    public void writeTestCaseSteps(String text){
        driver.findElement(By.xpath(String.format(inputTestCaseSteps,this.label))).clear();
        driver.findElement(By.xpath(String.format(inputTestCaseSteps,this.label))).sendKeys(text);
    }

}
