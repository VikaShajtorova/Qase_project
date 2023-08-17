package pages;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParametersCasePage extends CasePage{
    public static final By ADD_PARAMETER_BUTTON =  By.xpath("//span[text()='Add parameter']/ancestor::div[@id='case-attachments']");
    public static final By ADD_STEP_BUTTON =  By.xpath("//button[@type='button']//span[text()=' Add step']");
    public static final By ADD_SHRED_STEP_BUTTON =  By.xpath("//button[@type='button']//span[text()=' Add shared step']");
    public static final By ADD_VALUE_BUTTON =  By.xpath("//button[@type='button']//span[text()='Add value']");
    public static final By REMOVE_PARAMETER_BUTTON = By.xpath("//button[@aria-label='Remove parameter']/../../div[@class='uzb236']");
    public static final By REMOVE_PARAMETER_VALUE_BUTTON = By.xpath("//button[@aria-label='Remove parameter value']/../../../div[@class='orFHna H4dNGP'][1]");
    public ParametersCasePage(WebDriver driver) {
        super(driver);
    }


    public ParametersCasePage clickAddParameterButton(){
        driver.findElement(ADD_PARAMETER_BUTTON).click();
        return this;
    }

    public ParametersCasePage fillInParametersFields(){
        new Input(driver,"Parameter title").write("");
        new Input(driver,"Parameter values").write("");
        return this;
    }

    public ParametersCasePage clickAddValueButton(){
        driver.findElement(ADD_VALUE_BUTTON).click();
        return this;
    }
    public ParametersCasePage deleteValue(){
        driver.findElement(REMOVE_PARAMETER_VALUE_BUTTON).click();
        return this;
    }

    public ParametersCasePage addValueAndWrite(){
        clickAddValueButton();
        new Input(driver,"Parameter values").write("");
        return this;
    }


    public ParametersCasePage deleteParameter(){
        driver.findElement(REMOVE_PARAMETER_BUTTON).click();
        return this;
    }

    public ParametersCasePage fillInTestCaseStepsFields(){
        new Input(driver,"Step Action").writeTestCaseSteps("");
        new Input(driver,"Data").writeTestCaseSteps("");
        new Input(driver,"Expected result").writeTestCaseSteps("");
        return this;
    }

    public ParametersCasePage clickAddStepButton(){
        driver.findElement(ADD_STEP_BUTTON).click();
        return this;
    }

    public ParametersCasePage clickAddShredStepButton(){
        driver.findElement(ADD_SHRED_STEP_BUTTON).click();
        return this;
    }
}
