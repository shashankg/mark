package com.mark.dataprovider;

import com.shash.autoNG.utils.dataUtil.DataGenerator;

public class TestData {
    public static final String randomString = DataGenerator.generateAlphaNumericString(5);
    public static final String username = "test123@test.com";
    public static final String password = "test@123";

    public static final String country = "UAE";
    public static final String city = "Dubai";
    public static final String phone = "1234567890";


    public static final String validSearchKeyword = "Mobile";
    public static final String inValidSearchKeyword = "XXXXXXX";
    public static final String chineseKeyword = "字母";
    public static final String specialCharKeyword = "!@#$%^&*()";
    public static final String productId = "154574273";

    public static final String searchKeyword = "Nokia";

    public static final String firstName = "FirstName";
    public static final String lastName = "LastName";
    public static final String email = System.currentTimeMillis() + "@email.com";
    public static final String gender = "male";
    public static final String nationality = "India";
    public static final String cc = "5555555555554444";
}
