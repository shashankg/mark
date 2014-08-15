package com.mark.resource.page;

import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FacebookLoginPage extends BasePage<FacebookLoginPage> {
    private static final String USERNAME_ID = "email";
    private static final String PASSWORD_ID = "pass";
    private static final String LOGIN_ID = "u_0_1";

    /**
     * Constructor
     *
     * @param driver
     */
    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(LOGIN_ID)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public HomePage login(String email, String password) {
        logger.info("[Facebook Login] Trying to login with email: [{}] and password [{}]", email, password);
        getWebElement(By.id(USERNAME_ID)).sendKeys(email);
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.id(LOGIN_ID)).click();
        return new HomePage(getDriver()).getPage(HomePage.class);
    }
}
