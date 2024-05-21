package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtils {

    final static Logger logger = LogManager.getLogger(BrowserUtils.class);

    public static String getCurrentUrlOfBrowser(WebDriver driver) {
        WaitUtils.waifForPageToBeLoad(driver);
        return driver.getCurrentUrl();
    }

    public static String getAttributeValueOfTheWebElement(WebElement element, String attributeName) {
        String attValue = null;
        try {
            attValue = element.getAttribute(attributeName);
            if (attValue != null) {
                logger.info("Attribute value for '{}': {}", attributeName, attValue);
            } else {
                logger.warn("Attribute '{}' not found or has no value.", attributeName);
            }
        } catch (Exception e) {
            logger.error("An error occurred while getting the attribute value for '{}': {}", attributeName, e.getMessage(), e);
        }
        return attValue;
    }

    public static void selectExpectedOptionFromTheListOfWebElement(WebDriver driver, List<WebElement> elements, String expectedElementText) {
        WaitUtils.waitForTheAllElementsToBeVisible(driver, elements, expectedElementText);
        for (WebElement ele : elements) {
            if (ele.getText().trim().equals(expectedElementText)) {
                ele.click();
                break;
            }
        }

    }
}
