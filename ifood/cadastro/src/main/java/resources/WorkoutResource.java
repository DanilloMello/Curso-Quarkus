package resources;

import domain.Workout;
import domain.dto.WorkoutDTO;
//import mapper.WorkoutMapper;
import mappers.WorkoutMapper;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import services.WorkoutService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/workouts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutResource {
    @Inject
    WorkoutService workoutService;

    @GET
    public List<Workout> listAll() {
        return workoutService.listAll();
    }
    @POST
    public Response create(@RequestBody WorkoutDTO workoutDto) {
        return workoutService.create(workoutDto);
    }
    @PUT
    public Response update(@RequestBody WorkoutDTO workoutDTO) {
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


}
