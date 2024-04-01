package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubMethodTest extends BaseTest {

    @DataProvider(name = "subLongTestData")
    public Object[][] subLongTestData() {
        return new Object[][]{
                {10, 5, 5},
                {-10, -5, -5},
                {10, -5, 15},
                {0, 5, -5},
                {0, -5, 5}
        };
    }

    @Test(dataProvider = "subLongTestData", groups = {"smoke"})
    public void testSub(long a, long b, long expected) {

        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expected, "Subtraction of " + a + " and " + b);
    }

    //DOUBLE
    @DataProvider(name = "subDoubleTestData")
    public Object[][] subDoubleTestData() {
        return new Object[][]{
                {10.0, 51.0, -41.0},
                {-10.0999, -5.99, -4.1099},
                {11000.44434434, -5.3433331123, 11005.7876774523},
                {0.9999999, 5.77786543, -4.777865530000001},
                {0.6464642, -5.64564645, 6.29211065}
        };
    }

    @Test(dataProvider = "subDoubleTestData")
    public void testSub(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, expected, "Subtraction of " + a + " and " + b);
    }
}
