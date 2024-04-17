package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeMethodTest extends BaseTest {

    @DataProvider(name = "isNegativeData")
    public Object[][] isNegativeData() {
        return new Object[][]{
                {-1, true},
                {0, false},
                {-1000000, true},
                {2, false},
                {Long.MAX_VALUE, false},  // Максимальное положительное значение long
                {Long.MIN_VALUE, true}  // отрицательное значение long
        };
    }

    @Test(dataProvider = "isNegativeData")
    public void testIsPositive(long val, boolean expected) {
        boolean result = calculator.isNegative(val);
        Assert.assertEquals(result, expected, "Check if " + val + " is positive");
    }
}
