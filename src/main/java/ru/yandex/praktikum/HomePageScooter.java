package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

class HomePageScooter
{
    private WebDriver driver;

    // локатор согласия с куками
    private By cookieButton = By.id("rcc-confirm-button");

    // локатор верхней кнопки "Заказать"
    private By orderButtonUp = By.className("Button_Button__ra12g");

    // локатор нижней кнопки "Заказать"
    private By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // локаторы для открывающегося списка вопросов
    private By zeroQuestion = By.xpath(".//*[@id='accordion__heading-0']");
    private By firstQuestion = By.xpath(".//*[@id='accordion__heading-1']");
    private By secondQuestion = By.xpath(".//*[@id='accordion__heading-2']");
    private By thirdQuestion = By.xpath(".//*[@id='accordion__heading-3']");
    private By fourthQuestion = By.xpath(".//*[@id='accordion__heading-4']");
    private By fifthQuestion = By.xpath(".//*[@id='accordion__heading-5']");
    private By sixthQuestion = By.xpath(".//*[@id='accordion__heading-6']");
    private By seventhQuestion = By.xpath(".//*[@id='accordion__heading-7']");

    // конструктор класса
    public HomePageScooter(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickCookieButton()
    {
        driver.findElement(cookieButton).click();
    }

    // нажатие на верхнюю кнопку "Заказать"
    public void clickOrderButtonUp()
    {
        driver.findElement(orderButtonUp).click();
    }

    // нажатие на нижнюю кнопку "Заказать"
    public void clickOrderButtonDown()
    {
        driver.findElement(orderButtonDown).click();
    }


    // метод для нажатия на первый открывающийся вопрос
    public void ZeroQuestion()
    {
        driver.findElement(zeroQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-0']/p")));;
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p")).getText();
        String expectAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void FirstQuestion()
    {
        driver.findElement(firstQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-1']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-1']/p")).getText();
        String expectAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void SecondQuestion()
    {
        driver.findElement(secondQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-2']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-2']/p")).getText();
        String expectAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли " +
                "самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void ThirdQuestion()
    {
        driver.findElement(thirdQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-3']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-3']/p")).getText();
        String expectAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void FourthQuestion()
    {
        driver.findElement(fourthQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-4']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-4']/p")).getText();
        String expectAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по " +
                "красивому номеру 1010.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void FifthQuestion()
    {
        driver.findElement(fifthQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-5']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-5']/p")).getText();
        String expectAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если " +
                "будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void SixthQuestion()
    {
        driver.findElement(sixthQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-6']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-6']/p")).getText();
        String expectAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не " +
                "попросим. Все же свои.";
        assertEquals(expectAnswer, actualAnswer);
    }

    public void SeventhQuestion()
    {
        driver.findElement(seventhQuestion).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-7']/p")));
        String actualAnswer = driver.findElement(By.xpath(".//div[@id='accordion__panel-7']/p")).getText();
        String expectAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals(expectAnswer, actualAnswer);
    }
}