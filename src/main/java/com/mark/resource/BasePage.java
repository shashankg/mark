package com.mark.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public abstract class BasePage<T> {
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;

    /**
     * Constructor
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param clazz
     * @param baseUrl
     * @return
     */
    public T openPage(Class<T> clazz, String baseUrl) {
        T page = PageFactory.initElements(driver, clazz);
        logger.info("Opening the base with url: {} ", baseUrl + getPageUrl());
        driver.get(baseUrl + getPageUrl());
        driver.manage().window();
        ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }

    @SuppressWarnings("unchecked")
    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        logger.info("[Wait for Page load] Condition: {} ", pageLoadCondition);
        Wait wait = new FluentWait(driver).pollingEvery(2000,
                TimeUnit.MILLISECONDS).withTimeout(10000,
                TimeUnit.MICROSECONDS);
        wait.until(pageLoadCondition);
    }

    /**
     * Provides condition when page can be considered as fully loaded.
     *
     * @return
     */
    protected abstract ExpectedCondition getPageLoadCondition();

    /**
     * Provides page relative url/
     *
     * @return
     */
    public abstract String getPageUrl();

    /**
     * Send text keys to the element that finds by cssSelector.
     * It shortens "driver.findElement(By.cssSelector()).sendKeys()".
     *
     * @param cssSelector
     * @param text
     */
    protected void sendTextByCss(String cssSelector, String text) {
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    /**
     * Is the text present in page.
     */
    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }

    /**
     * Is the Element in page.
     */
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Is the Element present in the DOM.
     *
     * @param _cssSelector element locator
     * @return WebElement
     */
    public boolean isElementPresent(String _cssSelector) {
        try {
            driver.findElement(By.cssSelector(_cssSelector));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /**
     * Checks if the element is in the DOM and displayed.
     *
     * @param by - selector to find the element
     * @return true or false
     */
    public boolean isElementPresentAndDisplay(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the first WebElement using the given method.
     * It shortens "driver.findElement(By)".
     *
     * @param by element locator.
     * @return the first WebElement
     */
    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
