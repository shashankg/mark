package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final String username = "";
    private static final String password = "";

    @Test(groups = {"smoke"}, description = "Verify login functionality with valid credentials")
    public void test_login_with_valid_credentials() throws Exception {
        LoginPage login = new LoginPage(getDriver()).openPage(LoginPage.class);
        login.login(username, password);
        String message = login.getMessage();
        Assert.assertEquals(message, "Login was successful");
    }

    @Test(groups = {"smoke"}, description = "Verify login functionality with invalid credentials")
    public void test_login_with_invalid_credentials() throws Exception {
        LoginPage login = new LoginPage(getDriver()).openPage(LoginPage.class);
        login.login(username + "123", password);
        String message = login.getMessage();
        Assert.assertEquals(message, "Username/password is wrong");
    }


}
