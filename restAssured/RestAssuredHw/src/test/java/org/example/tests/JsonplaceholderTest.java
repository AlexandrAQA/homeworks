package org.example.tests;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.example.elements.Variables.*;
import static org.hamcrest.Matchers.*;


public class JsonplaceholderTest extends BaseTest {

    @Test  //1st test
    public void verifyingHttpStatusCode() {
        ExtractableResponse<Response> response = given()
                .get(BASE_URL + "/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("getJsonSchema.json"))
                .extract();
        System.out.println(response.body().asPrettyString());
    }

    @Test //2nd test
    public void verifyingHttpResponseHeader() {
        ExtractableResponse<Response> response = given()
                .get(BASE_URL + "/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body(matchesJsonSchemaInClasspath("getJsonSchema.json"))
                .extract();
        System.out.println(response.body().asPrettyString());
    }

    @Test  // 3rd test
    public void verifyHttpResponseBodyContainsUsers() {
        Response response =
                given()
                        .get(BASE_URL + "/posts")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("size()", equalTo(100))
                        .body(matchesJsonSchemaInClasspath("getJsonSchema.json"))
                        .extract()
                        .response();

        System.out.println("Response Body:");
        System.out.println(response.body().asString());
    }

    @Test  // 4th test POST
    public void creatingNewPostShouldBePossible() {
        Response response =
                given()
                        .body(POST_REQUEST_BODY)
                        .when()
                        .post(BASE_URL + "/posts")
                        .then()
                        .assertThat()
                        .statusCode(201)
                        .body(not(isEmptyString()))
                        .extract()
                        .response();

        String postId = response.jsonPath().getString("id");
        System.out.println("New post id: " + postId);

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("postPutSchema.json"));
    }

    @Test  // 5th test PUT
    public void updatingPostShouldBePossible() {
        Response response =
                given()
                        .body(PUT_REQUEST_BODY)
                        .when()
                        .put(BASE_URL + "/posts/1")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("id", equalTo(1))
                        .extract()
                        .response();

        String postId = response.jsonPath().getString("id");
        System.out.println("New post id: " + postId);

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("postPutSchema.json"));
    }

    @Test // 6th test DELETE
    public void deletePost() {
        Response response =
                given()
                        .when()
                        .delete(BASE_URL + "/posts/1")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath("getJsonSchema.json"))
                        .extract()
                        .response();
    }
}
