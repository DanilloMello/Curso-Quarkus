package mappers;

import domain.Exercise;
import domain.dto.ExerciseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ExerciseMapper {
    Exercise toExercise(ExerciseDTO dto);
}
