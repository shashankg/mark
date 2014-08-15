package com.mark.resource.page;

import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.mark.resource.component.SearchBar;
import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage<LoginPage> {
    private static final String EMAIL_ID = "email";
    private static final String FAKE_PASSWORD_ID = "fakelogin-password";
    private static final String PASSWORD_ID = "login-password";
    private static final String LOGIN_BTN_XPATH = ".//*[@id='landmarkLoginForm']/fieldset/div[6]/input";






    private Header header;
    private Footer footer;
    private SearchBar searchBar;

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.searchBar = new SearchBar(driver);
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
     * @param email
     * @param password
     */
    public AccountPage login(String email, String password) {
        getWebElement(By.id(EMAIL_ID)).sendKeys(email);
        getWebElement(By.id(FAKE_PASSWORD_ID)).clear();
        getWebElement(By.id(PASSWORD_ID)).sendKeys(password);
        getWebElement(By.xpath(LOGIN_BTN_XPATH)).click();
        return new AccountPage(getDriver()).getPage(AccountPage.class);
    }





}
