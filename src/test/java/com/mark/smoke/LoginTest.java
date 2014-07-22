package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.LoginAssertion;
import com.mark.dataprovider.MarkTestData;
import com.mark.resource.component.ForgotPasswordPopUp;
import com.mark.resource.component.Header;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.LoginPage;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_visibility_of_login_flyout_and_its_element() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Header header = homePage.getHeader();
        sleep("Login Completion");

        LoginAssertion.assertVisibilityOfLoginFlyoutElements(header);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_visibility_of_login_flyout_and_its_element"})
    public void test_login_from_login_flyout() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(MarkTestData.username, MarkTestData.password);
        sleep("Login Completion");

        LoginAssertion.assertSuccessfulLogin(homePage.getHeader());
    }


    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_logout_from_login_flyout() {
        Header header = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL).getHeader();
        header.login(MarkTestData.username, MarkTestData.password);
        sleep("Login Completion");
        header.logout();

        LoginAssertion.assertSuccessfulLogout(header);
    }


    @Test(groups = {"smoke"})
    public void test_login_from_standalone_login_page() {
        LoginPage loginPage = new LoginPage(getDriver()).openPage(LoginPage.class, BASE_URL);
        Header header = loginPage.login(MarkTestData.username, MarkTestData.password).getHeader();

        LoginAssertion.assertSuccessfulLogin(header);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_login_flyout_with_wrong_user_name() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login("wrong.user@email.com", MarkTestData.password);
        sleep("Login Completion");

        LoginAssertion.assertForUnsuccessfulLogin(homePage.getHeader());
    }


    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_login_flyout_with_wrong_password() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login("wrong.user@email.com", MarkTestData.password);
        sleep("Login Completion");

        LoginAssertion.assertForUnsuccessfulLogin(homePage.getHeader());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_login_from_login_flyout"})
    public void test_login_flyout_with_empty_credentials() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(" ", " ");
        sleep("Login Completion");

        LoginAssertion.assertForUnsuccessfulLogin(homePage.getHeader());
    }

    @Test(groups = {"smoke"})
    public void test_password_reset_functinality()
    {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class,BASE_URL);
        //assert
        homePage.getHeader().clickAtForgotPassword().forgotPassword("test1234@test.com");
        //assert
    }

    @Test(groups = {"smoke"})
    public void test_cancel_password_reset()
    {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class,BASE_URL);
        //assert
        homePage.getHeader().clickAtForgotPassword().closePopUp();
     }

    @Test(groups = {"smoke"})
    public void test_resend_password()
    {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class,BASE_URL);
        //assert
        homePage.getHeader().clickAtForgotPassword().resendPassword();
        //assert
    }

    @Test(groups = {"smoke"})
    public void test_remember_me_functionality()
    {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class,BASE_URL);

        //assert
    }

}
