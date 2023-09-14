package tests;

import io.qameta.allure.Description;
import models.Case;
import models.CaseFactory;
import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class AttachmentsTests extends BaseTest {
    @Description("Check the file download")
    @Test
    public void checkFileDownload() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInTitleFieldInCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic);
        attachmentsCasePage.clickAddAttachmentButton();
        attachmentsCasePage.downloadFile();
        String fileName = attachmentsCasePage.getFileName();
        casePage.clickSaveButton();
        projectsPage.clickProjectButton();
        repositoryPage.getAlertOnRepositoryPage();
        projectsPage.deleteLatestProject();

        assertEquals(fileName, "Screenshot_8.png", "The file name does not match");
    }

    @Description("Check the file download")
    @Test
    public void checkFileDownloadFromList() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInTitleFieldInCase();
        basicCasePage.fillInTitleFieldInCase(caseBasic);
        attachmentsCasePage.clickAddAttachmentButton();
        attachmentsCasePage.clickBrowseButton();
        attachmentsCasePage.selectFileFromList();
        boolean isDisplayed = attachmentsCasePage.checksThatFileIsDisplayed();
        casePage.clickSaveButton();
        projectsPage.clickProjectButton();
        repositoryPage.getAlertOnRepositoryPage();
        projectsPage.deleteLatestProject();

        assertTrue(isDisplayed, "The file name does not match");
    }

}
