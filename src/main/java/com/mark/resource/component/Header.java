package com.mark.resource.component;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage<Header> {
    private static final String LOGIN_LINK_XPATH = ".//*[@id='header']/div[1]/div/div/ul/li[1]/a[2]";
    private static final String USERNAME_ID = "j_username";
    private static final String PASSWORD_ID = "fakej_password";
    private static final String LOGIN_BUTTON_ID = "login";

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath(LOGIN_LINK_XPATH)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void login(String username, String password) throws InterruptedException {
        getWebElement(By.xpath(LOGIN_LINK_XPATH)).click();
        logger.info("Trying to login with username: {}, password: {}", username, password);
        getWebElement(By.id(USERNAME_ID)).sendKeys(username);
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.id(LOGIN_BUTTON_ID)).click();
    }
}
