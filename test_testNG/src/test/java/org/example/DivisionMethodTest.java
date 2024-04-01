package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionMethodTest extends BaseTest {

    @DataProvider(name = "longDivData")
    public Object[][] longDivData() {
        return new Object[][]{
                {10, 2, 5},
                {-10, -2, 5},
                {10, -2, -5},
                {0, 5, 0}
        };
    }

    @DataProvider(name = "doubleDivData")
    public Object[][] doubleDivData() {
        return new Object[][]{
                {10.0, 2.0, 5.0},
                {-10.0, -2.0, 5.0},
                {10.0, -2.0, -5.0},
                {0.0, 5.0, 0.0},
                {10.0, 0.0, Double.POSITIVE_INFINITY}, // ERROR: Cannot divide by zero
        };
    }

    @Test(dataProvider = "longDivData", priority = 0)
    public void testDivLong(long a, long b, long expected) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expected, "Division of " + a + " and " + b + " (long)");
    }

    @Test(dataProvider = "doubleDivData", priority = 1)
    public void testDivDouble(double a, double b, double expected) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expected, 0.001, "Division of " + a + " and " + b + " (double)");
    }

    @Test(priority = 2, dependsOnMethods = {"testDivLong", "testDivDouble"})
    public void testDivLongByZeroShouldBeThrowErrorMessage() {
        try {
            long div = calculator.div(10, 0);
        } catch (NumberFormatException e) {
            // System.out.println("here should be error like this: Cannot divide by zero");
            Assert.assertEquals(e.getMessage(), "Attempt to divide by zero");
        }
    }
}
