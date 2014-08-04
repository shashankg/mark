package com.mark.resource.component;

import com.mark.resource.BasePage;
import com.mark.resource.page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchBar extends BasePage<SearchBar> {
    private static final String SEARCH_BAR_ID = "text1";
    private static final String SEARCH_BTN_XPATH = ".//*[@id='search']/fieldset/input";

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchBar(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(SEARCH_BAR_ID)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    /**
     * Search an item
     *
     * @param lookingFor
     */
    public SearchResultPage search(String lookingFor) {
        logger.info("[Search] Looking for: {}", lookingFor);
        getWebElement(By.id(SEARCH_BAR_ID)).clear();
        getWebElement(By.id(SEARCH_BAR_ID)).sendKeys(lookingFor);
        getWebElement(By.xpath(SEARCH_BTN_XPATH)).click();
        return new SearchResultPage(getDriver()).getPage(SearchResultPage.class);
    }

    /**
     * If search bar is displayed or not
     *
     * @return
     */
    public boolean isSearchBarDisplayed() {
        return isElementPresentAndDisplay(By.id(SEARCH_BAR_ID)) &&
                isElementPresentAndDisplay(By.xpath(SEARCH_BTN_XPATH));
    }
}
