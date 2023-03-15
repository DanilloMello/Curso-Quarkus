package resources;

import infra.domain.ExerciseConfiguration;
import infra.domain.dto.ExerciseConfigurationDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import services.ExerciseConfigurationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/exercise-configurations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExerciseConfigurationResource {
    @Inject
    ExerciseConfigurationService exerciseConfigurationService;
    @GET
    public List<ExerciseConfiguration> listAll() {
        return exerciseConfigurationService.listAll();
    }
    @POST
    public Response create(@RequestBody ExerciseConfigurationDTO dto) {
        return exerciseConfigurationService.create(dto);
    }
    @PUT
    public Response update(@RequestBody ExerciseConfigurationDTO dto) {
        return exerciseConfigurationService.update(dto);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){ return exerciseConfigurationService.delete(id); }
}
