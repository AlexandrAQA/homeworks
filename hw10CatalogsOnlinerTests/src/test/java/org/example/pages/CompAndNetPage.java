package org.example.pages;

import java.util.Arrays;
import java.util.List;

public class CompAndNetPage {

    public final String xpathExpression = ".//div[@class='catalog-navigation-list__aside-title']";

    public final String componentsCard = ".//*[@class='catalog-navigation-list__dropdown-data']";

    public final String componentLocator = ".//*[contains(text(),'Комплектующие')]";

    public String itemDetailsXPath = ".//*[@class = 'catalog-navigation-list__dropdown-title']";

    public List<String> expectedSubcategories = Arrays.asList(
            "Ноутбуки, компьютеры, мониторы",
            "Комплектующие",
            "Техника для печати и дизайна",
            "Кассовые аппараты и торговое оборудование",
            "Манипуляторы и устройства ввода",
            "Хранение данных",
            "Мультимедиа периферия",
            "Сетевое оборудование",
            "Аксессуары к ноутбукам и компьютерам",
            "Электропитание",
            "Игры и программное обеспечение"
    );
}
