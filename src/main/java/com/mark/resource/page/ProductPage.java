package com.mark.resource.page;

import com.mark.resource.BasePage;
import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage<ProductPage> {
    private static final String ADD_TO_BASKET_ID = "addToBasket";
    private static final String QUANTITY_DD_ID = "quantity";

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
    public void addProductToBasket(int quantity) {
        logger.info("[Product Page] Trying to add product to basket with quantity {}", quantity);
        selectFromDropDown(By.id(QUANTITY_DD_ID), String.valueOf(quantity));
        getWebElement(By.id(ADD_TO_BASKET_ID)).click();
        waitFor("[Product Page] Waiting for product to get added to the basket.");
    }
}
