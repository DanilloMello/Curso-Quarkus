package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class WorkoutResourceTest {


    @Test
    public void shouldRetrieveWorkouts() {
        System.out.println(given()
                .when()
                .get("/workouts")
                .then()
                .extract().asString());
    }
}