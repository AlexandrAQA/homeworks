package org.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.BrowserFactory;
import org.example.utils.BrowserTypeEnum;
import org.example.utils.ConfigurationReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

// SingletonDriver.java
public class SingletonDriver {
    private static WebDriver driver;

    private SingletonDriver() {
    }

    private static void initDriver() {
        WebDriverManager.chromedriver().setup();
        String browserType = ConfigurationReader.getProperty("browser");
        if (browserType != null) {
            driver = BrowserFactory.createInstance(BrowserTypeEnum.valueOf(browserType));
            if (driver == null) {
                throw new RuntimeException("Failed to create WebDriver instance for browser type: " + browserType);
            }
        } else {
            throw new RuntimeException("Browser type is not specified in the config.properties file");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
