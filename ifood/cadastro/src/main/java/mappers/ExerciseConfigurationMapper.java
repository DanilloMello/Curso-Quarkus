package mappers;

import domain.ExerciseConfiguration;
import domain.dto.ExerciseConfigurationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ExerciseConfigurationMapper {
    ExerciseConfiguration toExerciseConfiguration(ExerciseConfigurationDTO dto);
}
