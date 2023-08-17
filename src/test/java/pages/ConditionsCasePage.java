package pages;

import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ConditionsCasePage extends CasePage{
    @Step("Fill in the Conditions fields by label")
    public ConditionsCasePage fillInConditionsFields(Case caseConditions){
        new TextArea(driver,"Pre-conditions").write(caseConditions.getPre_Conditions());
        new TextArea(driver,"Post-conditions").write(caseConditions.getPost_Conditions());
        return this;
    }
    public ConditionsCasePage(WebDriver driver) {
        super(driver);
    }
}
