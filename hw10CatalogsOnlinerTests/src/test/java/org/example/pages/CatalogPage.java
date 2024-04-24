package org.example.pages;

import org.openqa.selenium.By;

import static org.example.runner.BaseFunctionalTest.*;

public class CatalogPage extends BasePage implements IbasePage {

    private final By cookieLocator = COOKIE_LOCATOR; // Define COOKIE_LOCATOR
    private final String catalogUrl = CATALOG_URL; // Define CATALOG_URL
    private final By categoryLocator = By.id("category");

    public CatalogPage() {
        super();
    }

    @Override
    public void openPage() {
        driver.get(catalogUrl);
    }

    public void clickCategory(String categoryName) {
        driver.findElement(categoryLocator).click();
    }

    public void clickCookieIfPresent() {
        if (!driver.findElements(cookieLocator).isEmpty()) {
            clickElementWithJS(cookieLocator);
        }
    }

    public By getCategoryLocator(String catalogCategories) {
        return By.xpath(".//span[@class='catalog-navigation-classifier__item-title-wrapper']" +
                "[contains(text(),'" + catalogCategories + "')]");
    }


    @Override
    public boolean isOpened() {
        return false;
    }
}
