package infra.mappers;

import infra.domain.Workout;
import infra.domain.dto.WorkoutDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "cdi")
public interface WorkoutMapper {
    Workout toWorkout(WorkoutDTO dto);
}
