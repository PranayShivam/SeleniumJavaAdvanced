package com.advancedSelenium.components;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private Logger log;


    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver() {

        if (driver != null) {
            log.info("Initializing Driver: {} from BrowserDriverFactory", browser);
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;

                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;

                case "edge":
                    driver.set(new EdgeDriver());
                    break;

                default:
                    driver = null;
                    break;
            }
        } else System.out.println("Driver is already initialized...");

        assert driver != null;
        return driver.get();
    }
}
