package domain.dto;

import domain.Exercise;
import domain.embedded.Reps;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import javax.persistence.*;
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
