package pages.createCase;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RepositoryPage;

import java.io.File;
import java.util.List;

@Log4j2
public class AttachmentsCasePage extends CasePage {
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[@type='button' and text()='Add attachment']");
    public static final By UPLOAD_NEW_BUTTON = By.xpath("//input[@type='file']");
    public static final By FILE_NAME = By.xpath("//span[text()='Screenshot_8.png']");
    public static final By BROWSE_BUTTON = By.xpath("//a[@class='nav-link attach-existing']");
    public static final By FILE_LIST = By.xpath("//div[@class='attach-existing-form attachments']//a");
    public static final By FILE_IS_DISPLAYED = By.xpath("//div[@class='Vu0OIH']//a");

    public AttachmentsCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click the Add Attachment button")
    public void clickAddAttachmentButton() {
        driver.findElement(ADD_ATTACHMENT_BUTTON).click();
        log.info("Find element and click "+ADD_ATTACHMENT_BUTTON);
    }

    @Step("Click the Browse button")
    public void clickBrowseButton() {
        driver.findElement(BROWSE_BUTTON).click();
        log.info("Find element and click "+BROWSE_BUTTON);
    }

    @Step("Select a file from list")
    public AttachmentsCasePage selectFileFromList() {
        List<WebElement> list = driver.findElements(FILE_LIST);
        list.get(0).click();
        log.info("Put file in the list and click");
        return this;
    }

    @Step("Attach a new file")
    public void downloadFile() {
        File file = new File("src/test/resources/Screenshot_8.png");
        driver.findElement(UPLOAD_NEW_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Select a file: " + UPLOAD_NEW_BUTTON + " src/test/resources/Screenshot_8.png");
    }

    public String getFileName() {
        String fileName = driver.findElement(FILE_NAME).getText();
        log.info("Find element: "+FILE_NAME + "get text"+fileName);
        return fileName;
    }

    @Step("Checks that list cases is displayed")
    public boolean checksThatFileIsDisplayed() {
        boolean isDisplayed = driver.findElement(FILE_IS_DISPLAYED).isDisplayed();
        log.info("Checks that list cases is displayed");
        return isDisplayed;
    }
}
