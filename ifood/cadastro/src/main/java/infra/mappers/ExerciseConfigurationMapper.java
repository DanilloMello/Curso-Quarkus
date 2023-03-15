package infra.mappers;

import infra.domain.ExerciseConfiguration;
import infra.domain.dto.ExerciseConfigurationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ExerciseConfigurationMapper {
    ExerciseConfiguration toExerciseConfiguration(ExerciseConfigurationDTO dto);
}
