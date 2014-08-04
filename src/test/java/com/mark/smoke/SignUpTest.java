package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.SignUpAssertion;
import com.mark.dataprovider.TestData;
import com.mark.resource.component.Header;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.SignupPage;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_visibility_of_login_flyout_and_its_element() {
        Header header = loadHomepage().getHeader();
        SignUpAssertion.assertVisibilityOfSignupLink(header);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_visibility_of_login_flyout_and_its_element"})
    public void test_sign_up_page_navigation_from_login_flyout() {
        SignupPage signupPage = loadHomepage().getHeader().navigateToSignUp();
        SignUpAssertion.assertVisibilityOfSignupParams(signupPage);
    }

    @Test(groups = {"smoke"})
    public void test_successful_sign_up() {
        SignupPage signupPage = loadSignupPage();
        AccountPage accountPage = signupPage.signUp(TestData.firstName, TestData.lastName, TestData.email,
                TestData.password, TestData.password, TestData.gender);

        SignUpAssertion.assertAccountPageDetails(accountPage);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_successful_sign_up"})
    public void test_sign_up_for_empty_email() {
        SignupPage signupPage = loadSignupPage();
        signupPage.signUp(TestData.firstName, TestData.lastName, "", TestData.password,
                TestData.password, TestData.gender);

        SignUpAssertion.assertErrorForSignup(signupPage.getErrorMessage());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test_successful_sign_up"})
    public void test_sign_up_for_diff_password_and_confirm_password() {
        SignupPage signupPage = loadSignupPage();
        signupPage.signUp(TestData.firstName, TestData.lastName, TestData.email,
                TestData.password, TestData.password + "123", TestData.gender);

        SignUpAssertion.assertErrorForSignup(signupPage.getErrorMessage());
    }
}
