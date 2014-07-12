package com.mark.resource.page;

import com.mark.resource.BasePage;
import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage<LoginPage> {
    private static final String EMAIL_ID = "email";
    private static final String PASSWORD_PROMPT = "login-password";
    private static final String PASSWORD_ID = "fakelogin-password";
    private static final String LOGIN_BTN_ID = "";

    private Header header;
    private Footer footer;

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/login";
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public void login(String email, String password) {
        getWebElement(By.id(EMAIL_ID)).sendKeys(email);
        getWebElement(By.id(PASSWORD_PROMPT)).click();
        getWebElement(By.id(PASSWORD_ID)).clear();
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.id(LOGIN_BTN_ID)).submit();
    }
}
