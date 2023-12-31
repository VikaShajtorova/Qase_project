package tests;

import io.qameta.allure.Description;
import models.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class
TestPlanTests extends BaseTest {
    @Description("User create a test plan")
    @Test
    public void userCreateTestPlan() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInAllFieldsOfProject();
        projectModalPage.createProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInOnlyRequiredSuitesField();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite);
        repositoryPage.selectSuiteFromList()
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInTitleFieldInCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic)
                .clickSaveButton();
        testPlansPage.clickTestPlanButton();

               testPlansPage .clickCreatePlanButton();
        TestPlan testPlan = TestPlanFactory.fillInPlanDetails();
        createTestPlanPage.fillInTitleAndDescriptionField(testPlan)
                .clickAddCasesButton()
                .selectSuiteFromList()
                .clickDoneButton()
                        .clickCreatePlanButton();

        assertEquals(testPlansPage.getTextAlertMessageOnTestPlansPage(), "Test plan was created successfully!",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }
}
