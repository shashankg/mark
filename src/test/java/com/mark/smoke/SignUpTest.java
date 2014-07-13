package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.SignupPage;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(groups = {"smoke"}, description = "Verify SignUp functionality")
    public void test_sign_up_from_header() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SignupPage signupPage = homePage.getHeader().navigateToSignUp();
        signupPage.signUp("firstname", "lastname", System.currentTimeMillis() + "@email.com", "password", "password", "male");
    }

    @Test(groups = {"smoke"}, description = "Verify SignUp functionality")
    public void test_sign_up_from_sign_up_page() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        signupPage.signUp("firstname", "lastname", System.currentTimeMillis() + "@email.com", "password", "password", "male");
    }
}
