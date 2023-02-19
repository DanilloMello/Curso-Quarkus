package dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.Duration;
@Data
@RegisterForReflection
public class ExerciseConfigurationDTO {
    String method;
    Integer sets;
    RepsDTO reps;
    String cadence;
    Double weight;
    Integer rangeOfMotion;
    Duration restBetweenSets;
    Duration restBetweenReps;
    Duration restBetweenExercises;
}
