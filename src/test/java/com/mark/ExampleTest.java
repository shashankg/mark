package com.mark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ExampleTest {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        // String baseURL = "http://www.landmarkshops.com/";
        String baseURL = "http://www.landmarkshops.com/Electronics/Electronics/Audio/Headphone-%26-Earphones/Earbud-%26-In-Ear-Headphones/Sennheiser-CX-300-II-Earphones---Chrome/p/154007163";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get(baseURL);
        //driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/ul/li[1]/a[2]")).click();

//        driver.findElement(By.id("j_username")).sendKeys("test123@test.com");
//        driver.findElement(By.id("fakej_password")).clear();
//        driver.findElement(By.id("j_password")).sendKeys("test@123");
//        driver.findElement(By.id("login")).click();

        //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/ul/li[1]/a[1]")).click();
        //String str = driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[1]/a")).getText();
        //Assert.assertEquals(str, "My Account");

        //driver.close();

        //Sign Up

//successful signup
//    driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/ul/li[1]/div/div[2]/a")).click();
//    Assert.assertEquals(driver.getCurrentUrl(),"https://www.landmarkshops.com/register");
//    driver.findElement(By.id("firstName")).sendKeys("test123456");
//    driver.findElement(By.id("lastName")).sendKeys("test123456");
//    driver.findElement(By.id("email")).sendKeys("test123456@test.com");
//    driver.findElement(By.id("fakepassword")).clear();
//    driver.findElement(By.id("password")).sendKeys("test@123456");
//    driver.findElement(By.id("fakeconfirmPassword")).clear();
//    driver.findElement(By.id("confirmPassword")).sendKeys("test@123456");
//
//    WebElement gender=driver.findElement(By.id("gender"));
//    List<WebElement> ddownOption=gender.findElements(By.tagName("option"));
//
//    for(WebElement value:ddownOption){
//        if(value.getText().equalsIgnoreCase("Female")){
//            value.click();
//        }   }
//
//     driver.findElement(By.xpath(".//*[@id='registerForm']/fieldset/div[8]/input")).click();
//    Assert.assertEquals(driver.getCurrentUrl(),"https://www.landmarkshops.com/my-account");

// search Functionality for correct keyword

//    driver.findElement(By.id("text1")).sendKeys("shirt");
//    driver.findElement(By.xpath(".//*[@id='search']/fieldset/input")).click();
//    Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/p/a")).getText(),"shirt");


//search functionality for black or unavailable word
//        driver.findElement(By.id("text1")).sendKeys("");
//        driver.findElement(By.xpath(".//*[@id='search']/fieldset/input")).click();
//        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='main']/div/div[2]/h3")).getText(), "Sorry there are no matches for 'What are you looking for?'");


//
//    driver.findElement(By.xpath(".//*[@id='women']/a")).click();
//    driver.findElement(By.xpath(".//*[@id='nav__women-regular']/ul[2]/li[1]/ul/li[3]/a")).click();
//    driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[1]/div[3]/div[1]/div[1]/div/a/img")).click();
//    driver.findElement(By.className("holder")).click();
//    driver.findElement(By.id("addToBasket")).click();


        //String str = driver.getTitle();
        //System.out.print(driver.getTitle());
        //Assert.assertEquals(str,"Online Shopping for Clothing, Baby Products & Electronics at LandmarkShops.com");
        //Actions build = new Actions(driver);
        //WebElement hover = driver.findElement(By.xpath(".//*[@id='electronics']/a"));
        //build.moveToElement(hover).build().perform();
        //driver.findElement(By.linkText("Mobile Phones")).click();
        //driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[1]/div[3]/div[2]/div[1]/div/a/img")).click();
//        //String price1 = driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[1]/div[3]/div[1]/div[2]/div/span[1]/strong")).getText();
//        //String price2 = driver.findElement(By.xpath(".//*[@id='productPriceBlock']/strong")).getText();
//        //Assert.assertEquals(price1,price2);
//        //driver.findElement(By.id("sizeSelect8")).click();
        driver.findElement(By.id("addToBasket")).click();
//        //driver.findElement(By.className("basket btn-open")).click();
//        //driver.findElement(By.xpath(".//*[@id='wrap-basket-template']/a")).click();
//        driver.findElement(By.className("checkout")).click();
//        driver.findElement(By.id("addressNickName")).sendKeys("test");
//        driver.findElement(By.id("firstName")).sendKeys("test");
//        driver.findElement(By.id("lastName")).sendKeys("test");
//        driver.findElement(By.id("emaill")).sendKeys("test@test.com");
//        driver.findElement(By.id("line1")).sendKeys("test");
//        driver.findElement(By.id("line2")).sendKeys("test");
//        WebElement regions=driver.findElement(By.id("regions"));
//    List<WebElement> ddownregionOption=regions.findElements(By.tagName("option"));
//
//    for(WebElement value:ddownregionOption){
//        if(value.getText().equalsIgnoreCase("Dubai")){
//            value.click();
//        }   }
//
//        driver.findElement(By.id("phone")).sendKeys("123456789");
//        driver.findElement(By.xpath(".//*[@id='createLMGAddressForm']/div[2]/input")).click();
//        driver.findElement(By.id("sameBillingAsShipping")).click();
//
//
//
//        driver.findElement(By.id("ccf-number")).sendKeys("5566204900066815");
//        driver.findElement(By.id("ccf-name")).sendKeys("test");
//
//        WebElement expirymonth=driver.findElement(By.id("ccf-exp-month"));
//        List<WebElement> ddownexpirymonth=expirymonth.findElements(By.tagName("option"));
//
//        for(WebElement value:ddownexpirymonth){
//            if(value.getText().equalsIgnoreCase("05")){
//                value.click();
//            }   }
//
//        WebElement expiryyear=driver.findElement(By.id("ccf-exp-year"));
//        List<WebElement> ddownexpiryyear=expiryyear.findElements(By.tagName("option"));
//
//        for(WebElement value:ddownexpiryyear){
//            if(value.getText().equalsIgnoreCase("2022")){
//                value.click();
//            }   }
//
//        driver.findElement(By.id("ccf-cvv")).sendKeys("111");
//        driver.findElement(By.xpath(".//*[@id='createLMGAddressForm']/div[7]/input[5]")).click();
//        driver.findElement(By.id("submitBtn2")).click();
//        //driver.findElement(By.xpath("html/body/form/table/tbody/tr[6]/td[2]/input[1]")).click();
//        driver.findElement(By.id("cmdSubmit")).click();
//        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='wrap-basket-template']/a")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.xpath(".//*[@id='154595059']/span[2]/a")).click();
        driver.findElement(By.className("deleteRowButton")).click();
        //WebElement str = driver.findElement(By.xpath(".//*[@id='wrap-basket-template']/a/strong/span"));
        driver.navigate().refresh();
        WebElement str = driver.findElement(By.className("basket-count"));
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        System.out.println(str.getText());

        if (str.getText().contains("0"))

        {
            System.out.print("Item Removed");
        }


        //driver.close();

    }
}





