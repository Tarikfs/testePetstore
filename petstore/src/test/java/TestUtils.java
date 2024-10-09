import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestUtils {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static void setup() {
        RestAssured.baseURI = BASE_URI;
    }

    public static String createOrderRequestBody(int petId, int quantity) {
        return String.format("{ \"petId\": %d, \"quantity\": %d, \"shipDate\": \"2024-10-09T21:13:39.320Z\", \"status\": \"placed\", \"complete\": true }", petId, quantity);
    }

    public static Response postOrder(String requestBody) {
        return given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post("/store/order")
            .then()
            .log().all() 
            .extract().response();
    }

    public static Response getPetById(int petId) {
        return given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .log().all() 
            .extract().response();
    }

    public static String updatePetRequestBody(int petId, String name, String status) {
        return String.format("{ \"id\": %d, \"name\": \"%s\", \"status\": \"%s\" }", petId, name, status);
    }

    public static Response updatePet(String requestBody) {
        return given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .put("/pet")
            .then()
            .log().all() 
            .extract().response();
    }

    public static Response findPetsByStatus(String status) {
        return given()
            .queryParam("status", status)
            .when()
            .get("/pet/findByStatus")
            .then()
            .log().all() 
            .extract().response();
    }
}