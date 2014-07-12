package com.mark.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage<HomePage> {

    private Header header;

    /**
     * Constructor
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/ul/li[1]/a[2]")));
    }

    @Override
    public String getPageUrl() {
        return "";
    }
}
