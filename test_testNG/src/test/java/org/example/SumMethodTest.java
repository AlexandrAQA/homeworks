package org.example;

import org.testng.Assert;
import org.testng.annotations.*;


public class SumMethodTest extends BaseTest {

    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {50, 50, 100},
                {-50, -100, -150},
                {10, -5, 5},
                {0, 5, 5},
                {-10, -5, -15}
        };
    }

    // tests for LONG
    @Test(dataProvider = "sumTestData", groups = {"smoke"})
    public void testSumLongNumbers(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expected, "Sum of numbers: " + a + " and " + b);
        ;
    }

    // tests for DOUBLE
    @DataProvider(name = "sumDoubleTestData")
    public Object[][] sumDoubleTestData() {
        return new Object[][]{
                {5.5, 10.5, 16.0},   //positive numbers
                {-5.5, -10.5, -16.0},  //negative numbers
                {5.5, -10.5, -5.0},    //positive and negative numbers
                {0.0, 5.5, 5.5},      //zero and positive number
                {0.0, -5.5, -5.5},  //zero and negative number
                {5.512452457626, 4554.435355354, 4559.947807811626},    // a lot of numbers after the point (positive numbers)
                {-434343.545435435, -53.5345435435353, -434397.07997897855}  //   a lot of numbers after the point (negative numbers)

        };
    }

    @Test(dataProvider = "sumDoubleTestData", groups = {"smoke"})
    public void testSumDouble(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, expected, "Sum of " + a + " and " + b + " (double)");
    }
}

