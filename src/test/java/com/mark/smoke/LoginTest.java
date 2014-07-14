package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.component.Header;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final String username = "testuser@gmail.com";
    private static final String password = "password";

    @Test(groups = {"smoke"})
    public void test_visibility_of_login_flyout_and_its_element() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Header header = homePage.getHeader();

        Assert.assertTrue(header.isLoginFlyoutVisible());
        Assert.assertTrue(header.isLoginParamsVisibleInLoginFlyout());
        Assert.assertTrue(header.isLoginViaFBVisibleInLoginFlyout());
    }

    @Test(groups = {"smoke"})
    public void test_login_from_login_flyout() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username, password);

        Assert.assertTrue(homePage.getHeader().isLoggedIn());
    }

    @Test(groups = {"smoke"})
    public void test_login_from_standalone_login_page() {
        LoginPage loginPage = new LoginPage(getDriver()).openPage(LoginPage.class, BASE_URL);
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.getHeader().isLoggedIn());
    }

    @Test(groups = {"smoke"})
    public void test_login_flyout_with_wrong_user_name() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login("wrong.user@email.com", password);

        Assert.assertEquals(homePage.getHeader().getLoginErrorMessage(), "Login Error message");
        Assert.assertFalse(homePage.getHeader().isLoggedIn());
    }

    @Test(groups = {"smoke"})
    public void test_login_flyout_with_wrong_password() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login("wrong.user@email.com", password);

        Assert.assertEquals(homePage.getHeader().getLoginErrorMessage(), "Login Error message");
        Assert.assertFalse(homePage.getHeader().isLoggedIn());
    }

    @Test(groups = {"smoke"})
    public void test_login_flyout_with_empty_credentials() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(" ", " ");

        Assert.assertEquals(homePage.getHeader().getLoginErrorMessage(), "Login Error message");
        Assert.assertFalse(homePage.getHeader().isLoggedIn());
    }
}
