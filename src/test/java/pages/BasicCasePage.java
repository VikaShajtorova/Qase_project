package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import elements.TextEditor;
import org.openqa.selenium.WebDriver;

public class BasicCasePage extends CasePage{
    public BasicCasePage fillInBasicFields(){
        new Input(driver,"Title").write("Enter valid data in the password field");
        new DropDown(driver,"Status").selectOption("Draft");
        new TextEditor(driver,"Description").write("The user is on the registration page");
        new DropDown(driver,"Suite").selectOption("Test cases without suite");
        new DropDown(driver,"Type").selectOption("Smoke");
        new DropDown(driver,"Milestone").selectOption("Not set");
        new DropDown(driver,"Severity").selectOption("Normal");
        new DropDown(driver,"Layer").selectOption("Not set");
        new DropDown(driver,"Behavior").selectOption("Positive");
        new DropDown(driver,"Priority").selectOption("High");
        new DropDown(driver,"Is flaky").selectOption("No");
        new DropDown(driver,"Automation status").selectOption("Not automated");
        return this;
    }

    public BasicCasePage(WebDriver driver) {
        super(driver);
    }
}
