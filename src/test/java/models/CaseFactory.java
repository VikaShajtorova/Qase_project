package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class CaseFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Basic fields with random values")
    public static Case fillInAllFieldsOfBasicCase() {
        return Case.builder()
                .title(faker.hacker().verb())
                .status(faker.expression("Draft"))
                .description(faker.lorem().fixedString(20))
                .suite(faker.expression("Test cases without suite"))
                .type(faker.expression("Smoke"))
                .milestone(faker.expression("Not set"))
                .severity(faker.expression("Normal"))
                .layer(faker.expression("Not set"))
                .behavior(faker.expression("Positive"))
                .priority(faker.expression("High"))
                .is_Flaky(faker.expression("No"))
                .automationStatus(faker.expression("Not automated"))
                .build();
    }

    @Step("Fill in the title field in the case")
    public static Case fillInTitleFieldInCase() {
        return Case.builder()
                .title(faker.hacker().verb())
                .build();
    }

    @Step("Fill in the Conditions fields with random values")
    public static Case fillInAllFieldsOfConditionsCase() {
        return Case.builder()
                .pre_Conditions(faker.lorem().fixedString(100))
                .post_Conditions(faker.lorem().fixedString(120))
                .build();
    }

    @Step("Fill in the Tag fields with random values")
    public static Case fillInFieldTag() {
        return Case.builder()
                .select(faker.expression("class"))
                .build();
    }

    @Step("Fill in the Parameters fields with random values")
    public static Case fillInAllFieldsOfAddParameter() {
        return Case.builder()
                .parameterTitle(faker.lorem().fixedString(50))
                .parameterValues(faker.lorem().fixedString(20))
                .build();
    }

    @Step("Fill in the Steps fields with random values")
    public static Case fillInAllFieldsOfAddStep() {
        return Case.builder()
                .stepAction(faker.lorem().fixedString(25))
                .data(faker.lorem().fixedString(10))
                .expectedResult(faker.lorem().fixedString(50))
                .build();
    }
}
