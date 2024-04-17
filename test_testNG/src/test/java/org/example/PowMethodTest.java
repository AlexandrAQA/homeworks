package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowMethodTest extends BaseTest {
    @DataProvider(name = "powData")
    public Object[][] powData() {
        return new Object[][]{
                {2.0, 3.0, 8.0},
                {-2.0, 3.0, -8.0},
                {2.0, 0.0, 1.0},
                {4.0, 0.5, 2.0} //bug
        };
    }

    @Test(dataProvider = "powData")
    public void testPow(double a, double b, double expected) {
        double result = calculator.pow(a, b);
        Assert.assertEquals(result, expected, 0.001, "Power of " + a + " to the floor of " + b);
    }
}
