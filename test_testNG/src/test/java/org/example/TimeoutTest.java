package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TimeoutTest {
    @DataProvider(name = "sleepData")
    public Object[][] sleepData() {
        return new Object[][] {
                {1},  // 1 second
                {3},  // 3 second
                {5}   // 5 second
        };
    }

    @Test(dataProvider = "sleepData")
    public void testSleep(int sec) {
        long startTime = System.currentTimeMillis();
        Timeout.sleep(sec);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed Time (sec): " + elapsedTime / 1000);
    }
}
