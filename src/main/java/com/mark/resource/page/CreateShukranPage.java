package com.mark.resource.page;

import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreateShukranPage extends BasePage<CreateShukranPage> {

    private static final String CREATE_SHUKRAN_ACCOUNT_BUTTON_XPATH = ".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[1]/div/div/div/div/a";
    private static final String DOB_TEXTBOX_XPATH = ".//*[@id='create-shukran-account-form']/fieldset[1]/div[1]/img";
    private static final String CALENDAR_DATE_XPATH = ".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a";
    private static final String NATIONALITY_DD_ID = "nationality";
    private static final String COUNTRY_DD_ID = "country";
    private static final String CITY_DD_ID = "city";
    private static final String ADDRESS_LINE1_ID = "address1";
    private static final String ADDRESS_LINE2_ID = "address2";
    private static final String PO_BOX_ID = "poBox";
    private static final String MOBILE_ID = "mobileNumber";
    private static final String SUBMIT_CHANGES_ID = "save-changes";

    /**
     * Constructor
     *
     * @param driver
     */
    public CreateShukranPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/goToCreateShukran";
    }

    /**
     * Create a Shukran Account
     *
     * @param nationality
     * @param country
     * @param city
     * @param addressLine1
     * @param addressLine2
     * @param poBoxNumber
     * @param mobile
     */
    public ShukranHomePage createShukranAccount(String nationality, String country, String city, String addressLine1,
                                                String addressLine2, int poBoxNumber, String mobile) {
        getWebElement(By.xpath(DOB_TEXTBOX_XPATH)).click();
        getWebElement(By.xpath(CALENDAR_DATE_XPATH)).click();
        selectFromDropDown(By.id(NATIONALITY_DD_ID), nationality);
        selectFromDropDown(By.id(COUNTRY_DD_ID), country);
        selectFromDropDown(By.id(CITY_DD_ID), city);
        getWebElement(By.id(ADDRESS_LINE1_ID)).clear();
        getWebElement(By.id(ADDRESS_LINE1_ID)).sendKeys(addressLine1);
        getWebElement(By.id(ADDRESS_LINE2_ID)).clear();
        getWebElement(By.id(ADDRESS_LINE2_ID)).sendKeys(addressLine2);
        getWebElement(By.id(PO_BOX_ID)).sendKeys(String.valueOf(poBoxNumber));
        getWebElement(By.id(MOBILE_ID)).sendKeys(mobile);
        getWebElement(By.id(SUBMIT_CHANGES_ID)).click();
        return new ShukranHomePage(getDriver()).getPage(ShukranHomePage.class);
    }

}
