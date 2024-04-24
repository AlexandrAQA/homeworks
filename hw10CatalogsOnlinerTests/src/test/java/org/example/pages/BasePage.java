package org.example.pages;

import org.example.core.SingletonDriver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public final String xpathExpression = ".//div[@class='catalog-navigation-list__aside-title']";

    public final String componentsCard = ".//*[@class='catalog-navigation-list__dropdown-data']";

    public String itemDetailsXPath = ".//*[@class = 'catalog-navigation-list__dropdown-title']";

    protected WebDriver driver;

    public BasePage() {
        this.driver = SingletonDriver.getDriver();
    }
}
