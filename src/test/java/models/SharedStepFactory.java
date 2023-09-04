package models;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
public class SharedStepFactory {
    static Faker faker = new Faker();

    @Step("Fill in the Shared step title fields with random values")
    public static SharedStep fillInSharedStepTitleFieldRandomValues() {
        return SharedStep.builder()
                .sharedStepTitle(faker.lorem().sentence(2, 10))
                .build();
    }

    @Step("Fill in the Action the Input data the Expected result fields with random values")
    public static SharedStep fillInStepsToReproduce() {
        return SharedStep.builder()
                .action(faker.lorem().fixedString(50))
                .inputData(faker.lorem().sentence(1, 10))
                .expectedResult(faker.lorem().fixedString(60))
                .build();
    }
}
