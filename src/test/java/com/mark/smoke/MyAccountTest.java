package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.AddressBookPage;
import com.mark.resource.page.HomePage;
import com.shash.autoNG.utils.dataUtil.DataGenerator;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    private static final String username = "test123@test.com";
    private static final String password = "test@123";
    private static final String randomString = DataGenerator.generateAlphaNumericString(5);

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
}