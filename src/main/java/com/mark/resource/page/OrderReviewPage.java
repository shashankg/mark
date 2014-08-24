package com.mark.resource.page;

import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderReviewPage extends AutoNGBasePage<OrderReviewPage> {
    /**
     * Constructor
     *
     * @param driver
     */
    public OrderReviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return null;
    }
}
