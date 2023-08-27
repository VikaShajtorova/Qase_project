package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Email;
import models.EmailFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SignupPage extends BasePage {
    public static final By SIGN_UP_BUTTON = By.xpath("//button[@type='submit']");
    public static final By E_MAIL = By.xpath("//input[@placeholder='E-Mail']");
    public static final By PASSWORD = By.xpath("//input[@placeholder='Password']");
    public static final By PASSWORD_CONFIRMATION = By.xpath("//input[@placeholder='Password confirmation']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open SignupPage")
    public SignupPage open() {
        driver.get(BASE_URL + "signup");
        log.info("Go to the SignupPage by:" + BASE_URL + "signup");
        return this;
    }

    @Step("Create and enter a random email address in the mail field")
    public SignupPage createEmail() {
        Email email = EmailFactory.inputEmail();
        new SignupPage(driver).writeEmail(email);
        return this;
    }

    @Step("Write a email address in the mail field")
    public SignupPage writeEmail(Email e_mail) {
        driver.findElement(E_MAIL).sendKeys(e_mail.getE_mail());
        return this;
    }

    public SignupPage inputPasswordPasswordConfirmationInRegistrationForm(String password, String passwordConfirmation) {
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Input in the password field");
        driver.findElement(PASSWORD_CONFIRMATION).sendKeys(passwordConfirmation);
        log.info("Input in the password confirmation field: " + PASSWORD_CONFIRMATION);
        return this;
    }

    @Step("Input email: '{email}' password: '{password}' and password confirmation: '{passwordConfirmation}'")
    public SignupPage inputEmailPasswordPasswordConfirmationInRegistrationForm(String email, String password, String passwordConfirmation) {
        driver.findElement(E_MAIL).sendKeys(email);
        log.info("Input in the email field");
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Input in the password field");
        driver.findElement(PASSWORD_CONFIRMATION).sendKeys(passwordConfirmation);
        log.info("Input in the password confirmation field: " + PASSWORD_CONFIRMATION);
        return this;
    }


    @Step("Click the Sign up button")
    public SuccessfulRegistrationPage clickSignUpButton() {
        driver.findElement(SIGN_UP_BUTTON).click();
        log.info("Find xpath and click: " + SIGN_UP_BUTTON);
        return new SuccessfulRegistrationPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getMessage(String placeholder) {
        return driver.findElement(By.xpath(String.format(message, placeholder))).getText();
    }

    @Step("Signup page loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(SIGN_UP_BUTTON);
    }
}
