package com.mark.resource.page;

import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PaymentOptionsPage extends BasePage<PaymentOptionsPage> {
    private static final String ADD_PAYMENT_OPTION_LINK_CSS = ".title-with-link > a:nth-child(2)";
    private static final String FIRST_PAYMENT_OPTION_CSS = ".addresses-list > div:nth-child(2)";

    /**
     * Constructor
     *
     * @param driver
     */
    public PaymentOptionsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/payment-details";
    }

    public AddPaymentOptionPopUp addNewPaymentOption() {
        getWebElement(By.cssSelector(ADD_PAYMENT_OPTION_LINK_CSS)).click();
        sleep("Waiting for Popup to load.");
        return new AddPaymentOptionPopUp(getDriver()).getPage(AddPaymentOptionPopUp.class);
    }

    public String getFirstPaymentOptionDetails() {
        return getWebElement(By.cssSelector(FIRST_PAYMENT_OPTION_CSS)).getText().trim();
    }

    public boolean isFirstPaymentOptionDetailsVisible() {
        return isElementPresentAndDisplay(By.cssSelector(FIRST_PAYMENT_OPTION_CSS));
    }
}