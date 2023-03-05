package services;

import domain.Exercise;
import domain.Workout;
import domain.dto.ExerciseDTO;
import mappers.ExerciseMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@ApplicationScoped
public class ExerciseServiceImpl implements ExerciseService {
    @Inject
    ExerciseMapper exerciseMapper;
    @Override
    public List<Exercise> listAll() {
        return Exercise.listAll();
    }
    @Override
    public Response create(ExerciseDTO dto) {
        Exercise exercise = exerciseMapper.toExercise(dto);
        Exercise.persist(exercise);
        return exercise.isPersistent() ?
                Response.created(URI.create("/exercises/" + exercise.id)).build()
                : Response.status(BAD_REQUEST).build();
    }
    @Override
    public Response update(ExerciseDTO dto) {
        return Workout
                .findByIdOptional(dto.getId())
                .map(
                        e -> {
                            Exercise exercise = (Exercise) e;
                            exercise.setName(dto.getName());
                            exercise.persist();
                            return exercise.isPersistent() ?
                                    Response.ok(exercise).build() :
                                    Response.status(BAD_REQUEST).build();
                        })
                .orElse(Response.status(BAD_REQUEST).build());
    }
}
