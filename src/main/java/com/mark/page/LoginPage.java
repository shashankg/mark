package com.mark.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(id = "")
    private WebElement usernameField;

    @FindBy(xpath = "")
    private WebElement passwordField;

    @FindBy(css = "")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(loginButton);
    }

    @Override
    public String getPageUrl() {
        return "/login";
    }

    /**
     * Login functionality
     *
     * @param username
     * @param password
     * @return this
     */
    public void login(String username, String password) {
        logger.info("Trying to login with username: {}, password: {}" + username + " " + password);
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.seleniumAction.click(loginButton);
    }

    /**
     * Get the Message for login (error/success)
     *
     * @return this
     */
    public String getMessage() {
        return null;
    }
}
