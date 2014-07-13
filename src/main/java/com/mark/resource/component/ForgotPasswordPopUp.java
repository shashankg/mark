package com.mark.resource.component;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPopUp extends BasePage<ForgotPasswordPopUp> {
    private static final String FORGOT_EMAIL_ID = "";
    private static final String SEND_PASSWORD_ID = "";
    private static final String CLOSE_POP_UP_ID = "";

    /**
     * Constructor
     *
     * @param driver
     */
    public ForgotPasswordPopUp(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id(FORGOT_EMAIL_ID)));
    }

    @Override
    public String getPageUrl() {
        return "";
    }


    /**
     * Forgot Password functionality
     *
     * @param email
     */
    public void forgotPassword(String email) {
        getWebElement(By.id(FORGOT_EMAIL_ID)).sendKeys(email);
        getWebElement(By.id(SEND_PASSWORD_ID)).submit();
    }

    /**
     * Close the pop up
     */
    public void closePopUp() {
        getWebElement(By.id(CLOSE_POP_UP_ID)).click();
    }
}
