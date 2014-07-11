package com.mark.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class HomePage extends BasePage<HomePage> {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public ExpectedCondition getPageLoadCondition() {
        return null;
    }

    @Override
    public String getPageUrl() {
        return null;
    }
}
