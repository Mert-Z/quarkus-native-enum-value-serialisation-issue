package test.mert;

import static javax.ws.rs.core.Response.ok;

import io.smallrye.mutiny.Uni;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> hello() {
        GreetingResponse response = new GreetingResponse(TestEnum.VALUE_1);
        return Uni.createFrom().item(ok(response).build());
    }

}