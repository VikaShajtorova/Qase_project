package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
@Log4j2
public class AttachmentsCasePage extends CasePage {
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[@type='button' and text()='Add attachment']");
    public static final By UPLOAD_NEW_BUTTON = By.xpath("//div[@class='dz-default dz-message']");

    public AttachmentsCasePage(WebDriver driver) {
        super(driver);
    }
    @Step("Click the Add Attachment button")
    public void clickAddAttachmentButton() {
        driver.findElement(ADD_ATTACHMENT_BUTTON).click();
    }
    @Step("Click the Upload new button")
    public void clickUploadNewButton() {
        driver.findElement(UPLOAD_NEW_BUTTON).click();
    }
    @Step("Attach a new file")
    public void downloadFile() {
        File file = new File("src/test/resources/Screenshot_8.png");
        driver.findElement(UPLOAD_NEW_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Select a file: "+UPLOAD_NEW_BUTTON+" src/test/resources/Screenshot_8.png");
    }
}
