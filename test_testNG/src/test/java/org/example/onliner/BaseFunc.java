package org.example.onliner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseFunc {
    public final static String TV_CATEGORY_URL = "https://catalog.onliner.by/tv";
    public static WebDriver webDriver;

    public void hardClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void scrollToElement(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].scrollIntoView(true);", webElement);
        //executor.executeScript("window.scrollBy(0, 700);");
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.onliner.by/");
    }

    @AfterMethod
    public void cleanup() {
//        if (webDriver != null) {
//            webDriver.quit();
// }
    }
}
