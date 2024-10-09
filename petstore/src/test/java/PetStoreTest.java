import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 

import static org.hamcrest.Matchers.*;

public class PetStoreTest {

    @BeforeEach 
    public void setup() {
        TestUtils.setup();
    }

    @Test 
    public void testCreateOrder() {
        String requestBody = TestUtils.createOrderRequestBody(1, 1);
        Response response = TestUtils.postOrder(requestBody);

        response.then()
            .statusCode(200)
            .body("petId", equalTo(1))
            .body("quantity", equalTo(1))
            .body("status", equalTo("placed"));
    }

    @Test
    public void testGetNonExistentPet() {
        int nonExistentPetId = 99999; // ID que não existe
        Response response = TestUtils.getPetById(nonExistentPetId);

        response.then()
            .statusCode(404);
    }

    @Test
    public void testUpdatePet() {
        String requestBody = TestUtils.updatePetRequestBody(1, "Buddy", "available");
        Response response = TestUtils.updatePet(requestBody);

        response.then()
            .statusCode(200)
            .body("name", equalTo("Buddy"))
            .body("status", equalTo("available"));
    }

    @Test
    public void testFindPetsByStatusPending() {
        Response response = TestUtils.findPetsByStatus("pending");

        response.then()
            .statusCode(200)
            .body("$", hasSize(greaterThan(0)));
    }
}
