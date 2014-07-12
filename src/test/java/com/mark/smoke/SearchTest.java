package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.page.HomePage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test(groups = {"smoke"}, description = "Verify Search functionality")
    public void test_search() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        homePage.getSearchBar().search("Shirt");
    }
}

