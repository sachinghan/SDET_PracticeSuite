package com.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

//Factory pattern
public class DriverFactory {
public WebDriver createDriver(){
    String browser="chrome";
    switch(browser){
        case "chrome":
            return createChromeDriver();
        case "edge":
            return createEdgeDriver();
        default:
            throw new IllegalArgumentException(STR."Browser not supported \{browser}");
    }
}
private WebDriver createChromeDriver(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized","--disable-notifications","--no-sandbox","--remote-allow-origins=*");
    return new ChromeDriver(options);
}
private WebDriver createEdgeDriver(){
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--start-maximized","--disable-notifications","--no-sandbox","--remote-allow-origins=*");
    return new EdgeDriver(options);
}
}
