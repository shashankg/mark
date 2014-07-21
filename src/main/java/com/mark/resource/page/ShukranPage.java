package com.mark.resource.page;

import com.mark.resource.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ShukranPage extends BasePage<ShukranPage> {


    private static final String SHUKRAN_LINK_XATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[7]/a";
    private static final String CREATE_SHUKRAN_ACCOUNT_BUTTON_XATH = ".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[1]/div/div/div/div/a";
    private static final String DOB_TEXTBOX_XATH = ".//*[@id='create-shukran-account-form']/fieldset[1]/div[1]/img";
    private static final String CALENDAR_DATE_XATH = ".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a";
    private static final String NATIONALITY_DROPDOWN_ID = "nationality";
    private static final String COUNTRY_DROPDOWN_ID = "country";
    private static final String CITY_DROPDOWN_ID = "city";
    private static final String ADDRESS_LINE1_ID = "address1";
    private static final String ADDRESS_LINE2_ID = "address2";
    private static final String POBOX_ID = "poBox";
    private static final String MOBILE_ID = "mobileNumber";
    private static final String SUBMIT_CHANGES_ID = "save-changes";
    private static final String SUCCESSFUL_SHUKRAN_ACCOUNT_MESSAGE_XPATH = ".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[1]/div/div/span[1]";
    private static final String UNLINK_SHUKRAN_ACCOUNT_XPATH = ".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[2]/div[3]";
    private static final String UNLINK_MESSAGE_XPATH = ".//*[@id='popup-shukran-unlink']/div/div/h3";
    private static final String CLOSE_UNLINK_WINDOW_XPATH = ".//*[@id='popup-shukran-unlink']/a";

    /**
     * Constructor
     *
     * @param driver
     */
    public ShukranPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/shukranHomePage";
    }

    /**
     * Create a Shukran Account
     *
     * @param nationality
     * @param state
     * @param city
     * @param addressLine1
     * @param addressLine2
     * @param poBoxNumber
     * @param mobile
     */
    public void createShukranAccount(String nationality, String state, String city, String addressLine1, String addressLine2, String poBoxNumber, String mobile)

    {
        getWebElement(By.xpath(SHUKRAN_LINK_XATH)).click();
        getWebElement(By.xpath(CREATE_SHUKRAN_ACCOUNT_BUTTON_XATH)).click();
        getWebElement(By.xpath(DOB_TEXTBOX_XATH)).click();
        getWebElement(By.xpath(CALENDAR_DATE_XATH)).click();
        selectFromDropDown(By.xpath(NATIONALITY_DROPDOWN_ID), nationality);
        selectFromDropDown(By.xpath(COUNTRY_DROPDOWN_ID), state);
        selectFromDropDown(By.xpath(CITY_DROPDOWN_ID), city);
        getWebElement(By.id(ADDRESS_LINE1_ID)).clear();
        getWebElement(By.id(ADDRESS_LINE1_ID)).sendKeys(addressLine1);
        getWebElement(By.id(ADDRESS_LINE2_ID)).clear();
        getWebElement(By.id(ADDRESS_LINE2_ID)).sendKeys(addressLine2);
        getWebElement(By.id(POBOX_ID)).sendKeys(poBoxNumber);
        getWebElement(By.id(MOBILE_ID)).sendKeys(mobile);
        getWebElement(By.id(SUBMIT_CHANGES_ID)).click();

    }

    /**
     * Unlink Shukran account
     */

    public void unlinkShukranAccount(String nationality, String state, String city, String addressLine1, String addressLine2, String poBoxNumber, String mobile) {
        getWebElement(By.xpath(SHUKRAN_LINK_XATH)).click();
        getWebElement(By.xpath(CREATE_SHUKRAN_ACCOUNT_BUTTON_XATH)).click();
        getWebElement(By.xpath(DOB_TEXTBOX_XATH)).click();
        getWebElement(By.xpath(CALENDAR_DATE_XATH)).click();
        selectFromDropDown(By.xpath(NATIONALITY_DROPDOWN_ID), nationality);
        selectFromDropDown(By.xpath(COUNTRY_DROPDOWN_ID), state);
        selectFromDropDown(By.xpath(CITY_DROPDOWN_ID), city);
        getWebElement(By.id(ADDRESS_LINE1_ID)).clear();
        getWebElement(By.id(ADDRESS_LINE1_ID)).sendKeys(addressLine1);
        getWebElement(By.id(ADDRESS_LINE2_ID)).clear();
        getWebElement(By.id(ADDRESS_LINE2_ID)).sendKeys(addressLine2);
        getWebElement(By.id(POBOX_ID)).sendKeys(poBoxNumber);
        getWebElement(By.id(MOBILE_ID)).sendKeys(mobile);
        getWebElement(By.id(SUBMIT_CHANGES_ID)).click();
        getWebElement(By.xpath(UNLINK_SHUKRAN_ACCOUNT_XPATH)).click();
        getWebElement(By.xpath(CLOSE_UNLINK_WINDOW_XPATH)).click();

    }

    public String getUnlinkShukranMessage() {
        return getWebElement(By.xpath(UNLINK_MESSAGE_XPATH)).getText();
    }

    public String getSuccessfulShukranAccountMessageXpathMessage() {
        return getWebElement(By.xpath(SUCCESSFUL_SHUKRAN_ACCOUNT_MESSAGE_XPATH)).getText();
    }


}
