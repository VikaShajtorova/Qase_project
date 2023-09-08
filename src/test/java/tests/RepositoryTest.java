package tests;

import static org.testng.Assert.*;

import io.qameta.allure.Description;
import models.Case;
import models.CaseFactory;
import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import pages.createCase.BasicCasePage;
import pages.createCase.ConditionsCasePage;
import pages.createCase.ParametersCasePage;

public class RepositoryTest extends BaseTest {
    @Description("The user creates a suite by filling in all the fields")
    @Test
    public void userCreatesSuite() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickSuiteButton()
                .createSuiteByFillingInRequiredFields()
                .clickCreateButton();

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
                .clickSuiteButton()
                .createSuiteByFillingInRequiredFields()
                .clickCreateButton();
        repositoryPage.clickToLastSuiteInList()
                .clickDeleteButtonInDropDown()
                .clickDeleteButton();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Suite was successfully deleted.",
                "The message is missing or does not match");
    }

    @Test
    public void userCreateCase() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        repositoryPage.clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        new BasicCasePage(driver).fillInBasicFields(caseBasic);
        Case caseConditions = CaseFactory.fillInAllFieldsOfConditionsCase();
        new ConditionsCasePage(driver).fillInConditionsFields(caseConditions);
        new ParametersCasePage(driver).clickAddParameterButton();
        Case caseParameter = CaseFactory.fillInAllFieldsOfAddParameter();
        new ParametersCasePage(driver).fillInParametersFields(caseParameter);
        new ParametersCasePage(driver).clickAddStepButton();
        Case caseStep = CaseFactory.fillInAllFieldsOfAddStep();
        new ParametersCasePage(driver).fillInTestCaseStepsFields(caseStep)
                .clickSaveButton();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Test case was created successfully!",
                "The message is missing or does not match");
    }

    @Test
    public void checkFileDownload() {
        loginPage.userRegistersWithValidData();
        projectsPage.getLatestProjectInListAndClick();
        repositoryPage.clickCaseButton();
        attachmentsCasePage.clickAddAttachmentButton();
        attachmentsCasePage.downloadFile();

        assertEquals(attachmentsCasePage.getFileName(), "Screenshot_8.png", "имя файла не совпадает");
    }

}
