package com.mark.factory;

import com.mark.configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

    public enum DriverType {
        CHROME, FIREFOX, HEADLESS, IE, SAFARI
    }

    /**
     * The method prepareWebDriver initialize the WebDriver Object depending on the
     * browser
     *
     * @return the web driver
     */
    public static WebDriver prepareWebDriver() {
        DriverType browserType = DriverType.valueOf(Configuration.getDriverType().trim().toUpperCase());
        logger.info("Preparing WebDriver with browserType {}", browserType);

        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                return new ChromeDriver();
            case HEADLESS:
                System.out.println("here");
                DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
                System.out.println("here1");
                return new PhantomJSDriver(capabilities);
            case IE:
                return new InternetExplorerDriver();
            case SAFARI:
                return new SafariDriver();
            default:
                logger.warn("[WebDriver Factory] DriverType is unknown, hence choosing firefox driver as default");
                return new FirefoxDriver();
        }
    }
}
