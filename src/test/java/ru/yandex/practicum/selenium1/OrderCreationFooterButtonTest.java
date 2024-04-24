package ru.yandex.practicum.selenium1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.PageObjectModel.SamokatPageObject;
import ru.yandex.practicum.WebDriverFactory.WebDriverFactory;
import static ru.yandex.practicum.Constants.Browsers.*;

public class OrderCreationFooterButtonTest {

    private WebDriver driver;

    @Before

    public void starter(){
        driver = WebDriverFactory.getWebDriver(CHROME); // аргумент CHROME == запуск теста в гугл хром, FIREFOX == запуск теста в гугл хром
        driver.get("https://qa-scooter.praktikum-services.ru");
    }



    @Test
    public void orderCreationHeaderButtonTest(){


        SamokatPageObject mainPageObject = new SamokatPageObject(driver);

        mainPageObject.scrollUntilFooterOrderButton();

        mainPageObject.clickFooterOrderButton();

        mainPageObject.fillingNameField("Некий");

        mainPageObject.fillingLastNameField("Иванушка");

        mainPageObject.fillingAddressField("Тридевятое царство, тридесятое государство");

        mainPageObject.fillingMetroField("Сокол");

        mainPageObject.fillingPhoneField("890100000000");

        mainPageObject.nextButtonClicking();

        mainPageObject.fillingDateField("01.01.2025");

        mainPageObject.fillingRentTimeField("сутки");

        mainPageObject.totalOrderButtonClicking();

        mainPageObject.orderCreatingCompleteStep();


    }

    @After
    public void shutDown(){
        driver.quit();
    }


}
