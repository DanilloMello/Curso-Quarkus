package resource;

import config.CadastroTestLifecycleManager;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class PratoResourceTest {

    @Test
    public void shouldRetrieveAllPratos() {

        given()
        .when()
            .get("/pratos")
        .then()
            .body("nome", is(hasItem("teste")))
            .body("$", hasSize(1))
        ;
    }
}