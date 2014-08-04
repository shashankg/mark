package com.mark.assertion;

import com.mark.constant.Messages;
import com.mark.dataprovider.TestData;
import com.mark.resource.component.Header;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.SignupPage;
import org.testng.Assert;

public class SignUpAssertion extends BaseAssertion {
    public static void assertVisibilityOfSignupLink(Header header) {
        Assert.assertTrue(header.isSignUpLinkInLoginFlyoutVisible());
    }

    public static void assertVisibilityOfSignupParams(SignupPage signupPage) {
        Assert.assertTrue(signupPage.isSignupParamDisplayed());
    }

    public static void assertAccountPageDetails(AccountPage accountPage) {
        Assert.assertTrue(accountPage.getAccountDetails().contains("MY DETAILS"));
        Assert.assertTrue(accountPage.getAccountDetails().contains(TestData.firstName));
        Assert.assertTrue(accountPage.getAccountDetails().contains(TestData.lastName));
        Assert.assertTrue(accountPage.getAccountDetails().contains("Male"));
    }

    public static void assertErrorForSignup(String error) {
        Assert.assertEquals(error, Messages.GENERAL_ERROR_MESSAGE);
    }
}
