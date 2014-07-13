package com.mark.resource.component;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

/**
 * Created by shefali on 13/7/14.
 */
public class EndToEnd extends BasePage<EndToEnd> {

    private static final String HOVER_ELECTRONICS_XPATH = ".//*[@id='electronics']/a";
    private static final String MOBILE_HYPERLINK_ID = "Mobile Phones";
    private static final String MOBILE_DETAIL_XPATH = ".//*[@id='main']/div/div[3]/div[1]/div[3]/div[2]/div[1]/div/a/img";
    private static final String ADD_TO_BASKET_ID = "addToBasket";
    private static final String CHECKOUT_BUTTON_XPATH = "checkout";
    private static final String ADDRESS_ID = "addressNickName";
    private static final String FIRST_NAME_ID = "firstName";
    private static final String LAST_NAME_ID = "lastName";
    private static final String EMAIL_ID_ID = "emaill";
    private static final String ADDRESS_LINE1_ID = "line1";
    private static final String ADDRESS_LINE2_ID = "line2";
    private static final String REGION_XPATH = "regions";
    private static final String PHONE_XPATH = "phone";
    private static final String CONTINUE_TO_PAYMENT_XPATH = ".//*[@id='createLMGAddressForm']/div[2]/input";
    private static final String SHIPPING_DETAILS_CHECKBOX_XPATH = "sameBillingAsShipping";
    private static final String CARD_NUMBER_ID = "ccf-number";
    private static final String CARD_NAME_ID = "ccf-name";
    private static final String EXPIRY_MONTH_ID = "ccf-exp-month";
    private static final String EXPIRY_YEAR_ID = "ccf-exp-year";
    private static final String CVV_NUMBER_ID = "ccf-cvv";
    private static final String SUBMIT_PAYMENT_XPATH = ".//*[@id='createLMGAddressForm']/div[7]/input[5]";
    private static final String BOOK_PRODUCT_BUTTON_ID = "submitBtn2";
    private static final String CANCEL_FROM_PG_ID = "cmdSubmit";

    /**
     * Constructor
     *
     * @param driver
     */
    public EndToEnd(WebDriver driver) {
        super(driver);
    }


    public void searchElement()
    {
        logger.info("[End to End Functionality]:Trying to search an element");
        Actions build = new Actions(getDriver());
        WebElement hover = getWebElement(By.xpath("HOVER_ELECTRONICS_XPATH"));
        build.moveToElement(hover).build().perform();
        getWebElement(By.linkText("MOBILE_HYPERLINK_ID")).click();
        getWebElement(By.xpath("MOBILE_DETAIL_XPATH")).click();
    }

    public void addToBasket()
    {
        logger.info("[End to End Functionality]:Trying to add product to basket");
        getWebElement(By.id("ADD_TO_BASKET_ID")).click();
    }

    public void moveToCheckoutPage()
    {
        logger.info("[End to End Functionality]:Trying to click on checkout button");
        getWebElement(By.className("CHECKOUT_BUTTON_XPATH")).click();
    }

    public void fillShippingDetails(String address, String firstname,String lastname,String email,String addressline1,String addressline2,String phone)
    {
        logger.info("[End to End Functionality]:Trying to fill the shipping details with address: {}, firstname: {}, lastname: {}, email: {}, addressline1: {},addressline2: {}, phone: {}", address,firstname,lastname,email,addressline1,addressline2,phone);
        getWebElement(By.id("ADDRESS_ID")).sendKeys(address);
        getWebElement(By.id("FIRST_NAME_ID")).sendKeys(firstname);
        getWebElement(By.id("LAST_NAME_ID")).sendKeys(lastname);
        getWebElement(By.id("EMAIL_ID_ID")).sendKeys(email);
        getWebElement(By.id("ADDRESS_LINE1_ID")).sendKeys(addressline1);
        getWebElement(By.id("ADDRESS_LINE2_ID")).sendKeys(addressline2);
        selectFromDropDown(By.id("regions"), "Dubai");
        getWebElement(By.id("PHONE_XPATH")).sendKeys(phone);
    } 

    public void moveToPaymentPage()
    {
        logger.info("[End to End Functionality]: Trying to move to payment page");
        getWebElement(By.xpath("CONTINUE_TO_PAYMENT_XPATH")).click();
        getWebElement(By.id("SHIPPING_DETAILS_CHECKBOX_XPATH")).click();
    }

    public void fillCardDetails(String cardnumber,String nameoncard,String cvv)
    {
        logger.info("[End to End Functionality]: Trying to fill card details with nameoncard : {}", nameoncard);
        getWebElement(By.id("CARD_NUMBER_ID")).sendKeys(cardnumber);
        getWebElement(By.id("CARD_NAME_ID")).sendKeys(nameoncard);
        selectFromDropDown(By.id("EXPIRY_MONTH_ID"), "05");
        selectFromDropDown(By.id("EXPIRY_YEAR_ID"), "2022");
        getWebElement(By.id("CVV_NUMBER_ID")).sendKeys(cvv);
    }

    public void clickOnPayAndcancelFromPG()
    {
        logger.info("[End to End Functionality]:Trying to click on pay and cancel from PG");
        getWebElement(By.xpath("SUBMIT_PAYMENT_XPATH")).click();
        getWebElement(By.id("BOOK_PRODUCT_BUTTON_ID")).click();
        getWebElement(By.id("CANCEL_FROM_PG_ID")).click();
        getDriver().switchTo().alert().accept();
    }



    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return null;
    }

    @Override
    public String getPageUrl() {
        return null;
    }
}
