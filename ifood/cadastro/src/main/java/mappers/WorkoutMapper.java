package mappers;

import domain.Workout;
import domain.dto.WorkoutDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "cdi")
public interface WorkoutMapper {
    Workout toWorkout(WorkoutDTO dto);
}
