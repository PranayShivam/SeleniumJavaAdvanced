package com.advancedSelenium.AmazonPractice;


import com.advancedSelenium.utilities.BaseTest;
import com.advancedSelenium.xpathStore.AmazonXpath;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Requirement:
 * open browser
 * Open Amazon WebSite
 * Search for "MacBook with Intel Chip"
 * get all the options listed print it
 * click on the 2nd item
 * close browser
 */
public class Test_1 extends BaseTest {

    String searchField = "MacBook with Intel Chip";
    int productNo = 2;

    @BeforeMethod
    public void beforeTest() {
        extentTest = extentReports.createTest("Test 1");
        extentTest.info("Starting Test 1");
    }

    @Test(invocationCount = 20, threadPoolSize = 20/*, retryAnalyzer = com.advancedSelenium.Listeners.RetryAnalyzer.class*/)
    public void test_1() throws IOException {
        WebDriver driver = getDriver();
//        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50), Duration.ofSeconds(2));
        Actions cursorActions = new Actions(driver);

        if (!driver.findElements(AmazonXpath.continueShoppingButton).isEmpty()) {
            driver.findElement(AmazonXpath.continueShoppingButton).click();
        }

        wait.until(ExpectedConditions.titleContains("Amazon"));

        String title = driver.getTitle();
        Assert.assertTrue(Objects.requireNonNull(title).toLowerCase().contains("amazon.com"),
                "Title Validation Failed, Title:  " + title);

        WebElement searchBar = driver.findElement(AmazonXpath.searchBox);
        cursorActions.moveToElement(searchBar).click().sendKeys(searchField);
        performCursorAction(cursorActions);

        cursorActions.sendKeys(Keys.ENTER);
        performCursorAction(cursorActions);

        List<WebElement> listOfItemsElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AmazonXpath.listOfItemsXpath));
        List<String> listOfItems = listOfItemsElement.stream()
                .map(WebElement::getText)
                .toList();

        for (int i = 1; i < listOfItems.size(); i++) {
            System.out.println(i + ": " + listOfItems.get(i));
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(getScreenShotLocation() + "ScreenShot" + dateFormat.format(date) + ".png"));

        listOfItemsElement.get(productNo).click();
        String validationString_1 = listOfItems.get(productNo);
        String validationString_2 = driver.findElement(AmazonXpath.productTitle).getText();
        Assert.assertEquals(validationString_1, validationString_2, "Product Description mis-match");
        extentTest.log(Status.PASS, "Product Description Matched: \n" +
                "Validation String 1: " + validationString_1 + "\n" +
                "Validation String 2: " + validationString_2);

    }

    private void performCursorAction(Actions action) {
        action.perform();
    }

}
