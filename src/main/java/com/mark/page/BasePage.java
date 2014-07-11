package com.mark.page;

import com.mark.config.Config;
import com.shash.automationNG.core.ui.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public abstract class BasePage<T> {
    private static final String BASE_URL = Config.getBaseUrl();
    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    private WebDriver webDriver;
    private long pageLoadTime = 20000;
    private long pageRefreshTime = 2000;
    public SeleniumAction seleniumAction;

    /**
     * Instantiates a new base page.
     */
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.seleniumAction = new SeleniumAction(webDriver);
    }

    /**
     * Instantiates a new base page.
     */
    public BasePage(WebDriver webDriver, long pageLoadTime, long pageRefreshTime) {
        this.webDriver = webDriver;
        this.pageLoadTime = pageLoadTime;
        this.pageRefreshTime = pageRefreshTime;
        this.seleniumAction = new SeleniumAction(webDriver);
    }

    /**
     * Open a page
     *
     * @param clazz
     * @return
     */
    protected T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getWebDriver(), clazz);
        logger.info("Opening the base with url: {} ", BASE_URL + getPageUrl());
        getWebDriver().get(BASE_URL + getPageUrl());
        getWebDriver().manage().window().maximize();
        ExpectedCondition pageLoadCondition = ((BasePage) page)
                .getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }

    /**
     * Wait for page to load
     *
     * @param pageLoadCondition
     */
    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        logger.info("[Wait for Page load] Condition: {} ", pageLoadCondition);
        Wait wait = new FluentWait(getWebDriver()).pollingEvery(pageRefreshTime,
                TimeUnit.MILLISECONDS).withTimeout(pageLoadTime,
                TimeUnit.MICROSECONDS);
        wait.until(pageLoadCondition);
    }

    /**
     * @param clazz
     * @return
     */
    protected T getPage(Class<T> clazz) {
        T page = PageFactory.initElements(getWebDriver(), clazz);
        ExpectedCondition pageLoadCondition = ((BasePage) page)
                .getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        logger.info("Navigating to {} page", clazz.getName());
        return page;
    }

    /**
     * Provides condition when page can be considered as fully loaded.
     *
     * @return
     */
    protected abstract ExpectedCondition getPageLoadCondition();

    /**
     * Provides page relative URL/
     *
     * @return
     */
    protected abstract String getPageUrl();

    /**
     * Provides webdriver
     *
     * @return
     */
    protected WebDriver getWebDriver() {
        return this.webDriver;
    }

    /**
     * @return pageLoadTime
     */
    public long getPageLoadTime() {
        return pageLoadTime;
    }

    /**
     * @return pageRefreshTime
     */
    public long getPageRefreshTime() {
        return pageRefreshTime;
    }
}
