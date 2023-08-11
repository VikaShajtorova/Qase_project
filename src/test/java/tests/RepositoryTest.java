package tests;

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


    }

}
