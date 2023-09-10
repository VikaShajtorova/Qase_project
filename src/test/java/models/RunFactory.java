package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class RunFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Run fields with random values")
    public static Run fillInFieldsOfRun() {
        return Run.builder()
                .description(faker.lorem().fixedString(30))
                .environment(faker.expression("Not set"))
                .milestone(faker.expression("Not set"))
                .build();
    }
}
