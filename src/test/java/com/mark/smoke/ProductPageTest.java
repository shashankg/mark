package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.assertion.BasketAssertion;
import com.mark.dataprovider.TestData;
import com.mark.resource.page.ProductPage;
import com.mark.resource.page.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_visibility_of_breadcrumb_on_product_page() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.searchKeyword);
        ProductPage productPage = resultPage.clickOnFirstItem();

        Assert.assertTrue(productPage.isBreadcrumbVisible());
    }

    @Test(groups = {"smoke"})
    public void test_visibility_of_quantity_and_add_to_basket_elements() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search(TestData.searchKeyword);
        ProductPage productPage = resultPage.clickOnFirstItem();

        Assert.assertTrue(productPage.isAddToBasketVisible());
        Assert.assertTrue(productPage.isQuantityVisible());
        Assert.assertTrue(productPage.isPriceVisible());
    }

    @Test(groups = {"smoke"})
    public void test_a_product_with_color_size() {
        SearchResultPage resultPage = loadHomepage().getSearchBar().search("shirt");
        ProductPage productPage = resultPage.clickOnFirstItem();
        productPage.addProductToBasketWithSize(1);

        int basketItemCount = productPage.getHeader().getShoppingBasketItemCount();
        BasketAssertion.assertBasketItemCount(basketItemCount, 1);
    }
}
