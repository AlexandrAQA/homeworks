package org.example.pages;

import java.util.Arrays;
import java.util.List;

public class CompAndNetPage {

        public final String xpathExpression = ".//div[@class='catalog-navigation-list__aside-title']";

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
