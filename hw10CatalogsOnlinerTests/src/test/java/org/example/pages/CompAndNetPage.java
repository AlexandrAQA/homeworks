package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.runner.BaseFunctionalTest.*;
import static org.testng.AssertJUnit.fail;

public class CompAndNetPage extends BasePage implements IbasePage {

    public List<String> expectedSubcategories = Arrays.asList(
            "Ноутбуки, компьютеры, мониторы",
            "Комплектующие",
            "Техника для печати и дизайна",
            "Кассовые аппараты и торговое оборудование",
            "Манипуляторы и устройства ввода",
            "Хранение данных",
            "Мультимедиа периферия",
            "Сетевое оборудование",
            "Аксессуары к ноутбукам и компьютерам",
            "Электропитание",
            "Игры и программное обеспечение"
    );

    public CompAndNetPage() {
        super();
    }

    public void clickOnCookieWindow() {
        webDriver.get(CATALOG_URL);
        if (!webDriver.findElements(COOKIE_LOCATOR).isEmpty())
            clickElementWithJS(COOKIE_LOCATOR);
    }


    public void clickCategory(String categoryName) {
        By categoryLocator = getTvCategoryLocator(categoryName);
        driver.findElement(categoryLocator).click();
    }

    public List<String> getSubcategories() {
        List<WebElement> actualSubcategories =
                driver.findElements(By.xpath(xpathExpression));

        // Convert WebElement list to String list and ignore empty strings
        return actualSubcategories.stream()
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public void waitForSubcategories(int expectedNumber) {
        try {
            wait.until(driver -> getSubcategories().size() == expectedNumber);
        } catch (TimeoutException e) {
            fail("The number of subcategories is not equal to the expected number");
        }
    }

    @Override
    public void openPage() {

    }

    @Override
    public boolean isOpened() {
        return false;
    }
}
