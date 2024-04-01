package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CtgMethodTest extends BaseTest {

    @DataProvider(name = "ctgData")
    public Object[][] ctgData() {
        return new Object[][]{
                {1, 57.29},
                {45, 1.0},
                {30, 1.73},
                {60, 0.57},
                {90, 0.0}
        };
    }

    @Test(dataProvider = "ctgData")
    public void testCtg(double a, double expected) {
        double result = calculator.ctg(a);
        Assert.assertEquals(result, expected, 0.001, "Cotangent of " + a);
    }
}
