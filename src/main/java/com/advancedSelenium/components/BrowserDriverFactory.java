package com.advancedSelenium.components;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserDriverFactory {

    private final String browser;
//    private Logger log;


    public BrowserDriverFactory(String browser/*, Logger log*/) {
        this.browser = browser.toLowerCase();
//        this.log = log;
    }

    public WebDriver createDriver() {

        System.out.println("Initializing Driver: " + browser + " from BrowserDriverFactory");
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "safari" -> new SafariDriver();
            default -> throw new RuntimeException("Invalid Browser: " + browser);
        };
    }
}
