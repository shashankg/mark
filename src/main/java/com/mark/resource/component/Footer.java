package com.mark.resource.component;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Footer extends BasePage<Footer> {

    private static final String FOOTER_ID = "footer";

    /**
     * Constructor
     *
     * @param driver
     */
    public Footer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(FOOTER_ID)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }
}
