package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class ExerciseResourceTest {
    @Test
    public void shouldRetrieveExercises() {
        System.out.println(given()
                .when()
                .get("/exercises")
                .then()
                .extract().asString());
    }
}