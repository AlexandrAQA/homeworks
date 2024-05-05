package org.example.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void setup() {
        RestAssured.given().contentType("application/json");
    }
}
