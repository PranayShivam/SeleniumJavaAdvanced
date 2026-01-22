package com.advancedSelenium.utilities;

import com.advancedSelenium.components.BrowserDriverFactory;
import com.advancedSelenium.components.FrameWorkComponents;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseTest extends FrameWorkComponents {

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    static Response Response;
    protected WebDriver driver;
    protected Logger log;

    @BeforeSuite(alwaysRun = true)
    public void setExtentReports() {
        if (extentReports == null) {
            extentReports = createInstance();
        }
    }

    private ExtentReports createInstance() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm");
        String ReportFileLocation = getReportFolderLocation()+ "Selenium_Test" + dateFormat.format(date) + ".html";
        extentSparkReporter = new ExtentSparkReporter(ReportFileLocation);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }

    @AfterSuite(alwaysRun = true)
    public void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    @AfterMethod
    public void getExtentTest() {

        if (extentTest == null) {
            extentTest = extentReports.createTest("Auto Generated Test Report");
            extentTest.log(Status.WARNING, "Test Information not available as ExtentReports was" +
                    " not initialized from Test Execution Class");
        }
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(@Optional("chrome") String browser, ITestContext context) {
        String testName = context.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();     // closes ALL windows of this driver
        }
    }


}
