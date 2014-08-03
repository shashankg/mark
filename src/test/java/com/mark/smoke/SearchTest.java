package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.dataprovider.TestData;
import com.mark.resource.component.SearchBar;
import com.mark.resource.component.SearchResultPage;
import com.mark.resource.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_search_bar_is_displayed() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchBar searchBar = homePage.getSearchBar();
        Assert.assertTrue(searchBar.isSearchBarDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_search_with_valid_keyword() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(TestData.validSearchKeyword);
        Assert.assertTrue(resultPage.isSearchResultDisplayed());
        Assert.assertTrue(resultPage.getCountOfSearchedProducts() > 0);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_specific_product_id() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(TestData.productId);
        Assert.assertTrue(resultPage.isSearchResultDisplayed());
        Assert.assertTrue(resultPage.getCountOfSearchedProducts() == 1);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_empty_keyword() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(" ");
        Assert.assertFalse(resultPage.isErrorDisplayed());
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_search_with_non_existing_item() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(TestData.inValidSearchKeyword);
        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_search_with_unicode_character() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(TestData.chineseKeyword);
        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_search_with_special_characters() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(TestData.specialCharKeyword);
        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }
}

