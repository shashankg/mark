package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPaymentOptionPopUp extends BasePage<AddPaymentOptionPopUp> {
    private static final String CARD_NUMBER_ID = "ccf-number";
    private static final String CARD_HOLDER_NAME_ID = "ccf-name";
    private static final String EXPIRY_MONTH_ID = "ccf-exp-month";
    private static final String EXPIRY_YEAR_ID = "ccf-exp-year";
    private static final String CVV_ID = "ccf-cvv";
    private static final String SAVE_AS_DEFAULT_CHECKBOX_ID = "check-save";
    private static final String NICKNAME_ID = "addressNickName";
    private static final String FIRST_NAME_ID = "firstName";
    private static final String LAST_NAME_ID = "lastName";
    private static final String ADDRESS_LINE1_ID = "line1";
    private static final String ADDRESS_LINE2_ID = "line2";
    private static final String COUNTRY_ID = "countryIsoDrop";
    private static final String CITY_ID = "regions";
    private static final String PHONE_ID = "phone";
    private static final String SAVE_BUTTON_XPATH = ".//*[@id='creditCardForm']/div[9]/input";

    /**
     * Constructor
     *
     * @param driver
     */
    public AddPaymentOptionPopUp(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(CARD_HOLDER_NAME_ID)));
    }

    @Override
    public String getPageUrl() {
        return null;
    }

    public PaymentOptionsPage saveCardDetails(String cardNumber, String cardHolderName, String expiryMonth, String expiryYear, String cvv,
                                              Boolean isSaveAsDefault, String nickName, String firstName, String lastName, String addressLine1,
                                              String addressLine2, String country, String city, String phone) {
        getWebElement(By.id(CARD_NUMBER_ID)).sendKeys(cardNumber);
        getWebElement(By.id(CARD_HOLDER_NAME_ID)).sendKeys(cardHolderName);
        selectFromDropDown(By.id(EXPIRY_MONTH_ID), String.valueOf(expiryMonth));
        selectFromDropDown(By.id(EXPIRY_YEAR_ID), String.valueOf(expiryYear));
        getWebElement(By.id(CVV_ID)).sendKeys(cvv);
        if (isSaveAsDefault) getWebElement(By.id(SAVE_AS_DEFAULT_CHECKBOX_ID)).click();
        getWebElement(By.id(NICKNAME_ID)).sendKeys(nickName);
        getWebElement(By.id(FIRST_NAME_ID)).sendKeys(firstName);
        getWebElement(By.id(LAST_NAME_ID)).sendKeys(lastName);
        getWebElement(By.id(ADDRESS_LINE1_ID)).sendKeys(addressLine1);
        getWebElement(By.id(ADDRESS_LINE2_ID)).sendKeys(addressLine2);
        selectFromDropDown(By.id(COUNTRY_ID), country);
        selectFromDropDown(By.id(CITY_ID), city);
        getWebElement(By.id(PHONE_ID)).sendKeys(phone);
        getWebElement(By.xpath(SAVE_BUTTON_XPATH)).click();
        return new PaymentOptionsPage(getDriver()).getPage(PaymentOptionsPage.class);
    }

}