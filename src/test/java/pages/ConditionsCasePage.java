package pages;

import elements.TextArea;
import org.openqa.selenium.WebDriver;

public class ConditionsCasePage extends CasePage{
    public ConditionsCasePage fillInConditionsFields(){
        new TextArea(driver,"Pre-conditions").write("hhdhdhdhdhd");
        new TextArea(driver,"Post-conditions").write("pppppppppppp");
        return this;
    }
    public ConditionsCasePage(WebDriver driver) {
        super(driver);
    }
}
