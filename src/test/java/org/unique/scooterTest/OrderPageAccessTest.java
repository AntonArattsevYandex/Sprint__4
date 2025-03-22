package org.unique.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.unique.scooterTest.TestData.orderHeaderText;

public class OrderPageAccessTest {

    private WebDriver driver;

    @Test
    public void OrderPageOpenAfterHeaderButtonClick() {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        // Создать объект класса с домашней страницей
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // Нажать на кнопку "Заказать" в шапке страницы
        objMainPage.clickHeaderOrderButton();
        // Создать объект класса со страницей заказа
        OrderFormPage objOrderPage = new OrderFormPage(driver);
        // Проверить, что открылась страница заказа
        objOrderPage.isPageOpen(objOrderPage.getOrderHeader(), orderHeaderText);
    }

    @Test
    public void OrderPageOpenAfterPageButtonClick() {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        // Создать объект класса с домашней страницей
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // Нажать на кнопку "Заказать" внизу страницы
        objMainPage.clickPageOrderButton();
        // Создать объект класса со страницей заказа
        OrderFormPage objOrderPage = new OrderFormPage(driver);
        // Проверить, что открылась страница заказа
        objOrderPage.isPageOpen(objOrderPage.getOrderHeader(), orderHeaderText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
