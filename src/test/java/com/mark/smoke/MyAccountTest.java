package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.constant.Messages;
import com.mark.resource.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_saving_a_new_address_in_address_book() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username, password);
        sleep("Login Completion");
        AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
        AddressBookPage addressBookPage = accountPage.navigateToAddressBook().
                saveAddress(randomString, randomString, randomString, randomString,
                        randomString, randomString, randomString, randomString, false, false);

        //Assert that address is saved
    }

    @Test(groups = {"smoke"})
    public void test_creation_of_shukran_account() {
        AccountPage accountPage = signupAndGetAccountPage();
        CreateShukranPage createShukranPage = accountPage.navigateToShukran().navigateToCreateShukranPage();
        ShukranHomePage shukranHomePage = createShukranPage.createShukranAccount("India", "UAE", "Dubai",
                randomString, randomString, 122122, "1234567890");
        String successMessage = shukranHomePage.getSuccessfulShukranAccountMessage();
        Assert.assertEquals(successMessage, Messages.SHUKRAN_ACCOUNT_CREATED_MESSAGE);
    }

    @Test(groups = {"smoke"})
    public void test_unLinking_of_shukran_account() {
        AccountPage accountPage = signupAndGetAccountPage();
        CreateShukranPage createShukranPage = accountPage.navigateToShukran().navigateToCreateShukranPage();
        ShukranHomePage shukranHomePage = createShukranPage.createShukranAccount("India", "UAE", "Dubai",
                randomString, randomString, 122122, "1234567890");

        Assert.assertEquals(shukranHomePage.getUnlinkShukranMessage(), Messages.MESSAGE_FOR_UNLINK_SHUKRAN_ACCOUNT);
        Assert.assertEquals(shukranHomePage.clickUnlinkShukranAccountAndGetMessage(), Messages.UNLINK_POP_UP_MESSAGE);
    }

    @Test(groups = {"smoke"})
    public void test_saving_card() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username, password);
        AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
        PaymentOptionsPage paymentOptionsPage;
        paymentOptionsPage = accountPage.navigateToPaymentOptions();
        paymentOptionsPage.saveCardDetails("5555555555554444", "test", "08", "2015", "111", true, "test",
                "test", "test", "test", "test", "test", "test", "test");
        Assert.assertTrue(paymentOptionsPage.isNickNameDisplayed());
    }
}