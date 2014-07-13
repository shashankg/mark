package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage<ProductPage> {
    private static final String ADD_TO_BASKET_ID = "addToBasket";
    private static final String QUANTITY_DD_ID = "";

    /**
     * Constructor
     *
     * @param driver
     */
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(ADD_TO_BASKET_ID)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void addProductToBasket(String quantity) {
        logger.info("[Product Page] Trying to add product to basket with quantity {}", quantity);
        selectFromDropDown(By.id(QUANTITY_DD_ID), quantity);
        getWebElement(By.id(ADD_TO_BASKET_ID)).click();
    }
}
