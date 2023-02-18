package resource;

import config.CadastroTestLifecycleManager;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
//@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class ExerciseResourceTest {

//    @Test
//    public void shouldRetrieveAllPratos() {
//
//        given()
//        .when()
//                .get()
//        ;
//
//    }

    @Test
    public void shouldRetrievePratosCadastro() {
        String teste =
                given()
                        .when()
                        .get("/pratos/cadastro")
                        .then()
                        .body("$", hasSize(1))
                        .extract().asString()
                ;
        System.out.println(teste);
    }

    @Test
    public void shouldRetrievePratosNomePreco() {
        String teste =
                given()
                        .when()
                        .get("/pratos/nome-preco")
                        .then()
                        .body("$", hasSize(8))
                        .extract().asString()
                ;
        System.out.println(teste);
    }
}