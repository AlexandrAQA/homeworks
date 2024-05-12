package org.example.tests;

import org.example.runner.BaseFunctionalTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CatalogComponentsTest extends BaseFunctionalTest {

    @Test
    public void navigateToComponentsCategoryTest() {
        navigateToCategory();
    }

    @Test
    public void checkItemNamesTest() {
        List<WebElement> componentItemCards = getComponentItemCards();
        checkItemDetails(componentItemCards, "name");
    }

    @Test
    public void checkItemQuantitiesTest() {
        List<WebElement> componentItemCards = getComponentItemCards();
        checkItemDetails(componentItemCards, "quantity");
    }

    @Test
    public void checkItemPricesTest() {
        List<WebElement> componentItemCards = getComponentItemCards();
        checkItemDetails(componentItemCards, "price");
    }
}

