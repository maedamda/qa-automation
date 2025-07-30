package com.securitize.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    // コンストラクタ
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Do1 / Do2 ボタン
    private By do1Btn = By.id("do1");
    private By do2Btn = By.id("do2");

    public void clickDo1() {
        driver.findElement(do1Btn).click();
    }

    public void clickDo2() {
        driver.findElement(do2Btn).click();
    }

    public boolean isDo1Enabled() {
        return driver.findElement(do1Btn).isEnabled();
    }

    public boolean isDo2Enabled() {
        return driver.findElement(do2Btn).isEnabled();
    }

    // フォントサイズ変更
    private By increaseBtn = By.id("btnIncreaseFont");
    private By decreaseBtn = By.id("btnDecreaseFont");
    private By fontText = By.id("textFontSize");

    public void clickIncrease() {
        driver.findElement(increaseBtn).click();
    }

    public void clickDecrease() {
        driver.findElement(decreaseBtn).click();
    }

    public String getFontSize() {
        return driver.findElement(fontText).getCssValue("font-size");
    }

    // 背景色変更
    private By bgColorInput = By.id("bgColorInput");
    private By bgColorButton = By.id("btnSetBgColor");

    public void setBackgroundColor(String color) {
        WebElement input = driver.findElement(bgColorInput);
        input.clear();
        input.sendKeys(color);
        driver.findElement(bgColorButton).click();
    }

    public String getBackgroundColor() {
        return driver.findElement(By.tagName("body")).getCssValue("background-color");
    }
}
