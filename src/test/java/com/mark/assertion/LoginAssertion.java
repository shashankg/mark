package com.mark.assertion;

import com.mark.constant.Messages;
import com.mark.resource.component.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginAssertion {
    private static final Logger logger = LoggerFactory.getLogger(LoginAssertion.class);

    public static void assertVisibilityOfLoginFlyoutElements(Header header) {
        logger.info("[Assertion] Asserting for visibility of all the elements in Login flyout");
        Assert.assertTrue(header.isLoginFlyoutVisible(), "Login Flyout is not visible.");
        Assert.assertTrue(header.isLoginParamsVisibleInLoginFlyout(), "Login Parameters are not visible in login flyout.");
        Assert.assertTrue(header.isLoginViaFBVisibleInLoginFlyout(), "Login via Facebook button is not visible in login flyout.");
    }

    public static void assertSuccessfulLogin(Header header) {
        logger.info("[Assertion] Asserting for Successful Login");
        Assert.assertTrue(header.isLoggedIn());
    }

    public static void assertSuccessfulLogout(Header header) {
        logger.info("[Assertion] Asserting for Successful Logout");
        Assert.assertFalse(header.isLoggedIn());
    }

    public static void assertForUnsuccessfulLogin(Header header) {
        logger.info("[Assertion] Asserting for unsuccessful Login");
        Assert.assertEquals(header.getLoginErrorMessage(), Messages.LOGIN_ERROR_TEXT);
        header.refresh();
        Assert.assertFalse(header.isLoggedIn());
    }

}
