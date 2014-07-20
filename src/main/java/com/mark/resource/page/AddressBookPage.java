package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddressBookPage extends BasePage<AddressBookPage> {

    private static final String ADD_NEW_ADDRESS_BUTTON_CLASS = "btn-blue-s btn-addaddress";
    private static final String ADDRESS_BOOK_LINK_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[3]/a";
    private static final String EDIT_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[1]/a";
    private static final String EDIT_NICKNAME_TEXTFIELD_ID = "nickname8812267864087_";
    private static final String EDIT_CANCEL_BUTTON_XPATH = ".//*[@id='LMGAddressForm8812267864087_']/div[2]/div[10]/a";
    private static final String EDIT_SAVE_BUTTON_XPATH = ".//*[@id='LMGAddressForm8812267864087_']/div[2]/div[10]/input";
    private static final String DELETE_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a";
    private static final String DELETE_CONFIRMATION_POPUP_XPATH = ".//*[@id='removeAddressForm']/div/input";
    private static final String CANCEL_DELETION_BUTTON_XPATH = ".//*[@id='removeAddressForm']/div/a";

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
    private static final String DELETE_SAVED_ADDRESS_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[3]/div[1]/ul/li[2]/a";

    private static final String EDIT_SAVED_ADDRESS_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[3]/div[1]/ul/li[1]/a";
    private static final String EDIT_NICK_NAME_TEXTBOX_ID = "";
    private static final String EDIT_FIRST_NAME_TEXTBOX_ID = "";
    private static final String EDIT_LAST_NAME_TEXTBOX_ID = "";
    private static final String EDIT_LINE1_TEXTBOX_ID = "";
    private static final String EDIT_LINE2_TEXTBOX_ID = "";
    private static final String EDIT_COUNTRY_TEXTBOX_ID = "";
    private static final String EDIT_REGIONS_TEXTBOX_ID = "";
    private static final String EDIT_PHONE_TEXTBOX_ID = "";

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
     * Edit the current address params
     */
    public AddressBookPage editDetaultAddressdetails(int index, String nickName, String firstName, String lastName, String addressLine1,
                                                     String addressLine2, String country, String state, String phone,
                                                     boolean isDefaultShippingAddress, boolean isDefaultBillingAddress) {

        clickEditOnDefaultAddress(index);
        getWebElement(By.id(ADDRESS_BOOK_LINK_XPATH)).click();
        getWebElement(By.id(EDIT_NICKNAME_TEXTFIELD_ID)).clear();

        if (!nickName.isEmpty()) getWebElement(By.id(EDIT_NICK_NAME_TEXTBOX_ID)).sendKeys(nickName);
        if (!firstName.isEmpty()) getWebElement(By.id(EDIT_FIRST_NAME_TEXTBOX_ID)).sendKeys(firstName);
        if (!lastName.isEmpty()) getWebElement(By.id(EDIT_LAST_NAME_TEXTBOX_ID)).sendKeys(lastName);
        if (!addressLine1.isEmpty()) getWebElement(By.id(EDIT_LINE1_TEXTBOX_ID)).sendKeys(addressLine1);
        if (!addressLine2.isEmpty()) getWebElement(By.id(EDIT_LINE2_TEXTBOX_ID)).sendKeys(addressLine2);
        if (!country.isEmpty()) selectFromDropDown((By.id(EDIT_COUNTRY_TEXTBOX_ID)), country);
        if (!state.isEmpty()) selectFromDropDown((By.id(EDIT_REGIONS_TEXTBOX_ID)), state);
        if (!phone.isEmpty()) getWebElement(By.id(EDIT_PHONE_TEXTBOX_ID)).sendKeys(phone);
        if (isDefaultShippingAddress) getWebElement(By.id(DEFAULT_SHIPPING_ADDRESS_ID)).click();
        if (isDefaultBillingAddress) getWebElement(By.id(DEFAULT_BILLING_ADDRESS_ID)).click();

        getWebElement(By.xpath(EDIT_SAVE_BUTTON_XPATH)).click();
        return new AddressBookPage(getDriver()).getPage(AddressBookPage.class);
    }


    /**
     * Cancel while editing the current address
     */
    public void cancelWhileEditingDefaultAddress(int index, String nickName, String firstName, String lastName, String addressLine1,
                                                 String addressLine2, String country, String state, String phone,
                                                 boolean isDefaultShippingAddress, boolean isDefaultBillingAddress) {
        clickEditOnDefaultAddress(index);
        getWebElement(By.id(ADDRESS_BOOK_LINK_XPATH)).click();
        getWebElement(By.id(EDIT_NICKNAME_TEXTFIELD_ID)).clear();

        if (!nickName.isEmpty()) getWebElement(By.id(EDIT_NICK_NAME_TEXTBOX_ID)).sendKeys(nickName);
        if (!firstName.isEmpty()) getWebElement(By.id(EDIT_FIRST_NAME_TEXTBOX_ID)).sendKeys(firstName);
        if (!lastName.isEmpty()) getWebElement(By.id(EDIT_LAST_NAME_TEXTBOX_ID)).sendKeys(lastName);
        if (!addressLine1.isEmpty()) getWebElement(By.id(EDIT_LINE1_TEXTBOX_ID)).sendKeys(addressLine1);
        if (!addressLine2.isEmpty()) getWebElement(By.id(EDIT_LINE2_TEXTBOX_ID)).sendKeys(addressLine2);
        if (!country.isEmpty()) selectFromDropDown((By.id(EDIT_COUNTRY_TEXTBOX_ID)), country);
        if (!state.isEmpty()) selectFromDropDown((By.id(EDIT_REGIONS_TEXTBOX_ID)), state);
        if (!phone.isEmpty()) getWebElement(By.id(EDIT_PHONE_TEXTBOX_ID)).sendKeys(phone);
        if (isDefaultShippingAddress) getWebElement(By.id(DEFAULT_SHIPPING_ADDRESS_ID)).click();
        if (isDefaultBillingAddress) getWebElement(By.id(DEFAULT_BILLING_ADDRESS_ID)).click();

        getWebElement(By.xpath(EDIT_CANCEL_BUTTON_XPATH)).click();
    }

    /**
     * Delete current address
     */
    public void deleteDefaultAddress(int index) {
        clickDeleteOnDefaultAddress(index);
        getWebElement(By.xpath(DELETE_CONFIRMATION_POPUP_XPATH)).click();
    }


    /**
     * Cancel while deleting current address
     */
    public void cancelWhileDeletionOfDefaultAddress(int index) {
        clickDeleteOnDefaultAddress(index);
        getWebElement(By.xpath(CANCEL_DELETION_BUTTON_XPATH)).click();
    }

    /**
     * Save new address
     */
    public AddressBookPage saveAddress(String nickName, String firstName, String lastName, String addressLine1,
                                       String addressLine2, String country, String state, String phone,
                                       boolean isDefaultShippingAddress, boolean isDefaultBillingAddress) {
        getWebElement(By.xpath(ADD_ADDRESS_BUTTON_XPATH)).click();
        getWebElement(By.id(NICK_NAME_TEXTBOX_ID)).sendKeys(nickName);
        getWebElement(By.id(FIRST_NAME_TEXTBOX_ID)).sendKeys(firstName);
        getWebElement(By.id(LAST_NAME_TEXTBOX_ID)).sendKeys(lastName);
        getWebElement(By.id(LINE1_TEXTBOX_ID)).sendKeys(addressLine1);
        getWebElement(By.id(LINE2_TEXTBOX_ID)).sendKeys(addressLine2);
        selectFromDropDown((By.id(COUNTRY_TEXTBOX_ID)), country);
        selectFromDropDown((By.id(REGIONS_TEXTBOX_ID)), state);
        getWebElement(By.id(PHONE_TEXTBOX_ID)).sendKeys(phone);

        if (isDefaultShippingAddress) getWebElement(By.id(DEFAULT_SHIPPING_ADDRESS_ID)).click();
        if (isDefaultBillingAddress) getWebElement(By.id(DEFAULT_BILLING_ADDRESS_ID)).click();

        getWebElement(By.id(SAVED_ADDRESS_BUTTON_ID)).click();
        return new AddressBookPage(getDriver()).getPage(AddressBookPage.class);
    }

    /**
     * Delete saved address
     */
    public void deleteSavedAddress(int index) {
        clickOnDeleteSavedAddress(index);
        getWebElement(By.xpath(DELETE_SAVED_ADDRESS_BUTTON_XPATH)).click();
    }


    /**
     * Get all other saved address
     *
     * @return
     */
    public List<String> getOtherSavedAddresses() {
        return null;
    }

    /**
     * Get all default address
     *
     * @return
     */
    public List<String> getDefaultAddresses() {
        return null;
    }

    private void clickEditOnDefaultAddress(int index) {
    }

    private void clickDeleteOnDefaultAddress(int index) {
    }

    private void clickOnDeleteSavedAddress(int index) {
    }

}
