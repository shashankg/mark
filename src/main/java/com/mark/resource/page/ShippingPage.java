package com.mark.resource.page;

import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ShippingPage extends AutoNGBasePage<ShippingPage> {
    private static final String ADDRESS_NICK_NAME_ID = "addressNickName";
    private static final String FIRST_NAME_ID = "firstName";
    private static final String LAST_NAME_ID = "lastName";
    private static final String EMAIL_ID = "emaill";
    private static final String ADDR_LINE_1_ID = "line1";
    private static final String ADDR_LINE_2_ID = "line2";
    private static final String REGION_DD_ID = "regions";
    private static final String PHONE_NUM_ID = "phone";
    private static final String CONTINUE_BTN_XPATH = ".//*[@id='createLMGAddressForm']/div[2]/input";
    private static final String BACK_BTN_ID = ".//*[@id='createLMGAddressForm']/div[2]/a";
    private static final String SAME_BILLING_ADDR_CHECKBOX_ID = "sameBillingAsShipping";

    /**
     * Constructor
     *
     * @param driver
     */
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(CONTINUE_BTN_XPATH)));
    }

    @Override
    public String getPageUrl() {
        return "/checkout";
    }

    public ShippingPage fillShippingAddress(String nickName, String firstName, String lastName, String email,
                                            String addrLine1, String addrLine2, String region, String phoneNum,
                                            boolean isShippingAddressSameAsBillingAddr) {
        getWebElement(By.id(ADDRESS_NICK_NAME_ID)).sendKeys(nickName);
        getWebElement(By.id(FIRST_NAME_ID)).sendKeys(firstName);
        getWebElement(By.id(LAST_NAME_ID)).sendKeys(lastName);
        getWebElement(By.id(EMAIL_ID)).sendKeys(email);
        getWebElement(By.id(ADDR_LINE_1_ID)).sendKeys(addrLine1);
        getWebElement(By.id(ADDR_LINE_2_ID)).sendKeys(addrLine2);
        selectFromDropDown(By.id(REGION_DD_ID), region);
        getWebElement(By.id(PHONE_NUM_ID)).sendKeys(phoneNum);
        if (isShippingAddressSameAsBillingAddr)
            getWebElement(By.id(SAME_BILLING_ADDR_CHECKBOX_ID)).click();
        return this;
    }

    public BillingPage andContinue() {
        getWebElement(By.id(CONTINUE_BTN_XPATH)).click();
        return new BillingPage(getDriver()).getPage(BillingPage.class);
    }
}
