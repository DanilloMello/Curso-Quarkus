package resources;

import domain.Workout;
import domain.dto.WorkoutDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import services.WorkoutService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
       return workoutService.update(workoutDTO);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){ return workoutService.delete(id); }
}
