package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtMethodTest extends BaseTest {

    @DataProvider(name = "sqrtData")
    public Object[][] sqrtData() {
        return new Object[][]{
                {4.0, 2.0},
                {9.0, 3.0},
                {16.0, 4.0},
                {25.0, 5.0},
                {36.0, 6.0}
        };
    }

    @Test(dataProvider = "sqrtData")
    public void testSqrt(double a, double expected) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expected, "Square root of " + a);
    }
}
