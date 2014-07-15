package com.mark.resource;

import com.mark.configuration.Configuration;
import com.shash.autoNG.utils.clockUtil.ClockUtil;
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

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public abstract class BasePage<T> {
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static final long REFRESH_RATE = 2000;
    private static final long PAGE_LOAD_TIME_OUT = 10000;
    private WebDriver driver;

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
        logger.info("[Base Page] Opening the url: {} ", baseUrl + getPageUrl());
        driver.get(baseUrl + getPageUrl());
        driver.manage().window();
        ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }

    @SuppressWarnings("unchecked")
    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        logger.info("[Wait for Page load] Condition: {} ", pageLoadCondition);
        Wait wait = new FluentWait(driver).pollingEvery(REFRESH_RATE, TimeUnit.MILLISECONDS).
                withTimeout(PAGE_LOAD_TIME_OUT, TimeUnit.MICROSECONDS);
        wait.until(pageLoadCondition);
    }

    /**
     * @param clazz
     * @return
     */
    public T getPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        ExpectedCondition pageLoadCondition = ((BasePage) page)
                .getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        logger.info("Navigating to {} page", clazz);
        return page;
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
     * Selection from a drop down list
     *
     * @param by
     * @param selection
     */
    protected void selectFromDropDown(By by, String selection) {
        WebElement element = getDriver().findElement(by);
        List<WebElement> dropDownOptions = element.findElements(By.tagName("option"));
        for (WebElement value : dropDownOptions) {
            if (value.getText().equalsIgnoreCase(selection)) {
                value.click();
            }
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

    public void refresh() {
        driver.navigate().refresh();
    }

    public void waitFor(String reason) {
        try {
            ClockUtil.sleepingFor(reason, Configuration.getGlobalSleepTimeInMS());
        } catch (InterruptedException e) {
            logger.info("Unable to wait, Error: {}", e.getMessage());
        }
    }
}
