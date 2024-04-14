package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CatalogTests extends BaseFunctionalTest {

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
                {"Красота и спорт"},
                {"Детям и мамам"}
        };
    }

    @Test(dataProvider = "catalogCategories")
    public void catalogPageTest(String catalogCategories) {
        webDriver.get(CATALOG_URL);
        if (!webDriver.findElements(COOKIE_LOCATOR).isEmpty()) {
            clickElementWithJS(COOKIE_LOCATOR);
        } else {
            By categoryLocator = getTvCategoryLocator(catalogCategories);
            Assert.assertEquals(webDriver.findElement(categoryLocator), catalogCategories);
        }
    }
}
