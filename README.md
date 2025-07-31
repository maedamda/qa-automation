# QA Automation Assignment – Securitize

## Overview
This project contains Selenium-based UI automation tests for the following features on https://yltrue.com/automation/:

1. Toggle buttons (Do1 / Do2)
2. Font size increase / decrease
3. Background color change via input field

## Tech Stack
- Java
- Selenium WebDriver
- JUnit 5
- Maven

## How to Run
1. Install Chrome and compatible ChromeDriver
2. Set correct path in `System.setProperty("webdriver.chrome.driver", "...")` in `MainPageTest.java`
3. Run tests using IDE or:

```bash
mvn test

