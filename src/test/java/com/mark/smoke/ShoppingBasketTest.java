package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.dataprovider.MarkTestData;
import com.mark.resource.component.SearchResultPage;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingBasketTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_basket_flyout_is_visible() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Assert.assertTrue(homePage.getHeader().isBasketFlyoutVisible());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "test_basket_flyout_is_visible")
    public void test_basket_flyout_is_disabled_when_basket_is_emtpy() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Assert.assertFalse(homePage.getHeader().isBasketFlyoutEnabled());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "test_basket_flyout_is_visible")
    public void test_adding_item_to_basket() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage searchResultPage = homePage.getSearchBar().search(MarkTestData.searchKeyword);
        ProductPage productPage = searchResultPage.clickOnFirstItem();
        productPage.addProductToBasket(1);

        int basketItemCount = productPage.getHeader().getShoppingBasketItemCount();
        Assert.assertEquals(basketItemCount, 1);
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "test_basket_flyout_is_visible")
    public void test_removing_item_from_basket() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        SearchResultPage searchResultPage = homePage.getSearchBar().search(MarkTestData.searchKeyword);
        ProductPage productPage = searchResultPage.clickOnFirstItem();
        productPage.addProductToBasket(1);

        productPage.refresh();
        productPage.getHeader().removeFirstItemFromBasket();
        productPage.refresh();

        int basketItemCount = productPage.getHeader().getShoppingBasketItemCount();
        Assert.assertEquals(basketItemCount, 0);
    }

    

}
