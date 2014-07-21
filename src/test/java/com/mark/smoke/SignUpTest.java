package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.SignUpAssertion;
import com.mark.resource.component.Header;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.SignupPage;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private static final String firstName = "FirstName";
    private static final String lastName = "LastName";
    private static final String email = System.currentTimeMillis() + "@email.com";
    private static final String password = "password";
    private static final String gender = "male";

    @Test(groups = {"smoke"})
    public void test_visibility_of_login_flyout_and_its_element() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Header header = homePage.getHeader();
        SignUpAssertion.verifyVisibilityOfLoginFlyout(header);
    }


    @Test(groups = {"smoke"}, dependsOnMethods = {"test_visibility_of_login_flyout_and_its_element"})
    public void test_sign_up_page_navigation_from_login_flyout() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SignupPage signupPage = homePage.getHeader().navigateToSignUp();
        SignUpAssertion.verifyVisibilityOfSignupParams(signupPage);
    }


    @Test(groups = {"smoke"})
    public void test_successful_sign_up() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        AccountPage accountPage = signupPage.signUp(firstName, lastName, email, password, password, gender);
        SignUpAssertion.verifyForSuccessfulSignup(accountPage);
    }


    @Test(groups = {"smoke"}, dependsOnMethods = {"test_successful_sign_up"})
    public void test_sign_up_for_empty_email() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        signupPage.signUp(firstName, lastName, "", password, password, gender);
        String error = signupPage.getErrorMessage();
        SignUpAssertion.verifyErrorWhileSignup(error);
    }


    @Test(groups = {"smoke"}, dependsOnMethods = {"test_successful_sign_up"})
    public void test_sign_up_for_diff_password_and_confirm_password() {
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        signupPage.signUp(firstName, lastName, email, password, password + "123", gender);
        String error = signupPage.getErrorMessage();
        SignUpAssertion.verifyErrorWhileSignup(error);
    }
}
