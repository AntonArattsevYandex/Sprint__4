package org.unique.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.unique.scooterTest.TestData.*;

public class FAQValidationTest {

    private WebDriver driver;

    @Test
    public void FAQCorrectAnswerText() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        MainPageScooter objMainPage = new MainPageScooter(driver);

        objMainPage.expandFirstQuestion();
        objMainPage.isCorrectText(objMainPage.getFirstAnswerText(), firstAnswerText);

        objMainPage.expandSecondQuestion();
        objMainPage.isCorrectText(objMainPage.getSecondAnswerText(), secondAnswerText);

        objMainPage.expandThirdQuestion();
        objMainPage.isCorrectText(objMainPage.getThirdAnswerText(), thirdAnswerText);

        objMainPage.expandFourthQuestion();
        objMainPage.isCorrectText(objMainPage.getFourthAnswerText(), fourthAnswerText);

        objMainPage.expandFifthQuestion();
        objMainPage.isCorrectText(objMainPage.getFifthAnswerText(), fifthAnswerText);

        objMainPage.expandSixthQuestion();
        objMainPage.isCorrectText(objMainPage.getSixthAnswerText(), sixthAnswerText);

        objMainPage.expandSeventhQuestion();
        objMainPage.isCorrectText(objMainPage.getSeventhAnswerText(), seventhAnswerText);

        objMainPage.expandEighthQuestion();
        objMainPage.isCorrectText(objMainPage.getEighthAnswerText(), eighthAnswerText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

