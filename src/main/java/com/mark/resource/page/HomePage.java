package com.mark.resource.page;

import com.mark.resource.BasePage;
import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.mark.resource.component.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage<HomePage> {

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
}
