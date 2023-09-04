package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class TestPlanFactory {
    static Faker faker = new Faker();
    @Step("Fill in the Test plan fields with random values")
    public static TestPlan fillInPlanDetails() {
        return TestPlan.builder()
                .title(faker.lorem().word())
                .description(faker.lorem().fixedString(50))
                .build();
    }
}
