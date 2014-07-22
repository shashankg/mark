package com.mark.resource.component;

import com.mark.resource.BasePage;
import com.mark.resource.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPopUp extends BasePage<ForgotPasswordPopUp> {
    private static final String FORGOT_EMAIL_ID_TEXTBOX_XPATH = "forgotPassword_email";
    private static final String SEND_PASSWORD_ID = "forgotPasswordButton";
    private static final String CLOSE_POP_UP_XPATH = ".//*[@id='popup-enter-email']/a";
    private static final String SUCCESSFUL_PASSWORD_RESET_MESSAGE_XPATH = ".//*[@id='popup-enter-email-confirm']/div/div/div/h3";
    private static final String RESEND_LINK_XPATH = ".//*[@id='popup-enter-email-confirm']/div/div/div/p/a";
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
        return ExpectedConditions.visibilityOf(getWebElement(By.xpath(FORGOT_EMAIL_ID_TEXTBOX_XPATH)));
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
        getWebElement(By.xpath(FORGOT_EMAIL_ID_TEXTBOX_XPATH)).sendKeys(email);
        getWebElement(By.id(SEND_PASSWORD_ID)).submit();
        return this;

    }

    /**
     * Close the pop up
     */
    public void closePopUp() {
        getWebElement(By.id(CLOSE_POP_UP_XPATH)).click();
    }

    public ForgotPasswordPopUp resendPassword() {
        getWebElement(By.xpath(RESEND_LINK_XPATH)).click();
        return new ForgotPasswordPopUp(getDriver()).getPage(ForgotPasswordPopUp.class);
    }


    public String getMessageToEnterEmail() {
        return getWebElement(By.xpath(ENTER_EMAIL_MESSAGE_XPATH)).getText();
    }

    public String getSuccessfulPasswordResetMessage() {
        return getWebElement(By.xpath(SUCCESSFUL_PASSWORD_RESET_MESSAGE_XPATH)).getText();
    }


}
