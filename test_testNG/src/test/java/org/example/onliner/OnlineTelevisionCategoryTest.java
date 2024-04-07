package org.example.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlineTelevisionCategoryTest extends BaseFunc {
    public By COOKIE_LOCATOR =
            By.xpath(".//div[@class='fc-footer-buttons-container']//button//p[@class='fc-button-label'][contains(text(),'Соглашаюсь')]");
    public static By TV_Category_LOCATOR = By.xpath(
            ".//div[@class='catalog-form__checkbox-sign'][contains(text(), 'LG')][1]");
    public static By LG_PAGE_TAG_LOCATOR = By.xpath(
            ".//div[@class='button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag']");

    @Test
    public void selectTelevisionCategory() {
        //open TV category page
        webDriver.get(TV_CATEGORY_URL);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webDriver.findElement(COOKIE_LOCATOR));

        //find TV category (LG)
        scrollToElement(webDriver.findElement(TV_Category_LOCATOR));
        executor.executeScript("arguments[0].click();", webDriver.findElement(TV_Category_LOCATOR));
        Assert.assertEquals(webDriver.findElement(LG_PAGE_TAG_LOCATOR).getText(),
                "LG", "Wrong page is opened");
    }
}
