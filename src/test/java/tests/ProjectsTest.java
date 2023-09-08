package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProjectsTest extends BaseTest{
    @Test
    public void userCreatesProject(){
        loginPage.userRegistersWithValidData();
        projectsPage.clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInAllFieldsOfProject();
        projectModalPage.createProject(project);

        assertTrue(repositoryPage.getProjectCode());
    }

    @Test
    public void userCreatesProjectByFillingInOnlyRequiredFields(){
        loginPage.userRegistersWithValidData();
        projectsPage.clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInRequiredFieldsOfProject();
        projectModalPage.fillInRequiredFieldsOfProject(project);

        assertTrue(repositoryPage.getProjectCode());
    }

    @Test
    public void userCreatesProjectByFillingInOnlyProjectNameField(){
        loginPage.userRegistersWithValidData();
        projectsPage.clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInOnlyProjectNameField();
        projectModalPage.fillInOnlyProjectNameField(project);

        assertTrue(repositoryPage.getProjectCode());
    }

    @Test
    public void userChangeProjectSettings(){
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInOnlyProjectNameField();
        projectModalPage.fillInOnlyProjectNameField(project);
        projectsPage.clickProjectButton()
                .clickDropdownProject()
                .clickSettingsButton();
        Project settingsProject = ProjectFactory.fillInAllFieldsOfProject();
        projectSettingsPage.changeDataInProjectFields(settingsProject)
                .clickUpdateSettingsButton();

        assertEquals(projectSettingsPage.getTextAlertMessageOnSettingsPage(), "Project settings were successfully updated!",
                "The message is missing or does not match");
    }

    @Test
    public void userDeleteProject(){
        loginPage.userRegistersWithValidData()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInAllFieldsOfProject();
        projectModalPage.createProject(project);
        projectsPage.clickProjectButton();
        boolean list1 = projectsPage.getSizeListOfProjects();
        projectsPage.deleteLatestProject();
        boolean list2 = projectsPage.getSizeListOfProjects();

        assertNotEquals(list2,list1,"Списки равны");//TODO доделать
    }
}
