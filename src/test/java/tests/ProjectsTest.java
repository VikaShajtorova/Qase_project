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
}
