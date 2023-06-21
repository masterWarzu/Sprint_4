package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageScooter
{
    private final WebDriver driver;

    // локаторы первой страницы заказа
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//div/button[text()='Далее']");

    // локаторы второй страницы заказа
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    private final By commentsField = By.xpath("//div[@class='Input_InputContainer__3NykH']/" +
                                                                    "input[@placeholder='Комментарий для курьера']");
    private final By buttonOrderFinal = By.xpath("//*[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By buttonConfirm = By.xpath("//*[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public OrderPageScooter(WebDriver driver)
    {
        this.driver = driver;
    }

    // работа с полями в форме заказа
    public void userName(String username)
    {
        driver.findElement(nameField).isEnabled();
        driver.findElement(nameField).click();
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(username);
    }
    public void userSurname(String usersurname)
    {
        driver.findElement(surnameField).isEnabled();
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(usersurname);
    }
    public void userAddress(String useraddress)
    {
        driver.findElement(addressField).isEnabled();
        driver.findElement(addressField).click();
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(useraddress);
    }
    public void userPhoneNumber(String userphonenumber)
    {
        driver.findElement(phoneField).isEnabled();
        driver.findElement(phoneField).click();
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(userphonenumber);
    }
    public void choiceMetroStation(String nameMetroStation)
    {
        driver.findElement(metroField).isEnabled();
        driver.findElement(metroField).click();
        driver.findElement(metroField).clear();
        WebElement metroStation = driver.findElement(By.xpath(".//div[text()='" + nameMetroStation + "']"));
        metroStation.click();
    }
    public void clickButtonNext()
    {
        driver.findElement(buttonNext).click();
    }
    public void deliveryDate(String days)
    {
        driver.findElement(dateField).isEnabled();
        driver.findElement(dateField).click();
        driver.findElement(By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN"))
                                                                                .sendKeys(days);
        driver.findElement(By.className("Order_Header__BZXOb")).click();
    }
    public void countDays(int count)
    {
        driver.findElement(rentalPeriodField).isEnabled();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div[@role='option'][" + count + "]")).click();
    }
    public void colorScooter(String color)
    {
        driver.findElement(By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label/input[@id='" + color + "']"))
                                                                                                            .click();
    }
    public void comments(String comm)
    {
        driver.findElement(commentsField).isEnabled();
        driver.findElement(commentsField).click();
        driver.findElement(commentsField).clear();
        driver.findElement(commentsField).sendKeys(comm);
    }
    public void clickButtonOrderFinal()
    {
        driver.findElement(buttonOrderFinal).click();
    }
    public void clickButtonConfirm()
    {
        driver.findElement(buttonConfirm).click();
    }

    public void order(String username, String usersurname, String useraddress, String nameMetroStation,
                      String userphonenumber, String days, int countDays, String colorScooter, String textComments)
    {
        userName(username);
        userSurname(usersurname);
        userAddress(useraddress);
        choiceMetroStation(nameMetroStation);
        userPhoneNumber(userphonenumber);
        clickButtonNext();
        deliveryDate(days);
        countDays(countDays);
        colorScooter(colorScooter);
        comments(textComments);
        clickButtonOrderFinal();
        clickButtonConfirm();
    }
}