package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseFunctionalTest {
    public final static String TV_CATEGORY_URL = "https://catalog.onliner.by/tv";

    public final static By xpathTvItems = By.xpath(".//div[@class='catalog-form__offers-part catalog-form__offers-part_data']//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']");

    public final static By COOKIE_LOCATOR =
            By.xpath(".//div[@class='fc-footer-buttons-container']//button//p[@class='fc-button-label'][contains(text(),'Соглашаюсь')]");
    public final static By PAGE_TAG_LOCATOR =
            By.xpath(".//div[@class='button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag']");


    public static WebDriver webDriver;

    public void clickElementWithJS(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webDriver.findElement(locator));
    }

    public By getTvCategoryLocator(String tvCategory) {
        return By.xpath(".//div[@class='catalog-form__checkbox-sign'][contains(text(), '" + tvCategory + "')]");
    }

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webDriver.get("https://www.onliner.by/");
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
