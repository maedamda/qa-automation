package com.securitize.qa.tests;

import com.securitize.qa.pages.LoginPage;
import com.securitize.qa.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.LinkedHashMap;
import java.util.Map;

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
        // 目視確認のため5秒待機
        Thread.sleep(8000);
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testDo1DisablesDo2() {
        mainPage.clickDo1();
        assertFalse(mainPage.isDo1Disabled());
        assertTrue(mainPage.isDo2Disabled());
    }

    @Test
    public void testDo2DisablesDo1() {
        mainPage.clickDo2();
        assertFalse(mainPage.isDo2Disabled());
        assertTrue(mainPage.isDo1Disabled());
    }

    @Test
    public void testFontSizeIncreaseAndDecrease() throws Exception {
        float originalSize = Float.parseFloat(mainPage.getFontSize().replace("px", ""));

        // Increase ボタンを3回クリック（各クリック後500ms待機）
        mainPage.clickIncrease();
        Thread.sleep(800);
        mainPage.clickIncrease();
        Thread.sleep(800);
        mainPage.clickIncrease();
        Thread.sleep(800);

        float increasedSize = Float.parseFloat(mainPage.getFontSize().replace("px", ""));
        assertTrue(increasedSize > originalSize, "Font size should increase after 3 clicks");

        // Decrease ボタンを3回クリック（各クリック後500ms待機）
        mainPage.clickDecrease();
        Thread.sleep(800);
        mainPage.clickDecrease();
        Thread.sleep(800);
        mainPage.clickDecrease();
        Thread.sleep(800);

        float decreasedSize = Float.parseFloat(mainPage.getFontSize().replace("px", ""));
        assertEquals(originalSize, decreasedSize, 0.5, "Font size should return to original after 2 decreases");
    }

    @Test
    public void testChangeBackgroundColorsSequentially() throws Exception {
        // テストする色と、期待されるキーワードまたは16進数表現
        Map<String, String> colorExpectations = new LinkedHashMap<>();
        colorExpectations.put("red", "rgb(255, 0, 0)");
        colorExpectations.put("green", "rgb(0, 128, 0)");
        colorExpectations.put("blue", "rgb(0, 0, 255)");

        for (Map.Entry<String, String> entry : colorExpectations.entrySet()) {
            String inputColor = entry.getKey();
            String expectedRgb = entry.getValue();

            mainPage.setBackgroundColor(inputColor);

            // 現在の背景色を取得
            String actualColor = mainPage.getBackgroundColor();
            System.out.println("Set: " + inputColor + " → Actual: " + actualColor);

            // テキストキーワードまたはRGB形式の含有を確認（環境によりフォーマットが変わる可能性もあるため柔軟に）
            assertTrue(
                actualColor.contains(expectedRgb) || actualColor.contains(inputColor),
                "Expected color not applied for: " + inputColor
            );
        }
    }
}