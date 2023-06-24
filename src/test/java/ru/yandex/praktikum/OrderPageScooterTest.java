package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageScooterTest
{
    private WebDriver driver;

    private final String buttonChoice;
    private final String username;
    private final String usersurname;
    private final String useraddress;
    private final String nameMetroStation;
    private final String userphonenumber;
    private final String days;
    private final int countDays;
    private final String colorScooter;
    private final String textComments;

    public OrderPageScooterTest(String buttonChoice, String username, String usersurname, String useraddress,
                                String nameMetroStation, String userphonenumber, String days, int countDays,
                                String colorScooter, String textComments)
    {
        this.buttonChoice = buttonChoice;
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
        Constants locator = new Constants();
        return new Object[][]
                {
                        {locator.UP_ORDER_BUTTON, "Андрей", "Петров", "ул. Ленина, д. 25, кв. 18", "Сокольники", "89995554321", "19.06.2023", 2,
                                "black", "Тут могла быть ваша реклама."},
                        {locator.DOWN_ORDER_BUTTON, "Светлана", "Сидорова", "ул. Плетёная, д. 9, кв. 341", "Кузьминки", "85556662211",
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
    public void clickOrderButton()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.clickOrderButton(buttonChoice);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.order(username, usersurname, useraddress, nameMetroStation, userphonenumber, days,
                countDays, colorScooter, textComments);

        assertTrue("Отсутствует окно подтверждения.", objOrderPage.checkConfirmationOfAnOrder());
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}