package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.constant.Messages;
import com.mark.resource.page.*;
import com.shash.autoNG.utils.dataUtil.DataGenerator;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    private static final String username = "test123@test.com";
    private static final String password = "test@123";
    private static final String randomString = DataGenerator.generateAlphaNumericString(5);

    @Test(groups = {"smoke"})
    public void test_saving_a_new_address_in_address_book() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username, password);
        AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
        AddressBookPage addressBookPage = accountPage.navigateToAddressBook().
                saveAddress(randomString, randomString, randomString, randomString,
                        randomString, randomString, randomString, randomString, false, false);

        //Assert that address is saved
    }
    @Test(groups = {"smoke"})
    public void test_creation_of_shukran_account(){
        HomePage homePage= new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username,password);
        AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
        ShukranPage shukranPage = accountPage.navigateToShukran();
        shukranPage.createShukranAccount("","","","","","","");
        String successmessage = shukranPage.getSuccessfulShukranAccountMessageXpathMessage();
        Assert.assertEquals(successmessage, Messages.SHUKRAN_ACCOUNT_CREATED_MESSAGE);
    }
        //unlink your shukran account
      @Test(groups = {"smoke"})
        public void test_unlinking_of_shukran_account(){
            HomePage homePage= new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
            homePage.getHeader().login(username,password);
            AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
            ShukranPage shukranPage = accountPage.navigateToShukran();
            shukranPage.createShukranAccount("","","","","","","");
            String unlinkmessage = shukranPage.getUnlinkShukranMessage();
            Assert.assertEquals(unlinkmessage,Messages.MESSAGE_FOR_UNLINK_SHUKRAN_ACCOUNT);
         }

    @Test(groups = {"smoke"})
    public void test_saving_card(){
        HomePage homePage= new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username,password);
        AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
        PaymentOptionsPage paymentOptionsPage = accountPage.navigateToPaymentOptions();
        paymentOptionsPage.saveCardDetails("5555555555554444","test","08","2015","111",true,"test","test","test","test","test","test","test","test");
       org.testng.Assert.assertTrue(paymentOptionsPage.isNickNameDisplayed());
    }


    
}