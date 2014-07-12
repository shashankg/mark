package com.mark.resource.component;

import com.mark.exception.MarkException;
import com.mark.resource.BasePage;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.OrderHistoryPage;
import com.mark.resource.page.ShukranPage;
import com.mark.resource.page.SignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage<Header> {

    private static final String LOGIN_LINK_XPATH = ".//*[@id='header']/div[1]/div/div/ul/li[1]/a[2]";
    private static final String SIGN_UP_LINK_XPATH = "//*[@id='header']/div[1]/div/div/ul/li[1]/div/div[2]/a";
    private static final String USERNAME_ID = "j_username";
    private static final String FAKE_PASSWORD_ID = "fakej_password";
    private static final String PASSWORD_ID = "j_password";
    private static final String LOGIN_BUTTON_ID = "login";

    private static final String MY_ACCOUNT_ID = "";
    private static final String ORDER_HISTORY_ID = "";
    private static final String SHUKRAN_ID = "";
    private static final String LOGOUT_LINK = "";

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.xpath(LOGIN_LINK_XPATH)));
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

    public void clickAtLogin() {
        getWebElement(By.xpath(LOGIN_LINK_XPATH)).click();
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
        getWebElement(By.id(ORDER_HISTORY_ID)).click();
        return new OrderHistoryPage(getDriver()).getPage(OrderHistoryPage.class);
    }

    public ShukranPage navaigateToShukran() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLogin();
        getWebElement(By.id(SHUKRAN_ID)).click();
        return new ShukranPage(getDriver()).getPage(ShukranPage.class);
    }

    public void logout() {
        if (!isLoggedIn())
            throw new MarkException("[Header] User is not logged in.");

        clickAtLogin();
        getWebElement(By.id(LOGOUT_LINK)).click();
    }
}
