package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class DropDown {
    WebDriver driver;
    String label;
    WebDriverWait wait;
    String dropDownLocator = "//label[text()='%s']/../..//span";
    String optionLocator = "//div[@class='vp8Qwu']//div//div//div[text()='%s']";
//div[@class='vp8Qwu']//div//div//div[text()='%s']
    //div[text()='%s']/ancestor::div[@class='vp8Qwu']

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver,10);
    }

    @Step("Select an option from the drop-down list")
    public void selectOption(String option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownLocator,this.label))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownLocator,this.label))));
        driver.findElement(By.xpath(String.format(dropDownLocator, this.label))).click();
        log.info("Find the DropDown field by label: "+label+ " and clicks");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionLocator,option))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator,option))));
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        log.info("Find the DropDown option field by label: "+label+ " and clicks");
    }
}
