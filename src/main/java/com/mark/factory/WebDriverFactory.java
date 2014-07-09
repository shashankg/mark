package com.mark.factory;

import com.mark.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

    public enum DriverType {
        CHROME, FIREFOX, HTML_UNIT_DRIVER, IE, SAFARI
    }

    /**
     * The method prepareWebDriver initialize the WebDriver Object depending on the
     * browser
     *
     * @return the web driver
     */
    public static WebDriver prepareWebDriver() {
        DriverType browserType = DriverType.valueOf(Config.getDriverType().trim().toUpperCase());
        logger.info("Preparing WebDriver with browserType {}", browserType);

        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                return new ChromeDriver();
            case HTML_UNIT_DRIVER:
                return new HtmlUnitDriver();
            case IE:
                return new InternetExplorerDriver();
            case SAFARI:
                return new SafariDriver();
            default:
                logger.warn("DriverType is unknown, hence choosing firefox driver as default");
                return new FirefoxDriver();
        }
    }
}
