package com.automation.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
public static void initializeDriver(){
    if(drivers.get()==null){
        WebDriver driver = new DriverFactory().createDriver();
        drivers.set(driver);
    }
}

public static WebDriver getDriver(){
    return drivers.get();
}

public static void quitDriver(){
    WebDriver driver = drivers.get();
    if(driver!=null){
        driver.quit();
        drivers.remove();
    }
}
}