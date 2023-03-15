package infra.domain.dto;

import infra.domain.Exercise;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.Duration;
@Data
@RegisterForReflection
public class ExerciseConfigurationDTO {
    Long id;
    String method;
    Integer sets;
    RepsDTO reps;
    String cadence;
    Double weight;
    Integer rangeOfMotion;
    Duration restBetweenSets;
    Duration restBetweenReps;
    Duration restBetweenExercises;
    Exercise exercise;
}
