package resources;

import infra.domain.Exercise;
import infra.domain.dto.ExerciseDTO;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import services.ExerciseService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/exercises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExerciseResource {
    @Inject
    ExerciseService exerciseService;
    @GET
    public List<Exercise> listAll() {
        return exerciseService.listAll();
    }
    @POST
    public Response create(@RequestBody ExerciseDTO dto) {
        return exerciseService.create(dto);
    }
    @PUT
    public Response update(@RequestBody ExerciseDTO dto) {
        return exerciseService.update(dto);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){ return exerciseService.delete(id); }
}
