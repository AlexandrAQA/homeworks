package org.example.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class OnlineTelevisionCategoryTest extends BaseFunc {
    public By COOKIE_LOCATOR =
            By.xpath(".//div[@class='fc-footer-buttons-container']//button//p[@class='fc-button-label'][contains(text(),'Соглашаюсь')]");
    public By LG_PAGE_TAG_LOCATOR =
            By.xpath(".//div[@class='button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag']");

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

    private By getTvCategoryLocator(String tvCategory) {
        return By.xpath(".//div[@class='catalog-form__checkbox-sign'][contains(text(), '" + tvCategory + "')]");
    }

    @Test(dataProvider = "tvCategory")
    public void selectTelevisionCategory(String tvCategory) {
        //open TV category page
        webDriver.get(TV_CATEGORY_URL);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webDriver.findElement(COOKIE_LOCATOR));

        //find TV category
        By TV_Category_LOCATOR = getTvCategoryLocator(tvCategory);
        executor.executeScript("arguments[0].click();", webDriver.findElement(TV_Category_LOCATOR));
        Assert.assertEquals(webDriver.findElement(LG_PAGE_TAG_LOCATOR).getText(),
                tvCategory, "Wrong page is opened");
    }

    @Test(dataProvider = "tvCategory", dependsOnMethods = "selectTelevisionCategory")
    public void validatingTvItemsName(String tvBrand) {
        List<WebElement> tvElements = webDriver.findElements(xpathTvItems);
        // Check if all TVs are manufactured by the specified brand
        for (WebElement tvElement : tvElements) {
            // Extract the manufacturer name for each TV
            String manufacturer = tvElement.getText();
            System.out.println(manufacturer);
            // Assert that the manufacturer is the specified brand
            Assert.assertTrue(manufacturer.toLowerCase().contains(tvBrand), "TV not manufactured by " + tvBrand + " found!");
        }
    }
}
