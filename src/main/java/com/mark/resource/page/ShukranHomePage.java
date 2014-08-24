package com.mark.resource.page;

import com.mark.configuration.Configuration;
import com.shash.autoNG.core.ui.AutoNGBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class ShukranHomePage extends AutoNGBasePage<ShukranHomePage> {

    private static final String SHUKRAN_LINK_XPATH = ".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[1]/div/div/div/div/a";
    private static final String UNLINK_MESSAGE_CSS = ".unlink > a:nth-child(1)";
    private static final String SUCCESSFUL_SHUKRAN_ACCOUNT_MESSAGE_XPATH = ".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[1]/div/div/span[1]";
    private static final String POP_UP_MESSAGE_CSS = "#popup-shukran-unlink > div:nth-child(1) > p:nth-child(2)";
    private static final String POP_UP_CLOSE_CSS = "#popup-shukran-unlink > a:nth-child(2)";

    /**
     * Constructor
     *
     * @param driver
     */
    public ShukranHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account/shukranHomePage";
    }

    /**
     * Navigate to create shukran page
     *
     * @return
     */
    public CreateShukranPage navigateToCreateShukranPage() {
        getWebElement(By.xpath(SHUKRAN_LINK_XPATH)).click();
        return new CreateShukranPage(getDriver()).getPage(CreateShukranPage.class);
    }

    /**
     * Unlink Shukran account
     */
    public String clickUnlinkShukranAccountAndGetMessage() {
        getWebElement(By.cssSelector(UNLINK_MESSAGE_CSS)).click();
        sleep("Pop up to load", Configuration.getGlobalSleepTimeInMS());
        String message = getWebElement(By.cssSelector(POP_UP_MESSAGE_CSS)).getText();
        getWebElement(By.cssSelector(POP_UP_CLOSE_CSS)).click();
        return message;
    }

    /**
     * Get unlink shukran message
     *
     * @return
     */
    public String getUnlinkShukranMessage() {
        return getWebElement(By.cssSelector(UNLINK_MESSAGE_CSS)).getText();
    }


    /**
     * Get successful shukran message
     *
     * @return
     */
    public String getSuccessfulShukranAccountMessage() {
        return getWebElement(By.xpath(SUCCESSFUL_SHUKRAN_ACCOUNT_MESSAGE_XPATH)).getText();
    }

}
