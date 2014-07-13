package com.mark.smoke;

import com.mark.BaseTest;
import com.mark.resource.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by shefali on 13/7/14.
 */
public class EndToEndTest extends BaseTest {
    @Test(groups = {"smoke"}, description = "Verify SignUp functionality")
    public void endToEndFonctinalityCheck()
    {
        HomePage homePage = new HomePage(getDriver()).openPage(HomePage.class, BASE_URL);
       // homePage.


    }

}
