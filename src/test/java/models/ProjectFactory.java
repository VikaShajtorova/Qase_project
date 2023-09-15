package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class ProjectFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Project fields with random values")
    public static Project fillInAllFieldsOfProject() {
        return Project.builder()
                .projectName(faker.lorem().word())
                .projectCode(faker.lorem().word())
                .description(faker.lorem().fixedString(50))
                .build();
    }

    @Step("Fill in required fields of Project with random values")
    public static Project fillInRequiredFieldsOfProject() {
        return Project.builder()
                .projectName(faker.lorem().word())
                .projectCode(faker.lorem().fixedString(3))
                .build();
    }

    @Step("Fill In Only Project Name field with random values")
    public static Project fillInOnlyProjectNameField() {
        return Project.builder()
                .projectName(faker.lorem().word())
                .build();
    }
}
