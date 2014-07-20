package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressBookPage extends BasePage<AddressBookPage> {

    private static final String ADD_NEW_ADDRESS_BUTTON_CLASS = "btn-blue-s btn-addaddress";
    private static final String ADDRESS_BOOK_LINK_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[3]/a";
    private static final String EDIT_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[1]/a";
    private static final String EDIT_NICKNAME_TEXTFIELD_ID = "nickname8812267864087_";
    private static final String EDIT_CANCEL_BUTTON_XPATH = ".//*[@id='LMGAddressForm8812267864087_']/div[2]/div[10]/a";
    private static final String EDIT_SAVE_BUTTON_XPATH = ".//*[@id='LMGAddressForm8812267864087_']/div[2]/div[10]/input";
    private static final String DELETE_BUTTON_XPATH= ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a";
    private static final String DELETE_CONFIRMATION_POPUP_XPATH = ".//*[@id='removeAddressForm']/div/input";
    private static final String CANCEL_DELETION_BUTTON_XPATH= ".//*[@id='removeAddressForm']/div/a";
    private static final String ADDING_ADDRESS_BUTTON_XPATH= ".//*[@id='main']/div/fieldset/div/div[2]/a";
    private static final String NICK_NAME_TEXTBOX_ID= "addressNickName";
    private static final String FIRST_NAME_TEXTBOX_ID= "firstName";
    private static final String LAST_NAME_TEXTBOX_ID= "lastName";
    private static final String LINE1_TEXTBOX_ID= "line1";
    private static final String LINE2_TEXTBOX_ID= "line2";
    private static final String COUNTRY_TEXTBOX_ID= "countryIsoDrop";
    private static final String REGIONS_TEXTBOX_ID= "regions";
    private static final String PHONE_TEXTBOX_ID= "phone";
    private static final String SAVED_ADDRESS_BUTTON_ID= "save-address";
    private static final String DELETE_SAVED_ADDRESS_BUTTON_XPATH= ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[3]/div[1]/ul/li[2]/a";
    private static final String EDIT_SAVED_ADDRESS_BUTTON_XPATH= ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[3]/div[1]/ul/li[1]/a";







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
    public void getEditCurrentAddressdetails(String newname)

    {
     getWebElement(By.id("ADDRESS_BOOK_LINK_XPATH")).click();
     getWebElement(By.id("EDIT_NICKNAME_TEXTFIELD_ID")).clear();
     getWebElement(By.id("EDIT_NICKNAME_TEXTFIELD_ID")).sendKeys(newname);
     getWebElement(By.xpath("EDIT_SAVE_BUTTON_XPATH")).click();
    }

    public void getCancelToEditTheCurrentAddress()
    {
      getWebElement(By.xpath("EDIT_CANCEL_BUTTON_XPATH")).click();
    }

    public void getDeleteTheCurrentAddress()
    {
        getWebElement(By.xpath("DELETE_BUTTON_XPATH")).click();
        getWebElement(By.xpath("DELETE_CONFIRMATION_POPUP_XPATH")).click();
    }

    public void getCancelDeletionOfCurrentAddress()
    {
        getWebElement(By.xpath("CANCEL_DELETION_BUTTON_XPATH")).click();
    }

    public void getSavingNewAddress(String nickname,String firstname,String lastname,String addressline1,String addressline2,String country,String state,String phone)
    {
        getWebElement(By.xpath("ADDING_ADDRESS_BUTTON_XPATH")).click();
        getWebElement(By.id("NICK_NAME_TEXTBOX_ID")).sendKeys(nickname);
        getWebElement(By.id("FIRST_NAME_TEXTBOX_ID")).sendKeys(firstname);
        getWebElement(By.id("LAST_NAME_TEXTBOX_ID")).sendKeys(lastname);
        getWebElement(By.id("LINE1_TEXTBOX_ID")).sendKeys(addressline1);
        getWebElement(By.id("LINE2_TEXTBOX_ID")).sendKeys(addressline2);
        selectFromDropDown((By.id("COUNTRY_TEXTBOX_ID")), country);
        selectFromDropDown((By.id("REGIONS_TEXTBOX_ID")),state);
        getWebElement(By.id("PHONE_TEXTBOX_ID")).sendKeys(phone);
        getWebElement(By.id("SAVED_ADDRESS_BUTTON_ID")).click();
    }

    public void getDeleteSavedNewAddress()
    {
        getWebElement(By.xpath("DELETE_SAVED_ADDRESS_BUTTON_XPATH")).click();
    }
}
