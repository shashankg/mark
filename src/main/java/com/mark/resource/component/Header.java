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
    private static final String AFTER_LOGIN_TEXT_ON_LOGIN_FLYOUT_XPATH = ".//*[@id='header']/div[1]/div/div/ul/li[1]/a[1]/span";

    private static final String MY_ACCOUNT_XPATH = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[1]/a";
    private static final String ORDER_HISTORY_ID = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[2]";
    private static final String SHUKRAN_ID = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[3]/a";
    private static final String LOGOUT_LINK_XPATH = ".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[4]/a";

    private static final String FORGOT_PASSWORD_LINK_XPATH = ".//*[@id='loginForm']/fieldset/div[3]/a";
    private static final String LOGIN_VIA_FACEBOOK_ID = "facebook-login";

    private static final String BASKET_CLASS = "basket btn-open";
    private static final String VIEW_BASKET_XPATH = ".//*[@id='wrap-basket-template']/div/table/tbody/tr[1]/td/a/span";
    private static final String BASKET_CHECKOUT_CLASS = "basket_checkout_button_class";
    private static final String LOGIN_FLYOUT_ERROR_MESSAGE_ID = "loginValidationErrorSpan";
    private static final String BASKET_ITEM_COUNT_CLASS = "basket-count";
    private static final String BASKET_FIRST_ITEM_REMOVE_LINK_CLASS = "deleteRowButton";

    private static final String REMEMBER_ME_CHECKBOX_ID ="check2";

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
        clickAtLoginBeforeLogin();
        logger.info("[Header Login] Trying to login with username: {}, password: {}", username, password);
        getWebElement(By.id(USERNAME_ID)).sendKeys(username);
        getWebElement(By.id(FAKE_PASSWORD_ID)).clear();
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.id(LOGIN_BUTTON_ID)).click();
    }

    private void clickAtLoginBeforeLogin() {
        getWebElement(By.xpath(LOGIN_FLYOUT_XPATH)).click();
    }

    private void clickAtLoginAfterLogin() {
        getWebElement(By.xpath(AFTER_LOGIN_TEXT_ON_LOGIN_FLYOUT_XPATH)).click();
    }

    public ForgotPasswordPopUp clickAtForgotPassword() {
        clickAtLoginAfterLogin();
        getWebElement(By.xpath(FORGOT_PASSWORD_LINK_XPATH)).click();
        return new ForgotPasswordPopUp(getDriver()).getPage(ForgotPasswordPopUp.class);
    }

    public SignupPage navigateToSignUp() {
        clickAtLoginBeforeLogin();
        getWebElement(By.xpath(SIGN_UP_LINK_XPATH)).click();
        return new SignupPage(getDriver()).getPage(SignupPage.class);
    }

    public boolean isLoggedIn() {
        String loginText = getWebElement(By.xpath(AFTER_LOGIN_TEXT_ON_LOGIN_FLYOUT_XPATH)).getText().trim();
        return loginText.contains("Hello,");
    }

    public boolean isLoggedInAs(String firstName, String lastName) {
        String loginText = getWebElement(By.id("")).getText().trim();
        return loginText.equalsIgnoreCase("Hello, " + firstName + " " + lastName);
    }

    public AccountPage navigateToMyAccount() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLoginAfterLogin();
        getWebElement(By.xpath(MY_ACCOUNT_XPATH)).click();
        return new AccountPage(getDriver()).getPage(AccountPage.class);
    }

    public OrderHistoryPage navigateToOrderHistory() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLoginAfterLogin();
        getWebElement(By.xpath(ORDER_HISTORY_ID)).click();
        return new OrderHistoryPage(getDriver()).getPage(OrderHistoryPage.class);
    }

    public ShukranHomePage navaigateToShukran() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLoginAfterLogin();
        getWebElement(By.xpath(SHUKRAN_ID)).click();
        return new ShukranHomePage(getDriver()).getPage(ShukranHomePage.class);
    }

    public ShoppingBasketPage navigateToBasketPage() {
        getWebElement(By.className(BASKET_CLASS)).click();
        getWebElement(By.xpath(VIEW_BASKET_XPATH)).click();
        return new ShoppingBasketPage(getDriver()).getPage(ShoppingBasketPage.class);
    }

    /**
     * Logout
     */
    public void logout() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLoginAfterLogin();
        getWebElement(By.xpath(LOGOUT_LINK_XPATH)).click();
    }

    /**
     * Get login error message in login flyout
     *
     * @return
     */
    public String getLoginErrorMessage() {
        return getWebElement(By.id(LOGIN_FLYOUT_ERROR_MESSAGE_ID)).getText();
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
        clickAtLoginBeforeLogin();
        boolean isDisplayed = isElementPresentAndDisplay(By.xpath(SIGN_UP_LINK_XPATH));
        clickAtLoginBeforeLogin();
        return isDisplayed;
    }

    /**
     * if login parameters are visible
     *
     * @return
     */
    public boolean isLoginParamsVisibleInLoginFlyout() {
        clickAtLoginBeforeLogin();
        boolean isDisplayed = isElementPresentAndDisplay(By.id(USERNAME_ID)) &&
                isElementPresentAndDisplay(By.id(FAKE_PASSWORD_ID)) &&
                isElementPresent(By.id(PASSWORD_ID)) &&
                isElementPresentAndDisplay(By.id(LOGIN_BUTTON_ID)) &&
                isElementPresentAndDisplay(By.xpath(FORGOT_PASSWORD_LINK_XPATH));
        clickAtLoginBeforeLogin();
        return isDisplayed;
    }

    /**
     * if login via facebook visible
     *
     * @return
     */
    public boolean isLoginViaFBVisibleInLoginFlyout() {
        clickAtLoginBeforeLogin();
        boolean isDisplayed = isElementPresentAndDisplay(By.id(LOGIN_VIA_FACEBOOK_ID));
        clickAtLoginBeforeLogin();
        return isDisplayed;
    }

    /**
     * @return
     */
    public int getShoppingBasketItemCount() {
        return Integer.parseInt(getWebElement(By.className(BASKET_ITEM_COUNT_CLASS)).getText());

    }

    /**
     * if basket flyout visible
     *
     * @return
     */
    public boolean isBasketFlyoutVisible() {
        return isElementPresentAndDisplay(By.className(BASKET_ITEM_COUNT_CLASS));
    }

    /**
     * if basket flyout enabled
     *
     * @return
     */
    public boolean isBasketFlyoutEnabled() {
        getWebElement(By.className(BASKET_ITEM_COUNT_CLASS)).click();
        return isElementPresentAndDisplay(By.xpath(VIEW_BASKET_XPATH));
    }

    /**
     * Remove first item from the basket
     */
    public void removeFirstItemFromBasket() {
        getWebElement(By.className(BASKET_ITEM_COUNT_CLASS)).click();
        sleep("Waiting for Dropdown to appear");
        getWebElement(By.className(BASKET_FIRST_ITEM_REMOVE_LINK_CLASS)).click();
    }

    public void rememberMe(Boolean isRememberMe)
    {
        if (isRememberMe) getWebElement(By.id(REMEMBER_ME_CHECKBOX_ID)).click();
    }
}
