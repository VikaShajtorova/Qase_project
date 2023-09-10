package pages.createCase;

import elements.ExpandableTextArea;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ConditionsCasePage extends CasePage {
    public ConditionsCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in the Conditions fields by label")
    public ConditionsCasePage fillInConditionsFields(Case caseConditions) {
        new ExpandableTextArea(driver, "Pre-conditions").write(caseConditions.getPre_Conditions());
        new ExpandableTextArea(driver, "Post-conditions").write(caseConditions.getPost_Conditions());
        return this;
    }

}
