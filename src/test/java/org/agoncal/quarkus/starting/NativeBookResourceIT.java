package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@NativeImageTest
public class NativeBookResourceIT extends BookResourceTest {

    @Test
    public void shouldGetBook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id",1)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Understand quarkus"))
                .body("author", is("Antonio"))
                .body("yearOfPublication", is(2020))
                .body("genre", is("Information Technology"))
        ;
    }
}