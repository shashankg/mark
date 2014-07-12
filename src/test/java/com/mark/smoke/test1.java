package com.mark.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by shefali on 12/7/14.
 */
public class test1 {
public static void main (String args[]){


    WebDriver driver = new FirefoxDriver();
    String baseURL="http://www.landmarkshops.com/";



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
    driver.findElement(By.id("text1")).sendKeys("");
    driver.findElement(By.xpath(".//*[@id='search']/fieldset/input")).click();
    Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='main']/div/div[2]/h3")).getText(),"Sorry there are no matches for 'What are you looking for?'");



}}





