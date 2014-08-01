package com.mark;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ExampleTest {

    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        // String baseURL = "http://www.landmarkshops.com/";
       // String baseURL = "http://www.landmarkshops.com/Electronics/Electronics/Audio/Headphone-%26-Earphones/Earbud-%26-In-Ear-Headphones/Sennheiser-CX-300-II-Earphones---Chrome/p/154007163";
        //String baseURL = "http://www.landmarkshops.com";
        String baseURL = "https://www.landmarkshops.com";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get(baseURL);
        //driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/ul/li[1]/a[2]")).click();

        //driver.findElement(By.id("j_username")).sendKeys("test12345@test.com");
        //driver.findElement(By.id("fakej_password")).clear();
        //driver.findElement(By.id("j_password")).sendKeys("test@12345");
        //driver.findElement(By.id("login")).click();

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

//eND TO END
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
       // driver.findElement(By.id("addToBasket")).click();
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

        //ADDING AND DELETING ITEM FROM BUCKET
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//        driver.findElement(By.xpath(".//*[@id='wrap-basket-template']/a")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //driver.findElement(By.xpath(".//*[@id='154595059']/span[2]/a")).click();
//        driver.findElement(By.className("deleteRowButton")).click();
//        //WebElement str = driver.findElement(By.xpath(".//*[@id='wrap-basket-template']/a/strong/span"));
//        driver.navigate().refresh();
//        WebElement str = driver.findElement(By.className("basket-count"));
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//        System.out.println(str.getText());
//
//        if (str.getText().contains("0"))
//
//        {
//            System.out.print("Item Removed");
//        }


        //driver.close();

        //Edit and delete the address information
       //login to check the saved details
       // driver.findElement(By.id("email")).sendKeys("test123@test.com");
        //driver.findElement(By.id("fakelogin-password")).clear();
        //driver.findElement(By.id("login-password")).sendKeys("test@123");
//        driver.findElement(By.xpath(".//*[@id='landmarkLoginForm']/fieldset/div[6]/input")).sendKeys("test@123");
//        driver.findElement(By.id("login")).click();
        //driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/ul/li[1]/ul/li[1]/a")).click();
        //edit the address
      // // driver.findElement(By.xpath(".//*[@id='main']/div/div/div[3]/div/ul/li[3]/a")).click();
//        driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
//        driver.findElement(By.id("nickname8812267864087_")).clear();
//        driver.findElement(By.id("nickname8812267864087_")).sendKeys("NewTest");
        //driver.findElement(By.id("nickname8812267864087_")).sendKeys(Keys.BACK_SPACE + "newtest");
        //cancelling the edit
//        driver.findElement(By.xpath(".//*[@id='LMGAddressForm8812267864087_']/div[2]/div[10]/a")).click();
//        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/h4")).getText(),"TEST");
        //saving the edited text
//        driver.findElement(By.xpath(".//*[@id='LMGAddressForm8812267864087_']/div[2]/div[10]/input")).click();
//        driver.manage().timeouts().implicitlyWaits0(3000, TimeUnit.SECONDS);
        //Assert.assertEquals(driver.findElement(By.id("nickname8812267864087_")).getText(),driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/h4")).getText());
        //delete the address
//        driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
//       driver.findElement(By.xpath(".//*[@id='removeAddressForm']/div/input")).click();
        //To cancel the deletion
//        driver.findElement(By.xpath(".//*[@id='removeAddressForm']/div/a")).click();

        //adding new address
//        driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/a")).click();
//        driver.findElement(By.id("addressNickName")).sendKeys("test3");
//        driver.findElement(By.id("firstName")).sendKeys("test3");
//        driver.findElement(By.id("lastName")).sendKeys("test3");
//        driver.findElement(By.id("line1")).sendKeys("test3");
//        driver.findElement(By.id("line2")).sendKeys("test3");
//        WebElement country=driver.findElement(By.id("countryIsoDrop"));
//        List<WebElement> ddcountry=country.findElements(By.tagName("option"));
//        for(WebElement value:ddcountry){
//            if(value.getText().equalsIgnoreCase("Ukraine")){
//                value.click();
//            }   }
//        Thread.sleep(3000);
//        WebElement state=driver.findElement(By.id("regions"));
//        List<WebElement> ddstate=state.findElements(By.tagName("option"));
//        for(WebElement value:ddstate){
//            if(value.getText().equalsIgnoreCase("Lviv oblast")){
//                value.click();
//            }   }
//        driver.findElement(By.id("phone")).sendKeys("123456789");
//        driver.findElement(By.id("save-address")).click();
//       System.out.print("New Address is added");

        //deleted the saved address
  //      driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[3]/div[1]/ul/li[2]/a")).click();


        //editing the saved address
//        driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div[1]/div[3]/div[1]/ul/li[1]/a")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("nickname8812421349399")).clear();
//        driver.findElement(By.id("nickname8812421349399")).sendKeys("test4");
//        driver.findElement(By.xpath(".//*[@id='LMGAddressForm8812421349399']/div[2]/div[10]/input")).click();


        //Shukran
  //      driver.findElement(By.xpath(".//*[@id='main']/div/div/div[3]/div/ul/li[7]/a")).click();
 //       driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div[1]/div[2]/div/div[1]/div/div/div/div/a")).click();
//        driver.findElement(By.xpath(".//*[@id='create-shukran-account-form']/fieldset[1]/div[1]/img")).click();
//        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a")).click();
//
//        WebElement nationality=driver.findElement(By.id("nationality"));
//        List<WebElement> ddnationality=nationality.findElements(By.tagName("option"));
//        for(WebElement value:ddnationality){
//            if(value.getText().equalsIgnoreCase("Aruba")){
//                value.click();
//            }   }
//
//        WebElement country=driver.findElement(By.id("country"));
//        List<WebElement> ddcountry=country.findElements(By.tagName("option"));
//        for(WebElement value:ddcountry){
//            if(value.getText().equalsIgnoreCase("UAE")){
//                value.click();
//            }   }
//        WebElement city=driver.findElement(By.id("city"));
//        List<WebElement> ddcity=city.findElements(By.tagName("option"));
//        for(WebElement value:ddcity){
//            if(value.getText().equalsIgnoreCase("Ajman")){
//                value.click();
//            }   }
//        driver.findElement(By.id("address1")).clear();
//        driver.findElement(By.id("address1")).sendKeys("test5");
//        driver.findElement(By.id("address2")).clear();
//        driver.findElement(By.id("address2")).sendKeys("test5");
//        driver.findElement(By.id("poBox")).sendKeys("123456");
//        driver.findElement(By.id("mobileNumber")).sendKeys("123456789");
//        driver.findElement(By.id("save-changes")).click();


        // driver.findElement(By.xpath(".//*[@id='main']/div/div/div[3]/div/ul/li[7]/a")).click();

//            driver.findElement(By.xpath(".//*[@id='main']/div/fieldset/div/div[2]/div/div/a")).click();
//         //cancel_button_xpath = .//*[@id='creditCardForm']/div[9]/a
//            driver.findElement(By.id("ccf-number")).sendKeys("5555555555554444");
//            driver.findElement(By.id("ccf-name")).sendKeys("test");
//            driver.findElement(By.id("")).sendKeys();


        //verification of breadcrum
//
//        //Women Section
//        Actions build1 = new Actions(driver);
//        WebElement hoverwomen = driver.findElement(By.xpath(".//*[@id='women']/a"));
//        build1.moveToElement(hoverwomen).build().perform();
//        WebElement womensection = driver.findElement(By.xpath(".//*[@id='nav__women-regular']"));
//        List<WebElement> alllinkswomen=womensection.findElements(By.tagName("a"));
//        for(WebElement value:alllinkswomen)
//        {
//            System.out.println(value.getText());
//        }
//
//        System.out.println("no of links" +alllinkswomen.size());
//
//
////      Men section
//        Actions build2 = new Actions(driver);
//        WebElement hovermen = driver.findElement(By.xpath(".//*[@id='men']/a"));
//        build2.moveToElement(hovermen).build().perform();
//        WebElement mensection = driver.findElement(By.xpath(".//*[@id='nav__men-regular']"));
//        List<WebElement> alllinksmen=driver.findElements(By.tagName("a"));
//        for(WebElement value:alllinksmen)
//        {
//            System.out.println(value.getText());
//        }
//
//        System.out.println("no of links" +alllinksmen.size());



// Verification of details on product page for an item with no color or size variance

//        Actions build3 = new Actions(driver);
//        WebElement hoverelectronic = driver.findElement(By.xpath(".//*[@id='electronics']/a"));
//        build3.moveToElement(hoverelectronic).build().perform();
//         driver.findElement(By.xpath(".//*[@id='nav__electronics-electronics']/ul[3]/li/ul/li[2]/a")).click();
//         driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[1]/div[3]/div[1]/div[1]/div/a/img")).click();
//
//        driver.findElement(By.xpath(".//*[@id='productPriceBlock']/strong")).getText();
//        driver.findElement(By.id("addToBasket")).click();


 //Verification of details on product page with color variance and its selection functionality

//        Actions build3 = new Actions(driver);
//        WebElement hoverclothes = driver.findElement(By.xpath(".//*[@id='women']/a"));
//        build3.moveToElement(hoverclothes).build().perform();
//        driver.findElement(By.linkText("Shrugs")).click();
//        driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[1]/div[3]/div[2]/div[1]/div/a/img")).click();
//        driver.findElement(By.xpath(".//*[@id='6009522']/div[2]/div[2]/form/div[1]/div[1]/label[1]/span[2]/img")).click();
//        driver.findElement(By.xpath(".//*[@id='sizeSelectPanel']/label[3]/span")).click();
//
//        if(driver.findElement(By.xpath(".//*[@id='inStockStatus']")).getText().equalsIgnoreCase("In Stock Online"))
//        {
//        driver.findElement(By.id("addToBasket")).click();
//        }


        //Verification of product details for Out of stock item

        Actions build3 = new Actions(driver);
        WebElement hoverclothes = driver.findElement(By.xpath(".//*[@id='women']/a"));
        build3.moveToElement(hoverclothes).build().perform();
        driver.findElement(By.linkText("Shrugs")).click();
        driver.findElement(By.xpath(".//*[@id='main']/div/div[3]/div[1]/div[3]/div[1]/div[1]/div/a/img")).click();
        if(driver.findElement(By.xpath(".//*[@id='outOfStockStatus']")).getText().equalsIgnoreCase("Sold out"))
        {
            driver.findElement(By.id("notifemail")).sendKeys("test1234@test.com");
            driver.findElement(By.xpath(".//*[@id='stocknotif__wrapper--default']/button")).click();
           if(driver.findElement(By.xpath(".//*[@id='stocknotif__wrapper--success']/p[2]/i")).isDisplayed())
            {
                System.out.print("Email sent");
            }

        }
    }


}
