package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Run {
    String description;
    String environment;
    String milestone;
    String manual;
}
