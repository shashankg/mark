package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.component.SearchBar;
import com.mark.resource.component.SearchResultPage;
import com.mark.resource.page.HomePage;
import org.testng.Assert;
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

        Assert.assertTrue(searchBar.isSearchBarDisplayed());
    }


    @Test(groups = {"smoke"})
    public void test_search_with_valid_keyword() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(validSearchKeyword);

        Assert.assertTrue(resultPage.isSearchResultDisplayed());
        //FIXME: Assert items are mobile on result page
    }

    @Test(groups = {"smoke"})
    public void test_search_with_specific_product_id() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(productId);

        Assert.assertTrue(resultPage.isSearchResultDisplayed());
        //FIXME: Assert items are mobile on result page
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
        SearchResultPage resultPage = homePage.getSearchBar().search(inValidSearchKeyword);

        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_search_with_unicode_character() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(chineseKeyword);

        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }

    @Test(groups = {"smoke"})
    public void test_search_with_special_characters() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage resultPage = homePage.getSearchBar().search(specialCharKeyword);

        Assert.assertTrue(resultPage.isErrorDisplayed());
        Assert.assertTrue(resultPage.getErrorMessage().contains("Sorry there are no matches for"));
        Assert.assertFalse(resultPage.isSearchResultDisplayed());
    }
}

