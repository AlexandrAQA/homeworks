package org.example.tests;

import org.example.runner.BaseFunctionalTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.fail;

public class CompAndNetworkTests extends BaseFunctionalTest {

    @Test
    public void compAndNetCategoryTest2() {
        webDriver.get(CATALOG_URL);
        if (!webDriver.findElements(COOKIE_LOCATOR).isEmpty())
            clickElementWithJS(COOKIE_LOCATOR);
        By categoryLocator = getTvCategoryLocator("Компьютеры и сети");
        webDriver.findElement(categoryLocator).click();
        List<WebElement> actualSubcategories =
                webDriver.findElements(By.xpath(compAndNetPage.xpathExpression));

        // Convert WebElement list to String list and ignore empty strings
        List<String> actualSubcategoriesText = actualSubcategories.stream()
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());

        Collections.sort(actualSubcategoriesText);
        Collections.sort(compAndNetPage.expectedSubcategories);

        try {
            wait.until(webDriver -> actualSubcategoriesText.size() == compAndNetPage.expectedSubcategories.size());
        } catch (TimeoutException e) {
            fail("The number of subcategories is not equal to the expected number");
        }
        Assert.assertEquals(actualSubcategoriesText, compAndNetPage.expectedSubcategories);
    }
}
