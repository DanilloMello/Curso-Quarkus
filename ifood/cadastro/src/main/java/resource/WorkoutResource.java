package resource;

import domain.Workout;
import dto.WorkoutDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/workout")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutResource {

    @GET
    public List<Workout> listAll() {
        return Workout.listAll();
    }

    @POST
    public Response create(@RequestBody WorkoutDTO workout) {
        //TODO: MapStruck Aqui
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id) {
        return Response.status(OK).build();
    }


}
