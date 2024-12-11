package com.epam.learn.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStep {
    protected WebDriver driver;

    public void initializeDriver() {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}