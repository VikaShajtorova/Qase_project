package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

@Log4j2
public class LoginPage extends BasePage {
    public static final By EMAIL = By.xpath("//input[@name='email']");
    public static final By PASSWORD = By.xpath("//input[@name='password']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='nlvny_']//span[@class='VF_8Uu']");

    public static final String message = "//input[@placeholder='%s']/ancestor::div[@class='tdishH']//small[@class='VV3w3Z']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open LoginPage")
    public LoginPage open() {
        driver.get(BASE_URL + "login");
        log.info("Go to the LoginPage by:" + BASE_URL + "login");
        return this;
    }

    @Step("Input the email and the password")
    public LoginPage inputEmailAndPassword(String email, String password) {
        driver.findElement(EMAIL).sendKeys(email);
        log.info("Input in the email field email");
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Input in the password field password");
        return this;
    }

    @Step("Click the Sign in button")
    public ProjectsPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        log.info("Find the item: " + SIGN_IN_BUTTON + " and click");
        return new ProjectsPage(driver);
    }

    @Step("Get a message about incorrect authorization")
    public String getErrorMessage() {
        String errorMessage = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Get a text message about incorrect authorization: " + errorMessage);
        return errorMessage;
    }

    @Step("Get a message about incorrect authorization")
    public String getMessage(String placeholder) {
        String messageText = driver.findElement(By.xpath(String.format(message, placeholder))).getText();
        log.info("Get a text message about incorrect authorization: " + messageText);
        return messageText;
    }

    @Step("User registers with valid data")
    public ProjectsPage userRegistersWithValidData() {
        open();
        log.info("Open LoginPage");
        inputEmailAndPassword(System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email")),
                System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password")));
        log.info("Input login and password");
        clickSignInButton();
        log.info("Click the Sign in button");
        return new ProjectsPage(driver);
    }

    @Step("LoginPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(SIGN_IN_BUTTON);
    }
}
