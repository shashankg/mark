package com.mark;

import com.mark.config.Config;
import com.mark.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        logger.info("[Setup] WebDriver used: {}", Config.getDriverType());
        this.driver = WebDriverFactory.prepareWebDriver();
        this.driver.manage().window();
        logger.info("[Setup] Setup complete.");
    }

    @AfterClass
    public void tearDown() {
        logger.info("[TearDown] Tearing down...");
        this.driver.close();
        this.driver.quit();
        logger.info("[TearDown] Tear down complete");
    }

    @BeforeMethod
    public void notifyStartOfTestCase(Method method) {
        System.out.println();
        System.out.println("\n******** Starting Test Case: " + method.getName() + " ********\n");
        System.out.println();
    }

    @AfterMethod
    public void notifyEndOfTestCase(Method method) {
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
}