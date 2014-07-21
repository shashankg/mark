package com.mark.assertion;

import com.mark.constant.Messages;
import com.mark.resource.component.Header;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.SignupPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SignUpAssertion {
    private static final Logger logger = LoggerFactory.getLogger(SignUpAssertion.class);

    public static void verifyVisibilityOfLoginFlyout(Header header) {
        Assert.assertTrue(header.isSignUpLinkInLoginFlyoutVisible(), "Signup link is not visible.");
        logger.info("[Assertion] Signup link is visible in login flyout.");
    }
    
    public static void verifyVisibilityOfSignupParams(SignupPage signupPage) {
        Assert.assertTrue(signupPage.isSignupParamDisplayed(), "Signup params are not visible in flyout.");
        logger.info("[Assertion] Signup params are visible in login flyout.");
    }

    public static void verifyForSuccessfulSignup(AccountPage accountPage) {
        //FIXME: Assert for account details on account page
    }

    public static void verifyErrorWhileSignup(String error) {
        Assert.assertEquals(error, Messages.SIGNUP_ERROR_MESSAGE, "Improper error message displayed.");
        logger.info("[Assertion] Proper error message found.");
    }
}

