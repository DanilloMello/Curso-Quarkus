package resource;

import domain.Prato;
import domain.Restaurante;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Optional;

@Path("/pratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PratoResource {

    @GET
    public List<Prato> recuperar(){
        return Prato.listAll();
    }
    @POST
    @Transactional
    public Response adicionar(Prato dto){
        dto.persist();
        return Response.status(Status.CREATED).build();
    }
    @PUT
    @Path("{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Prato dto){
        Optional<Prato> pratoOptional = Prato.findByIdOptional((id));
        pratoOptional.ifPresentOrElse((p) -> {
            p.nome = dto.nome;
            p.persist();
        }, () -> {
            throw new NotFoundException();
        });
        return Response.status(Status.OK).build();
    }
    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional((id));
        restauranteOp.ifPresentOrElse(Restaurante::delete, () -> {
            throw new NotFoundException();
        });
        return Response.status(Status.OK).build();
    }
}
