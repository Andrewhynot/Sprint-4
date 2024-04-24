package ru.yandex.practicum.selenium1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.PageObjectModel.SamokatPageObject;
import ru.yandex.practicum.WebDriverFactory.WebDriverFactory;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.Constants.Browsers.*;
import static ru.yandex.practicum.Constants.FAQAnswerText.*;
import static ru.yandex.practicum.Constants.FAQIndexes.*;
import static ru.yandex.practicum.Constants.FAQQuestionText.*;

@RunWith(Parameterized.class)
public class FAQBlockAssertionTest {

    private WebDriver driver;
    private final String textQuestion;
    private final String ethalonAnswerText;
    private final String indexAnswer;
    private final boolean expectedResult;

    public FAQBlockAssertionTest(String textQuestion, String ethalonAnswerText, String indexAnswer, boolean expectedResult){
        this.textQuestion = textQuestion;
        this.ethalonAnswerText = ethalonAnswerText;
        this.indexAnswer = indexAnswer;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] parametersFAQ() {
        return new Object[][] {
                { FIRST_QUESTION, FIRST_ANSWER, FIRST_INDEX, true},
                { SECOND_QUESTION, SECOND_ANSWER, SECOND_INDEX, true},
                { THIRD_QUESTION, THIRD_ANSWER, THIRD_INDEX, true},
                { FOURTH_QUESTION, FOURTH_ANSWER, FOURTH_INDEX, true},
                { FIFTH_QUESTION, FIFTH_ANSWER, FIFTH_INDEX, true},
                { SIXTH_QUESTION, SIXTH_ANSWER, SIXTH_INDEX, true},
                { SEVENTH_QUESTION, SEVENTH_ANSWER, SEVENTH_INDEX, true},
                { EIGHTH_QUESTION, EIGHTH_ANSWER, EIGHTH_INDEX, true},
        };
    }

    @Before

    public void starter(){
        driver = WebDriverFactory.getWebDriver(CHROME);  // аргумент CHROME == запуск теста в гугл хром, FIREFOX == запуск теста в гугл хром
        driver.get("https://qa-scooter.praktikum-services.ru");
    }



    @Test
    public void blockFAQAssertionTest(){

        SamokatPageObject mainPageObject = new SamokatPageObject(driver);

        mainPageObject.cookieAccept();
        mainPageObject.scrollUntilFAQ();
        mainPageObject.openTheAnswer(textQuestion, indexAnswer);
        String gottenAnswer = mainPageObject.gotAnswerText(indexAnswer);
        boolean answerCollationResult = ethalonAnswerText.equals(gottenAnswer);

        assertEquals("Ожидалось,что текст ответа с индексом " + indexAnswer + " совпадает с эталоном: " + ethalonAnswerText +"." ,expectedResult, answerCollationResult);

    }

    @After
    public void shutDown(){
        driver.quit();
    }


}
