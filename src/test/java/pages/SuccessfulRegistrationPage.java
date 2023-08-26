package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SuccessfulRegistrationPage extends BasePage {
    public static final By REGISTRATION_MASSAGE = By.xpath("//h1[@data-qase-test='congratulations']");
    public static final By MESSAGE = By.xpath("//div[@class='error404 text-start']//p[contains(text(),'created your account')]");


    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the message about successful registration")
    public String getMessageAboutSuccessfulRegistration() {
        log.info("Find xpath and get the message text: " + MESSAGE);
        return driver.findElement(MESSAGE).getText();
    }

    @Step("Made sure that I went to the successful registration page")
    @Override
    public boolean isPageOpen() {
        return isExist(REGISTRATION_MASSAGE);
    }
}
