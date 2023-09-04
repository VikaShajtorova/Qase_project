package elements;

import io.qameta.allure.Step;
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

    @Step("Clear and write the text in TextEditor")
    public void write(String text) {
        driver.findElement(By.xpath(String.format(textEditorLocator, this.label))).clear();
        log.info("Find the TextEditor field by label: " + label + " and clear: ");
        driver.findElement(By.xpath(String.format(textEditorLocator, this.label))).sendKeys(text);
        log.info("Find the TextEditor field by label: " + label + " and write text: " + text);
    }

}
