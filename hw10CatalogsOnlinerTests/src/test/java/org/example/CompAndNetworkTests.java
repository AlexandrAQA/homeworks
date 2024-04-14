package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CompAndNetworkTests extends BaseFunctionalTest{

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
        List<String> actualSubcategoriesText = actualSubcategories.stream()   //creating new stream
                .map(WebElement::getText)                                     //converting WebElement to String
                .filter(text -> !text.isEmpty())                            //ignoring empty strings
                .collect(Collectors.toList());                              //collecting to list

        //Sort both lists
        //This is necessary to ensure the same order of elements in both lists before comparison
        Collections.sort(actualSubcategoriesText);
        Collections.sort(compAndNetPage.expectedSubcategories);

        // Compare two lists
        wait.until(webDriver -> actualSubcategoriesText.size() == compAndNetPage.expectedSubcategories.size());
        Assert.assertEquals(actualSubcategoriesText, compAndNetPage.expectedSubcategories);
    }
}
