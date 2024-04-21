package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class OnlineTelevisionCategoryTest extends BaseFunctionalTest {

    @DataProvider(name = "tvCategory")
    public Object[][] tvCategory() {
        return new Object[][]{
                {"LG"},
                {"TCL"},
                {"Hisense"},
                {"Philips"},
                {"Sony"},
                {"Horizont"},
                {"Blaupunkt"},
                {"Яндекс"},
                {"KIVI"}
        };
    }

    @Test(dataProvider = "tvCategory")
    public void selectTelevisionCategory(String tvCategory) {
        webDriver.get(TV_CATEGORY_URL);
        if (!webDriver.findElements(COOKIE_LOCATOR).isEmpty()) {
            clickElementWithJS(COOKIE_LOCATOR);
        } else {
            By TV_Category_LOCATOR = getTvCategoryLocator(tvCategory);
            clickElementWithJS(TV_Category_LOCATOR);
            Assert.assertEquals(webDriver.findElement(PAGE_TAG_LOCATOR).getText(),
                    tvCategory, "Wrong page is opened");
        }
    }


    @Test(dataProvider = "tvCategory")
    public void validatingTvItemsName(String tvBrand) {
        List<WebElement> tvElements = webDriver.findElements(xpathTvItems);
        for (WebElement tvElement : tvElements) {
            String manufacturer = tvElement.getText();
            Assert.assertTrue(manufacturer.toLowerCase().contains(tvBrand), "TV is not produced by " + tvBrand + "!");
        }
    }
}
