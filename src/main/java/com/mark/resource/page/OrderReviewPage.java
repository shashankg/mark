package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class OrderReviewPage extends BasePage<OrderReviewPage> {
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
        return null;
    }

    @Override
    public String getPageUrl() {
        return null;
    }
}
