package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressBookPage extends BasePage<AddressBookPage> {
    private static final String EDIT_BUTTON_XPATH =  ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[1]/a";
    private static final String DELETE_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a";
    private static final String ADD_NEW_ADDRESS_BUTTON_CLASS = "btn-blue-s btn-addaddress";


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
}
