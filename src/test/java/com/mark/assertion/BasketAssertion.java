package com.mark.assertion;

import com.mark.resource.page.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class BasketAssertion {
    private static final Logger logger = LoggerFactory.getLogger(BasketAssertion.class);

    public static void verifyShoppingBasketIsVisible(HomePage homePage) {
        Assert.assertTrue(homePage.getHeader().isBasketFlyoutVisible(), "Shopping Basket Flyout is not visible.");
        logger.info("[Assertion] Shopping Basket Flyout is visible.");
    }

    public static void verifyBasketFlyoutIsDisabled(HomePage homePage) {
        Assert.assertFalse(homePage.getHeader().isBasketFlyoutEnabled(), "Shopping Basket Flyout is enabled.");
        logger.info("[Assertion] Shopping Basket Flyout is disabled.");
    }

    public static void verifyBasketCount(int actualBasketItemCount, int expectedBasketItemCount) {
        Assert.assertEquals(actualBasketItemCount, expectedBasketItemCount, "Basket item count is not wrong");
        logger.info("[Assertion] Basket item count is as per expected value.");
    }


}
