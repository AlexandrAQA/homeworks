package org.example.tests;

import org.example.runner.BaseFunctionalTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MobTest extends BaseFunctionalTest {

    @DataProvider(name = "catalogCategories")
    public Object[][] catalogPageTestData() {
        return new Object[][]{
                {"Online prime"},
                {"Электроника"},
                {"Компьютеры и сети"},
                {"Бытовая техника"},
                {"На каждый день"},
                {"Стройка и ремонт"},
                {"Дом и сад"},
                {"Авто и мото"},
                {"Красота и спорт"},
                {"Детям и мамам"}
        };
    }

    @Test(dataProvider = "catalogCategories")
    public void catalogPageTest(String catalogCategories) {

        webDriver.get(CATALOG_URL);

        if (!webDriver.findElements(COOKIE_LOCATOR).isEmpty()) {
            webDriver.findElement(COOKIE_LOCATOR).click();
        } else {
            By categoryLocator = getTvCategoryLocator(catalogCategories);
            Assert.assertEquals(webDriver.findElement(categoryLocator).getText(), catalogCategories);
        }

        webDriver.quit();
    }
}