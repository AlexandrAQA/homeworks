package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
