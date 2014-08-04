package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.AccountAssertion;
import com.mark.dataprovider.TestData;
import com.mark.resource.page.*;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_saving_a_new_address_in_address_book() {
        AccountPage accountPage = signupAndGetAccountPage();
        AddressBookPage addressBookPage = accountPage.navigateToAddressBook().
                saveAddress(TestData.randomString, TestData.randomString, TestData.randomString, TestData.randomString,
                        TestData.randomString, TestData.country, TestData.city, TestData.phone, false, false);
        
        AccountAssertion.assertNewAddressSaved(addressBookPage);
    }

    @Test(groups = {"smoke"})
    public void test_saving_a_new_address_in_address_book_with_invalid_params() {
        AccountPage accountPage = signupAndGetAccountPage();
        AddressBookPage addressBookPage = accountPage.navigateToAddressBook().
                saveAddress(" ", TestData.randomString, TestData.randomString, TestData.randomString,
                        TestData.randomString, TestData.country, TestData.city, TestData.phone, false, false);
        
        AccountAssertion.assertErrorMessage(addressBookPage.getErrorMsg());
    }

    @Test(groups = {"smoke"})
    public void test_creation_of_shukran_account() {
        AccountPage accountPage = signupAndGetAccountPage();
        CreateShukranPage createShukranPage = accountPage.navigateToShukran().navigateToCreateShukranPage();
        ShukranHomePage shukranHomePage = createShukranPage.createShukranAccount(TestData.nationality, TestData.country, TestData.city,
                TestData.randomString, TestData.randomString, TestData.pincode, TestData.phone);
        
        AccountAssertion.assertShukranAccountCreation(shukranHomePage.getSuccessfulShukranAccountMessage());
    }

    @Test(groups = {"smoke"})
    public void test_unLinking_of_shukran_account() {
        AccountPage accountPage = signupAndGetAccountPage();
        CreateShukranPage createShukranPage = accountPage.navigateToShukran().navigateToCreateShukranPage();
        ShukranHomePage shukranHomePage = createShukranPage.createShukranAccount(TestData.nationality, TestData.country, TestData.city,
                TestData.randomString, TestData.randomString, TestData.pincode, TestData.phone);
        
        AccountAssertion.assertUnlinkingShukranAccount(shukranHomePage);
    }

    @Test(groups = {"smoke"})
    public void test_saving_card_though_payments_page() {
        AccountPage accountPage = signupAndGetAccountPage();
        PaymentOptionsPage paymentOptionsPage = accountPage.navigateToPaymentOptions().
                addNewPaymentOption().saveCardDetails(TestData.cc, TestData.randomString, "08", "2015", "111", true, TestData.randomString,
                TestData.randomString, TestData.randomString, TestData.randomString, TestData.randomString, TestData.country, TestData.city, TestData.phone);
        
        AccountAssertion.assertPaymentOptionAddition(paymentOptionsPage);
    }

    @Test(groups = {"smoke"})
    public void test_saving_card_though_payments_page_with_invalid_details() {
        AccountPage accountPage = signupAndGetAccountPage();
        AddPaymentOptionPopUp addPaymentOptionPopUp = accountPage.navigateToPaymentOptions().addNewPaymentOption();
        addPaymentOptionPopUp.saveCardDetails(" ", TestData.randomString, "08", "2015", "111", true, TestData.randomString,
                TestData.randomString, TestData.randomString, TestData.randomString, TestData.randomString, TestData.country, TestData.city, TestData.phone);
        
        AccountAssertion.assertErrorMessage(addPaymentOptionPopUp.getErrorMessage());
    }
}