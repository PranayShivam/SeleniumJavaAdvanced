package com.advancedSelenium.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@SuppressWarnings({"removal", "unchecked", "deprecation", "preview"})
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int MAX_RETRY_COUNT = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        System.out.println("Processing Retry...");
        if (retryCount<MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        } return false;
    }

/*    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }*/
}
