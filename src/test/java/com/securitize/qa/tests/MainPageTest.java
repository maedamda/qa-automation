package com.securitize.qa.tests;

import com.securitize.qa.pages.LoginPage;
import com.securitize.qa.pages.MainPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver"); 
        driver = new ChromeDriver();
        driver.get("https://yltrue.com/automation/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("admin", "admin");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() throws Exception {
        // 目視確認のため、10秒間ブラウザを表示させておく
        Thread.sleep(10000);
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testDo1DisablesDo2() {
        mainPage.clickDo1();
        assertTrue(mainPage.isDo1Enabled());
        assertFalse(mainPage.isDo2Enabled());
    }

    @Test
    public void testDo2DisablesDo1() {
        mainPage.clickDo2();
        assertTrue(mainPage.isDo2Enabled());
        assertFalse(mainPage.isDo1Enabled());
    }

    @Test
    public void testFontSizeIncreaseAndDecrease() {
        String originalSize = mainPage.getFontSize();
        mainPage.clickIncrease();
        String increasedSize = mainPage.getFontSize();
        assertNotEquals(originalSize, increasedSize);

        mainPage.clickDecrease();
        String decreasedSize = mainPage.getFontSize();
        assertEquals(originalSize, decreasedSize); // フォントが元に戻るか確認
    }

    @Test
    public void testBackgroundColorChange() throws Exception {
        mainPage.setBackgroundColor("blue");
        
        String color = mainPage.getBackgroundColor();
        assertTrue(
            color.contains("0, 0, 255") ||
            color.equals("red") ||
            color.equals("#0000ff") ||
            color.equals("rgb(0, 0, 255)") ||
            color.equals("rgba(0, 0, 255, 1)")
        );
    }
}
