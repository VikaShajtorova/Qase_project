package tests;

import io.qameta.allure.Description;
import models.Project;
import models.ProjectFactory;
import models.SharedStep;
import models.SharedStepFactory;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SharedStepTests extends BaseTest {
    @Description("Create Shared steps")
    @Test
    public void userCreateSharedSteps() {
        loginPage.userRegistersWithValidData()
                .clickProjectButton()
                .clickCreateNewProjectButton();
        Project project = ProjectFactory.fillInAllFieldsOfProject();
        projectModalPage.createProject(project)
                .clickSharedStepsButton()
                .clickCreateSharedStepButton();
        SharedStep sharedStepTitle = SharedStepFactory.fillInSharedStepTitleFieldRandomValues();
        createSharedStepPage.inputInFieldSharedStepTitle(sharedStepTitle)
                .clickAddStepButton();
        SharedStep sharedStep = SharedStepFactory.fillInStepsToReproduce();
        createSharedStepPage.createSharedSteps(sharedStep)
                .clickCreateButton();

        assertEquals(sharedStepPage.getMessageAboutCreatingSharedStep(),"Shared step was created successfully!",
                "The message is missing or does not match");
        projectsPage.deleteLatestProjectAfterTest();
    }
}
