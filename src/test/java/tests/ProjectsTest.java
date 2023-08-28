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
    public void userCreatesProject1(){
        loginPage.userRegistersWithValidData();
        int size = projectsPage.getSizeListOfProjects();
        projectsPage.deleteLatestProject();
        int size2 = projectsPage.getSizeListOfProjects();

        assertNotEquals(size,size2);//TODO доделать
    }
}
