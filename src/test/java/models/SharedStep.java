package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SharedStep {
    String action;
    String inputData;
    String expectedResult;
    String sharedStepTitle;

}
