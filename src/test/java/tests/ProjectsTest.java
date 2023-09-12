package tests;

import io.qameta.allure.Description;
import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class ProjectsTest extends BaseTest {
    @Description("The user creates a project by filling in all the fields")
    @Test
    public void userCreatesProject() {
        loginPage.userRegistersWithValidData()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInAllFieldsOfProject();
        projectModalPage.createProject(project);
        boolean getProjectCode = repositoryPage.getProjectCode();
        projectsPage.deleteLatestProjectAfterTest();

        assertTrue(getProjectCode,"The project is missing from the page");
    }

    @Description("The user creates a project by filling only required fields")
    @Test
    public void userCreatesProjectByFillingInOnlyRequiredFields() {
        loginPage.userRegistersWithValidData();
        projectsPage.clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project);
        boolean getProjectCode = repositoryPage.getProjectCode();
        projectsPage.deleteLatestProjectAfterTest();

        assertTrue(getProjectCode,"The project is missing from the page");

    }
    @Description("The user creates a project by filling only the project name field")
    @Test
    public void userCreatesProjectByFillingInOnlyProjectNameField() {
        loginPage.userRegistersWithValidData();
        projectsPage.clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInOnlyProjectNameField();
        projectModalPage.fillInOnlyProjectNameField(project);
        boolean getProjectCode = repositoryPage.getProjectCode();
        projectsPage.deleteLatestProjectAfterTest();

        assertTrue(getProjectCode,"The project is missing from the page");
    }
    @Description("The user change the project settings")
    @Test
    public void userChangeProjectSettings() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project);
        projectsPage.clickProjectButton()
                .clickDropdownProject()
                .clickSettingsButton();
        Project settingsProject = ProjectFactory.fillInRequiredFieldsOfProject();
        projectSettingsPage.changeDataInProjectFields(settingsProject)
                .clickUpdateSettingsButton();
        projectsPage.deleteLatestProjectAfterTest();

        assertEquals(projectSettingsPage.getTextAlertMessageOnSettingsPage(), "Project settings were successfully updated!",
                "The message is missing or does not match");
    }

    @Description("Add a filter in the project")
    @Test
    public void addFilterInProject() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project)
        .clickAddFilterButton()
                .selectFilterFromList()
                .selectOptionFromCheckbox();

        assertEquals(repositoryPage.getTextNameFilter(), "Priority: Not set",
                "The name of the filter does not match or is missing");
        projectsPage.deleteLatestProjectAfterTest();
    }
    @Description("The user delete the project")
    @Test
    public void userDeleteProject() {
        loginPage.userRegistersWithValidData()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project);
        projectsPage.clickProjectButton();
        int list1 = projectsPage.getSizeListOfProjects();
        projectsPage.deleteLatestProject()
                .clickProjectButton();
        int list2 = projectsPage.getSizeListOfProjects();

        assertNotEquals(list2, list1, "The project lists are equal");
    }
}
