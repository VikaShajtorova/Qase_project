package tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class RepositoryTest extends BaseTest{
    @Test
    public void userCreatesSuite() {
        loginPage.userRegistersWithValidData();
        projectsPage.getLatestProjectInListAndClick();
        repositoryPage.clickSuiteButton()
                .isPageOpen();
        suiteModalPage.createSuite()
                .clickCreateButton();


        assertEquals(repositoryPage.getTextOfMessageAboutCreationOfSuite(),"Suite was successfully created.",
                "The message is missing or does not match");
    }
    @Test
    public void userCreateCase(){
        loginPage.userRegistersWithValidData();
        projectsPage.getLatestProjectInListAndClick();
        repositoryPage.clickCaseButton();
        casePage.createCase();
        casePage.clickSaveButton();
    }

}
