package org.unique.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

import static org.unique.scooterTest.TestData.*;

@RunWith(Parameterized.class) // Подключаем параметризацию
public class FAQValidationTest {

    private WebDriver driver;
    private final By questionLocator; // Локатор вопроса
    private final By answerLocator;   // Локатор ответа
    private final String expectedAnswer; // Ожидаемый текст ответа

    // Конструктор для параметризации
    public FAQValidationTest(By questionLocator, By answerLocator, String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }

    // Метод для предоставления тестовых данных
    @Parameterized.Parameters
    public static Collection<Object[]> getFAQData() {
        return Arrays.asList(new Object[][]{
                {By.xpath(".//div[@class='accordion__item'][1]"), By.id("accordion__panel-0"), firstAnswerText},
                {By.xpath(".//div[@class='accordion__item'][2]"), By.id("accordion__panel-1"), secondAnswerText},
                {By.xpath(".//div[@class='accordion__item'][3]"), By.id("accordion__panel-2"), thirdAnswerText},
                {By.xpath(".//div[@class='accordion__item'][4]"), By.id("accordion__panel-3"), fourthAnswerText},
                {By.xpath(".//div[@class='accordion__item'][5]"), By.id("accordion__panel-4"), fifthAnswerText},
                {By.xpath(".//div[@class='accordion__item'][6]"), By.id("accordion__panel-5"), sixthAnswerText},
                {By.xpath(".//div[@class='accordion__item'][7]"), By.id("accordion__panel-6"), seventhAnswerText},
                {By.xpath(".//div[@class='accordion__item'][8]"), By.id("accordion__panel-7"), eighthAnswerText},
        });
    }

    @Test
    public void FAQCorrectAnswerText() {
        // Инициализация драйвера
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Ожидание загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, 10); // Ожидание до 10 секунд

        // Прокручиваем страницу до блока с вопросами
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);

        // Раскрываем вопрос
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(questionLocator));
        question.click();

        // Ожидаем появления ответа
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));

        // Получаем текст ответа
        String actualAnswer = answer.getText();

        // Проверяем, что текст ответа соответствует ожидаемому
        MainPageScooter objMainPage = new MainPageScooter(driver);
        objMainPage.isCorrectText(actualAnswer, expectedAnswer);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}