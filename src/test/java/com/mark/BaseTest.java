package com.mark;

import com.mark.configuration.Configuration;
import com.mark.factory.WebDriverFactory;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.SignupPage;
import com.shash.autoNG.utils.clockUtil.ClockUtil;
import com.shash.autoNG.utils.dataUtil.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected static final String BASE_URL = Configuration.getBaseUrl();

    protected static final String randomString = DataGenerator.generateAlphaNumericString(5);
    protected static final String username = "test123@test.com";
    protected static final String password = "test@123";


    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        logger.info("[Setup] WebDriver used: {}", Configuration.getDriverType());
    }

    @BeforeMethod
    public void notifyStartOfTestCase(Method method) {
        System.out.println();
        System.out.println("\n******** Starting Test Case: " + method.getName() + " ********\n");
        this.driver = WebDriverFactory.prepareWebDriver();
        logger.info("[Setup] Opening Browser");
        System.out.println();
    }

    @AfterMethod
    public void notifyEndOfTestCase(Method method) {
        logger.info("[TearDown] Closing Browser");
        this.driver.close();
        this.driver.quit();
        System.out.println();
        System.out.println("\n******** Finished Test Case: " + method.getName() + " ********\n");
        System.out.println();
    }

    /**
     * @return web driver
     */
    protected WebDriver getDriver() {
        return this.driver;
    }

    /**
     * @param reason
     */
    protected void sleep(String reason) {
        try {
            ClockUtil.sleepingFor(reason, Configuration.getGlobalSleepTimeInMS());
        } catch (InterruptedException e) {
            logger.info("[Sleeping] Not able to sleep, Error: {}", e.getMessage());
        }
    }

    /**
     * Signup and get account page
     *
     * @return
     */
    protected AccountPage signupAndGetAccountPage() {
        String email = System.currentTimeMillis() + "@email.com";
        SignupPage signupPage = new SignupPage(getDriver()).openPage(SignupPage.class, BASE_URL);
        return signupPage.signUp(randomString, randomString, email, randomString, randomString, "male");
    }


}
