package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageScooterTest
{
    private WebDriver driver;

    @Before
    public void questionsTest()
    {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        // скроллинг до нижнего элемента
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void firstQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.Zero();    // первый вопрос
    }

    @Test
    public void secondQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.FirstQuestion();   // второй вопрос
    }

    @Test
    public void thirdQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.SecondQuestion();  // третий вопрос
    }

    @Test
    public void fourthQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.ThirdQuestion();   // четвёртый вопрос
    }

    @Test
    public void fifthQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.FourthQuestion();  // пятый вопрос
    }

    @Test
    public void sixthQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.FifthQuestion();   // шестой вопрос
    }

    @Test
    public void seventhQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.SixthQuestion();   // седьмой вопрос
    }

    @Test
    public void eighthQuestion()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.SeventhQuestion(); // восьмой вопрос
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}