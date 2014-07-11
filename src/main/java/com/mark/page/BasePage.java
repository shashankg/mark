package com.mark.page;

import com.shash.automationNG.core.ui.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage<T> {
    private WebDriver webDriver;
    private long pageLoadTime = 20000;
    private long pageRefreshTime = 2000;
    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);
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
     * Open page
     *
     * @param clazz
     * @param baseUrl
     * @return page
     */
    public T openPage(Class<T> clazz, String baseUrl) {
        T page = PageFactory.initElements(getWebDriver(), clazz);
        logger.info("Opening the base with url: {} ", baseUrl + getPageUrl());
        getWebDriver().get(baseUrl + getPageUrl());
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
    public void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
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
    public T getPage(Class<T> clazz) {
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
    public abstract ExpectedCondition getPageLoadCondition();

    /**
     * Provides page relative URL/
     *
     * @return
     */
    public abstract String getPageUrl();

    /**
     * Provides webdriver
     *
     * @return
     */
    public WebDriver getWebDriver() {
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
