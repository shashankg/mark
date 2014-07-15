package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingBasketPage extends BasePage<ShoppingBasketPage> {
    private static final String CHECKOUT_NOW_CLASS = "checkout";
    private static final String REMOVE_ITEM_XPATH = ".//*[@id='154595059']/span[2]/a";

    /**
     * Constructor
     *
     * @param driver
     */
    public ShoppingBasketPage(WebDriver driver) {
        super(driver);
    }

//    public removeEmptiesCart()
//    {
//        getWebElement(By.xpath("REMOVE_ITEM_XPATH")).click();
//
//    }


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
