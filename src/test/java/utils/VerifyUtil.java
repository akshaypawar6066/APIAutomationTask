package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class VerifyUtil {
    final static Logger logger = LogManager.getLogger(VerifyUtil.class);

    public static void checkTwoTextsAreEqualOrNot(String firstText, String secondText) {
        if (firstText.equals(secondText)) {
            logger.info(firstText + " is Equal to " + secondText);
            Assert.assertTrue(true);
        } else {
            logger.info(firstText + " is not equal to " + secondText);
            Assert.assertFalse(true);
        }
    }

    public static void checkTwoTextsContainsOrNot(String firstText, String secondText) {
        if (firstText.contains(secondText)) {
            logger.info(firstText + " is Containing  into " + secondText);
            Assert.assertTrue(true);
        } else {
            logger.info(firstText + " is not Containing into " + secondText);
            Assert.assertFalse(true);
        }
    }

    public static void assertThat(boolean status, String passMessage, String failMessage) {
        if (status) {
            Assert.assertTrue(true, passMessage);
        } else {
            Assert.fail(failMessage);
        }
    }


}
