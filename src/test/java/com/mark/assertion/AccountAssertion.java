package com.mark.assertion;

import com.mark.constant.Messages;
import com.mark.dataprovider.TestData;
import com.mark.resource.page.AddressBookPage;
import com.mark.resource.page.PaymentOptionsPage;
import com.mark.resource.page.ShukranHomePage;
import org.testng.Assert;

public class AccountAssertion extends BaseAssertion {


    public static void assertNewAddressSaved(AddressBookPage addressBookPage) {
        Assert.assertTrue(addressBookPage.isFirstDefaultAddressAdded());
        Assert.assertTrue(addressBookPage.getFirstDefaultAddressAdded().contains(TestData.country));
        Assert.assertTrue(addressBookPage.getFirstDefaultAddressAdded().contains(TestData.city));
        Assert.assertTrue(addressBookPage.getFirstDefaultAddressAdded().contains(TestData.phone));
    }

    public static void assertSuccessfulShukrantAcntCreation(String successMessage) {
        Assert.assertEquals(successMessage, Messages.SHUKRAN_ACCOUNT_CREATED_MESSAGE);
    }

    public static void assertUnlinkingOfShukranAcnt(ShukranHomePage shukranHomePage) {
        Assert.assertEquals(shukranHomePage.getUnlinkShukranMessage(), Messages.MESSAGE_FOR_UNLINK_SHUKRAN_ACCOUNT);
        Assert.assertEquals(shukranHomePage.clickUnlinkShukranAccountAndGetMessage(), Messages.UNLINK_POP_UP_MESSAGE);
    }

    public static void assertPaymentOptionAddition(PaymentOptionsPage paymentOptionsPage) {
        Assert.assertTrue(paymentOptionsPage.isFirstPaymentOptionDetailsVisible());
        Assert.assertTrue(paymentOptionsPage.getFirstPaymentOptionDetails().contains("XXXX XXXX XXXX 4444"));
    }

}
