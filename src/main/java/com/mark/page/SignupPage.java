package com.mark.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class SignupPage extends BasePage<SignupPage> {

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "fakepassword")
    private WebElement newPassword;

    @FindBy(id = "fakeconfirmPassword")
    private WebElement confirmNewPassword;

    @FindBy(id = "gender")
    private WebElement gender;

    @FindBy(id = "submit")
    private WebElement signUpButton;



    public SignupPage(WebDriver webDriver) {
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



    /**
     * Login functionality
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param newpassword
     * @param confirmnewpassword
     * @param gender
     * @return this
     */
    public SignupPage signup(String firstname, String lastname, String email,String newpassword,String confirmnewpassword,String gender) {
        logger.info("Trying to login with username: {}, password: {}" + firstname + " " + lastname);
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastname);
        this.email.sendKeys(email);
        this.newPassword.sendKeys(newpassword);
        this.confirmNewPassword.sendKeys(confirmnewpassword);
        this.gender.sendKeys(gender);

        return this;
    }

}
