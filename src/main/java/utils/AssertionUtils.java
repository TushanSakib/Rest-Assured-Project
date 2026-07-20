package utils;

import org.testng.Assert;

public class AssertionUtils {

    private AssertionUtils() {}

    public static void verifyStatusCode(
            int actual,
            int expected) {

        Assert.assertEquals(
                actual,
                expected,
                "Status Code Mismatch"
        );
    }

    public static void verifyNotNull(
            Object object) {

        Assert.assertNotNull(
                object,
                "Object should not be null"
        );
    }
}