package com.advancedSelenium.AmazonPractice;

import com.advancedSelenium.utilities.BaseTest;
import org.testng.annotations.Test;

/**
 * Requirement:
 * Open Url Amazon.in
 * Search for m2 2242 ssd
 * Print the list of all suggested items
 * Click on the one having 256gb
 *
 */
public class Test_2 extends BaseTest {

    @Test(retryAnalyzer = com.advancedSelenium.Listeners.RetryAnalyzer.class)
    public void test_2() {

    }
}
