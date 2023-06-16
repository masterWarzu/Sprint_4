package ru.yandex.praktikum;

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

    @Test
    public void checkQuestion()
    {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.clickCookieButton();

        // скроллинг до нижнего элемента
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        // обработка вопросов-ответов
        objHomePage.ZeroQuestion();    // первый вопрос
        objHomePage.FirstQuestion();   // второй вопрос
        objHomePage.SecondQuestion();  // третий вопрос
        objHomePage.ThirdQuestion();   // четвёртый вопрос
        objHomePage.FourthQuestion();  // пятый вопрос
        objHomePage.FifthQuestion();   // шестой вопрос
        objHomePage.SixthQuestion();   // седьмой вопрос
        objHomePage.SeventhQuestion(); // восьмой вопрос
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}