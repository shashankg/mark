package com.mark.resource.page;

import com.mark.resource.BasePage;
import com.mark.resource.component.Footer;
import com.mark.resource.component.Header;
import com.mark.resource.component.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage<AccountPage> {

    private static final String MY_DETAILS_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[2]/a";
    private static final String ADDRESS_BOOK_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[3]/a";
    private static final String PAYMENT_OPTION_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[4]/a";
    private static final String ORDER_HISTORY_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[5]/a";
    private static final String MY_REVIEWS_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[6]/a";
    private static final String SHUKRAN_XPATH = ".//*[@id='main']/div/div/div[3]/div/ul/li[7]/a";

    private Header header;
    private Footer footer;
    private SearchBar searchBar;

    /**
     * Constructor
     *
     * @param driver
     */
    public AccountPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.searchBar = new SearchBar(driver);
    }

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(getWebElement(By.id("header")));
    }

    @Override
    public String getPageUrl() {
        return "/my-account";
    }

    public Header getHeader() {
        return this.header;
    }

    public Footer getFooter() {
        return this.footer;
    }

    public SearchBar getSearchBar() {
        return this.searchBar;
    }

    public MyDetailsPage navigateToMyDetails() {
        getWebElement(By.id(MY_DETAILS_XPATH)).click();
        return new MyDetailsPage(getDriver()).getPage(MyDetailsPage.class);
    }

    public AddressBookPage navigateToAddressBook() {
        getWebElement(By.id(ADDRESS_BOOK_XPATH)).click();
        return new AddressBookPage(getDriver()).getPage(AddressBookPage.class);
    }

    public PaymentOptionsPage navigateToPaymentOptions() {
        getWebElement(By.id(PAYMENT_OPTION_XPATH)).click();
        return new PaymentOptionsPage(getDriver()).getPage(PaymentOptionsPage.class);
    }

    public OrderHistoryPage navigateToOrderHistory() {
        getWebElement(By.id(ORDER_HISTORY_XPATH)).click();
        return new OrderHistoryPage(getDriver()).getPage(OrderHistoryPage.class);
    }

    public MyReviewsPage navigateToMyReviews() {
        getWebElement(By.id(MY_REVIEWS_XPATH)).click();
        return new MyReviewsPage(getDriver()).getPage(MyReviewsPage.class);
    }

    public ShukranPage navigateToShukran() {
        getWebElement(By.id(SHUKRAN_XPATH)).click();
        return new ShukranPage(getDriver()).getPage(ShukranPage.class);
    }
}
