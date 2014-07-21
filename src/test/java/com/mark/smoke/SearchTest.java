package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.SearchAssertion;
import com.mark.resource.component.SearchBar;
import com.mark.resource.component.SearchResultPage;
import com.mark.resource.page.HomePage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    private static final String validSearchKeyword = "Mobile";
    private static final String inValidSearchKeyword = "XXXXXXX";
    private static final String chineseKeyword = "字母";
    private static final String specialCharKeyword = "!@#$%^&*()";
    private static final String productId = "154574273";

    @Test(groups = {"smoke"})
    public void test_search_bar_is_displayed() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchBar searchBar = homePage.getSearchBar();
        SearchAssertion.verifySearchBarIsDisplayed(searchBar);
    }


    @Test(groups = {"smoke"})
    public void test_search_with_valid_keyword() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(validSearchKeyword);
        SearchAssertion.verifySuccessfulSearch(resultPage);
    }


    @Test(groups = {"smoke"})
    public void test_search_with_specific_product_id() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(productId);
        SearchAssertion.verifySuccessfulSearchForProduct(resultPage, productId);
    }


    @Test(groups = {"smoke"})
    public void test_search_with_empty_keyword() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(" ");
        SearchAssertion.verifyNoSearchDone(resultPage);
    }


    @Test(groups = {"smoke"})
    public void test_search_with_non_existing_item() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(inValidSearchKeyword);
        SearchAssertion.verifyUnsuccessfulSearch(resultPage);
    }


    @Test(groups = {"smoke"})
    public void test_search_with_unicode_character() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(chineseKeyword);
        SearchAssertion.verifyUnsuccessfulSearch(resultPage);
    }


    @Test(groups = {"smoke"})
    public void test_search_with_special_characters() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(specialCharKeyword);
        SearchAssertion.verifyUnsuccessfulSearch(resultPage);
    }
}

