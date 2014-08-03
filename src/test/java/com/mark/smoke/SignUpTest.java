package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.constant.Messages;
import com.mark.dataprovider.TestData;
import com.mark.resource.component.Header;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_visibility_of_login_flyout_and_its_element() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Header header = homePage.getHeader();

        Assert.assertTrue(header.isSignUpLinkInLoginFlyoutVisible());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_visibility_of_login_flyout_and_its_element"})
    public void test_sign_up_page_navigation_from_login_flyout() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SignupPage signupPage = homePage.getHeader().navigateToSignUp();

        Assert.assertTrue(signupPage.isSignupParamDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_successful_sign_up() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        AccountPage accountPage = signupPage.signUp(TestData.firstName, TestData.lastName, TestData.email,
                TestData.password, TestData.password, TestData.gender);

        Assert.assertTrue(accountPage.getAccountDetails().contains("MY DETAILS"));
        Assert.assertTrue(accountPage.getAccountDetails().contains(TestData.firstName));
        Assert.assertTrue(accountPage.getAccountDetails().contains(TestData.lastName));
        Assert.assertTrue(accountPage.getAccountDetails().contains("Male"));
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_successful_sign_up"})
    public void test_sign_up_for_empty_email() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        signupPage.signUp(TestData.firstName, TestData.lastName, "", TestData.password,
                TestData.password, TestData.gender);
        String error = signupPage.getErrorMessage();

        Assert.assertEquals(error, Messages.SIGNUP_ERROR_MESSAGE);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_successful_sign_up"})
    public void test_sign_up_for_diff_password_and_confirm_password() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        signupPage.signUp(TestData.firstName, TestData.lastName, TestData.email,
                TestData.password, TestData.password + "123", TestData.gender);
        String error = signupPage.getErrorMessage();

        Assert.assertEquals(error, Messages.SIGNUP_ERROR_MESSAGE);
    }
}
