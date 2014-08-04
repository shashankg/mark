package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.LoginAssertion;
import com.mark.dataprovider.TestData;
import com.mark.resource.component.Header;
import com.mark.resource.page.FacebookLoginPage;
import com.mark.resource.page.ForgotPasswordPopUp;
import com.mark.resource.page.HomePage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_visibility_of_login_flyout_and_its_element() {
        Header header = loadHomepage().getHeader();
        sleep("Login Completion");
        LoginAssertion.assertVisibilityOfLoginFlyoutElements(header);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_visibility_of_login_flyout_and_its_element"})
    public void test_login_from_login_flyout() {
        HomePage homePage = loadHomepage();
        homePage.getHeader().login(TestData.username, TestData.password);
        sleep("Login Completion");
        LoginAssertion.assertSuccessfulLogin(homePage.getHeader());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_logout_from_login_flyout() {
        Header header = loadHomepage().getHeader();
        header.login(TestData.username, TestData.password);
        sleep("Login Completion");
        header.logout();
        LoginAssertion.assertSuccessfulLogout(header);
    }

    @Test(groups = {"smoke"})
    public void test_login_from_standalone_login_page() {
        Header header = loadLoginPage().login(TestData.username, TestData.password).getHeader();
        LoginAssertion.assertSuccessfulLogin(header);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_login_flyout_with_wrong_user_name() {
        Header header = loadHomepage().getHeader();
        header.login("wrong.user@email.com", TestData.password);
        sleep("Login Completion");
        LoginAssertion.assertForUnsuccessfulLogin(header);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_login_flyout_with_wrong_password() {
        HomePage homePage = loadHomepage();
        homePage.getHeader().login("wrong.user@email.com", TestData.password);
        sleep("Login Completion");
        LoginAssertion.assertForUnsuccessfulLogin(homePage.getHeader());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_login_flyout_with_empty_credentials() {
        HomePage homePage = loadHomepage();
        homePage.getHeader().login(" ", " ");
        sleep("Login Completion");
        LoginAssertion.assertForUnsuccessfulLogin(homePage.getHeader());
    }

    @Test(groups = {"smoke"})
    public void test_forgot_password_functionality() {
        HomePage homePage = loadHomepage();
        ForgotPasswordPopUp forgotPasswordPopUp = homePage.getHeader().clickAtForgotPassword();
        forgotPasswordPopUp.forgotPassword(TestData.username);
        LoginAssertion.assertResetPasswordAndMail(forgotPasswordPopUp.getSuccessfulPasswordResetMessage());
    }

    @Test(groups = {"smoke"})
    public void test_resend_password() {
        HomePage homePage = loadHomepage();
        ForgotPasswordPopUp forgotPasswordPopUp = homePage.getHeader().clickAtForgotPassword();
        forgotPasswordPopUp.forgotPassword(TestData.username);
        sleep("Sending the password");
        forgotPasswordPopUp.resendPassword().forgotPassword(TestData.username);
        LoginAssertion.assertResetPasswordAndMail(forgotPasswordPopUp.getSuccessfulPasswordResetMessage());
    }

    @Test(groups = {"smoke"})
    public void test_login_via_facebook() {
        HomePage homePage = loadHomepage();
        FacebookLoginPage facebookLoginPage = homePage.getHeader().clickLoginViaFacebook();
        Header header = facebookLoginPage.login(TestData.FB_EMAIL, TestData.FB_PASS).getHeader();
        LoginAssertion.assertSuccessfulLogin(header);
    }
}
