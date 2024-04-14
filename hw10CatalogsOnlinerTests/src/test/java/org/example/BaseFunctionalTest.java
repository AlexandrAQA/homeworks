package org.example;

import org.example.pages.CompAndNetPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseFunctionalTest{
    public final static String CATALOG_URL = "https://catalog.onliner.by/";
    public final static By COOKIE_LOCATOR =
            By.xpath(".//div[@class='fc-footer-buttons-container']//button//p[@class='fc-button-label'][contains(text(),'Соглашаюсь')]");

    public static WebDriver webDriver;
    WebDriverWait wait;

    public void clickElementWithJS(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webDriver.findElement(locator));
    }

    public By getTvCategoryLocator(String catalogCategories) {
        return By.xpath(".//span[@class='catalog-navigation-classifier__item-title-wrapper'][contains(text(),'" + catalogCategories + "')]");
    }

    CompAndNetPage compAndNetPage = new CompAndNetPage();

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        webDriver.get("https://www.onliner.by/");
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
