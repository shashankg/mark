package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void test_top_banner_visibility_and_navigation() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Assert.assertTrue(homePage.isTopBannerElementsDisplayed());
        Assert.assertTrue(homePage.isTopBannerNavigationEnabled());
    }

    @Test(groups = {"smoke"})
    public void test_mid_product_carousel_visibility_and_navigation() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Assert.assertTrue(homePage.isMidProductCarouselsElementsDisplayed());
        Assert.assertTrue(homePage.isMidBannerProductCarouselNavigationEnabled());
    }

    @Test(groups = {"smoke"})
    public void test_bottom_product_carousel_visibility_and_navigation() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Assert.assertTrue(homePage.isBottomProductCarouselElementsDisplayed());
        Assert.assertTrue(homePage.isBottomProductCarouselNavigationEnabled());
    }

    @Test(groups = {"smoke"})
    public void test_navigation_bar_is_visible_with_all_category() {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
        Assert.assertTrue(homePage.isNavigationBarElementsPresent());
    }
}
