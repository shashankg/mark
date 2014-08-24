package com.mark.resource.page;

import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.mark.resource.component.SearchBar;
import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends AutoNGBasePage<HomePage> {
    private static final String TOP_BANNER_CSS = ".sliders-holder > li:nth-child(2) > a:nth-child(1)";
    private static final String TOP_BANNER_NEXT_CSS = ".gallery-block > a:nth-child(2)";
    private static final String TOP_BANNER_PREVIOUS_CSS = ".gallery-block > a:nth-child(1)";

    private static final String MID_BANNER_CSS = "div.bestsellers-block--new:nth-child(1) > div:nth-child(2)";
    private static final String MID_BANNER_NEXT_CSS = "div.bestsellers-block--new:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(2)";
    private static final String MID_BANNER_PREVIOUS_CSS = "div.bestsellers-block--new:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)";

    private static final String BOTTOM_BANNER_CSS = "div.bestsellers-block--new:nth-child(2) > div:nth-child(2)";
    private static final String BOTTOM_BANNER_NEXT_CSS = "div.bestsellers-block--new:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(2)";
    private static final String BOTTOM_BANNER_PREVIOUS_CSS = "div.bestsellers-block--new:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)";

    private static final String NAVIGATION_HOME_CSS = ".icon-house";
    private static final String NAVIGATION_WOMEN_id = "#women > a:nth-child(1)";
    private static final String NAVIGATION_MEN_CSS = "#men > a:nth-child(1)";
    private static final String NAVIGATION_BABY_CSS = "#baby & child > a:nth-child(1)";
    private static final String NAVIGATION_ELECTRONICS_CSS = "#electronics > a:nth-child(1)";
    private static final String NAVIGATION_LOOK_BOOK_CSS = "#lookbooks > a:nth-child(1)";
    private static final String NAVIGATION_COLLECTION_CSS = "#collections > a:nth-child(1)";
    private static final String NAVIGATION_OFFERS_CSS = "#offers > a:nth-child(1)";
    private static final String NAVIGATION_SHOP_BY_BRANDS_CSS = "#shop by brand > a:nth-child(1)";


    private Header header;
    private Footer footer;
    private SearchBar searchBar;

    /**
     * Constructor
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.searchBar = new SearchBar(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public Header getHeader() {
        return this.header;
    }

    public Footer getFooter() {
        return this.footer;
    }

    public SearchBar getSearchBar() {
        return this.searchBar;
    }

    public boolean isTopBannerElementsDisplayed() {
        return isElementPresent(By.cssSelector(TOP_BANNER_CSS)) &&
                isElementPresent(By.cssSelector(TOP_BANNER_NEXT_CSS)) &&
                isElementPresent(By.cssSelector(TOP_BANNER_PREVIOUS_CSS));
    }

    public boolean isTopBannerNavigationEnabled() {
        try {
            getWebElement(By.cssSelector(TOP_BANNER_NEXT_CSS)).click();
            getWebElement(By.cssSelector(TOP_BANNER_PREVIOUS_CSS)).click();
        } catch (Exception e) {
            logger.info("Exception during clicking next/previous link => {}", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isMidProductCarouselsElementsDisplayed() {
        return isElementPresent(By.cssSelector(MID_BANNER_CSS)) &&
                isElementPresent(By.cssSelector(MID_BANNER_NEXT_CSS)) &&
                isElementPresent(By.cssSelector(MID_BANNER_PREVIOUS_CSS));
    }

    public boolean isMidBannerProductCarouselNavigationEnabled() {
        try {
            getWebElement(By.cssSelector(MID_BANNER_NEXT_CSS)).click();
            getWebElement(By.cssSelector(MID_BANNER_PREVIOUS_CSS)).click();
        } catch (Exception e) {
            logger.info("Exception during clicking next/previous link => {}", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isBottomProductCarouselElementsDisplayed() {
        return isElementPresent(By.cssSelector(BOTTOM_BANNER_CSS)) &&
                isElementPresent(By.cssSelector(BOTTOM_BANNER_NEXT_CSS)) &&
                isElementPresent(By.cssSelector(BOTTOM_BANNER_PREVIOUS_CSS));
    }

    public boolean isBottomProductCarouselNavigationEnabled() {
        try {
            getWebElement(By.cssSelector(BOTTOM_BANNER_NEXT_CSS)).click();
            getWebElement(By.cssSelector(BOTTOM_BANNER_PREVIOUS_CSS)).click();
        } catch (Exception e) {
            logger.info("Exception during clicking next/previous link => {}", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isNavigationBarElementsPresent() {
        return isElementPresentAndDisplay(By.cssSelector(NAVIGATION_HOME_CSS)) &&
                isElementPresentAndDisplay(By.cssSelector(NAVIGATION_WOMEN_id)) &&
                isElementPresentAndDisplay(By.cssSelector(NAVIGATION_MEN_CSS)) &&
//                isElementPresent(By.cssSelector(NAVIGATION_BABY_CSS)) &&
                isElementPresentAndDisplay(By.cssSelector(NAVIGATION_ELECTRONICS_CSS)) &&
                isElementPresentAndDisplay(By.cssSelector(NAVIGATION_LOOK_BOOK_CSS)) &&
                isElementPresentAndDisplay(By.cssSelector(NAVIGATION_COLLECTION_CSS)) &&
                isElementPresentAndDisplay(By.cssSelector(NAVIGATION_OFFERS_CSS));
//                &&isElementPresent(By.cssSelector(NAVIGATION_SHOP_BY_BRANDS_CSS));
    }
}
