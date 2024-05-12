package org.example.runner;

import org.example.pages.CatalogPage;
import org.example.pages.CompAndNetPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.fail;

public class BaseFunctionalTest {
    public final static String CATALOG_URL = "https://catalog.onliner.by/";
    public final static By COOKIE_LOCATOR =
            By.xpath(".//div[@class='fc-footer-buttons-container']//button//p[@class='fc-button-label']" +
                    "[contains(text(),'Соглашаюсь')]");

    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public CatalogPage catalogPage;

    public static void clickElementWithJS(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webDriver.findElement(locator));
    }

    public static By getTvCategoryLocator(String catalogCategories) {
        return By.xpath(".//span[@class='catalog-navigation-classifier__item-title-wrapper']" +
                "[contains(text(),'" + catalogCategories + "')]");
    }

    public CompAndNetPage compAndNetPage = new CompAndNetPage();

    public void navigateToCategory() {
        webDriver.get(CATALOG_URL);
        if (!webDriver.findElements(COOKIE_LOCATOR).isEmpty())
            clickElementWithJS(COOKIE_LOCATOR);
        By categoryLocator = getTvCategoryLocator("Компьютеры и сети");
        webDriver.findElement(categoryLocator).click();
        //Открыть пункт "Комплектующие".
        webDriver.findElement(By.xpath(".//*[contains(text(),'Комплектующие')]")).click();
    }

    public List<WebElement> getComponentItemCards() {
        return webDriver.findElements(By.xpath(compAndNetPage.componentsCard));
    }

    public void checkItemDetails(List<WebElement> componentItemCards, String detailType) {
        for (WebElement item : componentItemCards) {
            // Check if the item is displayed
            if (item.isDisplayed()) {
                // Check if the item has a detail (name, quantity, price)
                WebElement detailElement = item.findElement(By.xpath(compAndNetPage.itemDetailsXPath));
                String detail = detailElement.getText();
                System.out.println(detail);
                assertFalse(detail.isEmpty(), "Item " + detailType + " is empty");
            } else {
                fail("Item is not displayed");
            }
        }
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=375,812"); // Размер экрана iPhone X
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-file-access-from-files");
        options.addArguments("--start-maximized");
        options.addArguments("--auto-open-devtools-for-tabs");
        options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) " +
                "AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        webDriver.get("https://www.onliner.by/");

        catalogPage = new CatalogPage();
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
