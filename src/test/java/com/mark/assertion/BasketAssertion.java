package com.mark.assertion;

import com.mark.resource.component.Header;
import org.testng.Assert;

public class BasketAssertion extends BaseAssertion {
    public static void assertBasketIsVisible(Header header) {
        Assert.assertTrue(header.isBasketFlyoutVisible());
    }

    public static void assertBasketIsDisableWhenEmpty(Header header) {
        Assert.assertFalse(header.isBasketFlyoutEnabled());
    }

    public static void assertBasketItemCount(int basketItemCount, int expected) {
        Assert.assertEquals(basketItemCount, expected);
    }
}
