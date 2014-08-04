package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.BasketAssertion;
import com.mark.dataprovider.TestData;
import com.mark.resource.page.HomePage;
import com.mark.resource.page.ProductPage;
import com.mark.resource.page.ShoppingBasketPage;
import org.testng.annotations.Test;

public class ShoppingBasketTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_basket_flyout_is_visible() {
        HomePage homePage = loadHomepage();
        BasketAssertion.assertBasketIsVisible(homePage.getHeader());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "test_basket_flyout_is_visible")
    public void test_basket_flyout_is_disabled_when_basket_is_emtpy() {
        HomePage homePage = loadHomepage();
        BasketAssertion.assertBasketIsDisableWhenEmpty(homePage.getHeader());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "test_basket_flyout_is_visible")
    public void test_adding_item_to_basket() {
        ProductPage productPage = loadHomepage().getSearchBar().search(TestData.searchKeyword).
                clickOnFirstItem().addProductToBasket(1);

        int basketItemCount = productPage.getHeader().getShoppingBasketItemCount();
        BasketAssertion.assertBasketItemCount(basketItemCount, 1);
    }

    @Test(groups = {"smoke"})
    public void test_removing_item_from_basket() {
        loadHomepage().getSearchBar().search(TestData.searchKeyword).clickOnFirstItem().addProductToBasket(1);
        ShoppingBasketPage shoppingBasketPage = loadShoppingBasketPage().removeFirstItem();
        shoppingBasketPage.refresh();

        int basketItemCount = shoppingBasketPage.getHeader().getShoppingBasketItemCount();
        BasketAssertion.assertBasketItemCount(basketItemCount, 0);
    }
}
