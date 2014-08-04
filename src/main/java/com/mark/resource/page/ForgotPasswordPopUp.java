package com.mark.resource.page;

import com.mark.resource.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPopUp extends BasePage<ForgotPasswordPopUp> {
    private static final String FORGOT_EMAIL_ID_TEXTBOX_ID = "forgotPassword_email";
    private static final String SEND_PASSWORD_ID = "forgotPasswordButton";
    private static final String CLOSE_POP_UP_XPATH = ".//*[@id='popup-enter-email']/a";
    private static final String SUCCESSFUL_PASSWORD_RESET_MESSAGE_XPATH = ".//*[@id='popup-enter-email-confirm']/div/div/div/h3";
    private static final String RESEND_LINK_CSS = "a.open-popup:nth-child(1)";
    private static final String ENTER_EMAIL_MESSAGE_XPATH = ".//*[@id='forgotPassword']/fieldset/div/div/h3";

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
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
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
    public ForgotPasswordPopUp forgotPassword(String email) {
        sleep("PopUp to appear");
        getWebElement(By.id(FORGOT_EMAIL_ID_TEXTBOX_ID)).clear();
        getWebElement(By.id(FORGOT_EMAIL_ID_TEXTBOX_ID)).sendKeys(email);
        getWebElement(By.id(SEND_PASSWORD_ID)).submit();
        return this;
    }

    /**
     * Close the pop up
     */
    public void closePopUp() {
        getWebElement(By.xpath(CLOSE_POP_UP_XPATH)).click();
    }

    /**
     * @return
     */
    public ForgotPasswordPopUp resendPassword() {
        getWebElement(By.cssSelector(RESEND_LINK_CSS)).click();
        return new ForgotPasswordPopUp(getDriver()).getPage(ForgotPasswordPopUp.class);
    }

    /**
     * @return
     */
    public String getSuccessfulPasswordResetMessage() {
        return getWebElement(By.xpath(SUCCESSFUL_PASSWORD_RESET_MESSAGE_XPATH)).getText().trim();
    }
}
