package services;

import domain.Workout;
import domain.dto.WorkoutDTO;
import mappers.WorkoutMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@ApplicationScoped
@Transactional
public class WorkoutServiceImpl implements WorkoutService {
    @Inject
    WorkoutMapper workoutMapper;
    @Override
    public List<Workout> listAll() {
        return Workout.listAll();
    }
    @Override
    public Response create(WorkoutDTO dto) {
        Workout workout = workoutMapper.toWorkout(dto);
        Workout.persist(workout);
        return workout.isPersistent() ?
                Response.created(URI.create("/workouts/" + workout.id)).build()
                : Response.status(BAD_REQUEST).build();
    }

}
