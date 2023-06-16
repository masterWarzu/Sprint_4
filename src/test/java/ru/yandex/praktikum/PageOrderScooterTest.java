package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageOrderScooterTest
{
    private WebDriver driver;

    @Test
    public void checkOrder()
    {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.clickCookieButton();    // нажимает на согласие c куками

        objHomePage.clickOrderButtonUp();   // нажатие на верхнюю кнопку заказа
        //objHomePage.clickOrderButtonDown(); // нажатие на нижнюю кнопку заказа

        OrderPageScooter objPageOrderScooter = new OrderPageScooter(driver);

        // первый набор данных
        objPageOrderScooter.order("Андрей", "Петров", "ул. Ленина, д. 25, кв. 18",
                "Сокольники", "89995554321", "19.06.2023", 2,
                "black", "Я сделяль!");

        // второй набор данных
        objPageOrderScooter.order("Светлана", "Сидорова", "ул. Плетёная, д. 9, кв. 341",
                "Кузьминки", "85556662211", "24.06.2023", 5,
                "grey", "А розовые самокаты есть у вас вообще?!");
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}