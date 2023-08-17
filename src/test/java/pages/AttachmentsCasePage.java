package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AttachmentsCasePage extends CasePage{
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[@type='button' and text()='Add attachment']");

    public AttachmentsCasePage(WebDriver driver) {
        super(driver);
    }
}
