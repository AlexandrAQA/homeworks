package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseFunctionalTest {
    public final static String TV_CATEGORY_URL = "https://catalog.onliner.by/tv";

    public static By xpathTvItems = By.xpath(".//div[@class='catalog-form__offers-part catalog-form__offers-part_data']//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']");
    public static WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webDriver.get("https://www.onliner.by/");
    }

    @AfterClass
    public void cleanup() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
