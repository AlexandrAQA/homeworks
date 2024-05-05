package org.example.tests;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setup() {
        RestAssured.given().contentType("application/json");
    }
}
