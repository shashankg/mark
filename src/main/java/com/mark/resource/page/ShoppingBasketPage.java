package com.mark.resource.page;

import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ShoppingBasketPage extends BasePage<ShoppingBasketPage> {
    private static final String CHECKOUT_NOW_CSS = "div.action:nth-child(1) > form:nth-child(1) > input:nth-child(1)";
    private static final String REMOVE_FIRST_ITEM_CSS = ".removeFromBasket";

    private Header header;
    private Footer footer;

    /**
     * Constructor
     *
     * @param driver
     */
    public ShoppingBasketPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        footer = new Footer(driver);
    }


    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.cssSelector(CHECKOUT_NOW_CSS)));
    }

    @Override
    public String getPageUrl() {
        return "/shoppingCart/showCart";
    }

    public ShippingPage checkoutNow() {
        getWebElement(By.cssSelector(CHECKOUT_NOW_CSS)).click();
        return new ShippingPage(getDriver()).getPage(ShippingPage.class);
    }

    /**
     * Remove first item from checkout
     *
     * @return
     */
    public ShoppingBasketPage removeFirstItem() {
        getWebElement(By.cssSelector(REMOVE_FIRST_ITEM_CSS)).click();
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
