package com.mark.resource.page;

import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BillingPage extends AutoNGBasePage<BillingPage> {
    private static final String CC_RADIO_BTN_ID = "creditcard";
    private static final String COD_RADIO_BTN_ID = "codPaymentMode";
    private static final String SAME_BILLING_ADDR_CHECKBOX_ID = "sameBillingAsShipping";
    private static final String ADDRESS_NICK_NAME_ID = "addressNickName";
    private static final String FIRST_NAME_ID = "firstName";
    private static final String LAST_NAME_ID = "lastName";
    //private static final String EMAIL_ID = "";
    private static final String ADDR_LINE_1_ID = "line1";
    private static final String ADDR_LINE_2_ID = "line2";
    private static final String REGION_DD_ID = "countryIsoDrop";
    private static final String CITY_DD_ID = "regions";
    private static final String PHONE_NUM_ID = "phone";

    private static final String CC_NUM_ID = "ccf-number";
    private static final String CC_HOLDER_NAME_ID = "ccf-name";
    private static final String CC_EXP_MNTH_ID = "ccf-exp-month";
    private static final String CC_EXP_YEAR_ID = "ccf-exp-year";
    private static final String CC_SECURITY_CODE_ID = "ccf-cvv";

    private static final String CONTINUE_BTN_XPATH = ".//*[@id='createLMGAddressForm']/div[7]/input[5]";
    private static final String BACK_BTN_ID = "goBackId";


    /**
     * Constructor
     *
     * @param driver
     */
    public BillingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(CONTINUE_BTN_XPATH)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public BillingPage fillBillingAddress(String nickName, String firstName, String lastName, String email,
                                          String addrLine1, String addrLine2, String region, String city,
                                          String phoneNum, boolean isShippingAddressSameAsBillingAddr) {
        getWebElement(By.id(ADDRESS_NICK_NAME_ID)).sendKeys(nickName);
        getWebElement(By.id(FIRST_NAME_ID)).sendKeys(firstName);
        getWebElement(By.id(LAST_NAME_ID)).sendKeys(lastName);
       // getWebElement(By.id(EMAIL_ID)).sendKeys(email);
        getWebElement(By.id(ADDR_LINE_1_ID)).sendKeys(addrLine1);
        getWebElement(By.id(ADDR_LINE_2_ID)).sendKeys(addrLine2);
        selectFromDropDown(By.id(REGION_DD_ID), region);
        selectFromDropDown(By.id(CITY_DD_ID), city);
        getWebElement(By.id(PHONE_NUM_ID)).sendKeys(phoneNum);
        if (isShippingAddressSameAsBillingAddr)
            getWebElement(By.id(SAME_BILLING_ADDR_CHECKBOX_ID)).click();
        return this;
    }


    public BillingPage fillBillingDetails(String ccNum, String ccHolderName, String expMnth, String expYear, String cvv) {
        getWebElement(By.id(CC_NUM_ID)).sendKeys(ccNum);
        getWebElement(By.id(CC_HOLDER_NAME_ID)).sendKeys(ccHolderName);
        selectFromDropDown(By.id(CC_EXP_MNTH_ID), expMnth);
        selectFromDropDown(By.id(CC_EXP_YEAR_ID), expYear);
        getWebElement(By.id(CC_SECURITY_CODE_ID)).sendKeys(cvv);
        return this;
    }

    public OrderReviewPage clickContinue() {
        getWebElement(By.id(CONTINUE_BTN_XPATH)).click();
        return new OrderReviewPage(getDriver()).getPage(OrderReviewPage.class);
    }
}
