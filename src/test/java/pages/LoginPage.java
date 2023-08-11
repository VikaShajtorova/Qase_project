package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By EMAIL = By.xpath("//input[@name='email']");
    public static final By PASSWORD = By.xpath("//input[@name='password']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open LoginPage")
    public LoginPage open() {
        driver.get(BASE_URL + "login");
        log.info("Go to the LoginPage by:" + BASE_URL + "login");
        return this;
    }

    @Step("Input the email: '{email}' and the password: '{password}'")
    public LoginPage inputEmailAndPassword(String email, String password) {
        driver.findElement(EMAIL).sendKeys(email);
        log.info("Input in the email field: " + EMAIL + ": " + email);
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Input in the password field: " + PASSWORD + ": " + password);
        return this;
    }

    @Step("Click the Sign in button")
    public ProjectsPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        log.info("Find xpath and click: " + SIGN_IN_BUTTON);
        return new ProjectsPage(driver);
    }

    @Step("User registers with valid data")
    public ProjectsPage userRegistersWithValidData() {
        open();
        log.info("Open LoginPage");
        inputEmailAndPassword("shajtorova@mail.ru", "Dbrf_110585");
        log.info("Input login and password");
        clickSignInButton();
        log.info("Click the Sign in button");
        return new ProjectsPage(driver);
    }

    @Step("Made sure that I went to the login page")
    @Override
    public boolean isPageOpen() {
        log.info("Find xpath: "+SIGN_IN_BUTTON);
        return isExist(SIGN_IN_BUTTON);
    }
}
