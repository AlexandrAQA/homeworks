package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinMethodTest extends BaseTest {
    @DataProvider(name = "sinData")
    public Object[][] sinData() {
        return new Object[][]{
                {0.0, 0.0},
                {30.0, 0.5},
                {45.0, 0.707},
                {60.0, 0.866},
                {90.0, 1.0},
                {180.0, 0.0},
                {270.0, -1.0},
                {360.0, 0.0},
                // additional
                {0.0, 1.0},
                {22.0, 0.927184},
                {120.0, -0.5},
                {180.0, -1},
                {360.0, 1}
        };
    }

    @Test(dataProvider = "sinData")
    public void testSin(double a, double expected) {
        double result = calculator.sin(a);
        Assert.assertEquals(result, expected, "Cosine of " + a);
    }
}
