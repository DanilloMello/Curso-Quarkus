package services;

import domain.Workout;
import domain.dto.WorkoutDTO;

import javax.ws.rs.core.Response;
import java.util.List;

public interface WorkoutService {
    List<Workout> listAll();
    List<Workout> findById(Long id);
    Response create(WorkoutDTO workout);
    Response update(WorkoutDTO workoutDTO);
    Response delete(Long id);
}
