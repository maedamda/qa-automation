package com.securitize.qa.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.securitize.qa.pages.LoginPage;

public class LoginTest {

    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://yltrue.com/automation/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("admin", "admin");

        assertTrue(driver.getPageSource().contains("Main page"));

        driver.quit();
    }
}