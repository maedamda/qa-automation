package com.securitize.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // ロケーター定義
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.tagName("button");

    // コンストラクタ
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // メソッド定義
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // ログインを1つの操作で
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}