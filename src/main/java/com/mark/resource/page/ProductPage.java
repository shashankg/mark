package com.mark.resource.page;

import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPage extends BasePage<ProductPage> {
    private static final String ADD_TO_BASKET_ID = "addToBasket";
    private static final String QUANTITY_DD_ID = "quantity";
    private static final String SIZE_CSS = "label.size-radio:nth-child(2) > span:nth-child(2)";
    private static final String COLOR_CSS = ".color-radio > input:nth-child(1)";

    private static final String BREADCRUMB_CSS = ".breadcrumbs";
    private static final String PRICE_CSS = "strong.price:nth-child(3)";

    private Header header;
    private Footer footer;

    /**
     * Constructor
     *
     * @param driver
     */
    public ProductPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(ADD_TO_BASKET_ID)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    /**
     * add a product to the basket
     *
     * @param quantity
     * @return
     */
    public ProductPage addProductToBasket(int quantity) {
        logger.info("[Product Page] Trying to add product to basket with quantity {}", quantity);
        selectFromDropDown(By.id(QUANTITY_DD_ID), String.valueOf(quantity));
        getWebElement(By.id(ADD_TO_BASKET_ID)).click();
        sleep("[Product Page] Waiting for product to get added to the basket.");
        return this;
    }

    /**
     * add a product to the basket with color and size
     *
     * @param quantity
     * @return
     */
    public ProductPage addProductToBasketWithSize(int quantity) {
        logger.info("[Product Page] Trying to add product to basket with quantity {}", quantity);
        selectFromDropDown(By.id(QUANTITY_DD_ID), String.valueOf(quantity));
        getWebElement(By.cssSelector(SIZE_CSS)).click();
        getWebElement(By.id(ADD_TO_BASKET_ID)).click();
        sleep("[Product Page] Waiting for product to get added to the basket.");
        return this;
    }

    /**
     * Is breadcrumb visible
     *
     * @return
     */
    public boolean isBreadcrumbVisible() {
        return isElementPresentAndDisplay(By.cssSelector(BREADCRUMB_CSS));
    }

    /**
     * Is add to basket visible
     *
     * @return
     */
    public boolean isAddToBasketVisible() {
        return isElementPresentAndDisplay(By.id(ADD_TO_BASKET_ID));
    }

    /**
     * Is add to basket visible
     *
     * @return
     */
    public boolean isQuantityVisible() {
        return isElementPresentAndDisplay(By.id(QUANTITY_DD_ID));
    }

    /**
     * Is price visible
     *
     * @return
     */
    public boolean isPriceVisible() {
        return isElementPresentAndDisplay(By.cssSelector(PRICE_CSS));
    }
}
