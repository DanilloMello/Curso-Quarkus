package dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.Duration;
@Data
@RegisterForReflection
public class ExerciseConfigurationDTO {
    Integer sets;
    String cadence;
    String method;
    Double weight;
    Duration restBetweenSets;
    Duration restBetweenReps;
    Duration restBetweenExercises;
    RepsDTO reps;
}
