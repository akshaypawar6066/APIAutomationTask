package base;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;

import utils.ConfigReader;

public class BaseClass {

    private WebDriver driver = null;
    public ExtentReports extentReports;

    @BeforeSuite
    public void initializeExtentReport() {
        ExtentSparkReporter extentSparkReporter_all = new ExtentSparkReporter("AllTests.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter_all);

        extentSparkReporter_all.config().setProtocol(Protocol.HTTPS);
        extentSparkReporter_all.config().setEncoding("UTF-8");
        extentSparkReporter_all.config().setDocumentTitle("ExtentReport-UIAutomationTask");
        extentSparkReporter_all.config().setTheme(Theme.STANDARD);
        extentSparkReporter_all.config().setReportName("ExtentReport-UIAutomationTask");

        extentReports.setSystemInfo("Java Version", System.getProperty("Java.version"));
        extentReports.setSystemInfo("Java Version", System.getProperty("Java.version"));


    }


    @BeforeMethod()
    public void launchBrowser() throws IOException {

        String BrowserName = ConfigReader.readPropData("BrowserName");
        if (BrowserName.equalsIgnoreCase("Chrome")) {
            // Set up ChromeOptions
            ChromeOptions options = new ChromeOptions();

            // Add configurations
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
            driver.get("https://openweathermap.org/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (BrowserName.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();

            // Add options here
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-notifications");

            driver = new EdgeDriver(options);
            driver.get("https://openweathermap.org/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }


}
