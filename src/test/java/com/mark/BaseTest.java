package com.mark;

import com.mark.configuration.Configuration;
import com.mark.dataprovider.MarkTestData;
import com.mark.factory.WebDriverFactory;
import com.mark.resource.page.AccountPage;
import com.mark.resource.page.SignupPage;
import com.shash.autoNG.utils.clockUtil.ClockUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;

public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected static final String BASE_URL = Configuration.getBaseUrl();

    private static final String PHANTOM_LOG = "phantomjsdriver.log";
    private static final String VELOCITY_LOG = "velocity.log";


    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        logger.info("[Setup] WebDriver used: {}", Configuration.getDriverType());
    }

    @AfterSuite
    public void tearDown() {
        //Deleting phantom and velocity log
        File phantomLog = new File(PHANTOM_LOG);
        File velocityLog = new File(VELOCITY_LOG);

        if (phantomLog.exists()) phantomLog.deleteOnExit();
        if (velocityLog.exists()) phantomLog.deleteOnExit();

        logger.info("[TearDown] Complete.");
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
        return signupPage.signUp(MarkTestData.randomString, MarkTestData.randomString, email,
                MarkTestData.password, MarkTestData.password, MarkTestData.gender);
    }


}
