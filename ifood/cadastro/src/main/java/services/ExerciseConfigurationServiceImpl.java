package services;

import infra.domain.ExerciseConfiguration;
import infra.domain.Workout;
import infra.domain.dto.ExerciseConfigurationDTO;
import infra.mappers.ExerciseConfigurationMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

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
    @Override
    public Response delete(Long id) {
        Optional<ExerciseConfiguration> exerciseConfiguration = ExerciseConfiguration.findByIdOptional(id);
        return exerciseConfiguration.isPresent() ?
                ExerciseConfiguration.deleteById(exerciseConfiguration) ? Response.ok().build() : Response.status(NOT_FOUND).build()
                : Response.status(NOT_FOUND).build();
    }
}
