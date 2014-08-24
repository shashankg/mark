package com.mark.resource.page;

import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchResultPage extends AutoNGBasePage<SearchResultPage> {
    private static final String ERROR_MESSAGE_XPATH = ".//*[@id='main']/div/div[2]/h3";
    private static final String FIRST_ITEM_XPATH = ".//*[@id='main']/div/div[2]/fieldset/div[1]/div[2]/div[1]/div[2]/h4/a";
    private static final String SEARCHED_QUANTITY_CSS = ".qty > span:nth-child(1)";

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/search";
    }

    /**
     * If the error message is displayed
     *
     * @return
     */
    public boolean isErrorDisplayed() {
        return isElementPresent(By.xpath(ERROR_MESSAGE_XPATH));
    }

    /**
     * Gets and return the error message displayed if any
     *
     * @return
     */
    public String getErrorMessage() {
        System.out.println(getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText());
        return getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText();
    }

    /**
     * Click on the 2nd item of search result
     *
     * @return
     */
    public ProductPage clickOnFirstItem() {
        getWebElement(By.xpath(FIRST_ITEM_XPATH)).click();
        return new ProductPage(getDriver()).getPage(ProductPage.class);
    }

    /**
     * @return
     */
    public boolean isSearchResultDisplayed() {
        return isElementPresent(By.xpath(FIRST_ITEM_XPATH));
    }

    public int getCountOfSearchedProducts() {
        return Integer.parseInt(getWebElement(By.cssSelector(SEARCHED_QUANTITY_CSS)).getText().replace("(", "").replace(")", ""));
    }
}
