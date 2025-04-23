package com.qa.opencart.utilities;

public class StringUtils {

    public static String getRandomemail()
    {
        String email = "testautomation"+System.currentTimeMillis()+"@opencart.com";
        return email;
    }
}
