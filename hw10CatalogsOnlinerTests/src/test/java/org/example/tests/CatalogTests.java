package org.example.tests;

import org.example.runner.BaseFunctionalTest;
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
        catalogPage.openPage();
        catalogPage.clickCategory(catalogCategories);
    }
}
