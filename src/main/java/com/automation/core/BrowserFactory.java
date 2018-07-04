package com.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public WebDriver driver ;

    public WebDriver initDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Development_Avecto\\chromedriver.exe");
        this.driver = new ChromeDriver();
//        driver.get("https://www.google.co.in/");
        return this.driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
