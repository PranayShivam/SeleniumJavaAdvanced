package com.advancedSelenium.xpathStore;

import org.openqa.selenium.By;

public interface AmazonXpath {

    By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    By continueShoppingButton = By.xpath("//button[@type='submit']");
    By listOfItemsXpath = By.xpath("//div[@role='listitem']//following::h2[@aria-label]//span");
    By productTitle = By.xpath("//span[@id='productTitle']");
}
