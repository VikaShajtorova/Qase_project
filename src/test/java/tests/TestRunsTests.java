package tests;

import io.qameta.allure.Description;
import models.*;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TestRunsTests extends BaseTest {
    @Description("User create the Test run")
    @Test
    public void createTestRun() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInOnlyRequiredSuitesField();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite)
                .clickToLastSuiteInList()
                .clickCreateCaseButtonInDropDown();
        Case caseBasic = CaseFactory.fillInTitleFieldInCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic)
                .clickSaveButton();
        testRunsPage.clickTestRunButton();
                        testRunsPage.clickStartNewTestRunsButton();
        Run run = RunFactory.fillInFieldsOfRun();
        testRunsModalPage.fillInFieldsModalRun(run)
                .clickSelectCasesButton()
                .selectCasesFromCheckboxAndClick()
                .clickDoneButton()
                .clickStarRunButton();

        assertTrue(listOfSuitesInRunPage.titleOfTestRunIsDisplayed(), "The name of the test run is missing");
        projectsPage.deleteLatestProjectAfterTest();


    }

    @Description("User delete the Test run")
    @Test
    public void deleteTestRun() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInOnlyRequiredSuitesField();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite)
                .clickToLastSuiteInList()
                .clickCreateCaseButtonInDropDown();
        Case caseBasic = CaseFactory.fillInTitleFieldInCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic)
                .clickSaveButton();
        testRunsPage.clickTestRunButton();

        testRunsPage.clickStartNewTestRunsButton();
        Run run = RunFactory.fillInFieldsOfRun();
        testRunsModalPage.fillInFieldsModalRun(run)
                .clickSelectCasesButton()
                .selectCasesFromCheckboxAndClick()
                .clickDoneButton()
                .clickStarRunButton()
                .clickGoBackButton()
                .clickDropDownButtonTestRun()
                .selectOptionInDropDownButtonTestRun()
                .ClickDeleteButtonInModalWindow()
                .clickTestRunButton();

        assertFalse(testRunsPage.tableTestRunIstDisplayed(), "The table test run is displayed on TestRunPage");
        projectsPage.deleteLatestProjectAfterTest();
    }

}

