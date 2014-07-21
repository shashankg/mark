package com.mark.assertion;

import com.mark.constant.Messages;
import com.mark.resource.component.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginAssertion {
    private static final Logger logger = LoggerFactory.getLogger(LoginAssertion.class);

    public static void assertVisibilityOfLoginFlyoutElements(Header header) {
        Assert.assertTrue(header.isLoginFlyoutVisible(), "Login Flyout is not visible.");
        Assert.assertTrue(header.isLoginParamsVisibleInLoginFlyout(), "Login Parameters are not visible in login flyout.");
        Assert.assertTrue(header.isLoginViaFBVisibleInLoginFlyout(), "Login via Facebook button is not visible in login flyout.");
        logger.info("[Assertion] All the elements in Login flyout are visible.");
    }

    public static void assertSuccessfulLogin(Header header) {
        Assert.assertTrue(header.isLoggedIn(), "User is not logged in.");
        logger.info("[Assertion] Login Successful");
    }

    public static void assertSuccessfulLogout(Header header) {
        Assert.assertFalse(header.isLoggedIn(), "User is not logged out.");
        logger.info("[Assertion] Logout Successful");
    }

    public static void assertForUnsuccessfulLogin(Header header) {
        Assert.assertEquals(header.getLoginErrorMessage(), Messages.LOGIN_ERROR_TEXT);
        header.refresh();
        Assert.assertFalse(header.isLoggedIn(), "User logged in successful, expecting unsuccessful login.");
        logger.info("[Assertion] Unsuccessful Login as expected.");
    }

}
