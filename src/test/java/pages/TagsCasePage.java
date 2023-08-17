package pages;

import elements.DropDown;
import models.Case;
import org.openqa.selenium.WebDriver;

public class TagsCasePage extends CasePage{
    public TagsCasePage fillInTagsFields(Case caseTags){
        new DropDown(driver,"Select...").selectOptionTags(caseTags.getSelect(),"class");
        return this;
    }

    public TagsCasePage(WebDriver driver) {
        super(driver);
    }
}
