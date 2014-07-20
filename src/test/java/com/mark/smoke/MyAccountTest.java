package com.mark.smoke;

import com.mark.BaseTest;

import com.mark.resource.component.Header;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.AddressBookPage;
import com.mark.resource.page.HomePage;
import org.testng.annotations.Test;
import com.mark.resource.page.LoginPage;
import org.testng.Assert;


/**
 * Created by shefali on 20/7/14.
 */
public class MyAccountTest extends BaseTest {
    private static final String username = "test123@test.com";
    private static final String password = "test@123";

    @Test(groups = {"smoke"})
    public void test_edit_of_address() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getHeader().login(username, password);
        AccountPage accountPage = homePage.getHeader().navigateToMyAccount();
        AddressBookPage addressBookPage = accountPage.navigateToAddressBook();

}
}