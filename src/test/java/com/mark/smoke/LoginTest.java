package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"}, description = "Verify login functionality with valid credentials")
    public void test_login_from_header() throws Exception {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login("xyz", "abcdefg");
    }

    @Test(groups = {"smoke"}, description = "Verify login functionality with valid credentials")
    public void test_login_from_login_page() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver()).openPage(LoginPage.class, BASE_URL);
        loginPage.login("xyz", "abcdefg");
    }
}
