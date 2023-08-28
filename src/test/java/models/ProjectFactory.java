package models;

import com.github.javafaker.Faker;

public class ProjectFactory {
    static Faker faker = new Faker();

    public static Project fillInAllFieldsOfProject(){
        return Project.builder()
                .projectName(faker.lorem().word())
                .projectCode(faker.lorem().fixedString(3))
                .description(faker.lorem().fixedString(50))
                .build();
    }

    public static Project fillInRequiredFieldsOfProject(){
        return Project.builder()
                .projectName(faker.lorem().word())
                .projectCode(faker.lorem().fixedString(3))
                .build();
    }

    public static Project fillInOnlyProjectNameField(){
        return Project.builder()
                .projectName(faker.lorem().word())
                .build();
    }
}
