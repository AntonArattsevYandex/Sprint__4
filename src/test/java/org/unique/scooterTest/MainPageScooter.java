package org.unique.scooterTest;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

public class MainPageScooter {

    private WebDriver driver;

    // Локаторы для вопросов
    private By firstQuestion = By.xpath(".//div[@class='accordion__item'][1]");
    private By secondQuestion = By.xpath(".//div[@class='accordion__item'][2]");
    private By thirdQuestion = By.xpath(".//div[@class='accordion__item'][3]");
    private By fourthQuestion = By.xpath(".//div[@class='accordion__item'][4]");
    private By fifthQuestion = By.xpath(".//div[@class='accordion__item'][5]");
    private By sixthQuestion = By.xpath(".//div[@class='accordion__item'][6]");
    private By seventhQuestion = By.xpath(".//div[@class='accordion__item'][7]");
    private By eighthQuestion = By.xpath(".//div[@class='accordion__item'][8]");

    // Локаторы для ответов
    private By firstAnswer = By.id("accordion__panel-0");
    private By secondAnswer = By.id("accordion__panel-1");
    private By thirdAnswer = By.id("accordion__panel-2");
    private By fourthAnswer = By.id("accordion__panel-3");
    private By fifthAnswer = By.id("accordion__panel-4");
    private By sixthAnswer = By.id("accordion__panel-5");
    private By seventhAnswer = By.id("accordion__panel-6");
    private By eighthAnswer = By.id("accordion__panel-7");

    // Локаторы для кнопок "Заказать"
    private By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    private By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public MainPageScooter(WebDriver driver){
        this.driver = driver;
    }

    // Методы для раскрытия вопросов
    public void expandFirstQuestion() {
        driver.findElement(firstQuestion).click();
    }
    public void expandSecondQuestion() {
        driver.findElement(secondQuestion).click();
    }
    public void expandThirdQuestion() {
        driver.findElement(thirdQuestion).click();
    }
    public void expandFourthQuestion() {
        driver.findElement(fourthQuestion).click();
    }
    public void expandFifthQuestion() {
        driver.findElement(fifthQuestion).click();
    }
    public void expandSixthQuestion() {
        driver.findElement(sixthQuestion).click();
    }
    public void expandSeventhQuestion() {
        driver.findElement(seventhQuestion).click();
    }
    public void expandEighthQuestion() {
        driver.findElement(eighthQuestion).click();
    }

    // Метод для сравнения ответа на вопрос с правильным текстом
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }

    // Геттеры для получения текста ответов
    public String getFirstAnswerText() {
        return driver.findElement(firstAnswer).getText();
    }
    public String getSecondAnswerText() {
        return driver.findElement(secondAnswer).getText();
    }
    public String getThirdAnswerText() {
        return driver.findElement(thirdAnswer).getText();
    }
    public String getFourthAnswerText() {
        return driver.findElement(fourthAnswer).getText();
    }
    public String getFifthAnswerText() {
        return driver.findElement(fifthAnswer).getText();
    }
    public String getSixthAnswerText() {
        return driver.findElement(sixthAnswer).getText();
    }
    public String getSeventhAnswerText() {
        return driver.findElement(seventhAnswer).getText();
    }
    public String getEighthAnswerText() {
        return driver.findElement(eighthAnswer).getText();
    }

    // Методы для клика по кнопкам "Заказать"
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickPageOrderButton() {
        // Проскролить до появления кнопки
        WebElement bigButton = driver.findElement(pageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(pageOrderButton).click();
    }
}