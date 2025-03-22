package org.unique.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.unique.scooterTest.TestData.*;

@RunWith(Parameterized.class)
public class OrderCreationTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderCreationTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Джон", "Рэмбо", "г. Москва, ул. Пушкина, д.10", "Театральная", "89992282828", "01.01.2026", "сутки", "чёрный жемчуг", "Айл би бэк"},
                {"Джеки", "Чан", "проспект Маяковского 6", "Маяковская", "+79992281234", "10.10.2026", "двое суток", "серая безысходность", "Я на разборках в Бронксе"},
        };
    }

    @Test
    public void OrderPositiveTest() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPageScooter objMainPage = new MainPageScooter(driver);
        objMainPage.clickHeaderOrderButton();
        OrderFormPage objOrderPage = new OrderFormPage(driver);
        objOrderPage.acceptCookieButtonClick();

        //Позитивный сценарий оформления заказа
        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setAddress(address);
        objOrderPage.setSubway(subway);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickOrderNextButton();
        objOrderPage.setDate(date);
        objOrderPage.setRentalPeriod(rentalPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();

        // Проверка успешного создания заказа
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), confirmHeaderText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
