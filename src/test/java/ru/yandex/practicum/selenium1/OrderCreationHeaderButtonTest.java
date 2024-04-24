package ru.yandex.practicum.selenium1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.PageObjectModel.SamokatPageObject;
import ru.yandex.practicum.WebDriverFactory.WebDriverFactory;
import static ru.yandex.practicum.Constants.Browsers.*;




public class OrderCreationHeaderButtonTest {

    private WebDriver driver;

    @Before

    public void starter(){
        driver = WebDriverFactory.getWebDriver(CHROME); // аргумент CHROME == запуск теста в гугл хром, FIREFOX == запуск теста в гугл хром
        driver.get("https://qa-scooter.praktikum-services.ru");
    }



    @Test
    public void orderCreationHeaderButtonTest(){


        SamokatPageObject mainPageObject = new SamokatPageObject(driver);


        mainPageObject.clickHeaderOrderButton();

        mainPageObject.fillingNameField("Великий");

        mainPageObject.fillingLastNameField("Солнцеликий");

        mainPageObject.fillingAddressField("Гиперборея, улица Пушкина, дом Колотушкина");

        mainPageObject.fillingMetroField("Белоруcская");

        mainPageObject.fillingPhoneField("8901234567890");

        mainPageObject.nextButtonClicking();

        mainPageObject.fillingDateField("22.04.2024");

        mainPageObject.fillingRentTimeField("четверо суток");

        mainPageObject.totalOrderButtonClicking();

        mainPageObject.orderCreatingCompleteStep();


    }

    @After
    public void shutDown(){
        driver.quit();
    }


}
