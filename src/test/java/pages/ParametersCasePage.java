package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ParametersCasePage extends CasePage{
    public static final By ADD_PARAMETER_BUTTON =  By.xpath("//span[text()='Add parameter']/ancestor::button");
    public static final By ADD_STEP_BUTTON =  By.xpath("//button[@type='button']//span[text()=' Add step']");
    public static final By ADD_SHRED_STEP_BUTTON =  By.xpath("//button[@type='button']//span[text()=' Add shared step']");
    public static final By ADD_VALUE_BUTTON =  By.xpath("//button[@type='button']//span[text()='Add value']");
    public static final By REMOVE_PARAMETER_BUTTON = By.xpath("//button[@aria-label='Remove parameter']/../../div[@class='uzb236']");
    public static final By REMOVE_PARAMETER_VALUE_BUTTON = By.xpath("//button[@aria-label='Remove parameter value']/../../../div[@class='orFHna H4dNGP'][1]");
    public ParametersCasePage(WebDriver driver) {
        super(driver);
    }
@Step("Click the Add Parameter button")

    public ParametersCasePage clickAddParameterButton(){
        driver.findElement(ADD_PARAMETER_BUTTON).click();
        return this;
    }
    @Step("Fill in the Parameters fields by label")
    public ParametersCasePage fillInParametersFields(Case caseParameter){
        new Input(driver,"Parameter title").write(caseParameter.getParameterTitle());
        new Input(driver,"Parameter values").write(caseParameter.getParameterValues());
        return this;
    }
    @Step("Click the Add Value button")
    public ParametersCasePage clickAddValueButton(){
        driver.findElement(ADD_VALUE_BUTTON).click();
        return this;
    }
    @Step("Click the delete Value button")
    public ParametersCasePage deleteValue(){
        driver.findElement(REMOVE_PARAMETER_VALUE_BUTTON).click();
        return this;
    }
    @Step("Click the add Value button and write a text")
    public ParametersCasePage addValueAndWrite(Case caseParameter){
        clickAddValueButton();
        new Input(driver,"Parameter values").write(caseParameter.getParameterValues());
        return this;
    }

    @Step("Click the delete Parameter button")
    public ParametersCasePage deleteParameter(){
        driver.findElement(REMOVE_PARAMETER_BUTTON).click();
        return this;
    }
    @Step("Fill in the Steps fields by label")
    public ParametersCasePage fillInTestCaseStepsFields(Case caseStep){
        new Input(driver,"Step Action").writeTestCaseSteps(caseStep.getStepAction());
        new Input(driver,"Data").writeTestCaseSteps(caseStep.getData());
        new Input(driver,"Expected result").writeTestCaseSteps(caseStep.getExpectedResult());
        return this;
    }
    @Step("Click the Add Step button")
    public ParametersCasePage clickAddStepButton(){
        driver.findElement(ADD_STEP_BUTTON).click();
        return this;
    }
    @Step("Click the Add Shred Step button")
    public ParametersCasePage clickAddShredStepButton(){
        driver.findElement(ADD_SHRED_STEP_BUTTON).click();
        return this;
    }
}
