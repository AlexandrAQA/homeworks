package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationMethodTest extends BaseTest {


    @DataProvider(name = "multiplicationLongTestData")
    public Object[][] multiplicationLongTestData() {
        return new Object[][]{
                {2, 3, 6},
                {-4, -5, 20},
                {0, 100, 0},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "multiplicationLongTestData", groups = {"smoke"})
    public void testMultiplicationLong(long a, long b, long expected) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, "Multiplication of " + a + " and " + b + " (long)");
    }

    @DataProvider(name = "multiplicationDoubleTestData")
    public Object[][] multiplicationDoubleTestData() {
        return new Object[][]{
                {-4.5, -5.5, 24.75}, //bug
                {4.54, 5.54, 25.1516}, //bug
                {0.0, 10.0, 0.0},
                {0.0, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "multiplicationDoubleTestData")
    public void testMultiplicationDouble(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, "Multiplication of " + a + " and " + b + " (double)");
    }
}
