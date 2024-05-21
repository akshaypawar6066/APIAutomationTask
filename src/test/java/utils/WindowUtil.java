package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtil {
    final static Logger logger = LogManager.getLogger(WindowUtil.class);


    public static void switchToChildWindow(WebDriver driver) {

        String homeWindowAddress = driver.getWindowHandle();
        Set<String> allAddress = driver.getWindowHandles();

        try {
            for (String window : allAddress) {
                if (homeWindowAddress != window) {
                    driver.switchTo().window(window);
                }
            }
        } catch (Exception e) {
            logger.info("Expected Window is Not present:");
        }

    }

    public static void scrollIntoView(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
        logger.info("Scrolled to coordinates " + x + " X " + y);

    }
}
