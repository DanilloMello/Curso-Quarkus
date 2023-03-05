package services;

import domain.ExerciseConfiguration;
import domain.Workout;
import domain.dto.ExerciseConfigurationDTO;
import mappers.ExerciseConfigurationMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@ApplicationScoped
public class ExerciseConfigurationServiceImpl implements ExerciseConfigurationService {
    @Inject
    ExerciseConfigurationMapper exerciseConfigurationMapper;
    @Override
    public List<ExerciseConfiguration> listAll() {
        return ExerciseConfiguration.listAll();
    }
    @Override
    public Response create(ExerciseConfigurationDTO dto) {
        ExerciseConfiguration exerciseConfiguration = exerciseConfigurationMapper.toExerciseConfiguration(dto);
        ExerciseConfiguration.persist(exerciseConfiguration);
        return exerciseConfiguration.isPersistent() ?
                Response.created(URI.create("/exercise-configurations/" + exerciseConfiguration.id)).build()
                : Response.status(BAD_REQUEST).build();
    }
    @Override
    public Response update(ExerciseConfigurationDTO dto) {
        return Workout
                .findByIdOptional(dto.getId())
                .map(
                        e -> {
                            ExerciseConfiguration exerciseConfiguration = (ExerciseConfiguration) e;
                            exerciseConfiguration.setSets(dto.getSets());
                            exerciseConfiguration.persist();
                            return exerciseConfiguration.isPersistent() ?
                                    Response.ok(exerciseConfiguration).build() :
                                    Response.status(BAD_REQUEST).build();
                        })
                .orElse(Response.status(BAD_REQUEST).build());
    }
}
