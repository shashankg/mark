package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistoryPage extends BasePage<OrderHistoryPage> {

    /**
     * Constructor
     *
     * @param driver
     */
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/orders";
    }
}
