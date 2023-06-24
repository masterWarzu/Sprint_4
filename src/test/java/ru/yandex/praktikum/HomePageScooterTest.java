package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HomePageScooterTest
{
    private WebDriver driver;

    private final int questionNumber;
    private final String answer;

    public HomePageScooterTest(int questionNumber, String answer)
    {
        this.questionNumber = questionNumber;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[] getAnswerToQuestion()
    {
        return new Object[][]
                {
                        {1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                        {2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                                " можете просто сделать несколько заказов — один за другим."},
                        {3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если" +
                                " мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                        {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                        {5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по " +
                                "красивому номеру 1010."},
                        {6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если " +
                                "будете кататься без передышек и во сне. Зарядка не понадобится."},
                        {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не " +
                                "попросим. Все же свои."},
                        {8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                };
    }
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
    public void questionAndAnswer()
    {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButton();
        objHomePage.clickQuestionButton(questionNumber);
        String actual = objHomePage.getAnswer(questionNumber);
        assertEquals("-= Тест не пройден: " + questionNumber + " =-", answer, actual);
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}