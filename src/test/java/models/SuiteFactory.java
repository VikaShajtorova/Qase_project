package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class SuiteFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Suite fields with random values")
    public static Suite fillInAllFieldsOfSuite() {
        return Suite.builder()
                .suiteName(faker.lorem().word())
                .parentSuite(faker.expression("Project root"))
                .description(faker.lorem().fixedString(50))
                .preconditions(faker.lorem().fixedString(50))
                .build();
    }

    @Step("Fill in only the required suites field")
    public static Suite fillInOnlyRequiredSuitesField() {
        return Suite.builder()
                .suiteName(faker.lorem().word())
                .build();
    }

}
