package pages;

import elements.DropDown;
import org.openqa.selenium.WebDriver;

public class TagsCasePage extends CasePage{
    public TagsCasePage fillInTagsFields(){
        new DropDown(driver,"Select...").selectOption("Alert");
        return this;
    }

    public TagsCasePage(WebDriver driver) {
        super(driver);
    }
}
