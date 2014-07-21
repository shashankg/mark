package com.mark.assertion;

import com.mark.resource.component.SearchBar;
import com.mark.resource.component.SearchResultPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SearchAssertion {
    private static final Logger logger = LoggerFactory.getLogger(SearchAssertion.class);

    public static void verifySearchBarIsDisplayed(SearchBar searchBar) {
        Assert.assertTrue(searchBar.isSearchBarDisplayed(), "Search Bar is not visible.");
        logger.info("[Assertion] Search Bar is visible.");
    }

    //FIXME: Assert more items
    public static void verifySuccessfulSearch(SearchResultPage resultPage) {
        Assert.assertTrue(resultPage.isSearchResultDisplayed(), "No Search Result is displayed.");
        logger.info("[Assertion] Search was successful.");
    }

    //FIXME: Assert more items
    public static void verifySuccessfulSearchForProduct(SearchResultPage resultPage, String productId) {
        Assert.assertTrue(resultPage.isSearchResultDisplayed(), "No Search Result is displayed for productId: " + productId);
        logger.info("[Assertion] Search successful for product: {}.", productId);
    }

    //FIXME: Assert more items
    public static void verifyNoSearchDone(SearchResultPage resultPage) {
        Assert.assertFalse(resultPage.isErrorDisplayed(), "Error is displayed, Its unexpected.");
        Assert.assertFalse(resultPage.isSearchResultDisplayed(), "Search Results are displayed, Its unexpected.");
        logger.info("[Assertion] No Search is done as expected.");
    }

    //FIXME: Assert more items
    public static void verifyUnsuccessfulSearch(SearchResultPage resultPage) {
        Assert.assertTrue(resultPage.isErrorDisplayed(), "Search Error message is not displayed");
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed(), "Search results are displayed, Its unexpected.");
        logger.info("[Assertion] Unsuccessful Search is done as expected.");
    }
}
