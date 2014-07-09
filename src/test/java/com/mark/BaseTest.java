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
    protected static final String BASE_URL = Config.getBaseUrl();
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        logger.info("[BaseTest] WebDriver used: {}", Config.getDriverType());
        this.driver = WebDriverFactory.prepareWebDriver();
        this.driver.manage().window();
    }

    @AfterClass
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
        logger.info("[BaseTest] Tear down complete");
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

    protected WebDriver getDriver() {
        return this.driver;
    }
}
