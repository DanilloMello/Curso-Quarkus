package infra.mappers;

import infra.domain.Exercise;
import infra.domain.dto.ExerciseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ExerciseMapper {
    Exercise toExercise(ExerciseDTO dto);
}
