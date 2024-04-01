package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveMethodTest extends BaseTest {
    @DataProvider(name = "isPositiveData")
    public Object[][] isPositiveData() {
        return new Object[][]{
                {1, true},
                {0, false},
                {-1, false},
                {2, true},
                {3, true},
                {Long.MAX_VALUE, true},  // Максимальное положительное значение long
                {Long.MIN_VALUE, false}  // отрицательное значение long
        };
    }

    @Test(dataProvider = "isPositiveData")
    public void testIsPositive(long val, boolean expected) {
        boolean result = calculator.isPositive(val);
        Assert.assertEquals(result, expected, "Check if " + val + " is positive");
    }
}
