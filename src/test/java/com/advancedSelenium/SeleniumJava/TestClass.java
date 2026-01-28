package com.advancedSelenium.SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestClass implements Comparable<Integer> {

    @Test
    public void demoClass() {
        String str = System.getProperty("user.dir") + "\\Reports";
        System.out.println(str);
        WebDriver driver = new FirefoxDriver();

    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
