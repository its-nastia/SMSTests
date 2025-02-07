import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/students";
    }

    @Test
    public void testGetStudents() {
        Response response = given()
                .when()
                .get("/students")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        assertEquals(200, response.getStatusCode());
        // Add more assertions as needed
    }

    @Test
    public void testCreateStudent() {
        String newStudent = "{ \"id\": 6, \"firstName\": \"New\", \"lastName\": \"Student\", \"age\": 22, \"major\": \"MATH\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(newStudent)
                .when()
                .post("/students")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        assertEquals(201, response.getStatusCode());

    }
}

