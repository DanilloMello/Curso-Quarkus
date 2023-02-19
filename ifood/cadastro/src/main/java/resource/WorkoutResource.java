package resource;

import domain.Workout;
import dto.WorkoutDTO;
import mapper.WorkoutMapper;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/workouts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutResource {
    @Inject
    WorkoutMapper workoutMapper;
    @GET
    public List<Workout> listAll() {
        return Workout.listAll();
    }
    @POST
    public Response create(@RequestBody WorkoutDTO workoutDto) {
        Workout workout = workoutMapper.toWorkout(workoutDto);
        Workout.persist(workout);
        return workout.isPersistent() ?
                Response.created(URI.create("/workouts/" + workout.id)).build()
                : Response.status(BAD_REQUEST).build();
    }
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id) {
        return Workout
                .findByIdOptional(id)
                .map(w -> Response.ok(w).build())
                .orElse(Response.status(NOT_FOUND).build());
    }


}
