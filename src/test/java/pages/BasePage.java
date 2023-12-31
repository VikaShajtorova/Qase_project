package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;
import java.util.NoSuchElementException;

@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final String BASE_URL = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
    public static final By CREATE_BUTTON = By.xpath("//button[@type='submit' or text()='Create']");
    public static final By CANCEL_BUTTON = By.xpath("//button//span[text()='Cancel']");
    public static final By ALERT_MESSAGE = By.xpath("//div[@role='alert']//span[@class='ic9QAx']");
    public static final By CLONE_BUTTON = By.xpath("//button[@type='submit']//span[@class='ZwgkIF' or text()='Clone']");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    protected abstract boolean isPageOpen();

    @Step("Check the presence of the locator in case of absence, the method will give false")
    protected boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
