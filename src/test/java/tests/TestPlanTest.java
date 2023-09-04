package tests;

import models.Project;
import models.ProjectFactory;
import models.TestPlan;
import models.TestPlanFactory;
import org.testng.annotations.Test;
import pages.sideMenuProject.CreateTestPlanPage;

public class TestPlanTest extends BaseTest{
    @Test
    public void userCreateTestPlan(){
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInAllFieldsOfProject();
        projectModalPage.createProject(project)
                .clickSuiteButton()
                .createSuite()
                .clickCreateButton();
        repositoryPage.selectSuiteFromList()
        .clickCaseButton()
                .createCase()
                .clickSaveButton();
        testPlansPage.clickTestPlanButton()
                .clickCreatePlanButton();
        TestPlan testPlan = TestPlanFactory.fillInPlanDetails();
        createTestPlanPage.fillInTitleAndDescriptionField(testPlan)
                .clickAddCasesButton()
                .selectSuiteFromList()
                .clickDoneButton();



    }
}
