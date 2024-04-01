package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosMethodTest extends BaseTest {

    @DataProvider(name = "cosData")
    public Object[][] cosData() {
        return new Object[][]{
                {0.0, 1.0},
                {22.0, 0.927184},
                {120.0, -0.5},
                {180.0, -1},
                {360.0, 1}
        };
    }

    @Test(dataProvider = "cosData")
    public void testCos(double a, double expected) {
        double result = calculator.cos(a);
        Assert.assertEquals(result, expected, "Cosine of " + a);
    }
}
