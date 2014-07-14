package com.mark.resource.component;

import com.mark.exception.MarkException;
import com.mark.resource.BasePage;
import com.mark.resource.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage<Header> {

    private static final String LOGIN_FLYOUT_XPATH = ".//*[@id='header']/div[1]/div/div/ul/li[1]/a[2]";
    private static final String SIGN_UP_LINK_XPATH = "//*[@id='header']/div[1]/div/div/ul/li[1]/div/div[2]/a";
    private static final String USERNAME_ID = "j_username";
    private static final String FAKE_PASSWORD_ID = "fakej_password";
    private static final String PASSWORD_ID = "j_password";
    private static final String LOGIN_BUTTON_ID = "login";

    private static final String MY_ACCOUNT_ID = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[1]";
    private static final String ORDER_HISTORY_ID = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[2]";
    private static final String SHUKRAN_ID = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[3]/a";
    private static final String LOGOUT_LINK = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[4]/a";

    private static final String FORGOT_PASSWORD_LINK_ID = "";
    private static final String LOGIN_VIA_FACEBOOK_ID = "";

    private static final String BASKET_ID = "";
    private static final String VIEW_BASKET_ID = "";
    private static final String BASKET_REMOVE_ITEM_ID = "";
    private static final String BASKET_CHECKOUT_IT = "";
    private static final String LOGIN_ERROR_MESSAGE_ID = "";

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.xpath(LOGIN_FLYOUT_XPATH)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void login(String username, String password) {
        clickAtLogin();
        logger.info("[Header Login] Trying to login with username: {}, password: {}", username, password);
        getWebElement(By.id(USERNAME_ID)).sendKeys(username);
        getWebElement(By.id(FAKE_PASSWORD_ID)).clear();
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.id(LOGIN_BUTTON_ID)).click();
    }

    private void clickAtLogin() {
        getWebElement(By.xpath(LOGIN_FLYOUT_XPATH)).click();
    }

    public void clickAtForgotPassword() {
        clickAtLogin();
        getWebElement(By.xpath(FORGOT_PASSWORD_LINK_ID)).click();
    }

    public SignupPage navigateToSignUp() {
        clickAtLogin();
        getWebElement(By.xpath(SIGN_UP_LINK_XPATH)).click();
        return new SignupPage(getDriver()).getPage(SignupPage.class);
    }

    public boolean isLoggedIn() {
        String loginText = getWebElement(By.id("")).getText().trim();
        return !loginText.equalsIgnoreCase("Login");
    }

    public boolean isLoggedInAs(String firstName, String lastName) {
        String loginText = getWebElement(By.id("")).getText().trim();
        return loginText.equalsIgnoreCase("Hello, " + firstName + " " + lastName);
    }

    public AccountPage navigateToMyAccount() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLogin();
        getWebElement(By.id(MY_ACCOUNT_ID)).click();
        return new AccountPage(getDriver()).getPage(AccountPage.class);
    }

    public OrderHistoryPage navigateToOrderHistory() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLogin();
        getWebElement(By.xpath(ORDER_HISTORY_ID)).click();
        return new OrderHistoryPage(getDriver()).getPage(OrderHistoryPage.class);
    }

    public ShukranPage navaigateToShukran() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLogin();
        getWebElement(By.xpath(SHUKRAN_ID)).click();
        return new ShukranPage(getDriver()).getPage(ShukranPage.class);
    }

    public ShoppingBasketPage navigateToBasketPage() {
        getWebElement(By.id(BASKET_ID)).click();
        getWebElement(By.id(VIEW_BASKET_ID)).click();
        return new ShoppingBasketPage(getDriver()).getPage(ShoppingBasketPage.class);
    }

    /**
     * Logout
     *
     * @return
     */
    public void logout() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLogin();
        getWebElement(By.xpath(LOGOUT_LINK)).click();
    }

    /**
     * Get login error message in login flyout
     *
     * @return
     */
    public String getLoginErrorMessage() {
        return getWebElement(By.id(LOGIN_ERROR_MESSAGE_ID)).getText();
    }

    /**
     * if login flyout is visible
     *
     * @return
     */
    public boolean isLoginFlyoutVisible() {
        return isElementPresentAndDisplay(By.xpath(LOGIN_FLYOUT_XPATH));
    }

    /**
     * if signup link is visible
     *
     * @return
     */
    public boolean isSignUpLinkInLoginFlyoutVisible() {
        clickAtLogin();
        boolean isDisplayed = isElementPresentAndDisplay(By.xpath(SIGN_UP_LINK_XPATH));
        clickAtLogin();
        return isDisplayed;
    }

    /**
     * if login parameters are visible
     *
     * @return
     */
    public boolean isLoginParamsVisibleInLoginFlyout() {
        clickAtLogin();
        boolean isDisplayed = isElementPresentAndDisplay(By.id(USERNAME_ID)) &&
                isElementPresentAndDisplay(By.id(PASSWORD_ID)) &&
                isElementPresentAndDisplay(By.id(LOGIN_BUTTON_ID)) &&
                isElementPresentAndDisplay(By.id(FORGOT_PASSWORD_LINK_ID));
        clickAtLogin();
        return isDisplayed;
    }

    /**
     * if login via facebook visible
     *
     * @return
     */
    public boolean isLoginViaFBVisibleInLoginFlyout() {
        clickAtLogin();
        boolean isDisplayed = isElementPresentAndDisplay(By.xpath(LOGIN_VIA_FACEBOOK_ID));
        clickAtLogin();
        return isDisplayed;
    }
}
