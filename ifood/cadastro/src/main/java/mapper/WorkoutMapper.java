package mapper;

import domain.Workout;
import dto.WorkoutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface WorkoutMapper {
    Workout toWorkout(WorkoutDTO dto);
}
