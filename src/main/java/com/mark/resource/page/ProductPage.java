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
    private static final String IN_STOCK_TEXT_XPATH = ".//*[@id='inStockStatus']";
    private static final String COLOR_XPATH = "";
    private static final String SIZE_XPATH = "";
    private static final String OUT_OF_STOCK_TEXT_XPATH = ".//*[@id='outOfStockStatus']";
    private static final String NOTIFY_TEXTBOX_ID = "notifemail";
    private static final String NOTIFY_BUTTON_XPATH = ".//*[@id='stocknotif__wrapper--default']/button";
    private static final String NOTIFICATION_XPATH = ".//*[@id='stocknotif__wrapper--success']/p[2]/i";


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
        sleep("[Product Page] Waiting for product to get added to the basket.");
    }

    public void addProductWithNoColorAndSizeVarianceToBasket() {
        logger.info("[Product Page] Trying to add product to basket with quantity {}");
        if (getWebElement(By.xpath(IN_STOCK_TEXT_XPATH)).getText().equalsIgnoreCase("In Stock Online")) {
            getWebElement(By.id(ADD_TO_BASKET_ID)).click();
        }
        sleep("[Product Page] Waiting for product to get added to the basket.");
    }

    public void addProductWithColorAndSizeVarianceToBasket() {
        logger.info("[Product Page] Trying to add product to basket with quantity {}");
        getWebElement(By.xpath(COLOR_XPATH)).click();
        getWebElement(By.xpath(SIZE_XPATH)).click();
        if (getWebElement(By.xpath(IN_STOCK_TEXT_XPATH)).getText().equalsIgnoreCase("In Stock Online")) {
            getWebElement(By.id(ADD_TO_BASKET_ID)).click();
        }
        sleep("[Product Page] Waiting for product to get added to the basket.");
    }

    public void notifyProductNotAvailable(String email) {
        logger.info("[Product Page] Trying to add product to basket with quantity {}");
        if (getWebElement(By.xpath(OUT_OF_STOCK_TEXT_XPATH)).getText().equalsIgnoreCase("Sold out")) {
            getWebElement(By.id(NOTIFY_TEXTBOX_ID)).sendKeys(email);
            getWebElement(By.xpath(NOTIFY_BUTTON_XPATH)).click();
        }
    }

    public String getSuccessfulEmailRegisteredForNotify() {
        return getWebElement(By.xpath(NOTIFICATION_XPATH)).getText();
    }


}
