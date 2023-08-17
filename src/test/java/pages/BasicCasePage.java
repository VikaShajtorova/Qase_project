package pages;

import elements.DropDown;
import elements.Input;
import elements.TextEditor;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.WebDriver;
@Log4j2
public class BasicCasePage extends CasePage{
    @Step("Fill in the Basic fields by label")
    public BasicCasePage fillInBasicFields(Case caseBasic){
        new Input(driver,"Title").write(caseBasic.getTitle());
        new DropDown(driver,"Status").selectOption(caseBasic.getStatus());
        new TextEditor(driver,"Description").write(caseBasic.getDescription());
        new DropDown(driver,"Suite").selectOption(caseBasic.getSuite());
        new DropDown(driver,"Type").selectOption(caseBasic.getType());
        new DropDown(driver,"Milestone").selectOptionMilestone(caseBasic.getMilestone());
        new DropDown(driver,"Severity").selectOption(caseBasic.getSeverity());
        new DropDown(driver,"Layer").selectOption(caseBasic.getLayer());
        new DropDown(driver,"Behavior").selectOption(caseBasic.getBehavior());
        new DropDown(driver,"Priority").selectOption(caseBasic.getPriority());
        new DropDown(driver,"Is flaky").selectOption(caseBasic.getIs_Flaky());
        new DropDown(driver,"Automation status").selectOption(caseBasic.getAutomationStatus());
        return this;
    }

    public BasicCasePage(WebDriver driver) {
        super(driver);
    }
}
