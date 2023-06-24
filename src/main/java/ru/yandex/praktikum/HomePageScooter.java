package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class HomePageScooter
{
    private final WebDriver driver;

    private final By cookieButton = By.id("rcc-confirm-button");

    private final By orderButtonUp = By.className("Button_Button__ra12g");
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    private final By firstQuestion = By.xpath(".//*[@id='accordion__heading-0']");
    private final By secondQuestion = By.xpath(".//*[@id='accordion__heading-1']");
    private final By thirdQuestion = By.xpath(".//*[@id='accordion__heading-2']");
    private final By fourthQuestion = By.xpath(".//*[@id='accordion__heading-3']");
    private final By fifthQuestion = By.xpath(".//*[@id='accordion__heading-4']");
    private final By sixthQuestion = By.xpath(".//*[@id='accordion__heading-5']");
    private final By seventhQuestion = By.xpath(".//*[@id='accordion__heading-6']");
    private final By eighthQuestion = By.xpath(".//*[@id='accordion__heading-7']");

    private final By firstAnswer = By.xpath(".//*[@id='accordion__panel-0']");
    private final By secondAnswer = By.xpath(".//*[@id='accordion__panel-1']");
    private final By thirdAnswer = By.xpath(".//*[@id='accordion__panel-2']");
    private final By fourthAnswer = By.xpath(".//*[@id='accordion__panel-3']");
    private final By fifthAnswer = By.xpath(".//*[@id='accordion__panel-4']");
    private final By sixthAnswer = By.xpath(".//*[@id='accordion__panel-5']");
    private final By seventhAnswer = By.xpath(".//*[@id='accordion__panel-6']");
    private final By eighthAnswer = By.xpath(".//*[@id='accordion__panel-7']");

    public HomePageScooter(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickCookieButton()
    {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButton(String buttonChoice)
    {
        if(buttonChoice == Constants.UP_ORDER_BUTTON)
            driver.findElement(orderButtonUp).click();
        else if(buttonChoice == Constants.DOWN_ORDER_BUTTON)
            driver.findElement(orderButtonDown).click();
    }

    public void waitingElement(By element)
    {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickQuestionButton(int questionNumber)
    {
        if(questionNumber == 1)
        {
            driver.findElement(firstQuestion).click();
            waitingElement(firstAnswer);
        }
        else if(questionNumber == 2)
        {
            driver.findElement(secondQuestion).click();
            waitingElement(secondAnswer);
        }
        else if(questionNumber == 3)
        {
            driver.findElement(thirdQuestion).click();
            waitingElement(thirdAnswer);
        }
        else if(questionNumber == 4)
        {
            driver.findElement(fourthQuestion).click();
            waitingElement(fourthAnswer);
        }
        else if(questionNumber == 5)
        {
            driver.findElement(fifthQuestion).click();
            waitingElement(fifthAnswer);
        }
        else if(questionNumber == 6)
        {
            driver.findElement(sixthQuestion).click();
            waitingElement(sixthAnswer);
        }
        else if(questionNumber == 7)
        {
            driver.findElement(seventhQuestion).click();
            waitingElement(seventhAnswer);
        }
        else if(questionNumber == 8)
        {
            driver.findElement(eighthQuestion).click();
            waitingElement(eighthAnswer);
        }
    }

    public String getAnswer(int answerNumber)
    {
        String answerString = "";
        if(answerNumber == 1)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p")).getText();
        else if(answerNumber == 2)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-1']/p")).getText();
        else if(answerNumber == 3)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-2']/p")).getText();
        else if(answerNumber == 4)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-3']/p")).getText();
        else if(answerNumber == 5)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-4']/p")).getText();
        else if(answerNumber == 6)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-5']/p")).getText();
        else if(answerNumber == 7)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-6']/p")).getText();
        else if(answerNumber == 8)
            answerString = driver.findElement(By.xpath(".//div[@id='accordion__panel-7']/p")).getText();
        return answerString;
    }
}