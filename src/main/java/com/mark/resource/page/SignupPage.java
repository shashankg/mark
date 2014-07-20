package com.mark.resource.page;

import com.mark.resource.BasePage;
import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.mark.resource.component.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends BasePage<SignupPage> {
    private static final String FIRST_NAME_ID = "firstName";
    private static final String LAST_NAME_ID = "lastName";
    private static final String EMAIL_ID = "email";
    private static final String FAKE_PASSWORD_ID = "fakepassword";
    private static final String PASSWORD_ID = "password";
    private static final String FAKE_CONFIRM_PASSWORD_ID = "fakeconfirmPassword";
    private static final String CONFIRM_PASSWORD_ID = "confirmPassword";
    private static final String GENDER_ID = "gender";
    private static final String SIGN_UP_XPATH = ".//*[@id='registerForm']/fieldset/div[8]/input";
    private static final String ERROR_MESSAGE_XPATH = ".//*[@id='registerForm']/div/span";

    private Header header;
    private Footer footer;
    private SearchBar searchBar;

    public SignupPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.searchBar = new SearchBar(driver);
    }

    @Override
    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/register";
    }

    public Header getHeader() {
        return this.header;
    }

    public Footer getFooter() {
        return this.footer;
    }

    public SearchBar getSearchBar() {
        return this.searchBar;
    }

    /**
     * Login functionality
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param confirmPassword
     * @param gender
     * @return AccountPage
     */
    public AccountPage signUp(String firstName, String lastName, String email, String password, String confirmPassword, String gender) {
        logger.info("[SignUp] Sign up with params FN: {}, LN: {}, Email: {}, Password: {}, " +
                "ConfirmPassword: {}, Gender: {}", firstName, lastName, email, password, confirmPassword, gender);
        getWebElement(By.id(FIRST_NAME_ID)).sendKeys(firstName);
        getWebElement(By.id(LAST_NAME_ID)).sendKeys(lastName);
        getWebElement(By.id(EMAIL_ID)).sendKeys(email);
        getWebElement(By.id(FAKE_PASSWORD_ID)).clear();
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.id(FAKE_CONFIRM_PASSWORD_ID)).clear();
        getWebElement(By.id(CONFIRM_PASSWORD_ID)).sendKeys(confirmPassword);
        selectFromDropDown(By.id(GENDER_ID), gender);
        getWebElement(By.xpath(SIGN_UP_XPATH)).submit();
        return new AccountPage(getDriver()).getPage(AccountPage.class);
    }

    /**
     * Is sign up parameters present
     *
     * @return
     */
    public boolean isSignupParamDisplayed() {
        return isElementPresentAndDisplay(By.id(FIRST_NAME_ID)) &&
                isElementPresentAndDisplay(By.id(LAST_NAME_ID)) &&
                isElementPresentAndDisplay(By.id(EMAIL_ID)) &&
                isElementPresentAndDisplay(By.id(FAKE_PASSWORD_ID)) &&
                isElementPresent(By.id(PASSWORD_ID)) &&
                isElementPresentAndDisplay(By.id(FAKE_CONFIRM_PASSWORD_ID))&&
                isElementPresent(By.id(CONFIRM_PASSWORD_ID)) &&
                isElementPresentAndDisplay(By.id(GENDER_ID)) &&
                isElementPresentAndDisplay(By.xpath(SIGN_UP_XPATH));
    }

    /**
     * Return error message is any while sign up
     *
     * @return
     */
    public String getErrorMessage() {
        return getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText();
    }
}
