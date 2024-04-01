package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgMethodTest extends BaseTest {
    @DataProvider(name = "tgData")
    public Object[][] tgData() {
        return new Object[][]{

                {0.0, 0.0},
                {5.0, 0.08748866352592400522201866943496},
                {Math.PI / 4, 1.0},
                {Math.PI / 6, 0.5773502691896257},
                {Math.PI / 3, 1.7320508075688772},
                {Math.PI / 2, Double.POSITIVE_INFINITY},
                {Math.PI, Double.NaN}  // expected result=NaN
        };
    }

    @Test(dataProvider = "tgData")
    public void testTg(double a, double expected) {
        double result = calculator.tg(a);
        Assert.assertEquals(result, expected, "Tangent of " + a);
    }
}
