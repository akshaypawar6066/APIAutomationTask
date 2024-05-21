package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaitUtils {

    final static Logger logger = LogManager.getLogger(WaitUtils.class);

    static WebDriverWait wait;

    public static void waifForPageToBeLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
    }

    public static boolean waitForTheElementToBeVisible(WebDriver driver, WebElement element, String WebElementName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement result = wait.until(ExpectedConditions.visibilityOf(element));
        if (result != null) {
            logger.info("WebElement is Visible:" + WebElementName);
            return true;
        } else {
            logger.info("WebElement is not visible:" + WebElementName);
            return false;
        }
    }

    public static boolean waitForTheAllElementsToBeVisible(WebDriver driver, List<WebElement> elements, String WebElementName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        if (results != null) {
            logger.info("WebElement is Visible:" + WebElementName);
            return true;
        } else {
            logger.info("WebElement is not visible:" + WebElementName);
            return false;
        }
    }

    public static void waitForTheElementToBeClickable(WebDriver driver, WebElement element, String WebElementName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement result = wait.until(ExpectedConditions.elementToBeClickable(element));
        if (result != null) {
            logger.info("WebElement is Visible:" + WebElementName);
        } else {
            logger.info("WebElement is not visible:" + WebElementName);
        }
    }

    public static void waitForTheFixedTime(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }
}
