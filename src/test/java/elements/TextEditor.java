package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class TextEditor {
    WebDriver driver;
    String label;
    String textEditorLocator = "//label[text()='%s']/../..//p";

    public TextEditor(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(textEditorLocator, this.label))).clear();
        log.info("Find the input field by label and clear: " + textEditorLocator + " " + this.label);
        driver.findElement(By.xpath(String.format(textEditorLocator, this.label))).sendKeys(text);
        log.info("Find the input field by label and write text: " + textEditorLocator + " " + this.label);
    }

}
