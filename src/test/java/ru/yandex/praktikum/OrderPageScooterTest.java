package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderPageScooterTest
{
    private WebDriver driver;

    private final String username;
    private final String usersurname;
    private final String useraddress;
    private final String nameMetroStation;
    private final String userphonenumber;
    private final String days;
    private final int countDays;
    private final String colorScooter;
    private final String textComments;

    public OrderPageScooterTest(String username, String usersurname, String useraddress, String nameMetroStation,
                                String userphonenumber, String days, int countDays, String colorScooter,
                                String textComments)
    {
        this.username = username;
        this.usersurname = usersurname;
        this.useraddress = useraddress;
        this.nameMetroStation = nameMetroStation;
        this.userphonenumber = userphonenumber;
        this.days = days;
        this.countDays = countDays;
        this.colorScooter = colorScooter;
        this.textComments = textComments;
    }

    @Parameterized.Parameters
    public static Object[][] orderData()
    {
        return new Object[][]
        {
            {"Андрей", "Петров", "ул. Ленина, д. 25, кв. 18", "Сокольники", "89995554321", "19.06.2023", 2,
                    "black", "Я сделяль!"},
            {"Светлана", "Сидорова", "ул. Плетёная, д. 9, кв. 341", "Кузьминки", "85556662211",
                    "24.06.2023", 5, "grey", "А розовые самокаты есть у вас вообще?!"},
        };
    }

    @Before
    public void orderTest()
    {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderButtonUp()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();    // нажимает на согласие c куками
        objHomePage.clickOrderButtonUp();   // нажатие на верхнюю кнопку заказа
        OrderPageScooter objPageOrderScooter = new OrderPageScooter(driver);    //создаётся экземпляр класса
        objPageOrderScooter.order(username, usersurname, useraddress, nameMetroStation, userphonenumber, days,
                                  countDays, colorScooter, textComments);
    }

    @Test
    public void orderButtonDown()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();    // нажимает на согласие c куками
        objHomePage.clickOrderButtonDown(); // нажатие на нижнюю кнопку заказа
        OrderPageScooter objPageOrderScooter = new OrderPageScooter(driver);    //создаётся экземпляр класса
        objPageOrderScooter.order(username, usersurname, useraddress, nameMetroStation, userphonenumber, days,
                                  countDays, colorScooter, textComments);
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}