package domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.util.List;
@Data
@RegisterForReflection
public class ExerciseDTO {
    String name;
    List<ExerciseConfigurationDTO> exerciseConfiguration;
}
