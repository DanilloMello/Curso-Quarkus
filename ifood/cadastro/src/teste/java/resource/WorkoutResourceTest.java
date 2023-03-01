package resource;

import config.QuarkusTestProfileImpl;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
//@QuarkusTestResource(CadastroTestLifecycleManager.class)
@TestProfile(QuarkusTestProfileImpl.class)
public class WorkoutResourceTest {

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
                        .get("/workouts")
                        .then()
                        .body("", hasSize(1))
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