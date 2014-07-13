package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends BasePage<BasketPage> {
    private static final String CHECKOUT_NOW_CLASS = "checkout";
    private static final String REMOVE_ITEM_ID = "";

    /**
     * Constructor
     *
     * @param driver
     */
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(CHECKOUT_NOW_CLASS)));
    }

    @Override
    public String getPageUrl() {
        return "/shoppingCart/showCart";
    }

    public ShippingPage checkoutNow() {
        getWebElement(By.className(CHECKOUT_NOW_CLASS)).click();
        return new ShippingPage(getDriver()).getPage(ShippingPage.class);
    }
}
