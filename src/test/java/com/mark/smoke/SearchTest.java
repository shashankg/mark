package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.SearchAssertion;
import com.mark.dataprovider.TestData;
import com.mark.resource.component.SearchBar;
import com.mark.resource.page.SearchResultPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_search_bar_is_displayed() {
        SearchBar searchBar = loadHomepage().getSearchBar();
        SearchAssertion.assertSearchBarIsVisible(searchBar);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_valid_keyword() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.validSearchKeyword);
        SearchAssertion.assertSearchResults(resultPage);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_specific_product_id() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.productId);
        SearchAssertion.assertSearchResultForAProduct(resultPage);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_empty_keyword() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(" ");
        SearchAssertion.assertSearchFOrEmptyKeyword(resultPage);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_non_existing_item() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.inValidSearchKeyword);
        SearchAssertion.assertUnSuccessfulSearch(resultPage);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_unicode_character() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.chineseKeyword);
        SearchAssertion.assertUnSuccessfulSearch(resultPage);
    }

    @Test(groups = {"smoke"})
    public void test_search_with_special_characters() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.specialCharKeyword);
        SearchAssertion.assertUnSuccessfulSearch(resultPage);
    }
}

