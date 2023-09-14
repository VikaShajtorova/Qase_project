package tests;

import static org.testng.Assert.*;

import io.qameta.allure.Description;
import models.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class RepositoryTests extends BaseTest {
    @Description("The user creates a suite by filling in all the fields")
    @Test
    public void userCreatesSuite() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInAllFieldsOfSuite();
        suiteModalPage.createSuite(createSuite);
        projectsPage.deleteLatestProjectAfterTest();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Suite was successfully created.",
                "The message is missing or does not match");

    }

    @Description("The user delete a suite")
    @Test
    public void deleteSuite() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInAllFieldsOfSuite();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite)
                .invisibilityOfElementLocated()
                .clickToLastSuiteInList()
                .clickDeleteButtonInDropDown()
                .clickDeleteButton();
        String message = repositoryPage.getTextAlertMessageOnRepositoryPage();
        projectsPage.clickProjectButton()
                        .deleteLatestProject();

        assertEquals(message, "Suite was successfully deleted.",
                "The message is missing or does not match");
    }

    @Description("The user edits the suite")
    @Test
    public void userEditsSuite() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInAllFieldsOfSuite();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite)
                .invisibilityOfElementLocated()
                .clickToLastSuiteInList()
                .clickEditButtonInDropDown();
        Suite editSuite = SuiteFactory.fillInAllFieldsOfSuite();
        editSuitePage.editsSuite(editSuite);

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Suite was successfully edited.",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();

    }

    @Description("The user clone the suite")
    @Test
    public void userCloneSuite() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInAllFieldsOfSuite();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite)
                .invisibilityOfElementLocated()
                .clickToLastSuiteInList()
                .clickCloneButtonInDropDown()
                .clickCloneButtonOnSuiteModalPage();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Suite was successfully cloned ",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }

    @Description("The user creates a sub suite")
    @Test
    public void userCreatesSubSuite() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton();
        Suite createSuite = SuiteFactory.fillInAllFieldsOfSuite();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSuite)
                .clickToLastSuiteInList()
                .clickCreateSuiteButtonInDropDown();
        Suite createSubSuite = SuiteFactory.fillInAllFieldsOfSuite();
        suiteModalPage.createSuiteByFillingInRequiredFields(createSubSuite);

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Suite was successfully created.",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }

    @Description("The user creates a case by filling in all the fields")
    @Test
    public void userCreateCaseByFillingInAllFields() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        basicCasePage.fillInBasicFields(caseBasic);
        Case caseConditions = CaseFactory.fillInAllFieldsOfConditionsCase();
        conditionsCasePage.fillInConditionsFields(caseConditions);
        parametersCasePage.clickAddParameterButton();
        Case caseParameter = CaseFactory.fillInAllFieldsOfAddParameter();
        parametersCasePage.fillInParametersFields(caseParameter)
                .clickAddStepButton();
        Case caseStep = CaseFactory.fillInAllFieldsOfAddStep();
        parametersCasePage.fillInTestCaseStepsFields(caseStep)
                .clickSaveButton();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Test case was created successfully!",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }

    @Description("The user delete a case")
    @Test
    public void userDeleteCase() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        basicCasePage.fillInBasicFields(caseBasic)
                .clickSaveButton()
                .selectCaseFromList()
                .deleteCase();

        assertTrue(repositoryPage.checksThatListIsDisplayed(), "The list contains cases");
        projectsPage.deleteLatestProjectAfterTest();
    }

    @Description("The user clone a case")
    @Test
    public void userCloneCase() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic)
                .clickSaveButton()
                .invisibilityOfElementLocated()
                .selectCaseFromList()
                .clickCloneButtonOnCaseModalPage()
                .clickCloneButtonOnCloneCaseModalPage();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Case was successfully cloned",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }

    @Description("The user Edit a case")
    @Test
    public void userEditCase() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic)
                .clickSaveButton()
                .selectCaseFromList()
                .clickEditButtonOnCaseModalPage();
        Case caseBasicEdit = CaseFactory.fillInAllFieldsOfBasicCase();
        basicCasePage.fillInTitleFieldInCase(caseBasicEdit)
                .clickSaveButton();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Test case was edited successfully!",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }


}
