package com.mark.resource.page;

import com.mark.configuration.Configuration;
import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddressBookPage extends AutoNGBasePage<AddressBookPage> {
    private static final String ADD_ADDRESS_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/a";
    private static final String NICK_NAME_TEXTBOX_ID = "addressNickName";
    private static final String FIRST_NAME_TEXTBOX_ID = "firstName";
    private static final String LAST_NAME_TEXTBOX_ID = "lastName";
    private static final String LINE1_TEXTBOX_ID = "line1";
    private static final String LINE2_TEXTBOX_ID = "line2";
    private static final String COUNTRY_TEXTBOX_ID = "countryIsoDrop";
    private static final String REGIONS_TEXTBOX_ID = "regions";
    private static final String PHONE_TEXTBOX_ID = "phone";
    private static final String DEFAULT_SHIPPING_ADDRESS_ID = "";
    private static final String DEFAULT_BILLING_ADDRESS_ID = "";

    private static final String SAVED_ADDRESS_BUTTON_ID = "save-address";
    private static final String FIRST_DEFAULT_ADDRESS_CSS = "div.area:nth-child(2)";

    private static final String ERROR_MSG_CSS = "#msgBoxSave1 > span:nth-child(1)";

    /**
     * Constructor
     *
     * @param driver
     */
    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/address-book";
    }

    /**
     * Save new address
     */
    public AddressBookPage saveAddress(String nickName, String firstName, String lastName, String addressLine1,
                                       String addressLine2, String country, String city, String phone,
                                       boolean isDefaultShippingAddress, boolean isDefaultBillingAddress) {
        getWebElement(By.xpath(ADD_ADDRESS_BUTTON_XPATH)).click();
        sleep("", Configuration.getGlobalSleepTimeInMS());
        getWebElement(By.id(NICK_NAME_TEXTBOX_ID)).sendKeys(nickName);
        getWebElement(By.id(FIRST_NAME_TEXTBOX_ID)).sendKeys(firstName);
        getWebElement(By.id(LAST_NAME_TEXTBOX_ID)).sendKeys(lastName);
        getWebElement(By.id(LINE1_TEXTBOX_ID)).sendKeys(addressLine1);
        getWebElement(By.id(LINE2_TEXTBOX_ID)).sendKeys(addressLine2);
        selectFromDropDown((By.id(COUNTRY_TEXTBOX_ID)), country);
        selectFromDropDown((By.id(REGIONS_TEXTBOX_ID)), city);
        getWebElement(By.id(PHONE_TEXTBOX_ID)).sendKeys(phone);

        if (isDefaultShippingAddress) getWebElement(By.id(DEFAULT_SHIPPING_ADDRESS_ID)).click();
        if (isDefaultBillingAddress) getWebElement(By.id(DEFAULT_BILLING_ADDRESS_ID)).click();

        getWebElement(By.id(SAVED_ADDRESS_BUTTON_ID)).click();
        return new AddressBookPage(getDriver()).getPage(AddressBookPage.class);
    }

    public boolean isFirstDefaultAddressAdded() {
        return isElementPresentAndDisplay(By.cssSelector(FIRST_DEFAULT_ADDRESS_CSS));
    }

    public String getFirstDefaultAddressAdded() {
        return getWebElement(By.cssSelector(FIRST_DEFAULT_ADDRESS_CSS)).getText();
    }

    public String getErrorMsg(){
        return getWebElement(By.cssSelector(ERROR_MSG_CSS)).getText().trim();
    }

}
