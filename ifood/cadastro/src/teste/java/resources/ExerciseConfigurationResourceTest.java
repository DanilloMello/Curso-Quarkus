package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ExerciseConfigurationResourceTest {
    @Test
    public void shouldRetrieveExerciseConfigurations() {
        System.out.println(given()
                .when()
                .get("/exercise-configurations")
                .then()
                .extract().asString());
    }
}