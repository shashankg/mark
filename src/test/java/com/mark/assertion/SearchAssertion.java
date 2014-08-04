package com.mark.assertion;

import com.mark.resource.component.SearchBar;
import com.mark.resource.page.SearchResultPage;
import org.testng.Assert;

public class SearchAssertion extends BaseAssertion {
    public static void assertSearchBarIsVisible(SearchBar searchBar) {
        Assert.assertTrue(searchBar.isSearchBarDisplayed());
    }

    public static void assertSearchResults(SearchResultPage resultPage) {
        Assert.assertTrue(resultPage.isSearchResultDisplayed());
        Assert.assertTrue(resultPage.getCountOfSearchedProducts() > 0);
    }

    public static void assertSearchResultForAProduct(SearchResultPage resultPage) {
        Assert.assertTrue(resultPage.isSearchResultDisplayed());
        Assert.assertTrue(resultPage.getCountOfSearchedProducts() == 1);
    }

    public static void assertSearchFOrEmptyKeyword(SearchResultPage resultPage) {
        Assert.assertFalse(resultPage.isErrorDisplayed());
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }

    public static void assertUnSuccessfulSearch(SearchResultPage resultPage) {
        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }
}
