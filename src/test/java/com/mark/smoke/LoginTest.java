package com.mark.smoke;

import com.mark.BaseTest;

import com.mark.page.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"}, description = "Verify login functionality with valid credentials")

    public void test_login_from_header() throws Exception {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login("xyz", "abcdefg");
    }


}
