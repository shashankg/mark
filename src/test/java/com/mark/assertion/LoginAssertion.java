package com.mark.assertion;

import com.mark.constant.Messages;
import com.mark.resource.component.Header;
import org.testng.Assert;

public class LoginAssertion extends BaseAssertion {

    public static void assertVisibilityOfLoginFlyoutElements(Header header) {
        logger.info("[Assertion] Asserting for visibility of all the elements in Login flyout");
        Assert.assertTrue(header.isLoginFlyoutVisible(), "Login Flyout is not visible.");
        Assert.assertTrue(header.isLoginParamsVisibleInLoginFlyout(), "Login Parameters are not visible in login flyout.");
        Assert.assertTrue(header.isLoginViaFBVisibleInLoginFlyout(), "Login via Facebook button is not visible in login flyout.");
        logger.info("[Assertion] All elements are visible in Login flyout");
    }

    public static void assertSuccessfulLogin(Header header) {
        logger.info("[Assertion] Asserting for Successful Login");
        Assert.assertTrue(header.isLoggedIn());
        logger.info("[Assertion] Login was successful");
    }

    public static void assertSuccessfulLogout(Header header) {
        logger.info("[Assertion] Asserting for Successful Logout");
        Assert.assertFalse(header.isLoggedIn());
        logger.info("[Assertion] Logout was successful");
    }

    public static void assertForUnsuccessfulLogin(Header header) {
        logger.info("[Assertion] Asserting for unsuccessful Login");
        Assert.assertEquals(header.getLoginErrorMessage(), Messages.LOGIN_ERROR_TEXT);
        header.refresh();
        Assert.assertFalse(header.isLoggedIn());
        logger.info("[Assertion] Login was not successful, as expected");
    }

    public  static void assertResetPasswordAndMail(String forgotPasswordMsg) {
        Assert.assertEquals(forgotPasswordMsg, Messages.RESET_PASSWORD_MESSAGE);
    }
}
