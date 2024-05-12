package org.example.tests;

import org.example.runner.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class CompAndNetworkTests extends BaseFunctionalTest {

    @Test
    public void compAndNetCategoryTest2() {
        compAndNetPage.clickOnCookieWindow();
        compAndNetPage.clickCategory("Компьютеры и сети");
        List<String> actualSubcategoriesText = compAndNetPage.getSubcategories();

        Collections.sort(actualSubcategoriesText);
        Collections.sort(compAndNetPage.expectedSubcategories);

        compAndNetPage.waitForSubcategories(compAndNetPage.expectedSubcategories.size());
        Assert.assertEquals(actualSubcategoriesText, compAndNetPage.expectedSubcategories);
    }
}
