package com.mark.resource.page;

import com.shash.autoNG.core.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyDetailsPage extends BasePage<MyDetailsPage> {

    /**
     * Constructor
     *
     * @param driver
     */
    public MyDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/profile";
    }
}
