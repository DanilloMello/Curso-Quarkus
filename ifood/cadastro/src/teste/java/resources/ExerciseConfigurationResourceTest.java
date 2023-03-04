package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
//@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class ExerciseConfigurationResourceTest {
    @Test
    public void shouldRetrieveWorkouts() {
        System.out.println(given()
                .when()
                .get("/exercises")
                .then()
                .extract().asString());
    }
}