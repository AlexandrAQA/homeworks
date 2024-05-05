package org.example.tests;

import io.restassured.response.Response;
import org.example.elements.RequestBody;
import org.example.elements.ResponseBody;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.example.elements.Variables.BASE_URL;


public class JsonPlaceHolderUsingJavaClassesTest extends BaseTest {

    @Test // 4th test POST
    public void creatingNewPostShouldBePossible() {
        RequestBody requestBody = new RequestBody();
        requestBody.setTitle("New Post Title");
        requestBody.setBody("New Post Body");
        requestBody.setUserId(1);

        Response response =
                given()
                        .body(requestBody)
                        .when()
                        .post(BASE_URL + "/posts")
                        .then()
                        .assertThat()
                        .statusCode(201)
                        .extract()
                        .response();

        ResponseBody responseBody = response.as(ResponseBody.class);
        System.out.println("New post id: " + responseBody.getId());
    }

    @Test // 5th test PUT
    public void updatingPostShouldBePossible() {
        RequestBody requestBody = new RequestBody();
        requestBody.setId(1);
        requestBody.setTitle("Updated Post Title");
        requestBody.setBody("Updated Post Body");
        requestBody.setUserId(1);

        Response response =
                given()
                        .body(requestBody)
                        .when()
                        .put(BASE_URL + "/posts/1")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .response();

        ResponseBody responseBody = response.as(ResponseBody.class);
        System.out.println("Updated post id: " + responseBody.getId());
    }
}
