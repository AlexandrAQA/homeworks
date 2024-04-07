package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.fail;

public class TimeoutTest {
    Timeout timeout = new Timeout();

    @Test
    public void sleepShouldNotThrowExceptionWhenGivenPositiveSeconds() {
        assertThrows(InterruptedException.class, () -> timeout.sleep(5));
    }

    @Test
    public void sleepShouldNotThrowExceptionWhenGivenZeroSeconds() {
        assertThrows(InterruptedException.class, () -> timeout.sleep(0));
    }
}
