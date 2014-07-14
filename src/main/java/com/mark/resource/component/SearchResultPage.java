package com.mark.resource.component;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage<SearchResultPage> {
    private static final String ERROR_MESSAGE_ID = "";

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/search";
    }

    /**
     * If the error message is displayed
     *
     * @return
     */
    public boolean isErrorDisplayed() {
        return isElementPresent(By.id(ERROR_MESSAGE_ID));
    }

    /**
     * Gets and return the error message displayed if any
     *
     * @return
     */
    public String getErrorMessage() {
        return getWebElement(By.id(ERROR_MESSAGE_ID)).getText();
    }
}
