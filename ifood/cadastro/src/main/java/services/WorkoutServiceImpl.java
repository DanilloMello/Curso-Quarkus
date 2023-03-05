package services;

import domain.Exercise;
import domain.Workout;
import domain.dto.WorkoutDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import mappers.WorkoutMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

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

    @Override
    public Response update(WorkoutDTO workoutDTO) {
        return Workout
                .findByIdOptional(workoutDTO.getId())
                .map(
                        w -> {
                            Workout workout = (Workout) w;
                            workout.setNome(workoutDTO.getNome());
                            workout.persist();
                            return workout.isPersistent() ?
                                    Response.ok(workout).build() :
                                    Response.status(BAD_REQUEST).build();
                        })
                .orElse(Response.status(BAD_REQUEST).build());
    }
    @Override
    public Response delete(Long id) {
        Optional<Workout> workout = Workout.findByIdOptional(id);
        return workout.isPresent() ?
                Workout.deleteById(workout) ? Response.ok().build() : Response.status(NOT_FOUND).build()
                : Response.status(NOT_FOUND).build();
    }

}
