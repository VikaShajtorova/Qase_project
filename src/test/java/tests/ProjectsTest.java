package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest{
    @Test
    public void userCreatesProject(){
        loginPage.userRegistersWithValidData();
        projectsPage.clickCreateNewProjectButton()
                .isPageOpen();
        projectModalPage.createProject();
        repositoryPage.isPageOpen();


        assertEquals(repositoryPage.getProjectCode(),"SF repository");
    }
}
