package resources;

import infra.domain.Workout;
import infra.domain.dto.WorkoutDTO;
import infra.exceptions.ConstraintViolationResponse;
import infra.exceptions.GenericErrorResponse;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.security.*;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import services.WorkoutService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/workouts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name= "Workout Resource", description = "Basic CRUD to Workout data")
@RolesAllowed("trainer")
@SecurityScheme(
        securitySchemeName = "fiqfit_workout-oauth",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                password = @OAuthFlow(tokenUrl = "http://localhost:8081/auth/realms/fiqfit_workout/protocol/openid-connect/token")))
@SecurityRequirement(name = "fiqfit_workout")
public class WorkoutResource {
    @Inject
    WorkoutService workoutService;
    @GET
    @APIResponse(responseCode = "201", description = "When all Workouts are successfully retrieved!")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    @APIResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = GenericErrorResponse.class)))
    public List<Workout> listAll() {
        return workoutService.listAll();
    }
    @GET
    @APIResponse(responseCode = "201", description = "When a Workout is successfully retrieved!")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    @APIResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = GenericErrorResponse.class)))
    @Path("{id}")
    public List<Workout> findById(@PathParam("id") Long id) {
        return workoutService.findById(id);
    }
    @POST
    @APIResponse(responseCode = "201", description = "When a Workout is successfully created!")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    @APIResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = GenericErrorResponse.class)))
    public Response create(@Valid @RequestBody WorkoutDTO workoutDto) {
        return workoutService.create(workoutDto);
    }
    @PUT
    @APIResponse(responseCode = "201", description = "When a Workout is successfully updated!")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    @APIResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = GenericErrorResponse.class)))
    public Response update(@RequestBody WorkoutDTO workoutDTO) {
       return workoutService.update(workoutDTO);
    }
    @DELETE
    @APIResponse(responseCode = "201", description = "When a Workout is successfully deleted!")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    @APIResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = GenericErrorResponse.class)))
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){ return workoutService.delete(id); }
}
